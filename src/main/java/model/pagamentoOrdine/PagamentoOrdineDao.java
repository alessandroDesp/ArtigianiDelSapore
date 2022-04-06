package model.pagamentoOrdine;

import java.sql.SQLException;

public interface PagamentoOrdineDao {
    PagamentoOrdine aggiungiPagamentoOrdine(int idOrdine, String indirizzo, String citta, String nazione, String codicePostale, String indirizzoEmail)  throws SQLException;
}
