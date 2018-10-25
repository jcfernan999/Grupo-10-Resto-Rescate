
package Modelo;


public class Cliente {
    private int idCliente = -1;
    private String nombre;
    private String apellido;
    private int dni;
    private boolean activo;
    

    public Cliente(int idCliente, String nombre, String apellido, int dni, boolean activo) 
    {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.activo = activo;
        
    }

    public Cliente(String nombre, String apellido, int dni) 
    {
        this.idCliente = -1;
        this.nombre = nombre;
        this.apellido=apellido;
        this.dni = dni;
        
    }
     public Cliente() 
    {
        this.idCliente = -1;
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
   
}
