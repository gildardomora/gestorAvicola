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
public class mSalida {

    private int idSalida;
    private int idGalpon;
    private String fecha;
    private int hSaldo;
    private int cantidad;
    private String descripcion;

    public mSalida(int idSalida, int idGalpon, String fecha, int hSaldo, int cantidad, String descripcion) {
        this.idSalida = idSalida;
        this.idGalpon = idGalpon;
        this.fecha = fecha;
        this.hSaldo = hSaldo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public mSalida() {
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getIdGalpon() {
        return idGalpon;
    }

    public void setIdGalpon(int idGalpon) {
        this.idGalpon = idGalpon;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int gethSaldo() {
        return hSaldo;
    }

    public void sethSaldo(int hSaldo) {
        this.hSaldo = hSaldo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
