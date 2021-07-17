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
public class UsuarioDto extends PersonaDto {

    private int cod_usuario;
    //private String rut_usuario;
    private String Login_usuario;
    private String Password_usuario;
    private String estado_usuario;
    private String tipo_Usuario;

    public UsuarioDto() {
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getLogin_usuario() {
        return Login_usuario;
    }

    public void setLogin_usuario(String Login_usuario) {
        this.Login_usuario = Login_usuario;
    }

    public String getPassword_usuario() {
        return Password_usuario;
    }

    public void setPassword_usuario(String Password_usuario) {
        this.Password_usuario = Password_usuario;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado) {
        this.estado_usuario = estado;
    }

    public String getTipo_Usuario() {
        return tipo_Usuario;
    }

    public void setTipo_Usuario(String tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }

}
