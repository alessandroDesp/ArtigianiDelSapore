package controller;

import model.prodotti.Prodotti;
import model.utente.Utente;
import utility.UtenteService;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "Carrello", value = "/Carrello")
public class CarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        Optional<Utente> us= UtenteService.getUtente(request);
        if(!us.isPresent())
        {
            response.sendRedirect("./");
        }
        else {
            List<Prodotti> prodottiSession = (List<Prodotti>) session.getAttribute(Utilita.SESSION_CARRELLO);
            List<Prodotti> prodottiList = new ArrayList<>();
            if (prodottiSession != null)
                prodottiList = prodottiSession;
            RequestDispatcher requestDispatcher;
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/cart.jsp");
            request.setAttribute("listaProdotti", prodottiList);
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
