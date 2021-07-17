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
public class PersonaDto {

    private String cedula_persona;
    private String nombre_persona;
    private String apellido_persona;
    private String direccion_persona;
    private String celular_persona;
    private String email_persona;
    private String sexo_persona;

    public PersonaDto() {
    }

    public String getCedula_persona() {
        return cedula_persona;
    }

    public void setCedula_persona(String cedula_persona) {
        this.cedula_persona = cedula_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getApellido_persona() {
        return apellido_persona;
    }

    public void setApellido_persona(String apellido_persona) {
        this.apellido_persona = apellido_persona;
    }

    public String getDireccion_persona() {
        return direccion_persona;
    }

    public void setDireccion_persona(String direccion) {
        this.direccion_persona = direccion;
    }

    public String getCelular_persona() {
        return celular_persona;
    }

    public void setCelular_persona(String celular) {
        this.celular_persona = celular;
    }

    public String getEmail_persona() {
        return email_persona;
    }

    public void setEmail_persona(String email) {
        this.email_persona = email;
    }

    public String getSexo_persona() {
        return sexo_persona;
    }

    public void setSexo_persona(String sexo) {
        this.sexo_persona = sexo;
    }

}
