/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelos.mProduccion;

/**
 *
 * @author GIMORE
 */
public class fProduccion {

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

        String[] titulos = {"ID Produccion", "Galpon", "Producto", "Cantidad", "Fecha"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[5];//almacenar registros de cada uno de los titulos
        //totalregistros=0;
        //modelo=new DefaultTableModel(titulos, ABORT);
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        // sSQL = "select * from produccion order by idproduccion ";
        sSQL = "select \"idproduccion\",\"produccion\".\"idgalpon\",\"nombre\",\"cantidad\",\"fecha\" from \"produccion\""
                + " inner join \"galpon\" on \"produccion\".\"idgalpon\"=\"galpon\".\"idgalpon\" inner join \"producto\" on \"produccion\".\"idproducto\"=\"producto\".\"idproducto\"";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("idproduccion");
                registro[1] = rs.getString("idgalpon");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("cantidad");
                registro[4] = rs.getString("fecha");

                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }
            desconectarse();
            // tablaProduccion.setModel(modelo);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        //postsql.cierraConexion();
    }    // cierre de metodo

    public boolean insertar(mProduccion dato, String producto) {// metodo INSERTAR
        establecerConexion();
        String a = "(select \"idproducto\" from \"producto\" where \"nombre\" like '%" + producto + "%')";

        sSQL = "insert into \"produccion\" (\"idgalpon\",\"idproducto\",\"cantidad\",\"fecha\")"
                + "values (" + dato.getIdGalpon() + "," + a + ",?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            // pst.setInt(1, Integer.parseInt(txtIdProduccion.getText()));
//            pst.setString(2, comboGalpon.getSelectedItem().toString());
            pst.setInt(1, dato.getCantidad());
            pst.setString(2, dato.getFecha());

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

    }//cierre de metodo

    public boolean editar(mProduccion dato, String producto) {// metodo editar datos de galpon
        //
      establecerConexion();
        //JOptionPane.showMessageDialog(rootPane, "el galpon es  : "+galpon+" y el ave es :"+ave);

        String a = "(select \"idproducto\" from \"producto\" where \"nombre\" like '%" + producto + "%')";
        sSQL = "update \"produccion\" set \"idgalpon\"=?,\"idproducto\"=" + a + ",\"cantidad\"=?,\"fecha\"=?"
                + " WHERE \"idproduccion\"=" + dato.getIdProduccion();

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dato.getIdGalpon());
            pst.setInt(2, dato.getCantidad());
            pst.setString(3, dato.getFecha());

            int n = pst.executeUpdate();
          return n != 0; //si n diferente de cero entonces se ingreso registros
          //JOptionPane.showMessageDialog(rootPane, "error al realizar la actualizacion de datos");

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }

    }// cierre metodo editar

}
