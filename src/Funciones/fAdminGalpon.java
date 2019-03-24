/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Conexion.Conexion;
import Interfaz.frmAdminGalpon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.mAdminGalpon;

/**
 *
 * @author GIMORE
 */
public class fAdminGalpon {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 

    public DefaultTableModel mostrar(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        String[] titulos = {"Num Galpon", "Ave", "Fecha Apertura", "Saldo", "Descripcion", "Estado"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[6];//almacenar registros de cada uno de los titulos
        //totalregistros=0;

        modelo = new DefaultTableModel(null, titulos);//original que funciona

        // sSQL = "select * from galpon order by idgalpon ";
        sSQL = "select \"idgalpon\",\"tipo_ave\".\"nombre\", \"f_inicio\", \"saldo\", \"descripcion\",\"estado\" from \"galpon\" inner join \"tipo_ave\" on \"galpon\".\"idave\"=\"tipo_ave\".\"idave\"  "
                + "where \"f_inicio\" like '%" + buscar + "%' or \"nombre\" like '%"+buscar+"%' order by \"idgalpon\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("idgalpon");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("f_inicio");
                registro[3] = rs.getString("saldo");
                registro[4] = rs.getString("descripcion");
                registro[5] = rs.getString("estado");

                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }

            //tablaAdminGalpon.setModel(modelo);
            st.executeQuery("Select Count (*) from \"galpon\"");

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        //postsql.cierraConexion();
    }    // cierre de metodo
    
        public  void listar(String buscar) {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

          DefaultTableModel modelo = (DefaultTableModel) frmAdminGalpon.tablaAdminGalpon.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
               
            sSQL =   sSQL = "select \"idgalpon\",\"tipo_ave\".\"nombre\", \"f_inicio\", \"saldo\", \"descripcion\",\"estado\" from \"galpon\" inner join \"tipo_ave\" on \"galpon\".\"idave\"=\"tipo_ave\".\"idave\"  where \"f_inicio\" like '%" + buscar + "%' order by \"idgalpon\" ";
       
       
        String registro[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idgalpon");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("f_inicio");
                registro[3] = rs.getString("saldo");
                registro[4] = rs.getString("descripcion");
                registro[5] = rs.getString("estado");


                modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(fAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public boolean insertar(mAdminGalpon dato, String ave) {// metodo INSERTAR
        cn = postsql.conectar();
        String a = "(select \"idave\" from \"tipo_ave\" where \"nombre\" like '%" + ave + "%')";

        sSQL = "insert into \"galpon\" (\"idgalpon\",\"idave\",\"f_inicio\",\"saldo\",\"descripcion\",\"estado\")"
                + //NumGalpon no se incluye por ser llave primaria
                "values (?," + a + ",?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dato.getIdGalpon());

            pst.setString(2, dato.getfInicio());
            pst.setInt(3, dato.getSaldo());
            pst.setString(4, dato.getDescripcion());
            pst.setString(5, dato.getEstado());

            int n = pst.executeUpdate();

            if (n != 0) {//si n diferente de cero entonces se ingreso registros
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al Guardar los Datos");
                //si ocurre un error entonces envia el mensaje de error
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }
        // postsql.cierraConexion();
        // mostrar(""); //cargar la tabla galpon nuevamente para ver los cambios
    }//cierre de metodo

    public boolean editar(mAdminGalpon datos, String ave) {// metodo editar datos de galpon
        //
        cn = postsql.conectar();

        String a = "(select \"idave\" from \"tipo_ave\" where \"nombre\" like '%" + ave + "%')";
        sSQL = "update \"galpon\" set \"idave\"=" + a + ",\"f_inicio\"=?,\"saldo\"=?,\"descripcion\"=?,\"estado\"=?"
                + " WHERE \"idgalpon\"=" + datos.getIdGalpon();

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, datos.getfInicio());
            pst.setInt(2, datos.getSaldo());
            pst.setString(3, datos.getDescripcion());
            pst.setString(4, datos.getEstado());

            int n = pst.executeUpdate();

            if (n != 0) {//si n diferente de cero entonces se ingreso registros
                return true;
            } else {
                return false;
                //  JOptionPane.showMessageDialog(rootPane, "error al realizar la actualizacion de datos");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }
        //postsql.cierraConexion();
        //mostrar("");

    }//cierre de metodo editar

    public boolean eliminar(mAdminGalpon dato) {//funcion eliminar registros de tabla galpon

        cn = postsql.conectar();
        String a = "";
        String b = "";
        String c = "";
        try {//comprueba si hay entradas para ese galpon
            if (contar("entrada") > 0) {
                a = "delete from \"entrada\" where \"idgalpon\"=" + dato.getIdGalpon() + ";";
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { //comprueba si hay salidas para ese galpon
            if (contar("salida") > 0) {
                b = "delete from \"salida\" where \"idgalpon\"=" + dato.getIdGalpon() + ";";
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { //comprueba si hay produccion para ese galpon
            if (contar("produccion") > 0) {
                c = "delete from \"produccion\" where \"idgalpon\"=" + dato.getIdGalpon() + ";";
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
        sSQL = a + b + c + "delete from \"galpon\" where \"idgalpon\"=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dato.getIdGalpon());

            int n = pst.executeUpdate();

            if (n != 0) {//si n diferente de cero entonces se ingreso registros
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }
        // postsql.cierraConexion();
    }//cierre metodo eliminar

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

        //postsql.cierraConexion();
        return n;
    }    // cierre de metodo contar  

}
