package model.foto;

import java.sql.SQLException;

public interface FotoDao {
    Foto creaFoto(String path,int idProdotti) throws SQLException;
    String getFotoByProdottoId(int idProdotti) throws SQLException;
}
