package controller;

import model.prodotti.Prodotti;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Carrello", value = "/Carrello")
public class CarrelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        List<Prodotti> prodottiSession = (List<Prodotti>) session.getAttribute(Utilita.SESSION_CARRELLO);
        RequestDispatcher requestDispatcher;
        requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/cart.jsp");
        request.setAttribute("listaProdotti",prodottiSession);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
