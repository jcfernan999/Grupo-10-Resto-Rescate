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
public class Mesero {
    private int idMesero= -1;
    private String nombre;
    private int dni;
    private boolean activo;
    
    public Mesero(int idMesero, String nombre, int dni, boolean activo) {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.dni = dni;
        this.activo = activo;
    }
    

    public Mesero(String nombre, int dni, boolean activo) {
        this.idMesero = -1;
        this.nombre = nombre;
        this.dni = dni;
        this.activo = activo;
    }

    public Mesero() {
        this.idMesero = -1;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
