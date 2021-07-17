/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.model.dto;

/**
 *
 * @author GIMORE
 */
public class mEntrada {
    
    private int idEntrada;
    private int idGalpon;
    private String fecha;
    private int saldo_aves;
    private int cantidad;
    private String descripcion;

    public mEntrada(int idEntrada, int idGalpon, String fecha, int saldo_aves, int cantidad, String descripcion) {
        this.idEntrada = idEntrada;
        this.idGalpon = idGalpon;
        this.fecha = fecha;
        this.saldo_aves = saldo_aves;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public mEntrada() {
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
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

    public int getsaldo_aves() {
        return saldo_aves;
    }

    public void setsaldo_aves(int saldo_aves) {
        this.saldo_aves = saldo_aves;
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
