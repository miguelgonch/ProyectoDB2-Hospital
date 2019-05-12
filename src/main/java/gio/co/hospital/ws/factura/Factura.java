/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.factura;

/**
 *
 * @author C.V
 */
public class Factura {
   private int  id;
   private int auth;
   private int cobroCliente;
   private int cita;
   private String fecha;
   private String nombre;
   private String apellido;
   private String subcat;
   private String cat;
   private int costo;

    public Factura(int id, int auth, int cobroCliente, int cita, String fecha, String nombre, String apellido, String subcat, String cat, int costo) {
        this.id = id;
        this.auth = auth;
        this.cobroCliente = cobroCliente;
        this.cita = cita;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellido = apellido;
        this.subcat = subcat;
        this.cat = cat;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public int getCobroCliente() {
        return cobroCliente;
    }

    public void setCobroCliente(int cobroCliente) {
        this.cobroCliente = cobroCliente;
    }

    public int getCita() {
        return cita;
    }

    public void setCita(int cita) {
        this.cita = cita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getSubcat() {
        return subcat;
    }

    public void setSubcat(String subcat) {
        this.subcat = subcat;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

}


