/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Conexion.Conexion;
import Funciones.fProduccion;
import Funciones.fProducto;
import Interfaz.diseño.estiloTabla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.mProduccion;
import modelos.mProducto;

/**
 *
 * @author GIMORE
 */
public class frmProduccion extends javax.swing.JInternalFrame {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 

    /**
     * Creates new form frmProduccion
     */
    public frmProduccion() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        mostrar("");
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        cargarCombos();
        estiloTabla diseño = new estiloTabla();
        diseño.tabla(tablaProduccion);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNueva = new javax.swing.JButton();
        comboGalpon = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboProducto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProduccion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel4 = new javax.swing.JPanel();
        lblidProduccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 475));

        jPanel2.setBackground(new java.awt.Color(9, 66, 66));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTROL DE PRODUCCION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(271, 271, 271))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(9, 66, 66));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Produccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/addverde32px.png"))); // NOI18N
        btnNueva.setText("Nueva");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        comboGalpon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", ".1", "2" }));
        comboGalpon.setEnabled(false);
        comboGalpon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGalponActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Galpon");

        comboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Huevo" }));
        comboProducto.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad");

        txtCantidad.setEnabled(false);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/editverde32px.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/produccion.png"))); // NOI18N

        jDateFecha.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                        .addComponent(btnNueva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboProducto, javax.swing.GroupLayout.Alignment.TRAILING, 0, 117, Short.MAX_VALUE)
                                    .addComponent(comboGalpon, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboGalpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        tablaProduccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Produccion", "Galpon", "Producto", "Cantidad", "Fecha"
            }
        ));
        tablaProduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProduccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProduccion);

        jPanel4.setBackground(new java.awt.Color(9, 66, 66));

        lblidProduccion.setForeground(new java.awt.Color(255, 255, 255));
        lblidProduccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblidProduccion.setText("#");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblidProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblidProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProduccionMouseClicked
        //
        btnEditar.setEnabled(true);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha;
        int filaSel = tablaProduccion.rowAtPoint(evt.getPoint());

        lblidProduccion.setText(tablaProduccion.getValueAt(filaSel, 0).toString());
        comboGalpon.setSelectedItem(tablaProduccion.getValueAt(filaSel, 1).toString());
        comboProducto.setSelectedItem(tablaProduccion.getValueAt(filaSel, 2).toString());
        // txtIdProduccion.setText(tablaProduccion.getValueAt(filaSel, 0).toString());
        txtCantidad.setText(tablaProduccion.getValueAt(filaSel, 3).toString());
        try {
            fecha = formatoFecha.parse((String) tablaProduccion.getValueAt(filaSel, 4));
            jDateFecha.setDate(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(frmProduccion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // txtFecha.setText(tablaProduccion.getValueAt(filaSel, 4).toString());
    }//GEN-LAST:event_tablaProduccionMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //

        if (btnEditar.getLabel().equals("Cancelar")) {
            deshabilitarcampos();
            btnNueva.setLabel("Nueva");
            btnNueva.setIcon(new ImageIcon("src/Archivos/addverde32px.png"));
            btnEditar.setLabel("Editar");
            btnEditar.setIcon(new ImageIcon("src/Archivos/editverde32px.png"));
            btnEditar.setEnabled(false);
            limpiarCampos();
            jDateFecha.setCalendar(null);
        } else {
            habilitarcampos();
            lblidProduccion.setEnabled(false);
            btnNueva.setLabel("Actualizar");
            btnEditar.setLabel("Cancelar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "ingresa solo numeros");
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void comboGalponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGalponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGalponActionPerformed

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        try {
            if (contar("galpon") == 0) {
                JOptionPane.showMessageDialog(rootPane, "No existen galpones registrados para Produccion");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmProduccion.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (contar("producto") == 0) {
                JOptionPane.showMessageDialog(rootPane, "No existen Productos registrados para Produccion");
                return;
            }
        } catch (Exception e) {
        }

        if (btnNueva.getText().equals("Nueva")) {
            btnEditar.setEnabled(true);
            habilitarcampos();
            btnNueva.setLabel("Guardar");
            btnNueva.setIcon(new ImageIcon("src/Archivos/saveverde32px.png"));

            btnEditar.setLabel("Cancelar");
            btnEditar.setIcon(new ImageIcon("src/Archivos/cancelverde32px.png"));
            Calendar actual = new GregorianCalendar();
            jDateFecha.setCalendar(actual);
            return;
        }

        mProduccion datos = new mProduccion();
        fProduccion func = new fProduccion();

        if (btnNueva.getText().equals("Guardar")) {

            if (comboGalpon.getSelectedItem().toString().equals("Seleccionar")) {
                JOptionPane.showMessageDialog(rootPane, "Debes asignar un Galpon a la produccion");
                comboGalpon.requestFocus();
                return;// para que salte y no siga el codigo
            }
            if (comboProducto.getSelectedItem().toString().equals("Seleccionar")) {
                JOptionPane.showMessageDialog(rootPane, "Debes asignar un Producto a la produccion");
                comboProducto.requestFocus();
                return;// para que salte y no siga el codigo
            }
            if (txtCantidad.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debes asignar una Cantidad a la produccion");
                txtCantidad.requestFocus();
                return;
            }
            java.util.Date fecha = jDateFecha.getDate();//almacena la fecha en formato Date
            long fechaP = fecha.getTime();
            java.sql.Date fechaProd = new java.sql.Date(fechaP);//establece el formato compatible con sql
            datos.setCantidad(Integer.parseInt(txtCantidad.getText()));
            datos.setFecha(fechaProd.toString());
            datos.setIdGalpon(Integer.parseInt(comboGalpon.getSelectedItem().toString()));

           if (func.insertar(datos, comboProducto.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(rootPane, "Produccion Guardada Correctamente");
            }

           int confirmar= (JOptionPane.showConfirmDialog(rootPane, "Agregar la produccion al Stock de ventas", "Confirmar", 2));
           if(confirmar==0){
               
               fProducto funcP =new fProducto();
            mProducto datosP = new mProducto();            
            //datosP.setIdProducto(Integer.parseInt(lblidProducto.getText()));
            datosP.setNombre(comboProducto.getSelectedItem().toString());
            datosP.setStock(Integer.parseInt(txtCantidad.getText())+funcP.cantidadProducto(datosP) );
         //funcP.cantidadProducto(datosP); 
            funcP.editarStock(datosP);
            
               
           }
            //insertar(comboGalpon.getSelectedItem().toString(), comboProducto.getSelectedItem().toString());
            mostrar("");
            deshabilitarcampos();
            limpiarCampos();
            btnNueva.setText("Nueva");
            btnEditar.setText("Editar");
            btnEditar.setEnabled(false);
            return;
        }
        if (btnNueva.getText().equals("Actualizar")) {
            java.util.Date fecha = jDateFecha.getDate();//almacena la fecha en formato Date
            long fechaP = fecha.getTime();
            java.sql.Date fechaProd = new java.sql.Date(fechaP);//establece el formato compatible con sql
            datos.setCantidad(Integer.parseInt(txtCantidad.getText()));
            datos.setFecha(fechaProd.toString());
            datos.setIdGalpon(Integer.parseInt(comboGalpon.getSelectedItem().toString()));
            datos.setIdProduccion(Integer.parseInt(lblidProduccion.getText()));

            if (func.editar(datos, comboProducto.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(rootPane, "Datos de produccion actualizados");
            }

            mostrar("");
            deshabilitarcampos();
            limpiarCampos();
            btnNueva.setText("Nueva");
            btnEditar.setText("Editar");
            btnEditar.setEnabled(false);

        }

    }//GEN-LAST:event_btnNuevaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    public void mostrar(String buscar) { //para mostrar registros de la tabla galpon
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
        if (cn == null) { // confirma si no hay conexion de la BD para no proceder con las consultas..
            JOptionPane.showMessageDialog(rootPane, " No se pueden  cargar Registros \n"
                    + " debido a un problema de Conexion a la BD. ");
            return;
        }

        try {
            DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
            fProduccion func = new fProduccion();
            modelo = func.mostrar("");
            tablaProduccion.setModel(modelo);
            // return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.WARNING_MESSAGE);
            // return null;
        }

        postsql.cierraConexion();
    }    // cierre de metodo

    public int contar(String tabla) throws SQLException { //para contar registros de tablas
        int n = 0;
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        // sSQL = "select * from venta order by idventa ";
        sSQL = "select count (*) from " + tabla;

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);
        if (rs.next()) {
            //Si hay resultados obtengo el valor. 
            n = rs.getInt(1);
        }

        postsql.cierraConexion();
        return n;
    }    // cierre de metodo contar   

    private void cargarCombos() {// carga datos de la BD y los pone en los combobox
        cn = postsql.conectar();
        comboGalpon.removeAllItems();
        comboProducto.removeAllItems();
        comboGalpon.addItem("Seleccionar");
        comboProducto.addItem("Seleccionar");

        ArrayList<String> listaGalpon = new ArrayList<String>();
        listaGalpon = llenar_comboGalpon();
        for (int i = 0; i < listaGalpon.size(); i++) {
            comboGalpon.addItem(listaGalpon.get(i));
        }

        ArrayList<String> listaProducto = new ArrayList<String>();
        listaProducto = llenar_comboProducto();
        for (int i = 0; i < listaProducto.size(); i++) {
            comboProducto.addItem(listaProducto.get(i));
        }

        postsql.cierraConexion();
    }

    private void habilitarcampos() {
        //txtIdProduccion.setEnabled(true);
        comboGalpon.setEnabled(true);
        comboProducto.setEnabled(true);
        txtCantidad.setEnabled(true);
        jDateFecha.setEnabled(true);

    }

    private void deshabilitarcampos() {
        // txtIdProduccion.setEnabled(false);
        comboGalpon.setEnabled(false);
        comboProducto.setEnabled(false);
        txtCantidad.setEnabled(false);
        jDateFecha.setEnabled(false);

    }

    public ArrayList<String> llenar_comboGalpon() {
        ArrayList<String> lista = new ArrayList<String>();
        sSQL = "select idgalpon from galpon";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("idgalpon"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

    public ArrayList<String> llenar_comboProducto() {//metodo para cargar datos en los combobox
        ArrayList<String> lista = new ArrayList<String>();
        sSQL = "select nombre from producto";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("nombre"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

    private void limpiarCampos() {
        lblidProduccion.setText("");
        comboGalpon.setSelectedItem("Seleccionar");
        comboProducto.setSelectedItem("Seleccionar");
        txtCantidad.setText("");
        jDateFecha.setDate(null);
    }

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
            java.util.logging.Logger.getLogger(frmProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JComboBox<String> comboGalpon;
    private javax.swing.JComboBox<String> comboProducto;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblidProduccion;
    private javax.swing.JTable tablaProduccion;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
