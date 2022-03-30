package model.ordiniProdotti;

import model.prodotti.Prodotti;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlOrdiniProdottiDao implements OrdiniProdottiDao{

    @Override
    public OrdiniProdotti aggiungiOrdiniProdotti(int idOrdine,int idProdotto,int quantita)  throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO OrdiniProdotti (ksOrdini,ksProdotti,quantita) VALUES(?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idOrdine);
            ps.setInt(2,idProdotto);
            ps.setInt(3,quantita);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                return null;
            }
            return new OrdiniProdotti(id,quantita,idOrdine,idProdotto);
        }
    }

    @Override
    public List<Prodotti> getProdottiDaOrdiniProdotti(int idOrdine)  throws SQLException {
        List<Prodotti> prodottiList = new ArrayList<>();
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("SELECT p.*,op.quantita FROM prodotti as p, ordiniprodotti as op where op.ksOrdini = ? && op.ksProdotti = p.idProdotti",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idOrdine);
            ResultSet rs = ps.executeQuery();;
            while (rs.next()) {
                Prodotti p = createProdotti(rs);
                p.setQuantitaDaAcquistare(rs.getInt("quantita"));
                prodottiList.add(p);
            }
            return prodottiList;
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
