package model.categoria;

import model.prodotti.Prodotti;
import utility.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlCategoriaDao implements CategoriaDao{
    @Override
    public Categoria getCategoriaByNome(String nome) throws SQLException {
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM Categoria WHERE nome=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createCategoria(rs);
            }
        }
        return null;
    }
    @Override
    public List<Categoria> getAll() throws SQLException {
        ArrayList<Categoria> listaCategoria = new ArrayList<>();
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("SELECT * FROM Categoria",
                            Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 listaCategoria.add(createCategoria(rs));
            }
            return listaCategoria;
        }
    }

    @Override
    public Categoria creaCategoria(String nome) throws SQLException {
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("INSERT INTO Categoria (nome) VALUES (?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,nome);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id;
            if(rs.next()){
                id = rs.getInt(1);
            }else{
                return null;
            }
            return new Categoria(id,nome);
        }
    }

    @Override
    public Categoria modificaCategoria(int idCategoria,String nome) throws SQLException {
        try (Connection con = Connect.getConnection()){
            PreparedStatement ps = con.prepareStatement
                    ("UPDATE Categoria SET nome=? WHERE idCategoria=?",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,nome);
            ps.setInt(2,idCategoria);
            ps.executeUpdate();
            return new Categoria(idCategoria,nome);
        }
    }

    private Categoria createCategoria(ResultSet rs) throws SQLException {
        int idCategoria = rs.getInt("idCategoria");
        String nome = rs.getString("nome");
        return new Categoria(idCategoria, nome);
    }
}
