package controller.areaUtente;

import model.utente.SqlUtenteDao;
import model.utente.Utente;
import model.utente.UtenteDAO;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "GestioneUtenti", value = "/GestioneUtenti")
public class GestioneUtentiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        if(!us.isPresent())
        {
            response.sendRedirect("./");
        }
        else
        {
            UtenteDAO dao = new SqlUtenteDao();
            try {
                List<Utente> listaUtente = dao.getAll();
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/areaUtente/gestioneUtenti.jsp");
                request.setAttribute("listaUtente",listaUtente);
                request.setAttribute("Tipo",4);
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
