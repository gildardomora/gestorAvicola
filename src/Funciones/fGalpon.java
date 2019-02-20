/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Conexion.Conexion;
import Interfaz.frmGalpon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.mEntrada;
import modelos.mSalida;

/**
 *
 * @author GIMORE
 */
public class fGalpon {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 

    public DefaultTableModel mostrarEntrada(String buscar) { //para mostrar registros de la tabla galpon

        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        String[] titulos = {"Tipo de Ave", "F. Apertura", "Saldo", "F. Entrada", "Cantidad Entrante", "Descripcion", "ID"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[7];//almacenar registros de cada uno de los titulos
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select \"nombre\",\"f_inicio\",\"hsaldo\",\"identrada\",\"fecha\",\"cantidad\",\"entrada\".\"descripcion\",\"identrada\" from \"galpon\" "
                + "inner join \"tipo_ave\" on \"galpon\".\"idave\"=\"tipo_ave\".\"idave\" inner join \"entrada\" on \"entrada\".\"idgalpon\"=\"galpon\".\"idgalpon\" where \"galpon\".\"idgalpon\" = '" + buscar + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("nombre");
                registro[1] = rs.getString("f_inicio");
                registro[2] = rs.getString("hsaldo");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("descripcion");
                registro[6] = rs.getString("identrada");
                modelo.addRow(registro);
            }

            //tablaEntrada.setModel(modelo);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        // postsql.cierraConexion();
    }    // cierre de metodo mostrarEntrada

    public DefaultTableModel mostrarSalida(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        String[] titulos = {"Tipo de Ave", "F. Apertura", "Saldo", "F. Salida", "Cantidad Saliente", "Descripcion", "ID"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[7];//almacenar registros de cada uno de los titulos
        //totalregistros=0;

        modelo = new DefaultTableModel(null, titulos);//original que funciona

        //sSQL = "select * from entrada order by identrada ";
        sSQL = "select \"nombre\",\"f_inicio\",\"hsaldo\",\"idsalida\",\"fecha\",\"cantidad\",\"salida\".\"descripcion\",\"idsalida\" from \"galpon\" "
                + "inner join \"tipo_ave\" on \"galpon\".\"idave\"=\"tipo_ave\".\"idave\" inner join \"salida\" on \"salida\".\"idgalpon\"=\"galpon\".\"idgalpon\" where \"galpon\".\"idgalpon\" = '" + buscar + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("nombre");
                registro[1] = rs.getString("f_inicio");
                registro[2] = rs.getString("hsaldo");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("descripcion");
                registro[6] = rs.getString("idsalida");

                modelo.addRow(registro);

            }

            //tablaSalida.setModel(modelo);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

        // postsql.cierraConexion();
    }    // cierre de metodo mostrarSalida

    
    
   public boolean insertarEntrada(mEntrada datoEnt) {// metodo INSERTAR
        cn = postsql.conectar();
      
        //JOptionPane.showMessageDialog(rootPane, "recibi : " + galpon + tipo);

        int cantidad = 0;//para almacenar la cantidad entrante o saliente
        int saldoTotal = 0;
  

            try {
                saldoTotal = Integer.parseInt(contar(datoEnt.getIdGalpon()));//Integer.parseInt(contar(galpon));

            } catch (Exception e) {
            }
           
            String operacion = "+";
            cantidad = datoEnt.getCantidad(); //Integer.parseInt(txtCantidadEnt.getText());
            
        //JOptionPane.showMessageDialog(null, "recibi : " + cantidad);
        String a = "update \"galpon\" set \"saldo\" =" + saldoTotal + operacion + cantidad + " where \"idgalpon\" =" + datoEnt.getIdGalpon();
        // JOptionPane.showMessageDialog(null, "recibi : " + a);
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//Ajusta el formato del DateChooser

        //salida
       
        sSQL = "insert into \"entrada\" (\"fecha\",\"hsaldo\",\"cantidad\",\"descripcion\",\"idgalpon\") values (?,?,?,?," + datoEnt.getIdGalpon() + ");" + a;
try {
             PreparedStatement pst = cn.prepareStatement(sSQL);
                    pst.setString(1, datoEnt.getFecha());
                    pst.setInt(2, datoEnt.gethSaldo());

                    pst.setInt(3, datoEnt.getCantidad());
                    pst.setString(4, datoEnt.getDescripcion());

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
        //  mostrarEntrada(galpon);
        // mostrarSalida(galpon);
        //return false;
        
    }//cierre de metodo insertar

    
    public boolean insertarSalida(mSalida datoSal) {// metodo INSERTAR
        cn = postsql.conectar();
       
        //JOptionPane.showMessageDialog(rootPane, "recibi : " + galpon + tipo);

        int cantidad = 0;//para almacenar la cantidad entrante o saliente
        int saldoTotal = 0;
          
            try {
                saldoTotal = Integer.parseInt(contar(datoSal.getIdGalpon()));//Integer.parseInt(contar(galpon));

            } catch (Exception e) {
            }
          
            String operacion = "-";
            cantidad = datoSal.getCantidad();
            if (saldoTotal < cantidad) {
                JOptionPane.showMessageDialog(null, "No se puede hacer una salida mayor al Saldo total Actual ");
                //  return;
            }
        
        //JOptionPane.showMessageDialog(null, "recibi : " + cantidad);
        String a = "update galpon set saldo =" + saldoTotal + operacion + cantidad + " where idgalpon =" + datoSal.getIdGalpon();
        // JOptionPane.showMessageDialog(null, "recibi : " + a);
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//Ajusta el formato del DateChooser

        //salida
       
        sSQL = "insert into \"salida\" (\"fecha\",\"hsaldo\",\"cantidad\",\"descripcion\",\"idgalpon\") values (?,?,?,?," + datoSal.getIdGalpon() + ");" + a;

        
                try {

                    PreparedStatement pst = cn.prepareStatement(sSQL);

                    pst.setString(1, datoSal.getFecha());
                    pst.setInt(2, datoSal.gethSaldo());
                    pst.setInt(3, datoSal.getCantidad());
                      pst.setString(4,datoSal.getDescripcion());
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
        //  mostrarEntrada(galpon);
        // mostrarSalida(galpon);
        //return false;
    }//cierre de metodo insertar

    
    
       public boolean editarEntrada(mEntrada datos) {// metodo editar datos de galpon el tipo es si es salida o entrada
        //
        cn = postsql.conectar();
        //JOptionPane.showMessageDialog(rootPane, "el galpon es  : "+galpon+" y el ave es :"+ave);
        //  String a = "(select idave from entrada where nombre like '%" + id + "%')";

        int saldoTotal = 0;
        try {
            saldoTotal = Integer.parseInt(contar(datos.getIdGalpon())); //pasa el valor del total del saldo de aves en el galpon recibido y lo asigna a la variable
        } catch (SQLException ex) {
            Logger.getLogger(frmGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }

        int cantidad = 0;//para almacenar la cantidad entrante o saliente

       
           String operacion = "+";
            cantidad = datos.getCantidad();
        
              
        //JOptionPane.showMessageDialog(rootPane, "recibi : " + cantidad);
        String a = "update \"galpon\" set \"saldo\" =" + saldoTotal + operacion + cantidad + " where \"idgalpon\" =" + datos.getIdGalpon();

        sSQL = "update \"Entrada\" set \"fecha\"=?,\"hsaldo\"=?,\"cantidad\"=?,descripcion=?"
                + " WHERE idgalpon=" + datos.getIdGalpon() + "and idEntrada=" + datos.getIdEntrada() + ";" + a;

         try {

                    PreparedStatement pst = cn.prepareStatement(sSQL);
                    pst.setString(1, datos.getFecha());
                    pst.setInt(2, datos.gethSaldo());
                    pst.setInt(3, datos.getCantidad());
                    pst.setString(4, datos.getDescripcion());

                    int n = pst.executeUpdate();

                    if (n != 0) {//si n diferente de cero entonces se ingreso registros
                         return true;                
                    } else {
                         return false;
                       // JOptionPane.showMessageDialog(null, "error al realizar la actualizacion de datos");
                    }

                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(null, e);
                     return false;

                }
        
       
       
        //frmGalpon(lblNoGalpon.getText());
        
        //postsql.cierraConexion();

       // mostrarEntrada(galpon);

        //mostrarSalida(galpon);

    }

    
     public boolean editarSalida(mSalida dato) {// metodo editar datos de galpon el tipo es si es salida o entrada
        //
        cn = postsql.conectar();
      
        int saldoTotal = 0;
        try {
           saldoTotal = Integer.parseInt(contar(dato.getIdGalpon())); //pasa el valor del total del saldo de aves en el galpon recibido y lo asigna a la variable
        } catch (SQLException ex) {
           Logger.getLogger(frmGalpon.class.getName()).log(Level.SEVERE, null, ex);
        }

        int cantidad = 0;//para almacenar la cantidad entrante o saliente

           String operacion = "-";
            cantidad = dato.getCantidad();
        
       // JOptionPane.showMessageDialog(null, "recibi : " + cantidad);
        String a = "update galpon set saldo =" + saldoTotal + operacion + cantidad + " where idgalpon =" + dato.getIdGalpon();

        sSQL = "update Salida set fecha=?,hsaldo=?,cantidad=?,descripcion=?"
                + " WHERE idgalpon=" + dato.getIdGalpon() + "and idSalida =" + dato.getIdSalida() + ";" + a;

        
                try {

                    PreparedStatement pst = cn.prepareStatement(sSQL);
                    pst.setString(1, dato.getFecha());
                    pst.setInt(2, dato.gethSaldo());
                    pst.setInt(3, dato.getCantidad());
                    pst.setString(4, dato.getDescripcion());

                    int n = pst.executeUpdate();

                    if (n != 0) {//si n diferente de cero entonces se ingreso registros
                         return true;                
                    } else {
                         return false;
                       // JOptionPane.showMessageDialog(rootPane, "error al realizar la actualizacion de datos");
                    }

                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(null, e);
                      return false;

                }
        
       
        //frmGalpon(lblNoGalpon.getText());
        //cantidad = 0;
        //saldoTotal = 0;
//        postsql.cierraConexion();

       // mostrarEntrada(galpon);

        //mostrarSalida(galpon);

    }

    
    
    
    public String contar(int galpon) throws SQLException { //para contar registros de tablas

        String n = "";
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        sSQL = "select saldo from galpon where idgalpon =" + galpon;

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);
        if (rs.next()) {
            //Si hay resultados obtengo el valor. 
            n = rs.getString(1);
        }

        //  postsql.cierraConexion();
        return n;
    }    // cierre de metodo contar  

}
