/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Modelos.mPersona;

/**
 *
 * @author GIMORE
 */
public class fPersona {
        private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 

      public boolean insertar(mPersona dato) {
        cn = postsql.conectar();
        sSQL = "insert into \"persona\" (\"cedula_persona\", \"nombre_persona\",\"apellido_persona\",\"direccion\",\"celular\",\"email\",\"sexo\")"
                + //NumGalpon no se incluye por ser llave primaria
                "values (?,?,?,?,?,?,?);";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dato.getCedula_persona());
            pst.setString(2, dato.getNombre_persona());
            pst.setString(3, dato.getApellido_persona());
            pst.setString(4, dato.getDireccion());
            pst.setString(5, dato.getCelular());
            pst.setString(6, dato.getEmail());
            pst.setString(7, dato.getSexo());
           

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

        //postsql.cierraConexion();
        // mostrar(""); //cargar la tabla galpon nuevamente para ver los cambios
    }// cierre metodo insertar
  
    
}
