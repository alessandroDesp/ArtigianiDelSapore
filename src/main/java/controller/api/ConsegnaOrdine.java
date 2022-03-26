package controller.api;

import model.ordini.OrdiniDao;
import model.ordini.SqlOrdiniDao;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ConsegnaOrdine", value = "/ConsegnaOrdine")
public class ConsegnaOrdine extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject obj = new JSONObject();
        int idOrdine = Integer.parseInt(request.getParameter("idOrdine"));
        OrdiniDao dao = new SqlOrdiniDao();
        try {
            dao.consegnaOrdine(idOrdine,3);
            obj.put("Ris",1);
            obj.put("Mess","Fatto");
            response.getOutputStream().print(obj.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            obj.put("Ris",0);
            obj.put("Mess","Si e' verificato un errore, riprovare piu' tardi o contattare l'assistenza");
            response.getOutputStream().print(obj.toString());
        }
    }
}
