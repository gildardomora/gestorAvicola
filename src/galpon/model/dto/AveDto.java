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
    public class AveDto {
    private int IdAve;
    private String Nombre;
    private String Descripcion;

    public AveDto() {
    }

    public AveDto(int IdAve, String Nombre, String Descripcion) {
        this.IdAve = IdAve;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getIdAve() {
        return IdAve;
    }

    public void setIdAve(int IdAve) {
        this.IdAve = IdAve;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    
}
