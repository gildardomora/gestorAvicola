/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

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
    
      public int Contar(String campo,String dato, String tabla) {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        sSQL = "select count(*) AS cantidad from \"" +tabla + "\" where  \""+campo+"\" ='"+ dato+"'";

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
