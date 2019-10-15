/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIMORE
 */
public class fGastoGalpon {
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
        String[] titulos = {"ID", "GALPON", "NUM GASTOS", "FECHA APERTURA", "ESTADO","TOTAL GASTOS"};//vector para los titulos para las columnas del Jtable
        String[] registro = new String[6];//almacenar registros de cada uno de los titulos
        //totalregistros=0;

        modelo = new DefaultTableModel(null, titulos);//original que funciona

        // sSQL = "select * from galpon order by idgalpon ";
        sSQL = "select \"gasto\".\"id_gasto\",\"galpon\".\"id_galpon\",\"cantidad_gasto_galpon\", \"fecha_apertura\", \"estado_galpon\",\"total_gasto_galpon\" "
                + "from \"galpon\" inner join \"gasto_galpon\" on \"galpon\".\"id_galpon\"=\"gasto_galpon\".\"id_galpon\" "
                + "inner join \"gasto\" on \"gasto_galpon\".\"id_gasto\"=\"gasto\".\"id_gasto\"  "
                + " where \"nombre_gasto\" like '%"+buscar+"%'  order by \"id_gasto\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_gasto");
                registro[1] = rs.getString("id_galpon");
                registro[2] = rs.getString("cantidad_gasto_galpon");
                registro[3] = rs.getString("fecha_apertura");
                registro[4] = rs.getString("estado_galpon");
                registro[5] = rs.getString("total_gasto_galpon");
         
                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }

            //tablaAdminGalpon.setModel(modelo);
            st.executeQuery("Select Count (*) from \"gasto\"");
            desconectarse();
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }


}
}
