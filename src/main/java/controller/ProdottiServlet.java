package controller;

import model.categoria.Categoria;
import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
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

@WebServlet(name = "Prodotti", value = "/Prodotti")
public class ProdottiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.isPresent())
        {
            HttpSession session=request.getSession(true);
            session.setAttribute(utility.Utilita.SESSION_USER,us.get());
        }
        String nomeCategoria = request.getParameter("categoria");
        CategoriaDao categoriaDao = new SqlCategoriaDao();
        ProdottiCategoriaDao prodottiCategoriaDao = new SqlProdottiCategoriaDao();
        ProdottiDao prodottiDao = new SqlProdottiDao();

        RequestDispatcher requestDispatcher;
        try {
            Categoria categoria = categoriaDao.getCategoriaByNome(nomeCategoria);
            List<Prodotti> prodotti = prodottiCategoriaDao.getProdottiByCategoriaId(categoria.getId());
            requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/prodotti.jsp");
            request.setAttribute("listaProdotti",prodotti);
        } catch (SQLException throwables) {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
