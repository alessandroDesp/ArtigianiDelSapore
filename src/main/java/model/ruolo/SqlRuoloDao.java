package model.ruolo;

import model.utente.Utente;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlRuoloDao implements RuoloDao{
    @Override
    public List<Ruolo> getAllRuolo() throws SQLException {
        ArrayList<Ruolo> listaRuolo = new ArrayList<>();
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Ruolo",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaRuolo.add(createRuolo(rs));
            }
            return listaRuolo;
        }
    }

    Ruolo createRuolo(ResultSet rs) throws SQLException {
        int id = rs.getInt("idRuolo");
        String ruolo = rs.getString("ruolo");
        return new Ruolo(id,ruolo);

    }
}
