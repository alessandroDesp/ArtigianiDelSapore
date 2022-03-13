package model.listaDesideriProdotti;

import model.listaDesideriProdotti.listaDesideriProdottiException.ListaDesideriProdottiAlreadyExstistException;
import model.prodotti.Prodotti;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlListaDesideriProdottiDao implements ListaDesideriProdottiDao{
    @Override
    public boolean alreadyExsist(int idProdotto,int idListaDesideri) throws SQLException,ListaDesideriProdottiAlreadyExstistException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM ListaDesideriProdotti WHERE ksProdotti=? AND ksListaDesideri=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idProdotto);
            ps.setInt(2,idListaDesideri);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return true;
            } else {
                throw new ListaDesideriProdottiAlreadyExstistException();
            }
        }
    }

    @Override
    public List<Prodotti> getFromListaDesideri(int idListaDesideri) throws SQLException {
        ArrayList<Prodotti> listaProdotti = new ArrayList<>();
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("SELECT p.* FROM ListaDesideriProdotti as ldp, Prodotti as p WHERE ldp.ksListaDesideri=? AND ldp.KsProdotti = p.idProdotti",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idListaDesideri);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                listaProdotti.add(createProdotti(rs));
            }
            return listaProdotti;
        }
    }

    @Override
    public ListaDesideriProdotti insert(int idProdotto,int idListaDesideri) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO ListaDesideriProdotti (ksListaDesideri ,ksProdotti) VALUES(?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idListaDesideri);
            ps.setInt(2, idProdotto);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                return null;
            }
            return new ListaDesideriProdotti(id,idProdotto,idListaDesideri);
        }
    }

    @Override
    public void remove(int idProdotto,int idListaDesideri) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("DELETE FROM ListaDesideriProdotti WHERE ksListaDesideri=? AND ksProdotti=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idListaDesideri);
            ps.setInt(2, idProdotto);
            ps.executeUpdate();
        }
    }

    private Prodotti createProdotti(ResultSet rs) throws SQLException {
        int id = rs.getInt("idProdotti");
        String nome = rs.getString("nome");
        float prezzo = rs.getFloat("prezzo");
        int quantitaAttuale = rs.getInt("quantitaAttuale");
        int quantitaVenduta = rs.getInt("quantitaVenduta");
        float sconto = rs.getFloat("sconto");
        String descrizione = rs.getString("descrizione");
        return new Prodotti(id, nome, prezzo, quantitaAttuale, quantitaVenduta, sconto, descrizione);
    }
}
