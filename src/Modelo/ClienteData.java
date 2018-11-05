package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ClienteData {
    private Connection connection = null;

    public ClienteData(Conexion conexion) 
    {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
     //-------------------------------Guardar datos 
    public void guardarCliente(Cliente cliente)
    {
        try {
            
            String sql = "INSERT INTO cliente (nombre, apellido, dni) VALUES ( ?, ?, ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setInt(3, cliente.getDni());
//            statement.setBoolean(4, cliente.getActivo());

            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un Cliente");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un Cliente: " + ex.getMessage());
        }
    }
    
    //-------------------------------Listar datos 
    public List<Cliente> obtenerCliente(){
        List<Cliente> clientes = new ArrayList<Cliente>();
            

        try {
            String sql = "SELECT * FROM cliente;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            while(resultSet.next()){
                cliente =new Cliente();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setActivo(resultSet.getBoolean("activo"));
                

                clientes.add(cliente);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Cliente: " + ex.getMessage());
        }
        return clientes;
    }
    public List<Cliente> obtenerCliente(String tipo,String dato){
        List<Cliente> clientes = new ArrayList<Cliente>();
        String sql;    
        PreparedStatement statement;
        try {
            if("Nombre".equals(tipo))
            {
                sql = "SELECT * FROM cliente WHERE nombre = ? AND activo = 1 ;";
                 statement = connection.prepareStatement(sql);
                statement.setString(1,dato);
            }
            else if("Apellido".equals(tipo))
            {
                sql = "SELECT * FROM cliente WHERE apellido = ? AND activo = 1 ;";
                 statement = connection.prepareStatement(sql);
                statement.setInt(1,Integer.parseInt(dato));
            }
            else if("DNI".equals(tipo))
            {
                sql = "SELECT * FROM cliente WHERE dni = ? AND activo = 1 ;";
                 statement = connection.prepareStatement(sql);
                statement.setInt(1,Integer.parseInt(dato));
            }
            else if("Activos".equals(tipo))
            {
                sql = "SELECT * FROM cliente WHERE activo = 1 ;";
                 statement = connection.prepareStatement(sql);
              
            }
            else if("Desactivado".equals(tipo))
            {
                sql = "SELECT * FROM cliente WHERE activo = 0 ;";
                 statement = connection.prepareStatement(sql);
                
            }
            else{
                sql = "SELECT * FROM cliente WHERE activo = 1;";
                 statement = connection.prepareStatement(sql);
            }
            
         
            ResultSet resultSet = statement.executeQuery();
            Cliente  cliente;
            while(resultSet.next()){
               cliente = new Cliente();
               cliente.setIdCliente(resultSet.getInt("idCliente"));
               cliente.setNombre(resultSet.getString("nombre"));
               cliente.setApellido(resultSet.getString("apellido"));
               cliente.setDni(resultSet.getInt("dni"));
               cliente.setActivo(resultSet.getBoolean("activo"));

               clientes.add(cliente);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la Mesa: " + ex.getMessage());
        }
        return clientes;
    }


    //-------------------------------Buscar
    public Cliente buscarCliente(int id){
        Cliente cliente=null;
    try {
        String sql = "SELECT * FROM cliente WHERE idCliente = ? and activo = 1;";

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, id);   
            
        ResultSet resultSet=statement.executeQuery();
            
        while(resultSet.next()){
            cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("idCliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setApellido(resultSet.getString("apellido"));
            cliente.setDni(resultSet.getInt("dni"));
            cliente.setActivo(resultSet.getBoolean("activo"));
            
        }      
        statement.close();
    } 
    catch (SQLException ex){
        System.out.println("Error al buscar un cliente: " + ex.getMessage());
    }
        
        return cliente;
    }
    
     //-------------------------------ACTUALIZAR
    public void actualizarCliente(Cliente cliente){
    
        try {
            
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, activo = ? WHERE idCliente = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setInt(3, cliente.getDni());
            statement.setBoolean(4, cliente.getActivo());
            statement.setInt(5, cliente.getIdCliente());
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Modidicar un Cliente: " + ex.getMessage());
        }
    
    }
    
     //-------------------------------Borrar
    public void borrarCliente(int id){
    try {
            
            String sql = "DELETE FROM cliente WHERE idCliente =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un alumno: " + ex.getMessage());
        }
    }
    public Cliente buscarClientePorDni(int dni){
        Cliente cliente=null;
        try {
            String sql = "SELECT * FROM cliente WHERE dni = ? and activo = 1;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);   

            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setActivo(resultSet.getBoolean("activo"));

            }      
            statement.close();
        } 
        catch (SQLException ex){
            System.out.println("Error al Buscar un Cliente: " + ex.getMessage());
        }
        return cliente;
    }
}
