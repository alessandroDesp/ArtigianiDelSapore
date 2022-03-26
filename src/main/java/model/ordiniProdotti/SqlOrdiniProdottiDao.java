package model.ordiniProdotti;

import utility.Connect;

import java.sql.*;

public class SqlOrdiniProdottiDao implements OrdiniProdottiDao{

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
}
