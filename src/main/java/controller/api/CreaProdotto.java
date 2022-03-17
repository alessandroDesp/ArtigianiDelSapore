package controller.api;

import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodottiCategoria.ProdottiCategoriaDao;
import model.prodottiCategoria.SqlProdottiCategoriaDao;
import model.utente.Utente;
import org.json.JSONObject;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "CreaProdotto", value = "/CreaProdotto")
public class CreaProdotto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
        Float sconto = Float.parseFloat(request.getParameter("sconto"));
        int quantitaAttuale = Integer.parseInt(request.getParameter("quantitaAttuale"));
        String descrizione = request.getParameter("descrizione");
        String categoriaStringa = request.getParameter("categorieAggiunteId");
        ArrayList<Integer> listIdCategoria = new ArrayList<>();
        String[] splittedCategoria = categoriaStringa.split("-");
        for(int i=0;i<splittedCategoria.length;i++){
            listIdCategoria.add(Integer.parseInt(splittedCategoria[i]));
        }
        ProdottiDao dao = new SqlProdottiDao();
        ProdottiCategoriaDao daoCategoriaProdotti = new SqlProdottiCategoriaDao();
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.get().getKsRuolo()==1 || us.get().getKsRuolo()==2)  {
            try {
                Prodotti p = dao.insertProdotto(nome, prezzo, sconto, quantitaAttuale, 0, descrizione);
                for (Integer c : listIdCategoria) {
                    daoCategoriaProdotti.addProdottiCategoria(c.intValue(), p.getIdProdotti());
                }
                response.sendRedirect("GestioneProdotti");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("./");
            }
        }
    }
}
