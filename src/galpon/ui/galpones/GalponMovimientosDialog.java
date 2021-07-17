/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.ui.galpones;

import galpon.ui.galpones.GalponMovimientosForm;
import galpon.ui.galpones.AdminGalponForm;
import galpon.model.bd.query.fGalpon;
import galpon.model.dto.mEntrada;
import galpon.model.dto.mSalida;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GIMORE
 */
public class GalponMovimientosDialog extends javax.swing.JDialog {

    /**
     * Creates new form DiagGalponEnSal
     */
    public GalponMovimientosDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarinformacion();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblSaldoActual = new javax.swing.JLabel();
        lblNumGalpon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AtxtObservaciones = new javax.swing.JTextArea();
        jDateFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 66, 66));

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("TITULO DE VENTANA");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblSaldoActual.setForeground(new java.awt.Color(9, 66, 66));
        lblSaldoActual.setText("000000");

        lblNumGalpon.setForeground(new java.awt.Color(9, 66, 66));
        lblNumGalpon.setText("000");

        jLabel5.setForeground(new java.awt.Color(9, 66, 66));
        jLabel5.setText("GALPON N°:");

        jLabel1.setForeground(new java.awt.Color(9, 66, 66));
        jLabel1.setText("SALDO ACTUAL:");

        jLabel6.setText("ID :");

        lblid.setText("000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lblNumGalpon)
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(lblSaldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoActual)
                    .addComponent(lblNumGalpon)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(lblid))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FECHA");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SALDO");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("OBSERVACIONES:");

        AtxtObservaciones.setColumns(20);
        AtxtObservaciones.setLineWrap(true);
        AtxtObservaciones.setRows(2);
        jScrollPane1.setViewportView(AtxtObservaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jDateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 196, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarinformacion() {
        lblSaldoActual.setText(AdminGalponForm.datostabla[3]);
        lblNumGalpon.setText(AdminGalponForm.datostabla[0]);
        Calendar actual = new GregorianCalendar();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        switch (GalponMovimientosForm.accion) {
            case "nueva entrada":
                jDateFecha.setCalendar(actual);
                break;
            case "editar entrada":

                try {
                    fecha = formatoFecha.parse((String) GalponMovimientosForm.datostabla[3]);
                } catch (ParseException ex) {
                    Logger.getLogger(GalponMovimientosDialog.class.getName()).log(Level.SEVERE, null, ex);
                }

                jDateFecha.setDate(fecha);
                txtSaldo.setText(GalponMovimientosForm.datostabla[4]);
                //jDateFecha.setD("SALDO ACTUAL: "+GalponMovimientosForm.datostabla[2]);
                AtxtObservaciones.setText(GalponMovimientosForm.datostabla[5]);
                break;
            case "nueva salida":
                jDateFecha.setCalendar(actual);
                break;
            case "editar salida":

                try {
                    fecha = formatoFecha.parse((String) GalponMovimientosForm.datostabla[3]);
                } catch (ParseException ex) {
                    Logger.getLogger(GalponMovimientosDialog.class.getName()).log(Level.SEVERE, null, ex);
                }

                jDateFecha.setDate(fecha);
                txtSaldo.setText(GalponMovimientosForm.datostabla[4]);
                //jDateFecha.setD("SALDO ACTUAL: "+GalponMovimientosForm.datostabla[2]);
                AtxtObservaciones.setText(GalponMovimientosForm.datostabla[5]);
                break;
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (jDateFecha.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Debes asignar una fecha");
            jDateFecha.requestFocus();
            return;
        }
        if (txtSaldo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debes asignar una Cantidad");
            txtSaldo.requestFocus();
            return;
        }

        mEntrada datosEnt = new mEntrada();
        mSalida datosSal = new mSalida();

        fGalpon func = new fGalpon();

        Date fechaObt = jDateFecha.getDate();//almacena la fecha en formato Date
        long fechaFinal = fechaObt.getTime();
        java.sql.Date fecha = new java.sql.Date(fechaFinal);//establece el formato compatible con sql
        if (GalponMovimientosForm.accion.equals("nueva entrada") || GalponMovimientosForm.accion.equals("editar entrada")) {
            datosEnt.setIdGalpon(Integer.parseInt(lblNumGalpon.getText()));
            datosEnt.setFecha(fecha.toString());
            datosEnt.setCantidad(Integer.parseInt(txtSaldo.getText()));
            datosEnt.setDescripcion(AtxtObservaciones.getText());
            datosEnt.setsaldo_aves(Integer.parseInt(lblSaldoActual.getText()));
        }
        if (GalponMovimientosForm.accion.equals("nueva salida") || GalponMovimientosForm.accion.equals("editar salida")) {
            datosSal.setIdGalpon(Integer.parseInt(lblNumGalpon.getText()));
            datosSal.setFecha(fecha.toString());
            datosSal.setCantidad(Integer.parseInt(txtSaldo.getText()));
            datosSal.setDescripcion(AtxtObservaciones.getText());
            datosSal.setsaldo_aves(Integer.parseInt(lblSaldoActual.getText()));
        }
        switch (GalponMovimientosForm.accion) {
            case "nueva entrada":

                if (func.insertarEntrada(datosEnt)) {
                    JOptionPane.showMessageDialog(rootPane, "Datos de nueva Entrada Agregados");
                }// ejecuta la insercion de datos

                break;
            case "editar entrada":
                datosEnt.setIdEntrada(Integer.parseInt(lblid.getText()));

                if (func.editarEntrada(datosEnt)) {
                    JOptionPane.showMessageDialog(rootPane, "Datos de Entrada Modificados");
                }

                break;
            case "nueva salida":
                if (func.insertarSalida(datosSal)) {
                    JOptionPane.showMessageDialog(rootPane, "Datos de Salida Agregados");
                }
                break;
            case "editar salida":
                  datosSal.setIdSalida(Integer.parseInt(lblid.getText()));
                  if(func.editarSalida(datosSal)){
                             JOptionPane.showMessageDialog(rootPane, "Datos de Salida Modificados");             
                  }

                break;

        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GalponMovimientosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GalponMovimientosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GalponMovimientosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GalponMovimientosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GalponMovimientosDialog dialog = new GalponMovimientosDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AtxtObservaciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumGalpon;
    private javax.swing.JLabel lblSaldoActual;
    public static javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}