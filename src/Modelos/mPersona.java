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
public class mPersona {

   
    private String cedula_persona;
    private String nombre_persona;
    private String apellido_persona;
    private String direccion;
    private String celular;
    private String email;
    private String sexo;

    public mPersona(String cedula_persona, String nombre_persona, String apellido_persona, String direccion, String celular, String email, String sexo) {
        this.cedula_persona = cedula_persona;
        this.nombre_persona = nombre_persona;
        this.apellido_persona = apellido_persona;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
    }

    public mPersona() {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
   
    }
