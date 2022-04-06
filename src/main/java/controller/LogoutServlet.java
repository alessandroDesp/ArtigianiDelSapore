package controller;

import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/Logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(utility.Utilita.SESSION_USER);
        session.removeAttribute(Utilita.SESSION_CARRELLO);
        Cookie c1 = new Cookie(utility.Utilita.COOKIE_ID,"");
        c1.setMaxAge(0);
        Cookie c2 = new Cookie(utility.Utilita.COOKIE_TOKEN,"");
        c2.setMaxAge(0);
        response.addCookie(c1);
        response.addCookie(c2);
        response.sendRedirect("./");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
