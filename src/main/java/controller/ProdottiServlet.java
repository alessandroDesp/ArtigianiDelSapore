package controller;

import model.categoria.Categoria;
import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodottiCategoria.ProdottiCategoriaDao;
import model.prodottiCategoria.SqlProdottiCategoriaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Prodotti", value = "/Prodotti")
public class ProdottiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
