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
public class mUsuario  extends mPersona{

    private int cod_usuario;
    //private String rut_usuario;
    private String usuario;
    private String password;
    private String estado;
    private String tipo_Usuario;

    public mUsuario(int cod_usuario, String usuario, String password, String estado, String tipo_Usuario) {
        this.cod_usuario = cod_usuario;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.tipo_Usuario = tipo_Usuario;
    }

    public mUsuario() {
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_Usuario() {
        return tipo_Usuario;
    }

    public void setTipo_Usuario(String tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }

 
    

   

   
}
