
package Modelo;

public class Mesa {
    private int idMesa = -1;
    private String nombre;
    private int capacidad;
    private int estado;
    private boolean activo;
    
    public Mesa(int idMesa, String nombre,int capacidad, int estado, boolean activo) {
        this.idMesa = idMesa;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.activo = activo;
    }
    public Mesa(String nombre,int capacidad, int estado) {
        this.idMesa = -1;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        
    }
    public Mesa() {
        this.idMesa = -1;
        
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
