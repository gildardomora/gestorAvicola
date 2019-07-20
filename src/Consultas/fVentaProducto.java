/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import Interfaz.frmStock;
import Interfaz.DiagVentaProductos;
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

        DefaultTableModel modelo = (DefaultTableModel) DiagVentaProductos.tablaProductos.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        sSQL = "SELECT * FROM \"producto\" where \"nombre\" like '%"+buscar+"%' order by \"idproducto\" ";

        String registro[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                
                 registro[0] = rs.getString("idproducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("unimedida");
                registro[3] = rs.getString("preciounimed");
             
                registro[4] = rs.getString("stock");
                               modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(fUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
