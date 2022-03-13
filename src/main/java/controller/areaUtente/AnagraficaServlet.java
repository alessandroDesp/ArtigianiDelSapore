package controller.areaUtente;

import model.utente.SqlUtenteDao;
import model.utente.Utente;
import model.utente.UtenteDAO;
import model.utente.utenteException.UtenteNotFoundException;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "Anagrafica", value = "/Anagrafica")
public class AnagraficaServlet extends HttpServlet {
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
                Utente ut = dao.doLogin(us.get().getIdUtente(),us.get().getTokenAuth());
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/areaUtente/anagrafica.jsp");
                request.setAttribute("utente",ut);
                request.setAttribute("Tipo",1);
                requestDispatcher.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (UtenteNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
