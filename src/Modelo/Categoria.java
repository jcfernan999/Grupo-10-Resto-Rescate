
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author kenchiro
 */
public class Categoria 
{
    private int idCategoria = -1;
    private String nombre;
    private String descripcion;
    

    public Categoria(int idCategoria, String nombre, String descripcion) 
    {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        
    }

    public Categoria(String nombre, String descripcion) 
    {
        this.idCategoria = -1;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Categoria()
    {
        this.idCategoria = -1;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
    
        return idCategoria+"-"+nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
