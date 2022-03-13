package utility;

import model.listaDesideri.ListaDesideri;
import model.listaDesideri.ListaDesideriDao;
import model.listaDesideri.SqlListaDesideriDao;
import model.listaDesideri.listaDesideriException.ListaDesideriNotFoundException;
import model.utente.SqlUtenteDao;
import model.utente.Utente;
import model.utente.UtenteDAO;
import model.utente.utenteException.UtenteNotFoundException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;

public class UtenteService {
    public static Optional<Utente> getUtente(HttpServletRequest request)
    {
        int idUtente=-1;
        String tokenAuth="";
        HttpSession session=request.getSession(true);
        Utente us=(Utente)session.getAttribute(utility.Utilita.SESSION_USER);
        if(us!=null)
        {
            return Optional.of(us);
        }
        else
        {
            if(request.getCookies()!=null)
            {
                Cookie[] cookies=request.getCookies();
                for(Cookie c:cookies)
                {
                    if(c.getName().equals(utility.Utilita.COOKIE_ID))
                    {
                        idUtente=Integer.parseInt(c.getValue());
                    }
                    if(c.getName().equals(utility.Utilita.COOKIE_TOKEN))
                    {
                        tokenAuth=c.getValue();
                    }
                }
            }
        }
        if(idUtente!=-1)
        {
            try
            {
                UtenteDAO dao = new SqlUtenteDao();
                ListaDesideriDao daoListaDesideri = new SqlListaDesideriDao();
                us= dao.doLogin(idUtente,tokenAuth);
                ListaDesideri ld = daoListaDesideri.getByUtenteId(us.getIdUtente());
                session.setAttribute(utility.Utilita.SESSION_USER,us);
                session.setAttribute(Utilita.SESSION_LISTADESIDERI,ld);
                return Optional.of(us);
            }
            catch (UtenteNotFoundException | SQLException | ListaDesideriNotFoundException e)
            {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
