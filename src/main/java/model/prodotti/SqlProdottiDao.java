package model.prodotti;

import model.prodotti.prodottiException.ProdottiNotFoundException;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlProdottiDao implements ProdottiDao{
    public List<Prodotti> getAllProdotti() throws SQLException {
        ArrayList<Prodotti> prodotti = new ArrayList<>();
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM Prodotti",Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prodotti.add(createProdotti(rs));
            }
        }
        return prodotti;
    }

    public Prodotti getProdottoById(int idProdotto) throws SQLException,ProdottiNotFoundException {
        Prodotti p;
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM Prodotti WHERE idProdotti=?",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idProdotto);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                p = createProdotti(rs);
            }else{
                throw new ProdottiNotFoundException();
            }
        }
        return p;
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
