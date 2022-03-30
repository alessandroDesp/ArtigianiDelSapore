package controller.api;

import model.utente.SqlUtenteDao;
import model.utente.UtenteDAO;
import model.utente.utenteException.EmailAlreadyExistingException;
import org.json.JSONObject;
import utility.Utilita;

import javax.rmi.CORBA.Util;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "ModificaAnagrafica", value = "/ModificaAnagrafica")
public class ModificaAnagrafica extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject obj = new JSONObject();
        if(Utilita.contieneParametro(request,"textIdUtente") && Utilita.contieneParametro(request,"textToken") &&
        Utilita.contieneParametro(request,"textNome") && Utilita.contieneParametro(request,"textCognome")&&
        Utilita.contieneParametro(request,"textCodiceFiscale") && Utilita.contieneParametro(request,"textDataNascita") &&
        Utilita.contieneParametro(request,"textEmail")) {

            int idUtente = Integer.parseInt(request.getParameter("textIdUtente"));
            String tokenAuth = request.getParameter("textToken");
            String textNome = request.getParameter("textNome");
            String textCognome = request.getParameter("textCognome");
            String textCodiceFiscale = request.getParameter("textCodiceFiscale");
            String textDataNascita = request.getParameter("textDataNascita");
            String textEmail = request.getParameter("textEmail");
            UtenteDAO dao = new SqlUtenteDao();
            try {
                if (dao.isEmailInDatabase(textEmail) && !dao.isEmailOld(idUtente, textEmail)) {
                    throw new EmailAlreadyExistingException();
                }
                dao.doChangeAnagrafica(idUtente, textNome, textCognome, textCodiceFiscale, Utilita.dataConverter(textDataNascita), textEmail);
                obj.put("Ris", 1);
                obj.put("Mess", "Fatto");
                response.getOutputStream().print(obj.toString());
            } catch (SQLException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
                response.getOutputStream().print(obj.toString());
            } catch (EmailAlreadyExistingException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "L'email e' gia stata inserita");
                response.getOutputStream().print(obj.toString());
            } catch (ParseException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
                response.getOutputStream().print(obj.toString());
            }
        }else{
            obj.put("Ris", 0);
            obj.put("Mess", "Inserisci tutti i campi obbligatori!");
            response.getOutputStream().print(obj.toString());
        }

    }
}
