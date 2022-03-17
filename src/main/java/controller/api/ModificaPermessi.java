package controller.api;

import model.utente.SqlUtenteDao;
import model.utente.Utente;
import model.utente.UtenteDAO;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "ModificaPermessi", value = "/ModificaPermessi")
public class ModificaPermessi extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUtente = Integer.parseInt(request.getParameter("idUtente"));
        int ruolo = Integer.parseInt(request.getParameter("ruolo"));
        UtenteDAO dao = new SqlUtenteDao();
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.get().getKsRuolo()==1)
        {
            try {
                dao.doChangeRuolo(idUtente,ruolo);
                response.sendRedirect("GestioneUtenti");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("./");
            }
        }
    }
}
