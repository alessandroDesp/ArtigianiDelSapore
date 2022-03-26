package controller.api;

import model.prodotti.Prodotti;
import model.prodotti.prodottiException.ProdottiNotFoundException;
import org.json.JSONObject;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModificaCarrello", value = "/ModificaCarrello")
public class ModificaCarrello extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantitaDaAcquistare = Integer.parseInt(request.getParameter("quantitaDaAcquistare"));
        int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
        HttpSession session = request.getSession(true);
        List<Prodotti> prodottiList = (List<Prodotti>)session.getAttribute(Utilita.SESSION_CARRELLO);
        for (Prodotti p : prodottiList){
            if(p.getIdProdotti() == idProdotto){
                p.setQuantitaDaAcquistare(quantitaDaAcquistare);
            }
        }
        session.setAttribute(Utilita.SESSION_CARRELLO,prodottiList);
    }
}
