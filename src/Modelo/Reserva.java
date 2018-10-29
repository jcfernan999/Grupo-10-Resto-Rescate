
package Modelo;

import java.sql.Date;

public class Reserva {
    private int idReserva = -1;
    private Cliente cliente;
    private Mesa mesa;
    private Date fecha;
    private String hora;
    private boolean activo;
    

    public Reserva(int idReserva, Cliente cliente, Mesa mesa,Date fecha,String hora, boolean activo) 
    {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.activo = activo;
        
    }

    public Reserva(Cliente cliente, Mesa mesa,Date fecha,String hora,boolean activo) 
    {
        this.idReserva = -1;
        this.cliente = cliente;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.activo = activo;
    }
     public Reserva() 
    {
        this.idReserva = -1;
        
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
   
}