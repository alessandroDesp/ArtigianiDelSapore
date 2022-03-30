package controller;

import model.ordini.Ordini;
import model.ordini.OrdiniDao;
import model.ordini.SqlOrdiniDao;
import model.ordiniProdotti.OrdiniProdottiDao;
import model.ordiniProdotti.SqlOrdiniProdottiDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodotti.prodottiException.ProdottiNotFoundException;
import model.utente.Utente;
import org.json.JSONObject;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "Pagamento", value = "/Pagamento")
public class PagamentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        List<Prodotti> prodottiSession = (List<Prodotti>) session.getAttribute(Utilita.SESSION_CARRELLO);
        Utente us=(Utente)session.getAttribute(utility.Utilita.SESSION_USER);
        OrdiniProdottiDao daoOrdiniProdotti = new SqlOrdiniProdottiDao();
        ProdottiDao daoProdotti = new SqlProdottiDao();
        OrdiniDao daoOrdini = new SqlOrdiniDao();
        RequestDispatcher requestDispatcher;
        if(prodottiSession!=null){
            float prezzoTotale = Utilita.getPrezzoTotale(prodottiSession);
            try {
                Ordini ordine = daoOrdini.aggiungiOrdine(us.getIdUtente(),2,prezzoTotale);
                for(Prodotti p : prodottiSession){
                    daoOrdiniProdotti.aggiungiOrdiniProdotti(ordine.getIdOrdini(),p.getIdProdotti(),p.getQuantitaDaAcquistare());
                    daoProdotti.aggiungiSottraiQuantita(p.getIdProdotti(),p.getQuantitaDaAcquistare());
                }
                session.setAttribute(Utilita.SESSION_CARRELLO,null);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/succesPage.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
            } catch (ProdottiNotFoundException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
            }
        }else{
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
        }
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
