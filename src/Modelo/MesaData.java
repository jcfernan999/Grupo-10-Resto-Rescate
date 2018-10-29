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
            
            String sql = "INSERT INTO mesa (nombre,capacidad, estado) VALUES ( ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, mesa.getNombre());
            statement.setInt(2, mesa.getCapacidad());
            statement.setInt(3, mesa.getEstado());
            
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
            
            String sql = "UPDATE mesa SET nombre = ?, capacidad = ?, estado = ? , activo = ? WHERE idMesa = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mesa.getNombre());
            statement.setInt(2, mesa.getCapacidad());
            statement.setInt(3, mesa.getEstado());
            statement.setBoolean(4, mesa.getActivo());
            statement.setInt(5, mesa.getIdMesa());
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Modidicar una Mesa: " + ex.getMessage());
        }
    
    }
    
    public List<Mesa> obtenerMesa(String tipo,String dato){
        List<Mesa> mesas = new ArrayList<Mesa>();
        String sql;    
        PreparedStatement statement;
        try {
            if("Nombre".equals(tipo))
            {
                sql = "SELECT * FROM mesa WHERE nombre = ? AND activo = 1 AND estado = 1;";
                 statement = connection.prepareStatement(sql);
                statement.setString(1,dato);
            }
            else if("Estado".equals(tipo))
            {
                sql = "SELECT * FROM mesa WHERE estado = ? AND activo = 1 AND estado = 1;";
                 statement = connection.prepareStatement(sql);
                statement.setString(1,dato);
            }
            else if("Capacidad".equals(tipo))
            {
                sql = "SELECT * FROM mesa WHERE capacidad = ? AND activo = 1 AND estado = 1;";
                 statement = connection.prepareStatement(sql);
                statement.setInt(1,Integer.parseInt(dato));
            }
             else if("Activos".equals(tipo))
            {
                sql = "SELECT * FROM mesa WHERE activo = 1 AND estado = 1;";
                statement = connection.prepareStatement(sql);
            }
              else if("Desactivado".equals(tipo))
            {
                sql = "SELECT * FROM mesa WHERE activo = 0 AND estado = 1;";
                 statement = connection.prepareStatement(sql);
                
            }
            else{
                sql = "SELECT * FROM mesa WHERE activo = 1 AND estado = 1;";
                statement = connection.prepareStatement(sql);
            }
            
         
            ResultSet resultSet = statement.executeQuery();
            Mesa  mesa;
            while(resultSet.next()){
               mesa = new Mesa();
               mesa.setNombre(resultSet.getString("nombre"));
               mesa.setIdMesa(resultSet.getInt("idMesa"));
               mesa.setCapacidad(resultSet.getInt("capacidad"));
               mesa.setEstado(resultSet.getInt("estado"));

               mesas.add(mesa);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la Mesa: " + ex.getMessage());
        }
        return mesas;
    }

    //-------------------------Pedido
    public List<Mesa> obtenerMesaDetalleBotones(int capacidad){
        List<Mesa> mesas = new ArrayList<Mesa>();
            

        try {
            String sql = "SELECT * FROM mesa WHERE capacidad = ? and activo = 1;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,capacidad);
         
            ResultSet resultSet = statement.executeQuery();
            Mesa  mesa;
            while(resultSet.next()){
               mesa = new Mesa();
               mesa.setNombre(resultSet.getString("nombre"));
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
    //VistaMesaLista,vista reserva y vistamesa2
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
    
//    vista pedido reserva
    public Mesa buscarMesa(int id){
    Mesa mesa=null;
    try {
            String sql = "SELECT * FROM mesa WHERE idMesa = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                mesa = new Mesa();
                mesa.setNombre(resultSet.getString("nombre"));
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setCapacidad(resultSet.getInt("capacidad"));
                mesa.setEstado(resultSet.getInt("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al Buscar una mesa: " + ex.getMessage());
        }
        
        return mesa;
    }
    public void borrarMesa(int id){
    try {
            
            String sql = "UPDATE mesa SET activo = 0 WHERE idMesa = ?;";
//            String sql = "DELETE FROM mesa WHERE idMesa =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Eliminar una Mesa: " + ex.getMessage());
        }
        
    
    }
    //Buscar Mesa por nombre
    public Mesa buscarMesa(String nombre){
    Mesa mesa=null;
    try {
            String sql = "SELECT * FROM mesa WHERE nombre = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombre);
           
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                mesa = new Mesa();
                mesa.setNombre(resultSet.getString("nombre"));
                mesa.setIdMesa(resultSet.getInt("idMesa"));
                mesa.setCapacidad(resultSet.getInt("capacidad"));
                mesa.setEstado(resultSet.getInt("estado"));
                mesa.setActivo(resultSet.getBoolean("activo"));
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al Buscar una mesa: " + ex.getMessage());
        }
        
        return mesa;
    }
}
