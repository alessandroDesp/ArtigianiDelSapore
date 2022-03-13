package model.statoOrdini;

import model.ruolo.Ruolo;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlStatoOrdiniDao implements StatoOrdiniDao{
    @Override
    public List<StatoOrdini> getAllStatoOrdini() throws SQLException {
        ArrayList<StatoOrdini> listStatoOrdini = new ArrayList<>();
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM StatoOrdini",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listStatoOrdini.add(createStatoOrdini(rs));
            }
            return listStatoOrdini;
        }
    }

    StatoOrdini createStatoOrdini(ResultSet rs) throws SQLException {
        int id = rs.getInt("idStatoOrdini");
        String stato = rs.getString("stato");
        return new StatoOrdini(id,stato);

    }
}
