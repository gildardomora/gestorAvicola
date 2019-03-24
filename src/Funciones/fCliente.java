/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.mCliente;
import modelos.mPersona;

/**
 *
 * @author GIMORE
 */
public class fCliente {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 

    public DefaultTableModel mostrar(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        String[] titulos = {"ID","Nombres", "Apellidos", "Cedulas", "Direccion", "Celular", "Email", "Sexo"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[8];//almacenar registros de cada uno de los titulos
        //totalregistros=0;
        //modelo=new DefaultTableModel(titulos, ABORT);
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        sSQL = "select \"cod_cliente\", \"persona\".\"nombre_persona\",\"persona\".\"apellido_persona\",\"persona\".\"cedula_persona\",\"direccion\",\"celular\",\"email\",\"sexo\" from \"cliente\" "
                + "inner join \"persona\" on \"cliente\".\"cedula_persona\" =\"persona\".\"cedula_persona\" where \"nombre_persona\"  like '%" + buscar + "%' order by \"cod_cliente\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
             
                registro[0] = rs.getString("cod_cliente");
                registro[1] = rs.getString("nombre_persona");
                registro[2] = rs.getString("apellido_persona");
                registro[3] = rs.getString("cedula_persona");

                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("celular");
                registro[6] = rs.getString("email");
                registro[7] = rs.getString("sexo");

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

    public boolean insertar(mCliente dato) {
        cn = postsql.conectar();
        sSQL = "insert into \"cliente\" (\"cedula_persona\") values(?) ";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dato.getCedula_persona());
          
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
      public boolean editar (mPersona datos,String id){
        cn = postsql.conectar();
        
            sSQL = "update \"persona\" set \"nombre_persona\"=?, \"apellido_persona\"=?, \"cedula_persona\"="+datos.getCedula_persona() +",\"direccion\"=?, \"celular\"=?,"
                + " \"email\"=?, \"sexo\"=? WHERE \"cedula_persona\"=" + id;
               
       try {

           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, datos.getNombre_persona());
           pst.setString(2, datos.getApellido_persona());
           pst.setString(3, datos.getDireccion());
           pst.setString(4, datos.getCelular());
           pst.setString(5, datos.getEmail());
           pst.setString(6, datos.getSexo());
         
           
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
     
      
        public boolean eliminar (mPersona datos){
             cn = postsql.conectar();
       
              sSQL = "delete from \"cliente\" where \"cedula_persona\"=?";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setString(1, datos.getCedula_persona());
           
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
