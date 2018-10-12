package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PedidoData {
    private Connection connection = null;
     private Conexion conexion;

    public PedidoData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    public void guardarPedido(Pedido pedido){
        System.out.println("0");
        try {
            System.out.println("1");
            String sql = "INSERT INTO pedido (idMesero,idMesa, fecha, hora,cancelado,pagado) VALUES ( ?, ?, ?, ?, ?, ?);";
System.out.println("2");
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, pedido.getMesa().getIdMesa());
            System.out.println(pedido.getMesa().getIdMesa());
            statement.setInt(2, pedido.getMesero().getIdMesero());
            System.out.println(pedido.getMesero().getIdMesero());
            statement.setDate(3, pedido.getFecha());
            System.out.println(pedido.getFecha());
            statement.setString(4, pedido.getHora());
            System.out.println(pedido.getHora());
            statement.setBoolean(5, pedido.getCancelado());
            System.out.println(pedido.getCancelado());
            statement.setBoolean(6, pedido.getPagado());
            System.out.println(pedido.getPagado());
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) {
                pedido.setIdPedido(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un Producto");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un Producto: " + ex.getMessage());
        }
    }
    
    public Pedido buscarPedido(int id){
        Pedido pedido=null;
    try {
            
            String sql = "SELECT * FROM pedido WHERE idPedido =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                pedido = new Pedido();
                pedido.setIdPedido(resultSet.getInt("idPedido"));
                
                pedido.setFecha(resultSet.getDate("fecha"));
                pedido.setHora(resultSet.getString("hora"));
                pedido.setCancelado(resultSet.getBoolean("cancelado"));
                pedido.setPagado(resultSet.getBoolean("pagado"));
                
                Mesero msr=buscarMesero(resultSet.getInt("idMesero"));
                pedido.setMesero(msr);
                
                Mesa ms=buscarMesa(resultSet.getInt("idMesa"));
                pedido.setMesa(ms);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("errorororror: " + ex.getMessage());
        }
        
        return pedido;
    }
    
     public Mesero buscarMesero(int id){
    
        MeseroData md=new MeseroData(conexion);
        
        return md.buscarMesero(id);
        
    }
     
     public Mesa buscarMesa(int id){
    
        MesaData md=new MesaData(conexion);
        
        return md.buscarMesa(id);
        
    }
}
