package controller.areaUtente;

import model.categoria.Categoria;
import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.utente.Utente;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "GestioneProdotti", value = "/GestioneProdotti")
public class GestioneProdottiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        if(!((us.get().getKsRuolo()==1) || (us.get().getKsRuolo()==2)))
        {
            response.sendRedirect("./");
        }
        else
        {
            ProdottiDao daoProdotti = new SqlProdottiDao();
            CategoriaDao daoCategoria = new SqlCategoriaDao();
            try {
                List<Prodotti> listaProdotti = daoProdotti.getAllProdotti();
                List<Categoria> listaCategorie = daoCategoria.getAll();
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/areaUtente/gestioneProdotti.jsp");
                request.setAttribute("listaProdotti",listaProdotti);
                request.setAttribute("listaCategorie",listaCategorie);
                request.setAttribute("Tipo",5);
                requestDispatcher.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
