package model.ordini;

import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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

    @Override
    public Ordini aggiungiOrdine(int idUtente,int ksStatoOrdini,float prezzoTotale) throws SQLException {
        Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO ordini (ksUtente,ksStatoOrdini,prezzoTotale,data) VALUES (?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idUtente);
            ps.setInt(2,ksStatoOrdini);
            ps.setFloat(3,prezzoTotale);
            ps.setDate(4,date1);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                return null;
            }
            return new Ordini(id,prezzoTotale,date1,idUtente,ksStatoOrdini);
        }
    }

    @Override
    public void consegnaOrdine(int idOrdine,int ksStatoOrdini) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Ordini SET ksStatoOrdini=? WHERE idOrdini=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,ksStatoOrdini);
            ps.setInt(2,idOrdine);
            ps.executeUpdate();
        }
    }

    private Ordini createOrdini(ResultSet rs) throws SQLException {
        int id = rs.getInt("idOrdini");
        int ksUtente = rs.getInt("ksUtente");
        int ksStatoOrdini = rs.getInt("ksStatoOrdini");
        float prezzoTotale = rs.getFloat("prezzoTotale");
        java.sql.Date data = rs.getDate("data");

        return new Ordini(id, prezzoTotale, data, ksUtente, ksStatoOrdini);
    }
}
