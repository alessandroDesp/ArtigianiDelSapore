package controller;

import model.categoria.Categoria;
import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.categoria.categoriaException.CategoriaNotFoundException;
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
        int  numeroPagina = Integer.parseInt(request.getParameter("numeroPagina"));
        int numeroPaginaCalcolato = numeroPagina - 1;
        CategoriaDao categoriaDao = new SqlCategoriaDao();
        ProdottiCategoriaDao prodottiCategoriaDao = new SqlProdottiCategoriaDao();
        RequestDispatcher requestDispatcher;
        try {
            Categoria categoria = categoriaDao.getCategoriaByNome(nomeCategoria);
            if(categoria!=null) {
                int numeroProdottiTotali = prodottiCategoriaDao.getNumeroProdottiByCategoriaId(categoria.getId());
                List<Prodotti> prodotti = prodottiCategoriaDao.getProdottiByCategoriaId(categoria.getId(),numeroPaginaCalcolato);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/prodotti.jsp");
                request.setAttribute("listaProdotti", prodotti);
                request.setAttribute("numeroPagina", numeroPagina);
                request.setAttribute("numeroProdottiTotali", numeroProdottiTotali);
                request.setAttribute("nomeCategoria",nomeCategoria);
            }else{
                throw new CategoriaNotFoundException();
            }
        } catch (SQLException throwables) {
            requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        } catch (CategoriaNotFoundException e) {
            e.printStackTrace();
            requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
