/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author aulasitc
 */
public class Cliente {
    private int idCliente = -1;
    private String nombre;
    private int dni;
    private boolean activo;

    public Cliente(int idCliente, String nombre, int dni, boolean activo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.activo = activo;
    }

    public Cliente(String nombre, int dni, boolean activo) {
        this.idCliente = -1;
        this.nombre = nombre;
        this.dni = dni;
        this.activo = activo;
    }

    public Cliente() {
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
    
    
   
