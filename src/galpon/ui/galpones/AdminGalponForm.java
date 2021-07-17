/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.ui.galpones;

import galpon.ui.gastos.GastosGalponForm;
import galpon.ui.principal.EliminarDialog;
import galpon.bd.conection.Conexion;
import galpon.model.bd.query.fAdminGalpon;
import galpon.model.bd.query.fContar;
import galpon.ui.styles.estiloTabla;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import galpon.model.dto.AdminGalponDto;
import galpon.ui.principal.InicioForm;
import javax.swing.JFrame;

/**
 *
 * @author GIMORE
 */
public class AdminGalponForm extends javax.swing.JInternalFrame {

    public GalponMovimientosForm formgalpon = null;

    //conexion prueba
    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 
    public static String accion = "";
    public static String[] datostabla = new String[9];

    /**
     * Creates new form GalponMovimientosForm
     */
    public AdminGalponForm() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        mostrar(""); //cargar datos y modelo de la tabla galpon

        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        dimensioncols();//tamaño columnas
        estiloTabla diseño = new estiloTabla();
        diseño.tabla(tablaAdminGalpon);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAdminGalpon = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEntradaSalida = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnGastos = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(9, 66, 66));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GESTION DE GALPONES");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GRANJA AVICOLA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(9, 66, 66));

        txtBuscar.setToolTipText("Bucar por fecha");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/searchblanco32px.png"))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("BUSCAR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tablaAdminGalpon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdGalpon", "Tipo de Ave", "Fecha de Apertura", "Saldo de Aves", "Descripcion", "Estado"
            }
        ));
        tablaAdminGalpon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAdminGalponMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAdminGalpon);

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setForeground(new java.awt.Color(9, 66, 66));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/addverde32px.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setForeground(new java.awt.Color(9, 66, 66));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/editverde32px.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setEnabled(false);
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setForeground(new java.awt.Color(9, 66, 66));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/deleterojo32px.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEntradaSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnEntradaSalida.setForeground(new java.awt.Color(9, 66, 66));
        btnEntradaSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/addpropverde32px.png"))); // NOI18N
        btnEntradaSalida.setText("REG [ Entrada / Salida ]");
        btnEntradaSalida.setEnabled(false);
        btnEntradaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaSalidaActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(9, 66, 66));
        jLabel11.setText("Lista de Galpones Registrados");

        btnGastos.setBackground(new java.awt.Color(255, 255, 255));
        btnGastos.setForeground(new java.awt.Color(9, 66, 66));
        btnGastos.setText("REGISTRAR GASTOS");
        btnGastos.setEnabled(false);
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEntradaSalida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntradaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
        public void dimensioncols() {
        tablaAdminGalpon.getColumnModel().getColumn(0).setPreferredWidth(25);//ancho para la primer columna
        tablaAdminGalpon.getColumnModel().getColumn(5).setPreferredWidth(15);//ancho para la primer columna
    }

    public void mostrar(String buscar) { //para mostrar registros de la tabla galpon
        //DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente

        try {
            DefaultTableModel modelo;
            fAdminGalpon func = new fAdminGalpon();
            modelo = func.mostrar(buscar);
            tablaAdminGalpon.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }    // cierre de metodo  

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // BOTON NUEVO
       fContar contar = new fContar(); 
    if (contar.existencia("id_ave", "tipo_ave")==0){
        JOptionPane.showMessageDialog(rootPane, "No hay aves registradas");
     return;
    }
        accion = "nuevo";
        GalponDialog datosgalpon = new GalponDialog(new JFrame(), true);
        datosgalpon.lblTitulo.setText("REGISTRAR NUEVO GALPON");
        datosgalpon.setVisible(true);
        mostrar("");// para recargar los datos en la tabla
        dimensioncols();
btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnEntradaSalida.setEnabled(false);
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //BOTON EDITAR
        // cambiar nombre de botones
        accion = "editar";
        GalponDialog datosgalpon = new GalponDialog(new JFrame(), true);
        datosgalpon.lblTitulo.setText("EDITAR GALPON");
        datosgalpon.setVisible(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnEntradaSalida.setEnabled(false);
        btnGastos.setEnabled(false);
        mostrar("");// para recargar los datos en la tabla
        dimensioncols();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEntradaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaSalidaActionPerformed
        // TODO add your handling code here:

        if (datostabla[0] == null) {
            JOptionPane.showMessageDialog(null, "Elija Primero un Galpon");
        } else {
            formgalpon = new GalponMovimientosForm();
            formgalpon.frmGalpon(datostabla[0]);
            int ancho = InicioForm.escritorio.getWidth();
            int altura = InicioForm.escritorio.getHeight();
            formgalpon.setSize(ancho, altura);
            InicioForm.escritorio.add(formgalpon);
            formgalpon.show();
        }


    }//GEN-LAST:event_btnEntradaSalidaActionPerformed

    private void tablaAdminGalponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAdminGalponMouseClicked
        // acciones al dar clic sobre la tabla
        btnEliminar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEntradaSalida.setEnabled(true);
        btnGastos.setEnabled(true);
        //btnEditar.setIcon(new ImageIcon("src/Archivos/Editverde32px.png"));
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha;
        int filaSel = tablaAdminGalpon.rowAtPoint(evt.getPoint());// guarda en la variable filaSel la ila que se selecciono en la tabla
        //pasa el contenido de la fila 0 al campo NumGalpon
        datostabla[0] = tablaAdminGalpon.getValueAt(filaSel, 0).toString();
        datostabla[1] = tablaAdminGalpon.getValueAt(filaSel, 1).toString();
        datostabla[2] = tablaAdminGalpon.getValueAt(filaSel, 2).toString();
        datostabla[3] = tablaAdminGalpon.getValueAt(filaSel, 3).toString();
        datostabla[4] = tablaAdminGalpon.getValueAt(filaSel, 4).toString();
        datostabla[5] = tablaAdminGalpon.getValueAt(filaSel, 5).toString();
//datostabla[6]=tablaAdminGalpon.getValueAt(filaSel, 6).toString();
//datostabla[7]=tablaAdminGalpon.getValueAt(filaSel, 7).toString();
//datostabla[8]=tablaAdminGalpon.getValueAt(filaSel, 8).toString();

    }//GEN-LAST:event_tablaAdminGalponMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // BOTON ELIMINAR
        EliminarDialog advertencia = new EliminarDialog(new JFrame(), true);
        advertencia.lblTitulo.setText("ELIMINAR GALPON");
        advertencia.AtxtAdvertencia.setText("Si elimina el GALPON, la información correspondiente a"
                + "\n Ventas, Gastos, Producción y Estadísticas será  afectada.");
        advertencia.lblmsgConfirmar.setText("¿ Confirma que desea ELIMINAR el GALPON ?  ");
        advertencia.setVisible(true);

        if (advertencia.respuesta.equals("eliminar")) {
            AdminGalponDto datos = new AdminGalponDto();
            fAdminGalpon func = new fAdminGalpon();
            try {
                if ((func.contar("entrada") > 0) || func.contar("salida") > 0 || func.contar("produccion") > 0) {
                    int adv = JOptionPane.showConfirmDialog(rootPane, "Se eliminará por completo la informacion del galpon", "confirmar", 2);
                    if (adv == 0) {
                        datos.setIdGalpon(Integer.parseInt(datostabla[0]));
                        if (func.eliminar(datos)) {
                            JOptionPane.showMessageDialog(rootPane, "Galpon Eliminado Correctamente");
                        }
                        // eliminar(Integer.parseInt(txtNumGalpon.getText()));
                        mostrar("");
                        dimensioncols();//tamaño columnas                           
                    }
                }//cierre comprobacion 
                // Si no hay entradas, salidas o producciones  elimina el galpon 

                datos.setIdGalpon(Integer.parseInt(datostabla[0]));
                if (func.eliminar(datos)) {
                    JOptionPane.showMessageDialog(rootPane, "Galpon Eliminado Correctamente");
                }
                // eliminar(Integer.parseInt(txtNumGalpon.getText()));
                mostrar("");
                dimensioncols();

            } catch (SQLException ex) {
                Logger.getLogger(AdminGalponForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnEntradaSalida.setEnabled(false);
        btnGastos.setEnabled(false);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        // txtNumGalpon.setText("");

        mostrar(txtBuscar.getText());
        dimensioncols();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed
        // TODO add your handling code here:
        GastosGalponForm formgastos = new GastosGalponForm();
        int ancho=InicioForm.escritorio.getWidth();
        int altura=InicioForm.escritorio.getHeight();
        formgastos.setSize(ancho, altura);
        InicioForm.escritorio.add(formgastos);
        formgastos.show();
        
    }//GEN-LAST:event_btnGastosActionPerformed

    /**
     * @param args the command line arguments
     */
    //metodo para conexion
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
            java.util.logging.Logger.getLogger(AdminGalponForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGalponForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGalponForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGalponForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGalponForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEntradaSalida;
    private javax.swing.JButton btnGastos;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaAdminGalpon;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}