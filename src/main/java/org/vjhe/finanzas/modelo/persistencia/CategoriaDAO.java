package org.vjhe.finanzas.modelo.persistencia;

import org.vjhe.finanzas.modelo.Categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void guardar(Categoria categoria){
        String query = "INSERT INTO categorias(nombre) VALUES(?)";
        try (PreparedStatement statement =  ConexionDB.getConnection().prepareStatement(query)){
            statement.setString(1, categoria.toString());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la nueva categoria", e);
        }
    }

    public List<Categoria> obtenerTodos(){
        String query = "SELECT * FROM categorias";
        List<Categoria> categoriaList = new ArrayList<>()   ;
        try (Statement statement = ConexionDB.getConnection().createStatement();
             ResultSet rs =  statement.executeQuery(query)){
            while (rs.next()){
                categoriaList.add(parseCategoria(rs));
            }
        } catch (SQLException e){
            throw new RuntimeException("Error al obtener las categorias");
        }
        return categoriaList;

    }

    private Categoria parseCategoria(ResultSet rs) throws SQLException {
        int id =  rs.getInt(1);
        String nombre = rs.getString(2);
        return new Categoria(id, nombre);
    }

    public static void main(String[] args) {
        System.out.println(new CategoriaDAO().obtenerTodos());
    }
}
