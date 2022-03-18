package model.prodotti;

import model.prodotti.prodottiException.ProdottiNotFoundException;
import model.utente.Utente;
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

    public Prodotti insertProdotto(String nome,float prezzo,float sconto,int quantitaAttuale,int quantitaVenduta,String descrizione) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO Prodotti (nome,prezzo,sconto,quantitaAttuale,quantitaVenduta,descrizione) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nome);
            ps.setFloat(2, prezzo);
            ps.setFloat(3, sconto);
            ps.setInt(4, quantitaAttuale);
            ps.setInt(5, quantitaVenduta);
            ps.setString(6, descrizione);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                return null;
            }
            return new Prodotti(id,nome,prezzo,quantitaAttuale,quantitaVenduta,sconto,descrizione);
        }
    }

    @Override
    public void modificaProdotto(int idProdotti, String nome, float prezzo, float sconto, int quantitaAttuale, int quantitaVenduta, String descrizione) throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("UPDATE Prodotti Set nome=?,prezzo=?,sconto=?,quantitaAttuale=?,quantitaVenduta=?,descrizione=? WHERE idProdotti=?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nome);
            ps.setFloat(2, prezzo);
            ps.setFloat(3, sconto);
            ps.setInt(4, quantitaAttuale);
            ps.setInt(5, quantitaVenduta);
            ps.setString(6, descrizione);
            ps.setInt(7, idProdotti);
            ps.executeUpdate();
        }
    }

    public Prodotti getProdottoById(int idProdotto) throws SQLException,ProdottiNotFoundException {
        Prodotti p;
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM Prodotti WHERE idProdotti=?",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idProdotto);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = createProdotti(rs);
            }else{
                throw new ProdottiNotFoundException();
            }
        }
        return p;
    }

    public ArrayList<Prodotti> getProdottoByName(String nProdotto) throws SQLException {

        ArrayList<Prodotti> prodotti = new ArrayList<>();



        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Prodotti WHERE nome LIKE ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "%" + nProdotto + "%");

            ResultSet rs = ps.executeQuery();

            while ( rs.next() ){
                prodotti.add(createProdotti(rs));
            }

        }

        return prodotti;
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
