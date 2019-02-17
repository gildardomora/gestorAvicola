/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Conexion.Conexion;
import java.sql.Connection;
import modelos.mTipo_ave;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public DefaultTableModel mostrar(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        String[] titulos = {"ID Ave", "Nombre"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[2];//almacenar registros de cada uno de los titulos
        //totalregistros=0;
        //modelo=new DefaultTableModel(titulos, ABORT);
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        sSQL = "select * from \"tipo_ave\" where \"nombre\"  like '%" + buscar + "%' order by \"idave\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("idave");
                registro[1] = rs.getString("nombre");

                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }

            //tablaAdminAves.setModel(modelo);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        // postsql.cierraConexion();
    }    // cierre de metodo mostrar

    public boolean insertar(mTipo_ave dato) {
        cn = postsql.conectar();
        sSQL = "insert into tipo_ave (nombre)"
                + //NumGalpon no se incluye por ser llave primaria
                "values (?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
         
            pst.setString(1, dato.getNombre());

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
    
     public boolean editar (mTipo_ave datos){
        cn = postsql.conectar();
        
            sSQL = "update tipo_ave set nombre=?"
                + " WHERE idave=" + datos.getIdAve();
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, datos.getNombre());
         
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }//cierre editar
     
        public boolean eliminar (mTipo_ave datos){
             cn = postsql.conectar();
       
              sSQL = "delete from tipo_ave where idave=?";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, datos.getIdAve());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
        
        
  
}
