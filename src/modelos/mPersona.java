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
public class mPersona {

    private int cod_persona;
    private String nombre_persona;
    private String direccion;
    private String telefono;
    private String email;
    private int celular;
    private String correo;

    public mPersona(int cod_persona, String nombre_persona, String direccion, String telefono, String email, int celular, String correo) {
        this.cod_persona = cod_persona;
        this.nombre_persona = nombre_persona;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.celular = celular;
        this.correo = correo;
    }

    public mPersona() {
    }

    public int getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(int cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    }
