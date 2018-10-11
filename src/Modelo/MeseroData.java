/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
import Modelo.Mesero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author quitian
 */
public class MeseroData {
    private Connection connection = null;

    public MeseroData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    public void guardarMesero(Mesero mesero){
        try {
            
            String sql = "INSERT INTO cliente (idMesero, nombre, dni, activo) VALUES ( ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesero.getIdMesero());
            statement.setString(2,mesero.getNombre());
            statement.setInt(3, mesero.getDni());
            statement.setBoolean(4, mesero.getActivo());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                mesero.setIdMesero(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un mesero");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un mesero: " + ex.getMessage());
        }
    }
        public void actualizarMesero(Mesero mesero){
    
        try {
            
            String sql = "UPDATE categoria SET nombre = ?, dni = ?, activo = ? WHERE idmesero = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesero.getIdMesero());
            statement.setString(2, mesero.getNombre());
            statement.setInt(3, mesero.getDni());
            statement.setBoolean(4, mesero.getActivo());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un mesero: " + ex.getMessage());
        }
    
    }
         public Mesero buscarMesero(int id){
    Mesero mesero=null;
    try {
            
            String sql = "SELECT * FROM mesero WHERE idmesero =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                mesero = new Mesero();
                mesero.setIdMesero(resultSet.getInt("idmesero"));
                mesero.setNombre(resultSet.getString("nombre"));
                mesero.setDni(resultSet.getInt("dni"));
                mesero.setActivo(resultSet.getBoolean("activo"));

                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un mesero: " + ex.getMessage());
        }
        
        return mesero;
    }
         
         public void borrarMesero(int idMesero){
    try {
            
            String sql = "DELETE FROM mesero WHERE idmesero =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idMesero);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un mesero: " + ex.getMessage());
        }
        
    
    }

    public void agregarMesero(Mesero mesero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
