/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Consultas.fPersona;
import Consultas.fUsuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Modelos.mPersona;
import Modelos.mUsuario;

/**
 *
 * @author GIMORE
 */
public class frmRegUsuario extends javax.swing.JFrame {

    /**
     * Creates new form frmRegUsuario
     */
    public frmRegUsuario() {

        initComponents();

        //this.setExtendedState(MAXIMIZED_BOTH);
    }

    public void Habilitar() {// habilita campos de texto
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtCedula.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtPassword.setEnabled(true);
        txtCelular.setEnabled(true);
        txtCorreo.setEnabled(true);
        comboEstado.setEnabled(true);
        comboTipo.setEnabled(true);
        comboSexo.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(9, 66, 66));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BIENVENIDO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel2)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 50));

        jPanel3.setBackground(new java.awt.Color(9, 66, 66));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Verifique la informacion personal antes de agregar el nuevo Usuario.");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Recuerde que el Usuario y la Contraseña seran usados para iniciar sesion en el Sistema.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 489, 660, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 66, 66)), "Datos de inicio de Sesion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(9, 66, 66))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Estandar" }));
        comboTipo.setEnabled(false);
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        jPanel4.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 115, 138, -1));

        jLabel7.setForeground(new java.awt.Color(9, 66, 66));
        jLabel7.setText("Tipo de Usuario");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 120, -1, -1));

        jLabel6.setForeground(new java.awt.Color(9, 66, 66));
        jLabel6.setText("Estado");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 89, -1, -1));

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        comboEstado.setEnabled(false);
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });
        jPanel4.add(comboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 84, 138, -1));

        txtUsuario.setEnabled(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel4.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 24, 215, -1));

        txtPassword.setEnabled(false);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        jPanel4.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 54, 215, -1));

        jLabel3.setForeground(new java.awt.Color(9, 66, 66));
        jLabel3.setText("Usuario ");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 28, 60, -1));

        jLabel4.setForeground(new java.awt.Color(9, 66, 66));
        jLabel4.setText("Contraseña");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 58, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/usersverde32px.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 380, 160));

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/addpropverde32px.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 220, 80));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 66, 66)), "Informacion Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(9, 66, 66))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(9, 66, 66));
        jLabel1.setText("Nombres");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 22, -1, -1));

        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel5.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 18, 214, -1));

        jLabel9.setForeground(new java.awt.Color(9, 66, 66));
        jLabel9.setText("Apellidos");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 52, -1, -1));

        txtApellido.setEnabled(false);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel5.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 48, 214, -1));

        txtCelular.setEnabled(false);
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });
        jPanel5.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 142, 141, -1));

        jLabel8.setForeground(new java.awt.Color(9, 66, 66));
        jLabel8.setText("Celular");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 146, -1, -1));

        jLabel10.setForeground(new java.awt.Color(9, 66, 66));
        jLabel10.setText("Correo");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 176, -1, -1));

        txtCorreo.setEnabled(false);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel5.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 172, 214, -1));

        jLabel13.setForeground(new java.awt.Color(9, 66, 66));
        jLabel13.setText("Cedula");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 86, -1, -1));

        txtCedula.setEnabled(false);
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel5.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 82, 214, -1));

        jLabel14.setForeground(new java.awt.Color(9, 66, 66));
        jLabel14.setText("Direccion");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 116, -1, -1));

        txtDireccion.setEnabled(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel5.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 112, 214, -1));

        jLabel15.setForeground(new java.awt.Color(9, 66, 66));
        jLabel15.setText("Sexo");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 207, -1, -1));

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Masculino", "Femenino" }));
        comboSexo.setEnabled(false);
        comboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSexoActionPerformed(evt);
            }
        });
        jPanel5.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 202, 140, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 250));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/users.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 260, -1));

        jLabel17.setText("Desarollado por Gildardo Mora");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (btnNuevo.getText().equals("Nuevo")) {
            Habilitar();
            txtNombre.requestFocus();
            btnNuevo.setText("Guardar");
            return;
        }
        if (btnNuevo.getText().equals("Guardar")) {
            if (txtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar un nombre");
                txtNombre.requestFocus();
                return;
            }
            if (txtApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar los Apellidos");
                txtApellido.requestFocus();
                return;
            }
            if (txtUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar un nombre de usuario");
                txtUsuario.requestFocus();
                return;
            }
            if (txtPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar una Contraseña");
                txtPassword.requestFocus();
                return;
            }
            if (txtCelular.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar un numero de Celular");
                txtCelular.requestFocus();
                return;
            }
            if (txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar un Correo");
                txtCorreo.requestFocus();
                return;
            }

            mUsuario datos = new mUsuario();
            mPersona datosP = new mPersona();

            fUsuario funcion = new fUsuario();
            fPersona funcionP = new fPersona();
            int confirmar = JOptionPane.showConfirmDialog(rootPane, "Registrar usuario : " + txtUsuario.getText() + " ?", "Confirmar", 2);
            if (confirmar == 0) {
                int existe = funcion.verificar(txtUsuario.getText());//verifica si ya existe este usuario
                if (existe == 1) {
                    JOptionPane.showMessageDialog(null, " El nombre de usuario que intenta registrar"
                            + "\n ya esta en uso.");
                    txtUsuario.requestFocus();
                    return;
                }
                datosP.setCedula_persona(this.txtCedula.getText());
                datosP.setNombre_persona(this.txtNombre.getText());
                datosP.setApellido_persona(this.txtApellido.getText());
                datosP.setDireccion_persona(this.txtDireccion.getText());
                datosP.setCelular_persona(txtCelular.getText());
                datosP.setEmail_persona(txtCorreo.getText());
                datosP.setSexo_persona(comboSexo.getSelectedItem().toString());
                
                
                datos.setCedula_persona(this.txtCedula.getText());
                datos.setLogin_usuario(this.txtUsuario.getText());
                datos.setPassword_usuario(this.txtPassword.getText());
                datos.setNombre_persona(this.txtNombre.getText());
                datos.setEstado_usuario(comboEstado.getSelectedItem().toString());
                datos.setTipo_Usuario(comboTipo.getSelectedItem().toString());

                if (funcionP.insertar(datosP) && funcion.agregar(datos)) {
                    JOptionPane.showMessageDialog(rootPane, "El Usuario ha sido Registrado ");
                }

                if (funcion.ContarUsuarios() > 1) {//comprueba si ya existe almens un usuario registrado
                    funcion.listar("");
                    this.dispose();
                    return;
                }

                //funcion.mostrarUsuario("");
                this.dispose();

                if (funcion.ContarUsuarios() == 1) {// si no hay usuarios muestra el formulario de acceso
                    frmLogin login = new frmLogin();

                    login.setVisible(true);
                }
            }// fin confirmar
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        txtApellido.requestFocus();

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
        comboEstado.requestFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
        txtCorreo.requestFocus();
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
        txtCedula.requestFocus();
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        if (txtNombre.getText().length() == 25) {//para que el maximo de caracteres ingresados sea 25

            evt.consume();
        }

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEstadoActionPerformed

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
            //JOptionPane.showMessageDialog(null, "ingresa solo numeros");
        }
        if (txtCelular.getText().length() == 10) {//para que el maximo de caracteres ingresados sea 10

            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        if (txtApellido.getText().length() == 25) {//para que el maximo de caracteres ingresados sea 25

            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        if (txtUsuario.getText().length() == 15) {//para que el maximo de caracteres ingresados sea 10

            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        // TODO add your handling code here:
        if (txtCorreo.getText().length() == 30) {//para que el maximo de caracteres ingresados sea 30

            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // TODO add your handling code here:
        if (txtPassword.getText().length() == 15) {//para que el maximo de caracteres ingresados sea 15

            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        if (txtCedula.getText().length() == 10) {//para que el maximo de caracteres ingresados sea 15

            evt.consume();
        }
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
            //JOptionPane.showMessageDialog(null, "ingresa solo numeros");
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtCelular.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void comboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSexoActionPerformed
        // TODO add your handling code here:
        txtUsuario.requestFocus();
    }//GEN-LAST:event_comboSexoActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboTipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRegUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegUsuario().setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnNuevo;
    public static javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboSexo;
    public static javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JTextField txtApellido;
    public static javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
