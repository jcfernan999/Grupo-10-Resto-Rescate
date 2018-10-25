/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author kenchiro
 */
public class Producto {
    private int idProducto = -1;
    private Categoria categoria;
    private String nombre;
    private int cantidad;
    private double precio;
    private byte[] imagen;
    private boolean activo;
public ImageIcon getImage()
     {
         return new ImageIcon(new ImageIcon(imagen).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
     }
    public Producto(int idProducto,Categoria categoria, String nombre, int cantidad,double precio,byte[] imagen,boolean activo) 
    {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.imagen = imagen;
        this.activo = activo;
    }

    public Producto(Categoria categoria,String nombre, int cantidad,double precio,byte[] imagen,boolean activo) 
    {
        this.idProducto = -1;
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.imagen = imagen;
        this.activo = activo;
    }
    
    public Producto()
    {
        
    }

//    public Producto(int idCategoria, String nombre, int cantidad, double precio, byte[] imagen) {
////        this.idProducto = -1;
////        this.nombre = nombre;
////        this.cantidad = cantidad;
////        this.precio = precio;
////        this.categoria.getIdCategoria() = idCategoria;
////        this.imagen = imagen;
//    }
    
    
    
    public String toString(){
    
        return idProducto+"-"+nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public boolean getActivo() {
        return activo;
    }

    

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
