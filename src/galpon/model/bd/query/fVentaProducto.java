/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.model.bd.query;

import galpon.bd.conection.Conexion;
import galpon.ui.productos.ProductoStockForm;
import galpon.ui.ventas.VentaProductosDialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIMORE
 */
public class fVentaProducto {

    public static Conexion postsql = new Conexion();
    public static Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    public static String sSQL = "";//para almacenar cadena de conexion 

    public static void listar(String buscar) {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
        DefaultTableModel modelo = (DefaultTableModel) VentaProductosDialog.tablaProductos.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        sSQL = "SELECT * FROM \"producto\" "
                + "inner join stock_producto on producto.id_stock_producto = stock_producto.id_stock_producto "
                + "where \"nombre_producto\" like '%" + buscar + "%' "
                + "order by \"id_producto\" ";

        String registro[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id_producto");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("uni_medida_producto");
                registro[3] = rs.getString("precio_uni_producto");
                registro[4] = rs.getString("categoria_producto");
                registro[5] = rs.getString("cantidad_stock");
                modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
