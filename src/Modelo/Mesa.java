/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author quitian
 */
public class Mesa {
   private int idMesa = -1;
   private int capacidad;
   private int estado;
   private boolean activo;

    public Mesa(int idMesa, int capacidad, int estado, boolean activo) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.activo = activo;
    }

    public Mesa(int capacidad, int estado, boolean activo) {
        this.idMesa = -1;
        this.capacidad = capacidad;
        this.estado = estado;
        this.activo = activo;
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
