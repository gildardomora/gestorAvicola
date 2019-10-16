/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

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
import java.util.ArrayList;

/**
 *
 * @author GIMORE
 */
public class fAdminGalpon {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 

    public void establecerConexion() {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
        if (cn == null) { // confirma si no hay conexion de la BD para no proceder con las consultas..
            JOptionPane.showMessageDialog(null, " No se pueden  cargar Registros \n"
                    + " debido a un problema de Conexion a la BD. ");
        }
    }

    public void desconectarse() {
        postsql.cierraConexion();
    }

    public DefaultTableModel mostrar(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        establecerConexion();
        String[] titulos = {"# GALPON", "AVE", "FECHA APERTURA", "SALDO", "DESCRIPCION", "ESTADO"};//vector para los titulos para las columnas del Jtable
        String[] registro = new String[6];//almacenar registros de cada uno de los titulos
        //totalregistros=0;

        modelo = new DefaultTableModel(null, titulos);//original que funciona

        // sSQL = "select * from galpon order by idgalpon ";
        sSQL = "select \"id_galpon\",\"tipo_ave\".\"nombre_ave\", \"fecha_apertura\", \"saldo_galpon\", \"galpon\".\"descripcion_galpon\",\"estado_galpon\" from \"galpon\" inner join \"tipo_ave\" on \"galpon\".\"id_ave\"=\"tipo_ave\".\"id_ave\" "
                + " where \"fecha_apertura\" like '%"+buscar+"%' or \"nombre_ave\" like '%"+buscar+"%' order by \"id_galpon\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_galpon");
                registro[1] = rs.getString("nombre_ave");
                registro[2] = rs.getString("fecha_apertura");
                registro[3] = rs.getString("saldo_galpon");
                registro[4] = rs.getString("descripcion_galpon");
                registro[5] = rs.getString("estado_galpon");

                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }

            //tablaAdminGalpon.setModel(modelo);
            st.executeQuery("Select Count (*) from \"galpon\"");
            desconectarse();
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }    // cierre de metodo

    public void listar(String buscar) {
        establecerConexion();
        DefaultTableModel modelo = (DefaultTableModel) frmAdminGalpon.tablaAdminGalpon.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        sSQL = "select \"id_galpon\",\"tipo_ave\".\"nombre_ave\", \"fecha_apertura\", \"saldo_galpon\", \"galpon\".\"descripcion_galpon\",\"estado\" from \"galpon\" inner join \"tipo_ave\" on \"galpon\".\"id_ave\"=\"tipo_ave\".\"id_ave\"  where \"fecha_apertura\" like '%" + buscar + "%' order by \"id_galpon\" ";

        String registro[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id_galpon");
                registro[1] = rs.getString("nombre_ave");
                registro[2] = rs.getString("fecha_apertura");
                registro[3] = rs.getString("saldo_galpon");
                registro[4] = rs.getString("descripcion_galpon");
                registro[5] = rs.getString("estado_galpon");

                modelo.addRow(registro);
                desconectarse();
            }
        } catch (SQLException ex) {
            Logger.getLogger(fAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertar(mAdminGalpon dato, String ave) {// metodo INSERTAR
        establecerConexion();
        String a = "(select \"id_ave\" from \"tipo_ave\" where \"nombre_ave\" like '%" + ave + "%')";

        sSQL = "insert into \"galpon\" (\"id_galpon\",\"id_ave\",\"fecha_apertura\",\"saldo_galpon\",\"descripcion_galpon\",\"estado_galpon\")"
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
                desconectarse();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al Guardar los Datos");
                //si ocurre un error entonces envia el mensaje de error
                desconectarse();
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            desconectarse();
            return false;

        }
        // postsql.cierraConexion();
        // mostrar(""); //cargar la tabla galpon nuevamente para ver los cambios
    }//cierre de metodo

    public boolean editar(mAdminGalpon datos, String ave) {// metodo editar datos de galpon
        //
        establecerConexion();
        String a = "(select \"id_ave\" from \"tipo_ave\" where \"nombre_ave\" like '%" + ave + "%')";
        sSQL = "update \"galpon\" set \"id_ave\"=" + a + ",\"fecha_apertura\"=?,\"saldo_galpon\"=?,\"descripcion_galpon\"=?,\"estado_galpon\"=?"
                + " WHERE \"id_galpon\"=" + datos.getIdGalpon();

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, datos.getfInicio());
            pst.setInt(2, datos.getSaldo());
            pst.setString(3, datos.getDescripcion());
            pst.setString(4, datos.getEstado());

            int n = pst.executeUpdate();
            desconectarse();
            return n != 0; //si n diferente de cero entonces se ingreso registros
            //  JOptionPane.showMessageDialog(rootPane, "error al realizar la actualizacion de datos");

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }//cierre de metodo editar

    public boolean eliminar(mAdminGalpon dato) {//funcion eliminar registros de tabla galpon

       establecerConexion();
        String a = "";
        String b = "";
        String c = "";
        try {//comprueba si hay entradas para ese galpon
            if (contar("entrada") > 0) {
                a = "delete from \"entrada\" where \"id_galpon\"=" + dato.getIdGalpon() + ";";
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { //comprueba si hay salidas para ese galpon
            if (contar("salida") > 0) {
                b = "delete from \"salida\" where \"id_galpon\"=" + dato.getIdGalpon() + ";";
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { //comprueba si hay produccion para ese galpon
            if (contar("produccion") > 0) {
                c = "delete from \"produccion\" where \"id_galpon\"=" + dato.getIdGalpon() + ";";
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdminGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }
        sSQL = a + b + c + "delete from \"galpon\" where \"id_galpon\"=?";

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
        establecerConexion();
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

    public ArrayList<String> llenar_comboAve() {//metodo para cargar el contenido en el combobox
        ArrayList<String> lista = new ArrayList<String>();
        establecerConexion();
        sSQL = "select nombre_ave from tipo_ave";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("nombre_ave"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        desconectarse();
        return lista;
    }

}
