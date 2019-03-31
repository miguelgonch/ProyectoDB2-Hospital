/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.cobertura;

/**
 *
 * @author C.V
 */
public class Coberturas {
    int paciente_id;
    int cita_id;
    String aseguradora;
    int id_subcat;
    String subcat;
    int costo;
    double pCobertura;
    String tipoSeguro;
    int id_tipo_seguro;

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public int getCita_id() {
        return cita_id;
    }

    public void setCita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public int getId_subcat() {
        return id_subcat;
    }

    public void setId_subcat(int id_subcat) {
        this.id_subcat = id_subcat;
    }

    public String getSubcat() {
        return subcat;
    }

    public void setSubcat(String subcat) {
        this.subcat = subcat;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public double getpCobertura() {
        return pCobertura;
    }

    public void setpCobertura(double pCobertura) {
        this.pCobertura = pCobertura;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public int getId_tipo_seguro() {
        return id_tipo_seguro;
    }

    public void setId_tipo_seguro(int id_tipo_seguro) {
        this.id_tipo_seguro = id_tipo_seguro;
    }

    public Coberturas(int paciente_id, int cita_id, String aseguradora, int id_subcat, String subcat, int costo, double pCobertura, String tipoSeguro, int id_tipo_seguro) {
        this.paciente_id = paciente_id;
        this.cita_id = cita_id;
        this.aseguradora = aseguradora;
        this.id_subcat = id_subcat;
        this.subcat = subcat;
        this.costo = costo;
        this.pCobertura = pCobertura;
        this.tipoSeguro = tipoSeguro;
        this.id_tipo_seguro = id_tipo_seguro;
    }
}



