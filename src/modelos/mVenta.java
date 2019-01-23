/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author GIMORE
 */
public class mVenta {
    private int idVenta;
    private int cantidad;
    private String descripcion;
    private int valorVenta;
    private String fecha;

    public mVenta(int idVenta, int cantidad, String descripcion, int valorVenta, String fecha) {
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.valorVenta = valorVenta;
        this.fecha = fecha;
    }

    public mVenta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

    public int getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
