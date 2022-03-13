package controller.api;

import model.listaDesideri.ListaDesideri;
import model.listaDesideri.ListaDesideriDao;
import model.listaDesideri.SqlListaDesideriDao;
import model.listaDesideri.listaDesideriException.ListaDesideriNotFoundException;
import model.listaDesideriProdotti.ListaDesideriProdottiDao;
import model.listaDesideriProdotti.SqlListaDesideriProdottiDao;
import model.listaDesideriProdotti.listaDesideriProdottiException.ListaDesideriProdottiAlreadyExstistException;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodotti.prodottiException.ProdottiNotFoundException;
import model.utente.Utente;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AggiungiPreferiti", value = "/AggiungiPreferiti")
public class AggiungiPreferiti extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int prodottiId = Integer.parseInt(request.getParameter("idProdotto"));
        ListaDesideriDao daoListaDesideri = new SqlListaDesideriDao();
        ListaDesideriProdottiDao daoListaDesideriProdotti = new SqlListaDesideriProdottiDao();
        HttpSession session=request.getSession(true);
        Utente us=(Utente)session.getAttribute(utility.Utilita.SESSION_USER);
        JSONObject obj=new JSONObject();
        if(us!=null){
            try {
                ListaDesideri ld = daoListaDesideri.getByUtenteId(us.getIdUtente());
                daoListaDesideriProdotti.alreadyExsist(prodottiId,ld.getIdListaDesideri());
                daoListaDesideriProdotti.insert(prodottiId,ld.getIdListaDesideri());
                obj.put("Ris", 1);
                obj.put("Mess", "Prodotto aggiunto ai preferiti con successo");
                response.getOutputStream().print(obj.toString());
            } catch (SQLException e) {
                obj.put("Ris",0);
                obj.put("Mess","Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
                response.getOutputStream().print(obj.toString());
            } catch (ListaDesideriNotFoundException e) {
                obj.put("Ris",0);
                obj.put("Mess","Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
                response.getOutputStream().print(obj.toString());
            } catch (ListaDesideriProdottiAlreadyExstistException e) {
                obj.put("Ris", 0);
                obj.put("Mess", "Il prodotto e' gia' presente nella lista preferiti");
                response.getOutputStream().print(obj.toString());
            }
        }
    }
}
