package controller.api;

import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import model.ordini.OrdiniDao;
import model.ordini.SqlOrdiniDao;
import org.json.JSONObject;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModificaCategoria", value = "/ModificaCategoria")
public class ModificaCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Utilita.contieneParametro(request, "categoriaId") && Utilita.contieneParametro(request, "nome")) {
            int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));
            String nome = request.getParameter("nome");
            CategoriaDao dao = new SqlCategoriaDao();
            try {
                dao.modificaCategoria(categoriaId,nome);
                response.sendRedirect("GestioneCategorie");

            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("./");
            }
        }else{
            response.sendRedirect("./");
        }
    }
}
