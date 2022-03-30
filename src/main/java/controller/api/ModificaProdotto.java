package controller.api;

import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.utente.Utente;
import utility.UtenteService;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "ModificaProdotto", value = "/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Utilita.contieneParametro(request, "nome") && Utilita.contieneParametro(request, "prezzo") &&
        Utilita.contieneParametro(request, "sconto") && Utilita.contieneParametro(request, "quantitaAttuale") &&
        Utilita.contieneParametro(request, "quantitaVenduta") && Utilita.contieneParametro(request, "prodottoId")) {
            String nome = request.getParameter("nome");
            Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
            Float sconto = Float.parseFloat(request.getParameter("sconto"));
            int quantitaAttuale = Integer.parseInt(request.getParameter("quantitaAttuale"));
            int quantitaVenduta = Integer.parseInt(request.getParameter("quantitaVenduta"));
            String descrizione = request.getParameter("descrizione");
            int idProdotto = Integer.parseInt(request.getParameter("prodottoId"));
            ProdottiDao dao = new SqlProdottiDao();
            Optional<Utente> us = UtenteService.getUtente(request);
            if (us.get().getKsRuolo() == 1 || us.get().getKsRuolo() == 2) {
                try {
                    dao.modificaProdotto(idProdotto, nome, prezzo, sconto, quantitaAttuale, quantitaVenduta, descrizione);
                    response.sendRedirect("GestioneProdotti");
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect("./");
                }
            }
        }else{
            response.sendRedirect("./");
        }
    }
}
