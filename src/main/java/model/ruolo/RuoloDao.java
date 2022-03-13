package model.ruolo;

import java.sql.SQLException;
import java.util.List;

public interface RuoloDao {
    List<Ruolo> getAllRuolo()throws SQLException;
}
