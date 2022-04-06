package controller.areaUtente;

import model.categoria.Categoria;
import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.utente.Utente;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "GestioneCategorie", value = "/GestioneCategorie")
public class GestioneCategorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        if(!us.isPresent())
        {
            response.sendRedirect("./");
        }
        else {
            if (!((us.get().getKsRuolo() == 1) || (us.get().getKsRuolo() == 2))) {
                response.sendRedirect("./");
            } else {
                CategoriaDao dao = new SqlCategoriaDao();
                try {
                    List<Categoria> listaCategoria = dao.getAll();
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/areaUtente/gestioneCategorie.jsp");
                    request.setAttribute("listaCategoria", listaCategoria);
                    request.setAttribute("Tipo", 6);
                    requestDispatcher.forward(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
