/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.controller;

import galpon.model.bd.query.UsuarioModel;
import galpon.model.bd.query.fPersona;
import galpon.model.dto.PersonaDto;
import galpon.model.dto.UsuarioDto;
import galpon.ui.login.LoginForm;
import galpon.ui.usuarios.RegistrarUsuarioForm;
import galpon.ui.usuarios.UsuariosForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author GIMORE
 */
public class RegistrarUsuarioController implements ActionListener {

    private UsuarioModel usuarioM;
    private RegistrarUsuarioForm regUsuarioF;
    private UsuariosForm usuariosF;

    public RegistrarUsuarioController(UsuarioModel usuarioM, RegistrarUsuarioForm regUsuarioF) {
        this.usuarioM = usuarioM;
        this.regUsuarioF = regUsuarioF;

        regUsuarioF.setResizable(false);
        regUsuarioF.setLocationRelativeTo(null);
        regUsuarioF.setVisible(true);
        regUsuarioF.toFront();
        habilitarCampos();
        RegistrarUsuarioForm.btnNuevo.setText("Guardar");
        RegistrarUsuarioForm.comboEstado.setSelectedItem("Activo");
        RegistrarUsuarioForm.comboEstado.setEnabled(false);
        RegistrarUsuarioForm.comboTipo.setSelectedItem("Administrador");
        RegistrarUsuarioForm.comboTipo.setEnabled(false);
        regUsuarioF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        habilitarCampos();

    }

    public void habilitarCampos() {// habilita campos de texto
        regUsuarioF.txtNombre.setEnabled(true);
        regUsuarioF.txtApellido.setEnabled(true);
        regUsuarioF.txtCedula.setEnabled(true);
        regUsuarioF.txtDireccion.setEnabled(true);
        regUsuarioF.txtUsuario.setEnabled(true);
        regUsuarioF.txtPassword.setEnabled(true);
        regUsuarioF.txtCelular.setEnabled(true);
        regUsuarioF.txtCorreo.setEnabled(true);
        regUsuarioF.comboEstado.setEnabled(true);
        regUsuarioF.comboTipo.setEnabled(true);
        regUsuarioF.comboSexo.setEnabled(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("evento recibido. " + e);
        if (e.getSource() == regUsuarioF.btnNuevo) {
            if (regUsuarioF.btnNuevo.getText().equals("Nuevo")) {
                habilitarCampos();
                regUsuarioF.txtNombre.requestFocus();
                regUsuarioF.btnNuevo.setText("Guardar");
                return;
            }
        }

        if (regUsuarioF.btnNuevo.getText().equals("Guardar")) {
            if (regUsuarioF.txtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(regUsuarioF, "Debe Ingresar un nombre");
                regUsuarioF.txtNombre.requestFocus();
                return;
            }
            if (regUsuarioF.txtApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(regUsuarioF, "Debe Ingresar los Apellidos");
                regUsuarioF.txtApellido.requestFocus();
                return;
            }
            if (regUsuarioF.txtUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(regUsuarioF, "Debe Ingresar un nombre de usuario");
                regUsuarioF.txtUsuario.requestFocus();
                return;
            }
            if (regUsuarioF.txtPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(regUsuarioF, "Debe Ingresar una Contraseña");
                regUsuarioF.txtPassword.requestFocus();
                return;
            }
            if (regUsuarioF.txtCelular.getText().equals("")) {
                JOptionPane.showMessageDialog(regUsuarioF, "Debe Ingresar un numero de Celular");
                regUsuarioF.txtCelular.requestFocus();
                return;
            }
            if (regUsuarioF.txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(regUsuarioF, "Debe Ingresar un Correo");
                regUsuarioF.txtCorreo.requestFocus();
                return;
            }

            UsuarioDto datos = new UsuarioDto();
            PersonaDto datosP = new PersonaDto();

            UsuarioModel funcion = new UsuarioModel();
            fPersona funcionP = new fPersona();
            int confirmar = JOptionPane.showConfirmDialog(regUsuarioF, "Registrar usuario : " + regUsuarioF.txtUsuario.getText() + " ?", "Confirmar", 2);
            if (confirmar == 0) {
                int existe = funcion.verificar(regUsuarioF.txtUsuario.getText());//verifica si ya existe este usuario
                if (existe == 1) {
                    JOptionPane.showMessageDialog(null, " El nombre de usuario que intenta registrar"
                            + "\n ya esta en uso.");
                    regUsuarioF.txtUsuario.requestFocus();
                    return;
                }
                datosP.setCedula_persona(regUsuarioF.txtCedula.getText());
                datosP.setNombre_persona(regUsuarioF.txtNombre.getText());
                datosP.setApellido_persona(regUsuarioF.txtApellido.getText());
                datosP.setDireccion_persona(regUsuarioF.txtDireccion.getText());
                datosP.setCelular_persona(regUsuarioF.txtCelular.getText());
                datosP.setEmail_persona(regUsuarioF.txtCorreo.getText());
                datosP.setSexo_persona(regUsuarioF.comboSexo.getSelectedItem().toString());

                datos.setCedula_persona(regUsuarioF.txtCedula.getText());
                datos.setLogin_usuario(regUsuarioF.txtUsuario.getText());
                datos.setPassword_usuario(regUsuarioF.txtPassword.getText());
                datos.setNombre_persona(regUsuarioF.txtNombre.getText());
                datos.setEstado_usuario(regUsuarioF.comboEstado.getSelectedItem().toString());
                datos.setTipo_Usuario(regUsuarioF.comboTipo.getSelectedItem().toString());

                if (funcionP.insertar(datosP) && funcion.agregar(datos)) {
                    JOptionPane.showMessageDialog(regUsuarioF, "El Usuario ha sido Registrado ");
                }

                if (funcion.ContarUsuarios() > 1) {//comprueba si ya existe almens un usuario registrado
                    funcion.listar("");
                    regUsuarioF.dispose();
                    return;
                }

                //funcion.mostrarUsuario("");
                regUsuarioF.dispose();

                if (funcion.ContarUsuarios() == 1) {// si no hay usuarios muestra el formulario de acceso
                    LoginForm login = new LoginForm();

                    login.setVisible(true);
                }
            }// fin confirmar
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
