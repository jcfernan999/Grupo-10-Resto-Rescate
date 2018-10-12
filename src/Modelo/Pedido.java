
package Modelo;

import java.sql.Date;
import java.time.LocalDate;


public class Pedido {
    private int idPedido=-1;
    private Mesero mesero;
    private Mesa mesa;
    private Date fecha;
    private String hora;
    private boolean pagado;
    private boolean cancelado;

    public Pedido(int idPedido, Mesero mesero, Mesa mesa, Date fecha, String hora, boolean pagado, boolean cancelado) {
        this.idPedido = idPedido;
        this.mesero = mesero;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.pagado = pagado;
        this.cancelado = cancelado;
    }

    public Pedido(Mesero mesero, Mesa mesa, Date fecha, String hora, boolean pagado, boolean cancelado) {
        this.idPedido = -1;
        this.mesero = mesero;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.pagado = pagado;
        this.cancelado = cancelado;
    }
    public Pedido() {
        this.idPedido = -1;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
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

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    
    
}
