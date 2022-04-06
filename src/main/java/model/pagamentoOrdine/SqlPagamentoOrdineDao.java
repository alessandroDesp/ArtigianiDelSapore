package model.pagamentoOrdine;

import model.ordiniProdotti.OrdiniProdotti;
import utility.Connect;

import java.sql.*;

public class SqlPagamentoOrdineDao implements PagamentoOrdineDao{

    @Override
    public PagamentoOrdine aggiungiPagamentoOrdine(int idOrdine, String indirizzo, String citta, String nazione, String codicePostale, String indirizzoEmail)  throws SQLException {
        try (Connection con = Connect.getConnection()) {
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO pagamentoordine (ksOrdini,indirizzoEmail,indirizzo,citta,nazione,codicePostale) VALUES(?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idOrdine);
            ps.setString(2,indirizzoEmail);
            ps.setString(3,indirizzo);
            ps.setString(4,citta);
            ps.setString(5,nazione);
            ps.setString(6,codicePostale);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                return null;
            }
            return new PagamentoOrdine(id,idOrdine,indirizzoEmail,indirizzo,citta,nazione,codicePostale);
        }
    }
}
