package controller.api;

import model.listaDesideri.ListaDesideri;
import model.listaDesideriProdotti.ListaDesideriProdotti;
import model.listaDesideriProdotti.SqlListaDesideriProdottiDao;
import model.utente.Utente;
import org.json.JSONObject;
import utility.Utilita;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RimuoviDaListaDesideri", value = "/RimuoviDaListaDesideri")
public class RimuoviDaListaDesideri extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int prodottiId = Integer.parseInt(request.getParameter("textIdProdotto"));
        HttpSession session=request.getSession(true);
        Utente us=(Utente)session.getAttribute(utility.Utilita.SESSION_USER);
        ListaDesideri ld=(ListaDesideri) session.getAttribute(Utilita.SESSION_LISTADESIDERI);
        JSONObject obj=new JSONObject();
        SqlListaDesideriProdottiDao dao = new SqlListaDesideriProdottiDao();
        try {
            dao.remove(prodottiId, ld.getIdListaDesideri());
            obj.put("Ris",1);
            obj.put("Mess","Fatto");
            response.getOutputStream().print(obj.toString());
        } catch (SQLException e) {
            obj.put("Ris",0);
            obj.put("Mess","Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
            response.getOutputStream().print(obj.toString());
        }

    }
}
