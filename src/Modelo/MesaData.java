package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MesaData {
    private Connection connection = null;
     private Conexion conexion;

    public MesaData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    public void guardarMesa(Mesa mesa){
        try {
            
            String sql = "INSERT INTO mesa (capacidad, estado, activo) VALUES ( ? , ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, mesa.getCapacidad());
            statement.setInt(2, mesa.getEstado());
            statement.setBoolean(3, mesa.getActivo());
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) {
                mesa.setIdMesa(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una Mesa");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una Mesa: " + ex.getMessage());
        }
    }
    
     //-------------------------------ACTUALIZAR
    public void actualizarMesa(Mesa mesa){
    
        try {
            
            String sql = "UPDATE mesa SET capacidad = ?, estado = ? , activo = ? WHERE idMesa = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesa.getCapacidad());
            statement.setInt(2, mesa.getEstado());
            statement.setBoolean(3, mesa.getActivo());
            statement.setInt(4, mesa.getIdMesa());
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Modidicar una Mesa: " + ex.getMessage());
        }
    
    }
    
    public List<Mesa> obtenerMesa(int  cap){
        List<Mesa> mesas = new ArrayList<Mesa>();
            

        try {
            String sql = "SELECT * FROM mesa WHERE capacidad = ? AND activo = 1;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,cap);
         
            ResultSet resultSet = statement.executeQuery();
            Mesa  mesa;
            while(resultSet.next()){
               mesa = new Mesa();
               mesa.setIdMesa(resultSet.getInt("idMesa"));
               mesa.setCapacidad(resultSet.getInt("capacidad"));
               mesa.setEstado(resultSet.getInt("estado"));
//               mesa.setActivo(resultSet.getBoolean("activo"));
              
                
               mesas.add(mesa);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la Mesa: " + ex.getMessage());
        }
        
        
        return mesas;
    }
    public List<Mesa> listaDeCapacidad(){
        List<Mesa> mesas = new ArrayList<Mesa>();
            

        try {
            String sql = "SELECT DISTINCT capacidad FROM mesa ;";
            PreparedStatement statement = connection.prepareStatement(sql);
           
         
            ResultSet resultSet = statement.executeQuery();
            Mesa  mesa;
            while(resultSet.next()){
               mesa = new Mesa();
              
               mesa.setCapacidad(resultSet.getInt("capacidad"));
              
               
               mesas.add(mesa);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las mesas: " + ex.getMessage());
        }
        
        
        return mesas;
    }

    public Mesa buscarMesa(int id){
    Mesa mesa=null;
    try {
            String sql = "SELECT * FROM mesa WHERE idMesa = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                mesa = new Mesa();
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setCapacidad(resultSet.getInt("capacidad"));
                mesa.setEstado(resultSet.getInt("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar una mesa: " + ex.getMessage());
        }
        
        return mesa;
    }

    




}
