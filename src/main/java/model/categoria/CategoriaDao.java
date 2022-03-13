package model.categoria;

import java.sql.SQLException;
import java.util.List;

public interface CategoriaDao {
    Categoria getCategoriaByNome(String nome) throws SQLException;
    List<Categoria> getAll() throws SQLException;
}
