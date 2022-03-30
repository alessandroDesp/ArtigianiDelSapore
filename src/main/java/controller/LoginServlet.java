package controller;

import model.utente.SqlUtenteDao;
import model.utente.Utente;
import model.utente.UtenteDAO;
import model.utente.utenteException.PasswordNotValidException;
import org.json.JSONObject;
import utility.UtenteService;
import utility.Utilita;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.isPresent())
        {
            requestDispatcher=request.getRequestDispatcher("WEB-INF/views/index.jsp");

        }else{
            requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject obj = new JSONObject();
        if(Utilita.contieneParametro(request,"textEmail")&& Utilita.contieneParametro(request,"textPassword")) {
            String email = request.getParameter("textEmail");
            String password = request.getParameter("textPassword");
            boolean ricordami = Boolean.parseBoolean(request.getParameter("textRicordami"));
            UtenteDAO dao = new SqlUtenteDao();

            try {
                Utente user = dao.doLogin(email, password);
                HttpSession session = request.getSession();
                session.setAttribute(utility.Utilita.SESSION_USER, user);
                obj.put("Ris", 1);
                obj.put("Mess", "Login effettuato con successo");
                response.getOutputStream().print(obj.toString());
                if (ricordami) {
                    Cookie c1 = new Cookie(utility.Utilita.COOKIE_ID, user.getIdUtente() + "");
                    Cookie c2 = new Cookie(utility.Utilita.COOKIE_TOKEN, user.getTokenAuth());
                    response.addCookie(c1);
                    response.addCookie(c2);
                }

            } catch (SQLException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
                response.getOutputStream().print(obj.toString());
            } catch (PasswordNotValidException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Hai immesso un nome utente o una password errata!");
                response.getOutputStream().print(obj.toString());
            }
        }else{
            obj.put("Ris", 0);
            obj.put("Mess", "Inserisci tutti i campi obbligatori!");
            response.getOutputStream().print(obj.toString());
        }
    }
}
