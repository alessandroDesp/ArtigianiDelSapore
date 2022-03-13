package controller;

import model.ruolo.Ruolo;
import model.ruolo.RuoloDao;
import model.ruolo.SqlRuoloDao;
import model.statoOrdini.SqlStatoOrdiniDao;
import model.statoOrdini.StatoOrdini;
import model.statoOrdini.StatoOrdiniDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet",loadOnStartup = 1)
public class StartServer extends HttpServlet
{
    public List<Ruolo> getAllRuoli() throws SQLException {
        RuoloDao daoRuolo = new SqlRuoloDao();
        return daoRuolo.getAllRuolo();
    }

    public List<StatoOrdini> getAllStato() throws SQLException {
        StatoOrdiniDao daoStatoOrdini = new SqlStatoOrdiniDao();
        return daoStatoOrdini.getAllStatoOrdini();
    }
    @Override
    public void init() throws ServletException
    {
        super.init();
        try {
            utility.Utilita.listRuoli=getAllRuoli();
            utility.Utilita.listStato=getAllStato();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}