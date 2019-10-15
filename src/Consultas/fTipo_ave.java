/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import java.sql.Connection;
import Modelos.mTipo_ave;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIMORE
 */
public class fTipo_ave {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 

    public fTipo_ave() {
    }

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
        String[] titulos = {"ID AVE", "NOMBRE","DESCRIPCION"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[3];//almacenar registros de cada uno de los titulos
        //totalregistros=0;
        //modelo=new DefaultTableModel(titulos, ABORT);
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        sSQL = "select * from \"tipo_ave\" where \"nombre_ave\"  like '%" + buscar + "%' order by \"id_ave\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_ave");
                registro[1] = rs.getString("nombre_ave");
                registro[2] = rs.getString("descripcion_ave");//PENDIENTE: --> ARREGLAR

                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            desconectarse();
            //tablaAdminAves.setModel(modelo);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            desconectarse();
            return null;
        }
        // postsql.cierraConexion();
    }    // cierre de metodo mostrar

    public boolean insertar(mTipo_ave dato) {
        establecerConexion();
        sSQL = "insert into \"tipo_ave\" (nombre_ave,descripcion_ave)"
                + //NumGalpon no se incluye por ser llave primaria
                "values (?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dato.getNombre());
            pst.setString(2, dato.getDescripcion());

            int n = pst.executeUpdate();
            desconectarse();
            return n != 0;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            desconectarse();
            return false;
        }

    }// cierre metodo insertar

    public boolean editar(mTipo_ave datos) {
        establecerConexion();

        sSQL = "update \"tipo_ave\" set \"nombre_ave\"=?, \"descripcion_ave\"=? "
                + " WHERE \"id_ave\"=" + datos.getIdAve();

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getDescripcion());

            int n = pst.executeUpdate();
            desconectarse();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            desconectarse();
            return false;
        }
    }//cierre editar

    public boolean eliminar(mTipo_ave datos) {
        establecerConexion();
        sSQL = "delete from \"tipo_ave\" where \"id_ave\"=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, datos.getIdAve());

            int n = pst.executeUpdate();
            desconectarse();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            desconectarse();
            return false;
        }
    }
    
    //PENDIENTE: --> establecer validaciones para verificar si ya existe el tipo de AVE en la BD..
        private void validar() {
        sSQL = "select count (*) from galpon where id_ave='1'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "obtuve : " + rs.getString(""));
                // lista.add(rs.getString("nombre"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


}
