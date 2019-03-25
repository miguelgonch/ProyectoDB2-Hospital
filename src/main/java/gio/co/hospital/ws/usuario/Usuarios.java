/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.cita;

/**
 *
 * @author migue
 */
public class Citas {
    private int id;
    private String diag;
    private String res;
    private String meds;
    private String pasos;
    private String observ;
    private String fecha;
    private String docName;
    private String docLastName;
    private int pId;
    private String pName;
    private String pLastName;

    public Citas(int id, String diag, String res, String meds, String pasos, String observ, String fecha, String docName, String docLastName, int pId, String pName, String pLastName) {
        this.id = id;
        this.diag = diag;
        this.res = res;
        this.meds = meds;
        this.pasos = pasos;
        this.observ = observ;
        this.fecha = fecha;
        this.docName = docName;
        this.docLastName = docLastName;
        this.pId = pId;
        this.pName = pName;
        this.pLastName = pLastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getMeds() {
        return meds;
    }

    public void setMeds(String meds) {
        this.meds = meds;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocLastName() {
        return docLastName;
    }

    public void setDocLastName(String docLastName) {
        this.docLastName = docLastName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpLastName() {
        return pLastName;
    }

    public void setpLastName(String pLastName) {
        this.pLastName = pLastName;
    }
    
    
}
