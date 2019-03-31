/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.patient;

import gio.co.hospital.ws.*;

/**
 *
 * @author migue
 */
public class Patients {
    private int id;
    private String nombre;
    private String apellido;
    private int tel;
    private double dpi;
    //Numero de seguro
    private String segNum;
    //Cumpleanos
    private String fNacimiento;
    private String dir;
    //id de aseguradora
    private int asegNum;
    private String asegName;
    private int asegType;
    private String asegTypeName;

    public Patients(int id, String nombre, String apellido, int tel, double dpi, String segNum, String fNacimiento, String dir, int asegNum, String asegName, int asegType, String asegTypeName) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tel = tel;
        this.dpi = dpi;
        this.segNum = segNum;
        this.fNacimiento = fNacimiento;
        this.dir = dir;
        this.asegNum = asegNum;
        this.asegName = asegName;
        this.asegType = asegType;
        this.asegTypeName = asegTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getDpi() {
        return dpi;
    }

    public void setDpi(double dpi) {
        this.dpi = dpi;
    }

    public String getSegNum() {
        return segNum;
    }

    public void setSegNum(String segNum) {
        this.segNum = segNum;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getAsegNum() {
        return asegNum;
    }

    public void setAsegNum(int asegNum) {
        this.asegNum = asegNum;
    }

    public String getAsegName() {
        return asegName;
    }

    public void setAsegName(String asegName) {
        this.asegName = asegName;
    }
    
    public int getAsegType() {
        return asegType;
    }

    public void setAsegType(int asegType) {
        this.asegType = asegType;
    }

    public String getAsegTypeName() {
        return asegTypeName;
    }

    public void setAsegTypeName(String asegTypeName) {
        this.asegTypeName = asegTypeName;
    }
    
    

}










