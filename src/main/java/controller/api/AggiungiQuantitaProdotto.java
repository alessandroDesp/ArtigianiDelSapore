package controller.api;

import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodotti.prodottiException.ProdottiNotFoundException;
import model.utente.Utente;
import utility.UtenteService;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "AggiungiQuantitaProdotto", value = "/AggiungiQuantitaProdotto")
public class AggiungiQuantitaProdotto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Utilita.contieneParametro(request,"quantitaAggiunta")&&Utilita.contieneParametro(request,"prodottoId")) {
            int quantitaDaAggiungere = Integer.parseInt(request.getParameter("quantitaAggiunta"));
            int idProdotto = Integer.parseInt(request.getParameter("prodottoId"));
            ProdottiDao dao = new SqlProdottiDao();
            Optional<Utente> us = UtenteService.getUtente(request);
            if (us.get().getKsRuolo() == 2) {
                try {
                    dao.aggiungiQuantita(idProdotto, quantitaDaAggiungere);
                    response.sendRedirect("GestioneProdotti");
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect("./");
                } catch (ProdottiNotFoundException e) {
                    e.printStackTrace();
                    response.sendRedirect("./");
                }
            }
        }else{
            response.sendRedirect("./");
        }
    }
}
