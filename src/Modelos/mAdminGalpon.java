/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author GIMORE
 */
public class mAdminGalpon {
    private int idGalpon;
    private int idAve;
    private String fInicio;
    private int saldo;
    private String descripcion;
    private String estado;

    public mAdminGalpon(int idGalpon, int idAve, String fInicio, int saldo, String descripcion, String estado) {
        this.idGalpon = idGalpon;
        this.idAve = idAve;
        this.fInicio = fInicio;
        this.saldo = saldo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public mAdminGalpon() {
    }

    public int getIdGalpon() {
        return idGalpon;
    }

    public void setIdGalpon(int idGalpon) {
        this.idGalpon = idGalpon;
    }

    public int getIdAve() {
        return idAve;
    }

    public void setIdAve(int idAve) {
        this.idAve = idAve;
    }

    public String getfInicio() {
        return fInicio;
    }

    public void setfInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
