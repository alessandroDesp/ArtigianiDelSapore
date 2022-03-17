package model.prodottiCategoria;

import model.prodotti.Prodotti;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlProdottiCategoriaDao implements ProdottiCategoriaDao{
    @Override
    public List<Prodotti> getProdottiByCategoriaId(int idCategoria) throws SQLException {
        ArrayList<Prodotti> prodotti = new ArrayList<>();
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("SELECT pd.* FROM Prodotti as pd ,ProdottiCategoria as pc WHERE pc.ksCategoria=? " +
                                    "AND pd.idProdotti = pc.ksProdotti",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prodotti.add(createProdotti(rs));
            }
        }
        return prodotti;
    }

    public void addProdottiCategoria(int idCategoria,int idProdotto) throws SQLException {
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO ProdottiCategoria (ksProdotti,ksCategoria) value (?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idProdotto);
            ps.setInt(2, idCategoria);
            ps.executeUpdate();
        }
    }

    private ProdottiCategoria createProdottiCategoria(ResultSet rs) throws  SQLException{
        int idProdottiCategoria = rs.getInt("idProdottiCategoria");
        int ksProdotti = rs.getInt("ksProdotti");
        int ksCategoria = rs.getInt("ksCategoria");
        return new ProdottiCategoria(idProdottiCategoria,ksProdotti,ksCategoria);
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
