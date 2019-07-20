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
public class mProduccion {
    
    private int idProduccion;
    private int idGalpon;
    private int idProducto;
    private int cantidad;
    private String fecha;

    public mProduccion(int idProduccion, int idGalpon, int idProducto, int cantidad, String fecha) {
        this.idProduccion = idProduccion;
        this.idGalpon = idGalpon;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public mProduccion() {
    }

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public int getIdGalpon() {
        return idGalpon;
    }

    public void setIdGalpon(int idGalpon) {
        this.idGalpon = idGalpon;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
