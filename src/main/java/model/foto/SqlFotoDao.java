package model.foto;

import model.categoria.Categoria;
import utility.Connect;

import java.sql.*;

public class SqlFotoDao implements FotoDao{

    @Override
    public Foto creaFoto(String path,int idProdotti) throws SQLException {
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO Foto (ksProdotti,percorso) VALUES (?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idProdotti);
            ps.setString(2,path);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if(rs.next()){
                id = rs.getInt(1);
            }else{
                return null;
            }
            return new Foto(id,idProdotti,path);
        }
    }

    @Override
    public String getFotoByProdottoId(int idProdotti) throws SQLException {
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("SELECT percorso FROM Foto as f WHERE ksProdotti = ?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idProdotti);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }else{
                return null;
            }
        }
    }
}
