/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.controller;

import galpon.ConstantesConfig;
import galpon.model.bd.query.UsuarioModel;
import galpon.model.dto.UsuarioDto;
import galpon.ui.login.LoginForm;
import galpon.ui.principal.InicioEscritorioForm;
import galpon.ui.principal.InicioForm;
import galpon.ui.usuarios.RegistrarUsuarioForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIMORE
 */
public class LoginController implements ActionListener {

    private LoginForm loginF;
    private UsuarioModel usuarioM;
    private InicioForm inicioF;

    private boolean sesion = false;
    private UsuarioDto usuarioDto;

    public LoginController(LoginForm login, UsuarioModel usuarioM, InicioForm inicioF, UsuarioDto usuarioDto) {
        this.loginF = login;
        LoginForm.btnEntrar.addActionListener(this);
        this.usuarioM = usuarioM;
        this.inicioF = inicioF;
        this.usuarioDto = usuarioDto;
//        LoginForm.btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {//para que funcione la tecla enter en el boton 
//        });

        iniciarLogin();
    }

    public boolean iniciarLogin() {
        loginF.setVisible(true);
        loginF.setLocationRelativeTo(null);// ajustar la posicion de la ventana
        loginF.jScrollPane1.setVisible(false);// para ocultar la tabla del loginF
        loginF.lblSesion.setVisible(false);
        loginF.lblVersion.setText(ConstantesConfig.VERSION);

        /*
        * valida si hay usuarios del sistema registrados 
        * si no exiten inicia el proceso de creacion del 
        * usuario administrador del sistems
         */
        if (usuarioM.ContarUsuarios() > 0) {
            loginF.setVisible(true);
            loginF.txtUsuario.requestFocus();
            //  this.show(false);
        } else {
            JOptionPane.showMessageDialog(loginF, "NO EXISTE UN USUARIO CON ACCESO  \n "
                    + "\n DEBE CREAR EL ADMINISTRADOR DEL SISTEMA",
                    "CONFIGURACION DE USUARIO", JOptionPane.INFORMATION_MESSAGE);
            registrarUsuarioAdmin();
        }
        loginF.setLocationRelativeTo(null);// ajustar la posicion de la ventana
        return sesion;
    }

    public void registrarUsuarioAdmin() {
        RegistrarUsuarioForm regUsuarioF = new RegistrarUsuarioForm();
        RegistrarUsuarioController regUsuarioC = new RegistrarUsuarioController(usuarioM, regUsuarioF);

    }

    public void iniciarSesion() {

        try {
            usuarioDto.setLogin_usuario(loginF.txtUsuario.getText());
            usuarioDto.setPassword_usuario(loginF.txtContraseña.getText());
            DefaultTableModel tblModel = definirTabla();
            loginF.tblUsuarios.setModel(tblModel);//envia el modelo a la tabla en loginF
        } catch (Exception e) {
            JOptionPane.showMessageDialog(loginF, e);
        }

        if (usuarioM.totalRegistros > 0) {//comprueba si hay usuarios registrados
            //  if (galpon.auditoria.AuditoriaApp.totalRegistros > 0) {//auditoria
            loginF.dispose();//para cerrar la ventana del loginF

            InicioEscritorioForm escritorioForm = new InicioEscritorioForm();
            InicioController inicioC = new InicioController(inicioF, escritorioForm);
            InicioForm.lblTipo.setText(loginF.tblUsuarios.getValueAt(0, 4).toString());//ajusta el tipo de usuario en la etiqueta 
            UsuarioController.usuarioActual = loginF.txtUsuario.getText();
            InicioForm.lbluser.setText(UsuarioController.usuarioActual);
            sesion = true;
            //String asa=tblUsuarios.getValueAt(0, 0).toString(); --- para prueba de error
            //JOptionPane.showMessageDialog(rootPane, "esto sale de la tabla :" + asa);
        } else {
            loginF.lblSesion.setText("Usuario y/o Contraseña incorrectos.");
            loginF.lblSesion.setVisible(true);
            loginF.txtUsuario.requestFocus();
        }

    }//fin metodo iniciar validarSesion

    public DefaultTableModel definirTabla() {//asigna la estreuctura de la tabla para loginF
        DefaultTableModel tblModel = usuarioM.validarSesion(usuarioDto.getLogin_usuario(),
                usuarioDto.getPassword_usuario());//ajusta los datos de acceso en el modelo de la tabla
        return tblModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("evento : " + e);
        if (e.getSource() == loginF.btnEntrar) {
            if (loginF.txtUsuario.getText().length() == 0) {
                //  lblCargando.setVisible(false);
                loginF.lblSesion.setText("Debe ingresar un Nombre de Usuario");
                loginF.lblSesion.setVisible(true);
                loginF.txtUsuario.requestFocus();
                return;
            }

            if (loginF.txtContraseña.getText().length() == 0) {
                //   lblCargando.setVisible(false);
                loginF.lblSesion.setText("Debe ingresar una Contraseña");
                loginF.lblSesion.setVisible(true);
                loginF.txtContraseña.requestFocus();
                return;
            }
            iniciarSesion();
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //para hacer un timeout o pausa de tiempo
//        try {
//            //Ponemos a "Dormir" el programa durante los ms que queremos
//            Thread.sleep(5 * 1000);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
}
