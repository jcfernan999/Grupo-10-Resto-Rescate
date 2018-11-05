package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DetalleData {
    private Connection connection = null;
    private Conexion conexion;
    public DetalleData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    public void guardarDetalle(Detalle detalle){
        try {
            
            String sql = "INSERT INTO detalle ( idProducto,idPedido, cantidad, Total) VALUES ( ? , ? , ?, ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, detalle.getProducto().getIdProducto());
            statement.setInt(2, detalle.getPedido().getIdPedido());
            statement.setInt(3, detalle.getCantidad());
            statement.setDouble(4, detalle.getTotal());
          
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) {
                detalle.setIdDetalle(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un Detalle");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un Detalle: " + ex.getMessage());
        }
    }
    public void actualizarDetalle(Detalle detalle){
        
        try {
            
            String sql = "UPDATE detalle SET activo = ? WHERE idDetalle = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, detalle.getActivo());
            statement.setInt(2, detalle.getIdDetalle());
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al Modidicar un Detalle: " + ex.getMessage());
        }
    
    }
    public List<Detalle> obtenerDetalle(int  idPedido,int idMesa){
        List<Detalle> detalles = new ArrayList<Detalle>();
            

        try {
            String sql = "SELECT * "
                       + "FROM detalle d, pedido p, mesa m "
                       + "WHERE d.idPedido = p.idPedido and "
                             + "p.idMesa = m.idMesa and "
                             + "d.idPedido = ? and "
                             + "p.idMesa = ? and "
                             + "pagado = 0;";//si 1, no 0
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,idPedido);
            statement.setInt(2,idPedido);
         
            ResultSet resultSet = statement.executeQuery();
            Detalle detalle;
            
            while(resultSet.next()){
               detalle = new Detalle();
               
               detalle.setCantidad(resultSet.getInt("d.cantidad"));
               detalle.setTotal(resultSet.getDouble("total"));
               
               Producto pro = buscarProducto(resultSet.getInt("d.idProducto"));
               detalle.setProducto(pro);
               
               Pedido pe = buscarPedido(resultSet.getInt("d.idPedido"));
               detalle.setPedido(pe);
               
               buscarMesa(resultSet.getInt("p.idMesa"));
               
                
               detalles.add(detalle);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Detalles: " + ex.getMessage());
        }
        
        
        return detalles;
    }
    
    public List<Detalle> obtenerDetalle(int  idPedido){
        List<Detalle> detalles = new ArrayList<Detalle>();
            

        try {
            String sql = "SELECT * "
                       + "FROM detalle "
                       + "WHERE idPedido = ? and activo = 1;";//si 1, no 0
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,idPedido);
//            statement.setInt(2,idPedido);
         
            ResultSet resultSet = statement.executeQuery();
            Detalle detalle;
            
            while(resultSet.next()){
               detalle = new Detalle();
               
               detalle.setCantidad(resultSet.getInt("cantidad"));
               detalle.setTotal(resultSet.getDouble("total"));
               detalle.setActivo(resultSet.getBoolean("activo"));
               detalle.setIdDetalle(resultSet.getInt("idDetalle"));
               
               Producto pro = buscarProducto(resultSet.getInt("idProducto"));
               detalle.setProducto(pro);
               
               Pedido pe = buscarPedido(resultSet.getInt("idPedido"));
               detalle.setPedido(pe);
               
//               buscarMesa(resultSet.getInt("p.idMesa"));
               
                
               detalles.add(detalle);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los Detalles: " + ex.getMessage());
        }
        
        
        return detalles;
    }
    
     public Detalle buscarDetalle(int id){
        Detalle detalle=null;
    try {
        String sql = "SELECT * FROM detalle WHERE idDetalle = ?;";

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, id);   
            
        ResultSet resultSet=statement.executeQuery();
            
        while(resultSet.next()){
            detalle = new Detalle();
            detalle.setIdDetalle(resultSet.getInt("idDetalle"));
            detalle.setCantidad(resultSet.getInt("cantidad"));
            detalle.setTotal(resultSet.getDouble("total"));
            detalle.setActivo(resultSet.getBoolean("activo"));
            
            Pedido pe = buscarPedido(resultSet.getInt("idPedido"));
                detalle.setPedido(pe);
                
            Producto pro = buscarProducto(resultSet.getInt("idProducto"));
            detalle.setProducto(pro);
        }      
        statement.close();
    } 
    catch (SQLException ex){
        System.out.println("Error: al buscar un detalle " + ex.getMessage());
    }
        
        return detalle;
    }
    
    public Mesa buscarMesa(int id){
    
        MesaData md=new MesaData(conexion);
        
        return md.buscarMesa(id);
        
    }
    
    public Producto buscarProducto(int id){
    
        ProductoData pd=new ProductoData(conexion);
        
        return pd.buscarProducto(id);
        
    }
    
    public Pedido buscarPedido(int id){
    
        PedidoData pd=new PedidoData(conexion);
        
        return pd.buscarPedido(id);
        
    }
}
