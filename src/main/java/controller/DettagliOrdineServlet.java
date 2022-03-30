package controller;

import model.ordini.Ordini;
import model.ordini.OrdiniDao;
import model.ordini.SqlOrdiniDao;
import model.ordiniProdotti.OrdiniProdottiDao;
import model.ordiniProdotti.SqlOrdiniProdottiDao;
import model.prodotti.Prodotti;
import model.utente.Utente;
import model.utente.utenteException.PermissionDeniedException;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "DettagliOrdine", value = "/DettagliOrdine")
public class DettagliOrdineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        Optional<Utente> us= UtenteService.getUtente(request);

        int idOrdine = Integer.parseInt(request.getParameter("id"));
        OrdiniDao daoOrdini = new SqlOrdiniDao();
        OrdiniProdottiDao daoOrdiniProdotti = new SqlOrdiniProdottiDao();
        if(us.isPresent()) {
            HttpSession session = request.getSession(true);
            session.setAttribute(utility.Utilita.SESSION_USER, us.get());
            try {
                if(daoOrdini.checkUtenteOrdine(us.get().getIdUtente(),idOrdine)){
                Ordini ordine = daoOrdini.getOrdiniById(idOrdine);
                List<Prodotti> prodottiList = daoOrdiniProdotti.getProdottiDaOrdiniProdotti(idOrdine);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/dettagliOrdine.jsp");
                request.setAttribute("listaProdotti", prodottiList);
                request.setAttribute("ordine", ordine);
                }else{
                    throw new PermissionDeniedException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
            } catch (PermissionDeniedException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
            }
        }else{
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        }
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
