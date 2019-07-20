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
public class mProducto {
    private int idProducto;
    private String nombre;
    private String uniMedida;
    private String Descripcion;
    private int precioUniMed,stock;

    public mProducto(int idProducto, String nombre, String uniMedida, String Descripcion, int precioUniMed, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.uniMedida = uniMedida;
        this.Descripcion = Descripcion;
        this.precioUniMed = precioUniMed;
        this.stock = stock;
    }

    public mProducto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUniMedida() {
        return uniMedida;
    }

    public void setUniMedida(String uniMedida) {
        this.uniMedida = uniMedida;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPrecioUniMed() {
        return precioUniMed;
    }

    public void setPrecioUniMed(int precioUniMed) {
        this.precioUniMed = precioUniMed;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

 
    
}
