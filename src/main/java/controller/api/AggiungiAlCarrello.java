package controller.api;

import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodotti.prodottiException.ProdottiNotFoundException;
import model.prodotti.prodottiException.ProdottoAlreadyInCarrelloException;
import model.prodotti.prodottiException.QuantitaProdottoInsufficienteException;
import model.utente.Utente;
import org.json.JSONObject;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AggiungiAlCarrello", value = "/AggiungiAlCarrello")
public class AggiungiAlCarrello extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject obj = new JSONObject();
        int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
        int quantitaDaAcquistare = Integer.parseInt(request.getParameter("quantitaDaAcquistare"));
        ProdottiDao dao = new SqlProdottiDao();
        HttpSession session=request.getSession(true);
        try {
            Prodotti prodotto = dao.getProdottoById(idProdotto);
            if(prodotto.getQuantitaAttuale()<quantitaDaAcquistare){
                throw new QuantitaProdottoInsufficienteException();
            }
            prodotto.setQuantitaDaAcquistare(quantitaDaAcquistare);
            List<Prodotti> prodottiSession = (List<Prodotti>) session.getAttribute(Utilita.SESSION_CARRELLO);
            List<Prodotti> prodottiList = new ArrayList<>();
            if(prodottiSession!=null){
                prodottiList = prodottiSession;
                for (Prodotti p : prodottiList){
                    if(p.getIdProdotti() == prodotto.getIdProdotti()){
                        throw new ProdottoAlreadyInCarrelloException();
                    }
                }
            }
            prodottiList.add(prodotto);
            session.setAttribute(Utilita.SESSION_CARRELLO,prodottiList);
            obj.put("Ris",1);
            obj.put("Mess","Fatto");
            response.getOutputStream().print(obj.toString());
        } catch (SQLException e) {
            obj.put("Ris",0);
            obj.put("Mess","Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
            response.getOutputStream().print(obj.toString());
        } catch (ProdottiNotFoundException e) {
            obj.put("Ris",0);
            obj.put("Mess","Prodotto non disponibile");
            response.getOutputStream().print(obj.toString());
        } catch (QuantitaProdottoInsufficienteException e) {
            obj.put("Ris",0);
            obj.put("Mess","La quantita' prodotto desiderata supera la quantita' disponibile");
            response.getOutputStream().print(obj.toString());
        } catch (ProdottoAlreadyInCarrelloException e) {
            obj.put("Ris",0);
            obj.put("Mess","Il prodotto e' gia presente nel carrello");
            response.getOutputStream().print(obj.toString());
        }
    }
}
