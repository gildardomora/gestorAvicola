/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Consultas.fUsuario;
import Estilos.estiloBoton;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelos.mUsuario;

/**
 *
 * @author GIMORE
 */
public class frmLogin extends javax.swing.JFrame {

    public static String version = "ver 1.4"; // indica la version del programa  
// Recordatorio GIMORE--- mover despues a una clase
 
    

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
      
        jScrollPane1.setVisible(false);// para ocultar la tabla del login

        lblSesion.setVisible(false);
        lblVersion.setText(version);
        if (!ContarUsuarios()) {

            this.setVisible(true);
            txtUsuario.requestFocus();
            //  this.show(false);
        }
        //this.setVisible(true);
        this.setLocationRelativeTo(null);
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {//para que funcione la tecla enter en el boton 
            public void keyPressed(java.awt.event.KeyEvent e) {
                btnEntrarActionPerformed(null);
            }
        });

    }

//    
    public boolean ContarUsuarios() {// para ver si existen usuarios registrados
//boolean verif=false;
        fUsuario funcion = new fUsuario();
        int cantidadUsuarios = funcion.ContarUsuarios();
        if (cantidadUsuarios == 0) {

            JOptionPane.showMessageDialog(rootPane, "DEBE CREAR EL ADMINISTRADOR DEL SISTEMA");

            frmRegUsuario form = new frmRegUsuario();
            form.setResizable(false);
            form.setLocationRelativeTo(null);
            form.setVisible(true);
            form.toFront();
            form.Habilitar();
            form.btnNuevo.setText("Guardar");
            form.comboEstado.setSelectedItem("Activo");
            form.comboEstado.setEnabled(false);

            form.comboTipo.setSelectedItem("Administrador");
            form.comboTipo.setEnabled(false);

            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return true;

        }//cierre
        return false;

    }

    public void iniciarSesion() {

        //para hacer un timeout o pausa de tiempo
//        try {
//            //Ponemos a "Dormir" el programa durante los ms que queremos
//            Thread.sleep(5 * 1000);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        if (txtUsuario.getText().length() == 0) {
            //  lblCargando.setVisible(false);
            lblSesion.setText("Debe ingresar un Nombre de Usuario");
            lblSesion.setVisible(true);
            txtUsuario.requestFocus();
            return;
        }

        if (txtContraseña.getText().length() == 0) {
            //   lblCargando.setVisible(false);
            lblSesion.setText("Debe ingresar una Contraseña");
            lblSesion.setVisible(true);
            txtContraseña.requestFocus();
            return;
        }

        try {
            DefaultTableModel modelo;
            fUsuario func = new fUsuario();
            mUsuario datos = new mUsuario();

            datos.setUsuario(txtUsuario.getText());
            datos.setPassword(txtContraseña.getText());

            modelo = func.sesion(datos.getUsuario(), datos.getPassword());//ajusta los datos de acceso en el modelo de la tabla

            //JOptionPane.showMessageDialog(rootPane, "usuario : " + datos.getUsuario());
            //JOptionPane.showMessageDialog(rootPane, "pass : " + datos.getPassword());
            // modelo =func.sesion(usuario, password)
            tblUsuarios.setModel(modelo);//envia el modelo a la tabla

            if (func.totalRegistros > 0) {//comprueba si hay usuarios registrados
                this.dispose();
                frmInicio form = new frmInicio();
                form.toFront();
                form.setVisible(true);
                frmInicio.lblTipo.setText(tblUsuarios.getValueAt(0, 4).toString());//ajusta el tipo de usuario en la etiqueta 

                frmInicioEscritorio form2 = new frmInicioEscritorio();
              
                frmInicio.escritorio.add(form2);
                try {
                    form2.toFront();
                    //form2.setClosable(true);
                    //form2.setIconifiable(true);
                    form2.setVisible(true);
                    this.setLocationRelativeTo(null);
                    form2.setMaximum(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                frmInicio.usuarioActual = txtUsuario.getText();
                frmInicio.lbluser.setText(frmInicio.usuarioActual);
             
                //String asa=tblUsuarios.getValueAt(0, 0).toString(); --- para prueba de error
                //JOptionPane.showMessageDialog(rootPane, "esto sale de la tabla :" + asa);

            } else {

                lblSesion.setText("Usuario y/o Contraseña incorrectos.");
                lblSesion.setVisible(true);
                txtUsuario.requestFocus();
            }

        } catch (Exception e) {
        }

    }//fin metodo iniciar sesion
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblSesion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 66, 66)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(9, 66, 66));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContraseña.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(9, 66, 66));
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 66, 66)));
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 185, 32));

        txtUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(9, 66, 66));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 66, 66)));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 185, 32));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INICIAR SESION");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(9, 66, 66));
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/keyEnter32pxVerde.png"))); // NOI18N
        btnEntrar.setText("INICIAR SESIÓN");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 180, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/user32pxblanco.png"))); // NOI18N
        jLabel2.setText("      USUARIO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/pass32pxblanco.png"))); // NOI18N
        jLabel3.setText("CONTRASEÑA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(102, 0, 0));
        jButton3.setText("X");
        jButton3.setToolTipText("Click para Salir de Aplicación");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 66, 66)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 7, 34, 30));

        lblSesion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/warningamariillo32px.png"))); // NOI18N
        lblSesion.setText("#");
        jPanel2.add(lblSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 249, 380, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GAVISOFT");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 1, 420, 280));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/acess90pxaverde.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 99, -1, -1));

        lblVersion.setForeground(new java.awt.Color(9, 66, 66));
        lblVersion.setText("version");
        lblVersion.setToolTipText("Por Gildardo Mora");
        jPanel1.add(lblVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 271, -1, -1));

        jScrollPane1.setEnabled(false);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsuarios.setEnabled(false);
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 17, 35, 21));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        System.exit(0);
        //dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        iniciarSesion();

        //JOptionPane.showMessageDialog(rootPane, txtContraseña.getText());

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
        btnEntrar.requestFocus();
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        txtContraseña.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarSesion();
        }

    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        // TODO add your handling code here:
               // estiloBoton.botonConMouse(btnEntrar);

    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        // TODO add your handling code here:
        estiloBoton.botonColor(btnEntrar,"","");
    }//GEN-LAST:event_btnEntrarMouseExited

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin();
                //.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEntrar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
