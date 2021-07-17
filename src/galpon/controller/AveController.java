/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.controller;

import galpon.model.bd.query.AveModel;
import galpon.model.dto.AveDto;
import galpon.ui.aves.AvesForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import galpon.ui.principal.EliminarDialog;
import galpon.ui.styles.estiloTabla;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author GIMORE
 */
public class AveController implements ActionListener, KeyListener, MouseListener, ItemListener {

    private AvesForm aveF;
    private AveModel aveM;

    public AveController(AvesForm aveF) {
        this.aveF = aveF;
        this.aveF.btnNuevo.addActionListener(this);
        this.aveF.btnEditar.addActionListener(this);
        this.aveF.tablaAdminAves.addMouseListener(this);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.aveF.getUI()).setNorthPane(null);//para que no se vea el bordo del escritorio
        this.aveF.contenedorTabla.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        this.aveF.txtNombreAve.addKeyListener(this);
        this.aveF.txtDescripcion.addKeyListener(this);
        this.aveF.txtBuscar.addKeyListener(this);
        this.aveF.comboNombre.addItemListener(this);
        establecerTema();
        cargarInfoItems();
        consultarAves("");

    }

    private void establecerTema() {
        estiloTabla diseño = new estiloTabla();
        diseño.tabla(this.aveF.tablaAdminAves);
        estiloTabla.dimensioncols(aveF.tablaAdminAves);

    }

    private void cargarInfoItems() {// carga dlista de Aves que se pueden los pone en los combobox
        //   comboUniMedida.removeAllItems();
        // comboUniMedida.addItem("Seleccionar");      
        aveM = new AveModel();
        String[] nombresAves = aveM.cargarInfoItems();
        for (String nombresAve : nombresAves) {
            aveF.comboNombre.addItem(nombresAve);
        }
    }

    private void consultarAves(String buscar) { //para consultarAves registros de la tabla galpon
        // DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        try {
            DefaultTableModel modelo;
            AveModel aveModel = new AveModel();
            modelo = aveModel.consultarAves(buscar);
            aveF.tablaAdminAves.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    // cierre de metodo consultarAves

    private void habilitarcampos() {
        aveF.lblidAve.setEnabled(true);
        aveF.txtNombreAve.setEnabled(true);
        aveF.txtDescripcion.setEnabled(true);
        aveF.comboNombre.setEnabled(true);
    }

    private void deshabilitarCampos() {
        aveF.lblidAve.setEnabled(false);
        aveF.txtNombreAve.setEnabled(false);
        aveF.txtDescripcion.setEnabled(false);
        aveF.comboNombre.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* ----------  boton Nuevo -------- */
        if (e.getSource() == aveF.btnNuevo) {
            if (aveF.btnNuevo.getText().equals("Nuevo")) {
                habilitarcampos();
                aveF.lblidAve.setText("");
                aveF.txtNombreAve.setText("");
                aveF.btnNuevo.setLabel("Guardar");
                aveF.btnNuevo.setIcon(new ImageIcon("src/Archivos/saveverde32px.png"));
                aveF.btnEditar.setLabel("Cancelar");
                aveF.btnEditar.setIcon(new ImageIcon("src/Archivos/cancelverde32px.png"));
                aveF.btnEditar.setEnabled(true);
                aveF.btnEliminar.setEnabled(false);
                aveF.txtNombreAve.requestFocus();
                return;
            }
            AveDto datos = new AveDto();
            AveModel func = new AveModel();

            if (aveF.btnNuevo.getText().equals("Guardar")) {

                if (aveF.txtNombreAve.getText().equals("")) {
                    JOptionPane.showMessageDialog(aveF, "Ingrese un Nombre para el tipo de Ave");
                    aveF.txtNombreAve.requestFocus();
                    return;
                }
                datos.setNombre(aveF.txtNombreAve.getText());
                //insertar();

                if (func.insertar(datos)) {
                    JOptionPane.showMessageDialog(aveF, "Tipo de ave registrado Correctamente");
                    consultarAves("");
                    deshabilitarCampos();
                }
                aveF.btnNuevo.setText("Nuevo");
                aveF.btnEditar.setEnabled(false);
                aveF.btnEliminar.setEnabled(false);
                aveF.btnEditar.setText("Editar");
                return;
            }// cierre Guardar

            if (aveF.btnNuevo.getText().equals("Actualizar")) {
                datos.setIdAve(Integer.parseInt(aveF.lblidAve.getText()));
                if (func.editar(datos)) {
                    JOptionPane.showMessageDialog(aveF, "El Ave fue Editada satisfactoriamente");
                    //mostrar("");
                    //inhabilitar();
                }
                //editar(txtIdAve.getText());
                //postsql.cierraConexion();
                consultarAves("");
                aveF.btnNuevo.setText("Nuevo");
                aveF.btnEditar.setEnabled(false);
                aveF.btnEliminar.setEnabled(false);
                deshabilitarCampos();
                aveF.btnEditar.setText("Editar");

            }
        }
        /* ----------  boton editar -------- */
        if (e.getSource() == aveF.btnEditar) {
            if (aveF.btnEditar.getLabel().equals("Cancelar")) {
                deshabilitarCampos();
                aveF.btnNuevo.setLabel("Nuevo");
                aveF.btnNuevo.setIcon(new ImageIcon("src/Archivos/addverde32px.png"));
                aveF.btnEditar.setLabel("Editar");
                aveF.btnEditar.setIcon(new ImageIcon("src/Archivos/Editverde32px.png"));
                aveF.btnEliminar.setEnabled(false);
                aveF.btnEditar.setEnabled(false);
                aveF.txtNombreAve.setText("");

            } else {
                habilitarcampos();
                aveF.btnNuevo.setLabel("Actualizar");
                aveF.btnEditar.setLabel("Cancelar");
                aveF.btnEliminar.setEnabled(false);
                aveF.lblidAve.setEnabled(false);
                aveF.btnEditar.setEnabled(true);
                aveF.txtNombreAve.requestFocus();
            }
        }
        /* ----------  boton eliminar -------- */
        if (e.getSource() == aveF.btnEliminar) {

            EliminarDialog advertencia = new EliminarDialog(new JFrame(), true);
            advertencia.lblTitulo.setText("ELIMINAR TIPO DE AVE");
            advertencia.AtxtAdvertencia.setText("Si elimina el AVE, la información correspondiente a"
                    + "\n Ventas, Gastos, Producción y Estadísticas será  afectada.");
            advertencia.lblmsgConfirmar.setText("¿ Confirma que desea ELIMINAR el AVE ?  ");
            advertencia.setVisible(true);

            if (EliminarDialog.respuesta.equals("eliminar")) {
                if (!aveF.lblidAve.getText().equals("")) {//confirma  si esta seleccionado un registro
                    AveModel aveM = new AveModel();
                    AveDto aveDto = new AveDto();
                    aveDto.setIdAve(Integer.parseInt(aveF.lblidAve.getText()));
                    if (aveM.eliminar(aveDto)) {
                        JOptionPane.showMessageDialog(aveF, "Ave Eliminada Correctamente");
                    }
                    //eliminar(Integer.parseInt(txtIdAve.getText()));
                    consultarAves("");
                    deshabilitarCampos();

                } else {
                    JOptionPane.showMessageDialog(aveF, "No seleccionó ningun Registro");
                }
            }
        }
    }

    /* ----------  eventos   -------- */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == aveF.txtNombreAve) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) || c == e.VK_DELETE || c == e.VK_SPACE) {
                e.consume();
                aveF.getToolkit().beep();
                //JOptionPane.showMessageDialog(null, "ingresa solo numeros");
            }

            if (Character.isLowerCase(c)) {
                String mayus = ("" + c).toUpperCase();
                c = mayus.charAt(0);
                e.setKeyChar(c);
            }

            if (aveF.txtNombreAve.getText().length() == 25) {//para que el maximo de caracteres ingresados sea 25
                e.consume();
                aveF.getToolkit().beep();
            }
        }

        if (e.getSource() == aveF.txtDescripcion) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) || c == e.VK_DELETE || c == e.VK_SPACE) {
                e.consume();
                aveF.getToolkit().beep();
                //JOptionPane.showMessageDialog(null, "ingresa solo numeros");
            }
            if (aveF.txtDescripcion.getText().length() == 60) {//para que el maximo de caracteres ingresados sea 25
                e.consume();
                aveF.getToolkit().beep();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == aveF.txtBuscar) {
            consultarAves(aveF.txtBuscar.getText());
           estiloTabla.dimensioncols(aveF.tablaAdminAves);
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getSource() == aveF.tablaAdminAves) {
            int filaSel = aveF.tablaAdminAves.rowAtPoint(e.getPoint());

            aveF.lblidAve.setText(aveF.tablaAdminAves.getValueAt(filaSel, 0).toString());
            aveF.txtNombreAve.setText(aveF.tablaAdminAves.getValueAt(filaSel, 1).toString());
            // comboNombre.setSelectedItem(tablaAdminAves.getValueAt(filaSel, 1).toString());
//       if(tablaAdminAves.getValueAt(filaSel, 2).toString()==""){
//           System.out.println("es nulo");
//           //txtDescripcion.setText(tablaAdminAves.getValueAt(filaSel, 2).toString());
//       }
            aveF.btnEditar.setEnabled(true);
            aveF.btnEliminar.setEnabled(true);
            aveF.txtNombreAve.requestFocus();
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == aveF.comboNombre) {
            String seleccionado = (String) aveF.comboNombre.getSelectedItem();
            if (seleccionado.equals("Otro")) {
                aveF.txtNombreAve.setText("");
                aveF.txtNombreAve.setEnabled(true);
            } else {
                if (seleccionado.equals("Seleccionar")) {
                    aveF.txtNombreAve.setText("");
                    aveF.txtNombreAve.setEnabled(true);
                }
                aveF.txtNombreAve.setEnabled(false);
                aveF.txtNombreAve.setText(seleccionado);
            }
        }
    }

}
