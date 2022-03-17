package controller.areaUtente;

import model.ordini.Ordini;
import model.ordini.OrdiniDao;
import model.ordini.SqlOrdiniDao;
import model.utente.Utente;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "GestioneOrdini", value = "/GestioneOrdini")
public class GestioneOrdiniServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        if(!us.isPresent())
        {
            response.sendRedirect("./");
        }
        else
        {
            OrdiniDao dao = new SqlOrdiniDao();
            try {
                List<Ordini> listaOrdini;
                if(us.get().getKsRuolo()==1||us.get().getKsRuolo()==2){
                    listaOrdini = dao.getAll();
                }else{
                    listaOrdini = dao.getOrdiniByUtente(us.get().getIdUtente());
                }
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/areaUtente/gestioneOrdini.jsp");
                request.setAttribute("listaOrdini",listaOrdini);
                request.setAttribute("Tipo",3);
                requestDispatcher.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
