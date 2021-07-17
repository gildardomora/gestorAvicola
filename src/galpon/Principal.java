/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon;

import galpon.auditoria.AuditoriaApp;
import galpon.controller.LoginController;
import galpon.model.bd.query.UsuarioModel;
import galpon.model.dto.UsuarioDto;
import galpon.ui.login.LoginForm;
import galpon.ui.principal.InicioForm;
import javax.swing.JOptionPane;

/**
 *
 * @author GIMORE
 */
public class Principal {

    public static void main(String[] args) {
        // AuditoriaApp tset = new AuditoriaApp();  
        cargarLogin();
    }

    public static void cargarLogin() { //cargar la ventana del login
        LoginForm loginF = new LoginForm();
        UsuarioModel usuarioM = new UsuarioModel();
        InicioForm inicioF = new InicioForm();
        UsuarioDto usuarioDto = new UsuarioDto();
        LoginController loginC = new LoginController(loginF, usuarioM, inicioF, usuarioDto);
       
    }

}
