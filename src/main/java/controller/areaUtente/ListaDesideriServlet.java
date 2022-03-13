package controller.areaUtente;

import model.listaDesideri.ListaDesideri;
import model.listaDesideri.ListaDesideriDao;
import model.listaDesideri.SqlListaDesideriDao;
import model.listaDesideri.listaDesideriException.ListaDesideriNotFoundException;
import model.listaDesideriProdotti.ListaDesideriProdotti;
import model.listaDesideriProdotti.SqlListaDesideriProdottiDao;
import model.prodotti.Prodotti;
import model.utente.Utente;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ListaDesideri", value = "/ListaDesideri")
public class ListaDesideriServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Utente> us= UtenteService.getUtente(request);
        if(!us.isPresent())
        {
            response.sendRedirect("./");
        }
        else
        {
            ListaDesideriDao daoListaDesideri = new SqlListaDesideriDao();
            SqlListaDesideriProdottiDao daoListaDesideriProdotti = new SqlListaDesideriProdottiDao();
            try {
                ListaDesideri listaDesideri = daoListaDesideri.getByUtenteId(us.get().getIdUtente());
                List<Prodotti> listaProdotti = daoListaDesideriProdotti.getFromListaDesideri(listaDesideri.getIdListaDesideri());
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/areaUtente/listaDesideri.jsp");
                request.setAttribute("listaProdotti",listaProdotti);
                request.setAttribute("Tipo",2);
                requestDispatcher.forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ListaDesideriNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
