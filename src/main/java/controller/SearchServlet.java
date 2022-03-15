package controller;

import model.prodotti.Prodotti;
import model.prodotti.SqlProdottiDao;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Search", value = "/Search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher;

        String sQuery = request.getParameter("sValue");

        SqlProdottiDao prodottiDao = new SqlProdottiDao();

        try {
            ArrayList<Prodotti> prodotti = prodottiDao.getProdottoByName(sQuery);
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/prodotti.jsp");
            request.setAttribute("listaProdotti",prodotti);

        } catch (SQLException  e) {
            e.printStackTrace();
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
        }

        requestDispatcher.forward(request,response);


    }
}
