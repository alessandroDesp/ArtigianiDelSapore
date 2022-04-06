package controller.api;

import model.categoria.CategoriaDao;
import model.categoria.SqlCategoriaDao;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreazioneCategoria", value = "/CreazioneCategoria")
public class CreazioneCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Utilita.contieneParametro(request, "nome")) {
            String nome = request.getParameter("nome");
            CategoriaDao dao = new SqlCategoriaDao();
            try {
                dao.creaCategoria(nome);
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
