/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.ui.productos;

import galpon.ui.productos.ProductosForm;
import galpon.bd.conection.Conexion;
import galpon.controller.ProductoController;
import galpon.model.bd.query.ProductoModel;
import galpon.model.dto.mProducto;
import java.awt.Color;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIMORE
 */
public class ProductoDialog extends javax.swing.JDialog {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 
    String[] medida = new String[6];
    String[] categoria = new String[2];

    /**
     * Creates new form frmDiagProducto
     */
    public ProductoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargar_acciones();
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
        lblTitulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AtxtDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUniMed = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrecioUni = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblidProducto = new javax.swing.JLabel();
        comboUniMedida = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        txtCategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(9, 66, 66));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("REGISTRAR PRODUCTO");

        AtxtDescripcion.setColumns(1);
        AtxtDescripcion.setForeground(new java.awt.Color(9, 66, 66));
        AtxtDescripcion.setLineWrap(true);
        AtxtDescripcion.setRows(1);
        AtxtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AtxtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(AtxtDescripcion);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NOMBRE");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("UNIDAD DE MEDIDA");

        txtUniMed.setForeground(new java.awt.Color(9, 66, 66));
        txtUniMed.setEnabled(false);
        txtUniMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniMedActionPerformed(evt);
            }
        });
        txtUniMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUniMedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUniMedKeyTyped(evt);
            }
        });

        txtNombre.setForeground(new java.awt.Color(9, 66, 66));
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

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PRECIO X UNI MED");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESCRIPCION:");

        txtPrecioUni.setForeground(new java.awt.Color(9, 66, 66));
        txtPrecioUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUniActionPerformed(evt);
            }
        });
        txtPrecioUni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUniKeyTyped(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setForeground(new java.awt.Color(9, 66, 66));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setPreferredSize(new java.awt.Dimension(86, 36));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(9, 66, 66));
        jButton2.setText("CANCELAR");
        jButton2.setMaximumSize(new java.awt.Dimension(92, 36));
        jButton2.setPreferredSize(new java.awt.Dimension(92, 36));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/productblanco100px.png"))); // NOI18N

        lblidProducto.setText("ID");

        comboUniMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboUniMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboUniMedidaItemStateChanged(evt);
            }
        });
        comboUniMedida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboUniMedidaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboUniMedidaMousePressed(evt);
            }
        });
        comboUniMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUniMedidaActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CATEGORIA");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategoriaItemStateChanged(evt);
            }
        });
        comboCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCategoriaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboCategoriaMousePressed(evt);
            }
        });
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

        txtCategoria.setForeground(new java.awt.Color(9, 66, 66));
        txtCategoria.setEnabled(false);
        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(comboUniMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecioUni, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtUniMed)
                                    .addComponent(txtCategoria))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblidProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUniMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboUniMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtPrecioUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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

    public void cargar_acciones() {
        cargarCombos();
        switch (ProductoController.accion) {
            case "nuevo":
                lblTitulo.setText("REGISTRAR NUEVO PRODUCTO");
                lblidProducto.setForeground(new Color(9, 66, 66));
                break;
            case "editar":
                lblTitulo.setText("EDITAR PRODUCTO");
                lblidProducto.setForeground(Color.white);
                // ProductosForm.
                lblidProducto.setText(ProductoController.datostabla[0]);
                txtNombre.setText(ProductoController.datostabla[1]);
                //              
                txtUniMed.setText(ProductoController.datostabla[2]);
                txtUniMed.setEnabled(true);
                for (int i = 0; i < medida.length; i++) {
                    if (ProductoController.datostabla[2].equals(medida[i])) {
                        comboUniMedida.setSelectedItem(ProductoController.datostabla[2]);
                    }
                }

                for (int i = 0; i < categoria.length; i++) {
                    if (ProductoController.datostabla[6].equals(categoria[i])) {
                        comboCategoria.setSelectedItem(ProductoController.datostabla[6]);
                    }
                }

                txtUniMed.setText(ProductoController.datostabla[2]);
                AtxtDescripcion.setText(ProductoController.datostabla[3]);
                txtPrecioUni.setText(ProductoController.datostabla[4]);
        }

    }

    private void cargarCombos() {// carga datos de la BD y los pone en los combobox

        //   comboUniMedida.removeAllItems();
        // comboUniMedida.addItem("Seleccionar");
        medida[0] = "Libra";
        medida[1] = "Kilogramo";
        medida[2] = "Unidad";
        medida[3] = "Docena";
        medida[4] = "Cubeta";
        medida[5] = "Otro";
        categoria[0] = "CARNICOS";
        categoria[1] = "Otro";

        for (int i = 0; i < medida.length; i++) {
            comboUniMedida.addItem(medida[i]);
        }

        for (int i = 0; i < categoria.length; i++) {
            comboCategoria.addItem(categoria[i]);
        }

    }//cierre metodo

    public void mostrar(String buscar) { //para mostrar registros de la tabla galpon
        //DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente

        try {
            DefaultTableModel modelo;
            ProductoModel func = new ProductoModel();
            modelo = func.mostrar(buscar);
            ProductosForm.tablaProducto.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //  ProductosForm.dimensioncols();

    }    // cierre de metodo

    private void validarDatoTipoNumero(String dato) {
        int num;
        try {
            num = Integer.parseInt(dato);
            //JOptionPane.showMessageDialog(rootPane,"No se admiten letras en: ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No se admiten letras en: ");
        }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        // TODO add your handling code here:
        mProducto datos = new mProducto();
        ProductoModel func = new ProductoModel();

        if (txtNombre.getText().equals("")) {//validar que se seleccione Ave
            JOptionPane.showMessageDialog(rootPane, "Debes asignar un nombre al producto");
            txtNombre.requestFocus();
            return;// para que salte y no siga el codigo
        }
        if (txtUniMed.getText().equals("")) {//validar que se seleccione Ave
            JOptionPane.showMessageDialog(rootPane, "Debes asignar una Unidad de Medida");
            txtUniMed.requestFocus();
            return;// para que salte y no siga el codigo
        }
        if (txtPrecioUni.getText().equals("")) {//validar que se seleccione Ave
            JOptionPane.showMessageDialog(rootPane, "Debes asignar una Precio a la Unidad de Medida");
            txtPrecioUni.requestFocus();
            return;// para que salte y no siga el codigo
        }
        if (txtCategoria.getText().equals("")) {//validar que se seleccione Ave
            JOptionPane.showMessageDialog(rootPane, "Debes asignar una Categoria");
            txtCategoria.requestFocus();
            return;// para que salte y no siga el codigo
        }

        java.util.Date fechaactual = new Date();//almacena la fecha actual en formato Date
        long fecha = fechaactual.getTime();
        java.sql.Date fechaSQL = new java.sql.Date(fecha);//establece el formato compatible con sql

        datos.setNombre(txtNombre.getText());
        datos.setUniMedida(txtUniMed.getText());
        datos.setCategoria(txtCategoria.getText());
        datos.setDescripcion(AtxtDescripcion.getText());
        datos.setPrecioUniMed(Integer.parseInt(txtPrecioUni.getText()));
        datos.setFecha(fechaSQL.toString());

        validarDatoTipoNumero(txtPrecioUni.getText());
        switch (ProductoController.accion) {
            case "nuevo":
                if (func.insertar(datos)) {
                    JOptionPane.showMessageDialog(rootPane, "Producto registrado Correctamente");

                    // deshabilitarcampos();
                }
                mostrar("");
                postsql.cierraConexion();
                this.dispose();
                break;
            case "editar":
                datos.setIdProducto(Integer.parseInt(lblidProducto.getText()));
                if (func.editar(datos)) {
                    JOptionPane.showMessageDialog(rootPane, "El Producto fue Editado satisfactoriamente");
                }
                mostrar("");
                this.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ocurrio un error..");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPrecioUniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
            // JOptionPane.showMessageDialog(null, "ingresa solo numeros");
        }
        if (txtPrecioUni.getText().length() == 10) {//para que el maximo de caracteres ingresados sea 100

            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioUniKeyTyped

    private void txtPrecioUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUniActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == evt.VK_DELETE || c == evt.VK_SPACE) {

        } else {

            evt.consume();
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null, "ingresa solo numeros");
        }
        if (txtNombre.getText().length() == 15) {//para que el maximo de caracteres ingresados sea 100

            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtUniMedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUniMedKeyTyped
        // validar que solo se ingrese numeros
        if (txtUniMed.getText().length() == 15) {//para que el maximo de caracteres ingresados sea 100

            evt.consume();
        }
    }//GEN-LAST:event_txtUniMedKeyTyped

    private void txtUniMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniMedActionPerformed

    private void AtxtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AtxtDescripcionKeyTyped
        // TODO add your handling code here:
        if (AtxtDescripcion.getText().length() == 100) {//para que el maximo de caracteres ingresados sea 100

            evt.consume();
        }
    }//GEN-LAST:event_AtxtDescripcionKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboUniMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUniMedidaActionPerformed
        // TODO add your handling code here:
//     

    }//GEN-LAST:event_comboUniMedidaActionPerformed

    private void comboUniMedidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboUniMedidaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_comboUniMedidaMouseClicked

    private void comboUniMedidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboUniMedidaMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboUniMedidaMousePressed

    private void comboUniMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboUniMedidaItemStateChanged
        // TODO add your handling code here:
        String seleccionado = (String) comboUniMedida.getSelectedItem();
        if (seleccionado.equals("Otro")) {
            txtUniMed.setText("");
            txtUniMed.setEnabled(true);
        } else {
            txtUniMed.setEnabled(false);
            txtUniMed.setText(seleccionado);
        }


    }//GEN-LAST:event_comboUniMedidaItemStateChanged

    private void comboCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategoriaItemStateChanged
        // TODO add your handling code here:
        String seleccionado = (String) comboCategoria.getSelectedItem();
        if (seleccionado.equals("Otro")) {
            txtCategoria.setText("");
            txtCategoria.setEnabled(true);
        } else {
            txtCategoria.setEnabled(false);
            txtCategoria.setText(seleccionado);
        }
    }//GEN-LAST:event_comboCategoriaItemStateChanged

    private void comboCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaMouseClicked

    private void comboCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCategoriaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaMousePressed

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaKeyTyped

    private void txtUniMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUniMedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniMedKeyReleased

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
            java.util.logging.Logger.getLogger(ProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductoDialog dialog = new ProductoDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea AtxtDescripcion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboUniMedida;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblidProducto;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioUni;
    private javax.swing.JTextField txtUniMed;
    // End of variables declaration//GEN-END:variables
}
