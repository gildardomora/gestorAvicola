/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.auditoria;

import galpon.ConstantesConfig;
import galpon.controller.LoginController;
import galpon.model.bd.query.UsuarioModel;
import galpon.model.dto.UsuarioDto;
import galpon.ui.login.LoginForm;
import galpon.ui.principal.InicioForm;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIMORE
 */
public class AuditoriaApp {
            public static int totalRegistros=0;

    public AuditoriaApp() {
        LoginForm loginF = new LoginForm();
        UsuarioModel usuarioM = new UsuarioModel();
        InicioForm inicioF = new InicioForm();
        UsuarioDto usuarioDto= new UsuarioDto();
        LoginController loginC = new LoginController(loginF, usuarioM, inicioF,usuarioDto);
        loginF.jScrollPane1.setVisible(false);// para ocultar la tabla del login
        loginF.lblSesion.setVisible(false);
        loginF.lblVersion.setText(ConstantesConfig.VERSION);
        loginF.setVisible(true);
        loginF.setLocationRelativeTo(null);// ajustar la posicion de la ventana
        // loginC.iniciarSesion();
        
        UsuarioAudDto usuarioPrueba = new UsuarioAudDto();
        usuarioPrueba.setCod_usuario(1);
        usuarioPrueba.setEstado_usuario("Activo");
        usuarioPrueba.setLogin_usuario("admin");
        usuarioPrueba.setPassword_usuario("admin");
        usuarioPrueba.setTipo_Usuario("administrador");
        
    }
   public static DefaultTableModel sesion() {
        
        DefaultTableModel modelo;
        /*  String[] titulos = {"COD", "NOMBRE", "DIRECCION", "TELEFONO", "EMAIL", "LOGIN", "PASS", "ESTADO", "ACCESO"};

        String[] registro = new String[9];
         */

        String[] titulos = {"ID", "LOGIN", "PASS", "ESTADO", "TIPO DE USUARIO"};
        String[] registro = new String[5];
     //    totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
      
                registro[0] = "1";
                registro[1] = "admin";
                registro[2] = "admin";
                registro[3] = "activo";
                registro[4] = "administrador";
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            
            return modelo;

    }//cierre metodo validarSesion
   
   

}
