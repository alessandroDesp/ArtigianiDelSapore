package controller;

import model.listaDesideri.ListaDesideri;
import model.listaDesideri.ListaDesideriDao;
import model.listaDesideri.SqlListaDesideriDao;
import model.utente.SqlUtenteDao;
import model.utente.Utente;
import model.utente.UtenteDAO;
import model.utente.utenteException.EmailAlreadyExistingException;
import model.utente.utenteException.PasswordNotValidException;
import org.json.JSONObject;
import utility.UtenteService;
import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;
import java.util.regex.Pattern;

@WebServlet(name = "RegistrazioneServlet", value = "/Registrazione")
public class RegistrazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.isPresent())
        {
            HttpSession session=request.getSession(true);
            session.setAttribute(utility.Utilita.SESSION_USER,us.get());
            requestDispatcher=request.getRequestDispatcher("WEB-INF/views/index.jsp");

        }else{
            requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/registrazione.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("textNome");
        String cognome = request.getParameter("textCognome");
        String codiceFiscale = request.getParameter("textCodiceFiscale");
        String dataNascita = request.getParameter("textDataNascita");
        String indirizzoEmail = request.getParameter("textIndirizzoEmail");
        String password = request.getParameter("textPassword");
        UtenteDAO daoUtente = new SqlUtenteDao();
        ListaDesideriDao daoListaDesideri = new SqlListaDesideriDao();
        JSONObject obj=new JSONObject();
        try {
            Date dataNascitaConvertita = utility.Utilita.dataConverter(dataNascita);
            String generatedTokenAuth = RandomStringUtils.random(utility.Utilita.lenghtAuth, true, false);
            if(daoUtente.isEmailInDatabase(indirizzoEmail)){
                throw new EmailAlreadyExistingException();
            }
            //Controllo se la password rispetta il pattern
            Pattern pattern = Pattern.compile(utility.Utilita.PASSWORD_PATTERN);
            if(pattern.matcher(password).matches()) {
                ListaDesideri listaDesideri = daoListaDesideri.insert();
                Utente utente = daoUtente.doInsert(3, listaDesideri.getIdListaDesideri(), codiceFiscale, nome, cognome, indirizzoEmail, dataNascitaConvertita, generatedTokenAuth, password);
                HttpSession session=request.getSession();
                session.setAttribute(utility.Utilita.SESSION_USER,utente);
                obj.put("Ris",1);
                obj.put("Mess","Login effettuato con successo");
                obj.put("Ris", 1);
                obj.put("Mess", "Registrazione effettuata con successo");
                response.getOutputStream().print(obj.toString());
            }else{
                throw new PasswordNotValidException();
            }
        } catch (SQLException | ParseException  e) {
            obj.put("Ris",0);
            obj.put("Mess","Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
            response.getOutputStream().print(obj.toString());
        } catch (EmailAlreadyExistingException e){
            obj.put("Ris",0);
            obj.put("Mess","L'email e' gia' esistente");
            response.getOutputStream().print(obj.toString());
        } catch (PasswordNotValidException e) {
            obj.put("Ris",0);
            obj.put("Mess","Password non valida");
            response.getOutputStream().print(obj.toString());
        }


    }
}
