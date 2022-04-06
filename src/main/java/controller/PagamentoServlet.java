package controller;

import model.ordini.Ordini;
import model.ordini.OrdiniDao;
import model.ordini.SqlOrdiniDao;
import model.pagamentoOrdine.PagamentoOrdineDao;
import model.pagamentoOrdine.SqlPagamentoOrdineDao;
import model.pagamentoOrdine.pagamentoException.PagamentoAlreadyDoneException;
import model.utente.Utente;
import model.utente.utenteException.PermissionDeniedException;
import utility.UtenteService;
import utility.Utilita;

import javax.rmi.CORBA.Util;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "Pagamento", value = "/Pagamento")
public class PagamentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        HttpSession session=request.getSession(true);
        Ordini ordine = null;
        if(!Utilita.contieneParametro(request,"id")) {
            ordine = (Ordini)session.getAttribute(Utilita.SESSION_PAGAMENTO);
        }else{
            int idOrdine = Integer.parseInt(request.getParameter("id"));
            OrdiniDao dao = new SqlOrdiniDao();
            try {
                ordine = dao.getOrdiniById(idOrdine);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher;
        if(us.isPresent() && ordine!=null) {
            request.setAttribute("ordine",ordine);
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/pagamento.jsp");
        }else{
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Optional<Utente> us= UtenteService.getUtente(request);
        if(us!=null){
            String indirizzoEmail = request.getParameter("indirizzoEmail");
            String indirizzo = request.getParameter("indirizzo");
            String citta = request.getParameter("citta");
            String nazione = request.getParameter("nazione");
            String codicePostale = request.getParameter("codicePostale");
            int idOrdine = Integer.parseInt(request.getParameter("idOrdine"));
            PagamentoOrdineDao daoPagamentoOrdine = new SqlPagamentoOrdineDao();
            OrdiniDao daoOrdini = new SqlOrdiniDao();
            RequestDispatcher requestDispatcher;
            try {
                Ordini ordine = daoOrdini.getOrdiniById(idOrdine);
                if(us.get().getIdUtente()==ordine.getKsUtente()) {
                    if(ordine.getKsStatoOrdini()==1) {
                        daoPagamentoOrdine.aggiungiPagamentoOrdine(idOrdine, indirizzo, citta, nazione, codicePostale, indirizzoEmail);
                        daoOrdini.modificaStatoOrdine(idOrdine, 2);
                        requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/succesPage.jsp");
                    }else{
                        throw new PagamentoAlreadyDoneException();
                    }
                }else{
                    throw new PermissionDeniedException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
            } catch (PermissionDeniedException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
            } catch (PagamentoAlreadyDoneException e) {
                e.printStackTrace();
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
            }
            requestDispatcher.forward(request,response);
        }
    }
}
