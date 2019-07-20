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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author GIMORE
 */
public class fCargarCombo {
    
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
       
     public   ArrayList<String> llenar_combo(String campo, String tabla) {
        ArrayList<String> lista = new ArrayList<String>();
          establecerConexion();
        sSQL = "select "+campo+" from "+ tabla;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString(campo));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

}
