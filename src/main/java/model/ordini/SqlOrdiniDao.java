package model.ordini;

import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlOrdiniDao implements OrdiniDao{

    @Override
    public List<Ordini> getAll() throws SQLException {
        ArrayList<Ordini> listaOrdini = new ArrayList<>();
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM ordini",
                            Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                listaOrdini.add(createOrdini(rs));
            }
            return listaOrdini;
        }
    }

    @Override
    public List<Ordini> getOrdiniByUtente(int idUtente) throws SQLException {
        ArrayList<Ordini> listaOrdini = new ArrayList<>();
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM ordini  WHERE ksUtente=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idUtente);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                listaOrdini.add(createOrdini(rs));
            }
            return listaOrdini;
        }
    }


    private Ordini createOrdini(ResultSet rs) throws SQLException {
        int id = rs.getInt("idOrdini");
        int ksUtente = rs.getInt("ksUtente");
        int ksStatoOrdini = rs.getInt("ksStatoOrdini");
        float prezzoTotale = rs.getFloat("prezzoTotale");
        Date data = rs.getDate("data");

        return new Ordini(id, prezzoTotale, data, ksUtente, ksStatoOrdini);
    }
}
