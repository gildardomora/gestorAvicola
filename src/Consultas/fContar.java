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

/**
 *
 * @author GIMORE
 */
public class fContar {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    private String sSQL = "";//para almacenar cadena de conexion 
    public Integer totalRegistros; // Obtener los registros
    
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

    public int Contar(String campo, String dato, String tabla) {
       establecerConexion();
        sSQL = "select count(*) AS cantidad from \"" + tabla + "\" where  \"" + campo + "\" ='" + dato + "'";

        try {
            int cantidad = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }

            return cantidad;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }//cierre metodo
    
       public int existencia(String campo ,String tabla) {
       establecerConexion();

        sSQL = "select Count(\""+campo+"\") AS cantidad from " + tabla;

        try {
            int cantidad = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }

            return cantidad;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }//cierre metodo
       public int Contabilizar(String consulta) {
       establecerConexion();

        sSQL = "select sum(\"stock\") AS cantidad from " + consulta;

        try {
            int cantidad = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }

            return cantidad;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }//cierre metodo

}
