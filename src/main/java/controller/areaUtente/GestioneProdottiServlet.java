package controller.areaUtente;

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
        if(!us.isPresent())
        {
            response.sendRedirect("./");
        }
        else
        {
            ProdottiDao dao = new SqlProdottiDao();
            try {
                List<Prodotti> listaProdotti = dao.getAllProdotti();
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/areaUtente/gestioneProdotti.jsp");
                request.setAttribute("listaProdotti",listaProdotti);
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
