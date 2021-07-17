/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.controller;

import galpon.model.bd.query.ProductoModel;
import galpon.model.dto.mProducto;
import galpon.ui.principal.EliminarDialog;
import galpon.ui.principal.InicioForm;
import galpon.ui.productos.ProductoStockForm;
import galpon.ui.productos.ProductosForm;
import galpon.ui.styles.estiloTabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIMORE
 */
public class ProductoController implements ActionListener, MouseListener {

    private ProductosForm productosF;
    public static String accion = "";
    public static String[] datostabla = {"", "", "", "", "", "", ""}; //vector para almacenar la informacion de la tabla

    public ProductoController(ProductosForm productosF) {
        this.productosF = productosF;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.productosF.getUI()).setNorthPane(null);
        productosF.contenedorTabla.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        estiloTabla diseño = new estiloTabla();
        diseño.tabla(productosF.tablaProducto);
        consultarProductos("");
        this.productosF.btnNuevo.addActionListener(this);
        this.productosF.btnEditar.addActionListener(this);
        this.productosF.btnEliminar.addActionListener(this);

    }

    public void consultarProductos(String buscar) { //para consultarProductos registros de la tabla galpon
        //DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente

        try {
            DefaultTableModel modelo;
            ProductoModel func = new ProductoModel();
            modelo = func.mostrar(buscar);
            productosF.tablaProducto.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        estiloTabla.dimensioncols(productosF.tablaProducto);
    }    // cierre de metodo

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productosF.btnNuevo) {
            accion = "nuevo";
            new galpon.ui.productos.ProductoDialog(new JFrame(), true).setVisible(true);
        }
        if (e.getSource() == productosF.btnEditar) {
            accion = "editar";
            new galpon.ui.productos.ProductoDialog(new JFrame(), true).setVisible(true);
        }
        if (e.getSource() == productosF.btnEliminar) {
            EliminarDialog advertencia = new EliminarDialog(new JFrame(), true);
            advertencia.lblTitulo.setText("ELIMINAR PRODUCTO");
            advertencia.AtxtAdvertencia.setText("Si elimina el PRODUCTO, la información correspondiente a"
                    + "\n Ventas, Gastos, Producción y Estadísticas será  afectada.");
            advertencia.lblmsgConfirmar.setText("¿ Confirma que desea ELIMINAR el PRODUCTO ?  ");
            advertencia.setVisible(true);

            if (EliminarDialog.respuesta.equals("eliminar")) {
                if (!productosF.lblidProducto.getText().equals("ID")) {//confirma  si esta seleccionado un registro
                    ProductoModel productoM = new ProductoModel();
                    mProducto datos = new mProducto();
                    datos.setIdProducto(Integer.parseInt(productosF.lblidProducto.getText()));
                    // int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Desea eliminar el producto?", "confirmar", 2);

                    if (productoM.eliminar(datos)) {
                        JOptionPane.showMessageDialog(productosF, "Producto Eliminado Correctamente");
                    }
                    //eliminar(Integer.parseInt(txtIdProducto.getText()));
                    // mostrar("");
                    // postsql.cierraConexion();
                } else {
                    JOptionPane.showMessageDialog(productosF, "No seleccionó ningun Registro");
                }
            }
        }
        if (e.getSource() == productosF.btnStockProductos) {
            ProductoStockForm form = new ProductoStockForm();
            int ancho = InicioForm.escritorio.getWidth();
            int altura = InicioForm.escritorio.getHeight();
            form.setSize(ancho, altura);
            InicioForm.escritorio.add(form);
            form.show();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == productosF.tablaProducto) {
            productosF.btnEditar.setEnabled(true);
            productosF.btnEliminar.setEnabled(true);
            int filaSel = productosF.tablaProducto.rowAtPoint(e.getPoint());

            datostabla[0] = productosF.tablaProducto.getValueAt(filaSel, 0).toString();//idproducto
            datostabla[1] = productosF.tablaProducto.getValueAt(filaSel, 1).toString();//nombre
            datostabla[2] = productosF.tablaProducto.getValueAt(filaSel, 2).toString();//unidad de medida
            datostabla[3] = productosF.tablaProducto.getValueAt(filaSel, 3).toString();//descripcion
            datostabla[4] = productosF.tablaProducto.getValueAt(filaSel, 4).toString();//precio unidad de medida
            datostabla[5] = productosF.tablaProducto.getValueAt(filaSel, 5).toString();//precio unidad de medida
            datostabla[4] = productosF.tablaProducto.getValueAt(filaSel, 4).toString();//precio unidad de medida  productosF.datostabla[6] = productosF.tablaProducto.getValueAt(filaSel, 6).toString();//precio unidad de medida

            productosF.lblidProducto.setText(datostabla[0]);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
