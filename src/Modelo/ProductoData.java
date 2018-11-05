
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoData {
     private Connection connection = null;
     private Conexion conexion;

    public ProductoData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    public void guardarProducto(Producto producto){
        try {
            
            String sql = "INSERT INTO producto ( idcategoria,nombre, cantidad, precio,imagen,activo) VALUES ( ? , ? , ?, ? ,?,?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, producto.getCategoria().getIdCategoria());
            statement.setString(2, producto.getNombre());
            statement.setInt(3, producto.getCantidad());
            statement.setDouble(4, producto.getPrecio());
            statement.setBytes(5, producto.getImagen());
            statement.setBoolean(6, producto.getActivo());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un Producto");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un Producto: " + ex.getMessage());
        }
    }
    public List<Producto> listaProducto(){
        List<Producto> productos = new ArrayList<Producto>();
            

        try {
            String sql = "Select * From producto;"; 
                    
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            while(resultSet.next()){
                producto = new Producto();
                producto.setIdProducto(resultSet.getInt("idProducto"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setImagen(resultSet.getBytes("imagen"));
                producto.setActivo(resultSet.getBoolean("activo"));
                Categoria c=buscarCategoria(resultSet.getInt("idCategoria"));
                producto.setCategoria(c);
                
                productos.add(producto);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Categorias: " + ex.getMessage());
        }
        
        
        return productos;
      
    }

    public Categoria buscarCategoria(int id){
    
        CategoriaData ad=new CategoriaData(conexion);
        
        return ad.buscarCategoria(id);
        
    }
    //con este llenamos table 
    public List<Producto> obtenerProductoCategoria(String tipo,String  dato){
        List<Producto> productos = new ArrayList<Producto>();
        String sql;    
        PreparedStatement statement;
        try {
             if("Nombre".equals(tipo))
            {
                sql = "SELECT * FROM producto WHERE nombre = ? and activo=1;";
                statement = connection.prepareStatement(sql);
                statement.setString(1,dato);
            }
            else if("Categoria".equals(tipo))
            {
                sql = "SELECT * FROM producto p, categoria c WHERE p.IdCategoria = c.IdCategoria and  c.Nombre = ?  and p.activo=1;";
                statement = connection.prepareStatement(sql);
                statement.setString(1,dato);
            }
             else if("Activos".equals(tipo))
            {
                sql = "SELECT * FROM producto WHERE activo=1;";
                statement = connection.prepareStatement(sql);
                
            }
              else if("Desactivado".equals(tipo))
            {
                sql = "SELECT * FROM producto WHERE activo = 0;";
                statement = connection.prepareStatement(sql);
                
            }
            else{
                sql = "SELECT * FROM producto WHERE activo = 1;";
                 statement = connection.prepareStatement(sql);
            }
            
         
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            while(resultSet.next()){
               producto = new Producto();
               producto.setIdProducto(resultSet.getInt("idProducto"));
               producto.setNombre(resultSet.getString("nombre"));
               producto.setCantidad(resultSet.getInt("cantidad"));
               producto.setPrecio(resultSet.getDouble("precio"));
               producto.setImagen(resultSet.getBytes("imagen"));
               producto.setActivo(resultSet.getBoolean("activo"));
               
               Categoria c = buscarCategoria(resultSet.getInt("idCategoria"));
               producto.setCategoria(c);
                
               productos.add(producto);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return productos;
    }
    
    //Actializar,Modificar
    public void actualizarProducto(Producto producto){
    
        try {
            
            String sql = "UPDATE producto SET nombre = ?, idCategoria = ? , cantidad =?, precio = ?, imagen = ?, activo = ? WHERE idProducto = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getCategoria().getIdCategoria());
            statement.setInt(3, producto.getCantidad());
            statement.setDouble(4, producto.getPrecio());
            statement.setBytes(5, producto.getImagen());
            statement.setBoolean(6, producto.getActivo());
            statement.setInt(7, producto.getIdProducto());
            
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Modificar un Producto: " + ex.getMessage());
        }
    
    }
    public Producto buscarProducto(int id){
        Producto producto=null;
    try {
            
            String sql = "SELECT * FROM producto WHERE idProducto =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                producto = new Producto();
                producto.setIdProducto(resultSet.getInt("idProducto"));
                
                producto.setNombre(resultSet.getString("nombre"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setImagen(resultSet.getBytes("imagen"));
                producto.setActivo(resultSet.getBoolean("activo"));
                
                Categoria c=buscarCategoria(resultSet.getInt("idCategoria"));
                producto.setCategoria(c);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar un producto: " + ex.getMessage());
        }
        
        return producto;
    }
     
     
     
      //-------------------------------Borrar
    public void borrarProducto(int id){
    try {
            
//            String sql = "DELETE FROM producto WHERE  idProducto =?;";
            String sql = "UPDATE producto SET activo = 0 WHERE idProducto = ?; ";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Eliminar un Producto: " + ex.getMessage());
        }
        
    
    }
    
    public List<Producto> listaProductoPorCategoria(int idCategoria){
        List<Producto> productos = new ArrayList<Producto>();
            

        try {
            String sql = "Select * From producto where idCategoria = ? and activo=1 ;"; 
                    
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCategoria);
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            while(resultSet.next()){
                producto = new Producto();
                producto.setIdProducto(resultSet.getInt("idProducto"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setImagen(resultSet.getBytes("imagen"));
                producto.setActivo(resultSet.getBoolean("activo"));
                Categoria c=buscarCategoria(resultSet.getInt("idCategoria"));
                producto.setCategoria(c);
                
                productos.add(producto);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Categorias: " + ex.getMessage());
        }
        
        
        return productos;
      
    }
    
}
