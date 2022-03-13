package controller;

import model.utente.Utente;
import utility.UtenteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "StartServlet", value = "")
public class StartServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/views/index.jsp");
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.isPresent())
        {
            HttpSession session=request.getSession(true);
            session.setAttribute(utility.Utilita.SESSION_USER,us.get());
        }
        requestDispatcher.forward(request,response);
    }


}