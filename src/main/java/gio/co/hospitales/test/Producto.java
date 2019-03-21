/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales.test;

/**
 *
 * @author migue
 */
public class Producto {
    private int id;
    private String name;
    private float precio;
    
    public Producto(){
        
    }

    public Producto(int id, String name, float precio) {
        this.id = id;
        this.name = name;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
