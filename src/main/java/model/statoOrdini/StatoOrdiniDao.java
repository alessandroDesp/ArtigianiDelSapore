package model.statoOrdini;

import java.sql.SQLException;
import java.util.List;

public interface StatoOrdiniDao {
    List<StatoOrdini> getAllStatoOrdini() throws SQLException;
}
