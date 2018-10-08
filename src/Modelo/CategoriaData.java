/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kenchiro
 */
public class CategoriaData {
    private Connection connection = null;

    public CategoriaData(Conexion conexion) 
    {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
     //-------------------------------Guardar datos 
    public void guardarCategoria(Categoria categoria)
    {
        try {
            
            String sql = "INSERT INTO categoria (nombre, descripcion) VALUES ( ?, ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoria.getNombre());
            statement.setString(2, categoria.getDescripcion());
//            statement.setBoolean(3, categoria.getActivo());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                categoria.setIdCategoria(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una categoria");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una categoria: " + ex.getMessage());
        }
    }
    
    //-------------------------------Litar datos 
    public List<Categoria> obtenerCategorias(){
        List<Categoria> categorias = new ArrayList<Categoria>();
            

        try {
            String sql = "SELECT * FROM categoria;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Categoria categoria;
            while(resultSet.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                

                categorias.add(categoria);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las categoria: " + ex.getMessage());
        }
        return categorias;
    }
    
    public List<Categoria> obtenerCategoria(String nombre){
    List<Categoria> Categorias = new ArrayList<Categoria>();
            

        try {
            String sql = "Select * from categoria where nombre =?";
                    
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            Categoria categoria;
            while(resultSet.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                
                Categorias.add(categoria);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Categorias: " + ex.getMessage());
        }
        
        
        return Categorias;
      
    }

    //-------------------------------Buscar
    public Categoria buscarCategoria(int id){
        Categoria categoria=null;
    try {
            
            String sql = "SELECT * FROM categoria WHERE idCategoria =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("errorororror: " + ex.getMessage());
        }
        
        return categoria;
    }
    
     //-------------------------------ACTUALIZAR
    public void actualizarCategoria(Categoria categoria){
    
        try {
            
            String sql = "UPDATE categoria SET nombre = ?, descripcion = ? WHERE idCategoria = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoria.getNombre());
            statement.setString(2, categoria.getDescripcion());
            statement.setInt(3, categoria.getIdCategoria());
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Modidicar una Categoria: " + ex.getMessage());
        }
    
    }
    
     //-------------------------------Borrar
    public void borrarCategoria(int id){
    try {
            
            String sql = "DELETE FROM categoria WHERE idCategoria =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
    
    }
}
