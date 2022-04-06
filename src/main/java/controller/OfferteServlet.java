package controller;

import model.categoria.Categoria;
import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.categoria.categoriaException.CategoriaNotFoundException;
import model.foto.FotoDao;
import model.foto.SqlFotoDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodottiCategoria.ProdottiCategoriaDao;
import model.prodottiCategoria.SqlProdottiCategoriaDao;
import model.utente.Utente;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "Offerte", value = "/Offerte")
public class OfferteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.isPresent())
        {
            HttpSession session=request.getSession(true);
            session.setAttribute(utility.Utilita.SESSION_USER,us.get());
        }
        int  numeroPagina = Integer.parseInt(request.getParameter("numeroPagina"));
        int numeroPaginaCalcolato = numeroPagina - 1;
        ProdottiDao daoProdotti = new SqlProdottiDao();
        FotoDao daoFoto = new SqlFotoDao();
        RequestDispatcher requestDispatcher;
        try {
            int numeroProdottiTotali = daoProdotti.getNumeroProdottiBySconto();
            List<Prodotti> prodotti = daoProdotti.getProdottoBySconto(numeroPaginaCalcolato);
            for(Prodotti p: prodotti){
                p.setFotoPath(daoFoto.getFotoByProdottoId(p.getIdProdotti()));
            }
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/prodottiOfferte.jsp");
            request.setAttribute("listaProdotti", prodotti);
            request.setAttribute("numeroPagina", numeroPagina);
            request.setAttribute("numeroProdottiTotali", numeroProdottiTotali);
        } catch (SQLException e) {
            e.printStackTrace();
            requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
