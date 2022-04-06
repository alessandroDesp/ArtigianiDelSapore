package controller;

import model.foto.FotoDao;
import model.foto.SqlFotoDao;
import model.prodotti.Prodotti;
import model.prodotti.ProdottiDao;
import model.prodotti.SqlProdottiDao;
import model.prodotti.prodottiException.ProdottiNotFoundException;
import model.utente.Utente;
import utility.UtenteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "DettagliProdotto", value = "/DettagliProdotto")
public class DettagliProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProdotto = Integer.parseInt(request.getParameter("id"));
        ProdottiDao dao = new SqlProdottiDao();
        FotoDao daoFoto = new SqlFotoDao();
        RequestDispatcher requestDispatcher;
        Optional<Utente> us= UtenteService.getUtente(request);
        if(us.isPresent())
        {
            HttpSession session=request.getSession(true);
            session.setAttribute(utility.Utilita.SESSION_USER,us.get());
        }
        try {
            Prodotti prodotto = dao.getProdottoById(idProdotto);
            prodotto.setFotoPath(daoFoto.getFotoByProdottoId(idProdotto));
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/dettagliProdotto.jsp");
            request.setAttribute("prodotto",prodotto);
        } catch (SQLException e) {
            e.printStackTrace();
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
        } catch (ProdottiNotFoundException e) {
            e.printStackTrace();
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/notificationPage/errorPage.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
