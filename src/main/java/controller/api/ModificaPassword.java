package controller.api;

import model.utente.SqlUtenteDao;
import model.utente.Utente;
import model.utente.UtenteDAO;
import model.utente.utenteException.PasswordNotValidException;
import model.utente.utenteException.PermissionDeniedException;
import org.json.JSONObject;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet(name = "ModificaPassword", value = "/ModificaPassword")
public class ModificaPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject obj=new JSONObject();
        if (Utilita.contieneParametro(request, "textIdUtente") && Utilita.contieneParametro(request, "textToken") &&
        Utilita.contieneParametro(request, "textNuovaPassword") && Utilita.contieneParametro(request, "textRipetiPassword") &&
        Utilita.contieneParametro(request, "textVecchiaPassword")) {
            int idUtente = Integer.parseInt(request.getParameter("textIdUtente"));
            String token = request.getParameter("textToken");
            String nuovaPassword = request.getParameter("textNuovaPassword");
            String ripetiPassword = request.getParameter("textRipetiPassword");
            String vecchiaPassword = request.getParameter("textVecchiaPassword");
            HttpSession session = request.getSession(true);
            Utente us = (Utente) session.getAttribute(utility.Utilita.SESSION_USER);
            UtenteDAO dao = new SqlUtenteDao();
            try {
                if ((idUtente != us.getIdUtente()) || (!token.equals(us.getTokenAuth()))) {
                    throw new PermissionDeniedException();
                }
                Pattern pattern = Pattern.compile(utility.Utilita.PASSWORD_PATTERN);
                if (pattern.matcher(nuovaPassword).matches()) {
                    if ((dao.isPasswordValid(idUtente, vecchiaPassword)) && (nuovaPassword.equals(ripetiPassword))) {
                        dao.doChangePassword(idUtente, nuovaPassword);
                        obj.put("Ris", 1);
                        obj.put("Mess", "Fatto");
                        response.getOutputStream().print(obj.toString());
                    } else {
                        throw new PasswordNotValidException();
                    }
                }else{
                    throw new PasswordNotValidException();
                }
            } catch (SQLException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
                response.getOutputStream().print(obj.toString());
            } catch (PasswordNotValidException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Password non valida");
                response.getOutputStream().print(obj.toString());
            } catch (PermissionDeniedException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Operazione non valida");
                response.getOutputStream().print(obj.toString());
            }
        }else{
            obj.put("Ris", 0);
            obj.put("Mess", "Inserisci tutti i campi obbligatori!");
            response.getOutputStream().print(obj.toString());
        }

    }
}
