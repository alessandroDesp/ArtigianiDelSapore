package controller;

import model.categoria.Categoria;
import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.foto.FotoDao;
import model.foto.SqlFotoDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodottiCategoria.ProdottiCategoriaDao;
import model.prodottiCategoria.SqlProdottiCategoriaDao;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher;

        String sQuery = request.getParameter("sValue");
        int  numeroPagina = Integer.parseInt(request.getParameter("numeroPagina"));
        int numeroPaginaCalcolato = numeroPagina - 1;
        ProdottiDao prodottiDao = new SqlProdottiDao();
        CategoriaDao categoriaDao = new SqlCategoriaDao();
        ProdottiCategoriaDao prodottiCategoriaDao = new SqlProdottiCategoriaDao();
        FotoDao daoFoto = new SqlFotoDao();
        List<Prodotti> prodotti;
        int numeroProdottiTotali;
        try {
            Categoria categoria = categoriaDao.getCategoriaByNome(sQuery);
            if(categoria != null){
                numeroProdottiTotali = prodottiCategoriaDao.getNumeroProdottiByCategoriaId(categoria.getId());
                prodotti = prodottiCategoriaDao.getProdottiByCategoriaId(categoria.getId(),numeroPaginaCalcolato);

            }else{
                numeroProdottiTotali = prodottiDao.getNumeroProdottiByName(sQuery);
                prodotti = prodottiDao.getProdottoByName(sQuery,numeroPaginaCalcolato);
            }
            for(Prodotti p: prodotti){
                p.setFotoPath(daoFoto.getFotoByProdottoId(p.getIdProdotti()));
            }
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/prodottiSearchResult.jsp");
            request.setAttribute("listaProdotti",prodotti);
            request.setAttribute("numeroPagina", numeroPagina);
            request.setAttribute("numeroProdottiTotali", numeroProdottiTotali);
            request.setAttribute("nomeRicerca",sQuery);

        } catch (SQLException  e) {
            e.printStackTrace();
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
        }

        requestDispatcher.forward(request,response);


    }
}
