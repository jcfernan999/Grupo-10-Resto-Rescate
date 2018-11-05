/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MeseroData {
  private Connection connection = null;

    public MeseroData(Conexion conexion) 
    {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
     //-------------------------------Guardar datos 
    public void guardarMesero(Mesero mesero)
    {
        try {
            
            String sql = "INSERT INTO mesero (nombre, dni, activo) VALUES ( ?, ?, ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mesero.getNombre());
            statement.setInt(2, mesero.getDni());
            statement.setBoolean(3, mesero.getActivo());

            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                mesero.setIdMesero(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un Mesero");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un Mesero: " + ex.getMessage());
        }
    }
    
    //-------------------------------Litar datos 
    public List<Mesero> obtenerMesero(){
        List<Mesero> meseros = new ArrayList<Mesero>();
            

        try {
            String sql = "SELECT * FROM mesero;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            while(resultSet.next()){
                mesero =new Mesero();
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
//                mesero.setApellido(resultSet.getString("apellido"));
                mesero.setDni(resultSet.getInt("dni"));
                mesero.setActivo(resultSet.getBoolean("activo"));
                

                meseros.add(mesero);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Meseros: " + ex.getMessage());
        }
        return meseros;
    }
    public List<Mesero> obtenerMesero(String tipo,String dato){
        List<Mesero> meseros = new ArrayList<Mesero>();
        String sql;    
        PreparedStatement statement;
        try {
            if("Nombre".equals(tipo))
            {
                sql = "SELECT * FROM mesero WHERE nombre = ? AND activo = 1 ;";
                 statement = connection.prepareStatement(sql);
                statement.setString(1,dato);
            }
            else if("DNI".equals(tipo))
            {
                sql = "SELECT * FROM mesero WHERE dni = ? AND activo = 1 ;";
                 statement = connection.prepareStatement(sql);
                statement.setInt(1,Integer.parseInt(dato));
            }
            else if("".equals(tipo))
            {
                sql = "SELECT * FROM mesero WHERE activo = 1;";
                statement = connection.prepareStatement(sql);
                
            }else if("Activos".equals(tipo))
            {
                sql = "SELECT * FROM mesero WHERE activo = 1;";
                statement = connection.prepareStatement(sql);    
            }
            else{
                sql = "SELECT * FROM mesero WHERE activo = 0;";
                 statement = connection.prepareStatement(sql);
            }
            
         
            ResultSet resultSet = statement.executeQuery();
            Mesero  mesero;
            while(resultSet.next()){
               mesero = new Mesero();
               mesero.setIdMesero(resultSet.getInt("idMesero"));
               mesero.setNombre(resultSet.getString("nombre"));
               mesero.setDni(resultSet.getInt("dni"));
               mesero.setActivo(resultSet.getBoolean("activo"));

               meseros.add(mesero);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la Mesa: " + ex.getMessage());
        }
        return meseros;
    }
    
    
    public List<Mesero> obtenerMeseros(String nombre){
    List<Mesero> meseros = new ArrayList<Mesero>();
            

        try {
            String sql = "Select * from mesero where nombre =?";
                    
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            while(resultSet.next()){
                mesero = new Mesero();
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
//                mesero.setNombre(resultSet.getString("apellido"));
                meseros.add(mesero);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Meseros: " + ex.getMessage());
        }
        
        
        return meseros;
      
    }

    //-------------------------------Buscar
    public Mesero buscarMesero(int id){
        Mesero mesero=null;
    try {
        String sql = "SELECT * FROM mesero WHERE idMesero = ?;";

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, id);   
            
        ResultSet resultSet=statement.executeQuery();
            
        while(resultSet.next()){
            mesero = new Mesero();
            mesero.setIdMesero(resultSet.getInt("idMesero"));
            mesero.setNombre(resultSet.getString("nombre"));
            mesero.setDni(resultSet.getInt("dni"));
            mesero.setActivo(resultSet.getBoolean("activo"));
            
        }      
        statement.close();
    } 
    catch (SQLException ex){
        System.out.println("Error al buscar un mesero: " + ex.getMessage());
    }
        
        return mesero;
    }
    
     //-------------------------------ACTUALIZAR
    public void actualizarMesero(Mesero mesero){
    
        try {
            
            String sql = "UPDATE mesero SET nombre = ?, dni = ?, activo = ? WHERE idMesero = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mesero.getNombre());
            statement.setInt(2, mesero.getDni());
            statement.setBoolean(3, mesero.getActivo());
            statement.setInt(4, mesero.getIdMesero());
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Modidicar una Mesa: " + ex.getMessage());
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
    public Mesero buscarUsuario(String usuario, String pass){
        Mesero mesero=null;
    try {
        String sql = "SELECT * FROM mesero WHERE nombre = ? and dni = ?;";

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, usuario);   
        statement.setString(2, pass);    
        ResultSet resultSet=statement.executeQuery();
            
        while(resultSet.next()){
            mesero = new Mesero();
            mesero.setIdMesero(resultSet.getInt("idMesero"));
            mesero.setNombre(resultSet.getString("nombre"));
            mesero.setDni(resultSet.getInt("dni"));
            mesero.setActivo(resultSet.getBoolean("activo"));
            
        }      
        statement.close();
    } 
    catch (SQLException ex){
        System.out.println("errorororror: " + ex.getMessage());
    }
        
        return mesero;
    }
    public Mesero buscarMeseroPorDni(int dni){
        Mesero mesero=null;
        try {
            String sql = "SELECT * FROM mesero WHERE dni = ? and activo = 1;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);   

            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                mesero = new Mesero();
                mesero.setIdMesero(resultSet.getInt("idMesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));
                mesero.setActivo(resultSet.getBoolean("activo"));

            }      
            statement.close();
        } 
        catch (SQLException ex){
            System.out.println("Error al Buscar un Mesero: " + ex.getMessage());
        }
        return mesero;
    }
}
