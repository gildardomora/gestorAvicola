/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.model.bd.query;

import galpon.bd.conection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import galpon.model.dto.mProduccion;

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
        sSQL = "select \"id_produccion\",\"produccion\".\"id_galpon\",\"nombre_producto\",\"cantidad_producto\",\"fecha_produccion\" from \"produccion\""
                + " inner join \"galpon\" on \"produccion\".\"id_galpon\"=\"galpon\".\"id_galpon\" inner join \"producto\" on \"produccion\".\"id_producto\"=\"producto\".\"id_producto\"";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_produccion");
                registro[1] = rs.getString("id_galpon");
                registro[2] = rs.getString("nombre_producto");
                registro[3] = rs.getString("cantidad_producto");
                registro[4] = rs.getString("fecha_produccion");

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
        String a = "(select \"id_producto\" from \"producto\" where \"nombre_producto\" like '%" + producto + "%')";

        sSQL = "insert into \"produccion\" (\"id_galpon\",\"id_producto\",\"cantidad_producto\",\"fecha_produccion\")"
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

        String a = "(select \"id_producto\" from \"producto\" where \"nombre_producto\" like '%" + producto + "%')";
        sSQL = "update \"produccion\" set \"id_galpon\"=?,\"id_producto\"=" + a + ",\"cantidad_producto\"=?,\"fecha_produccion\"=?"
                + " WHERE \"id_produccion\"=" + dato.getIdProduccion();

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
