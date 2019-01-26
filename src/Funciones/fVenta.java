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
import modelos.mVenta;

/**
 *
 * @author GIMORE
 */
public class fVenta {
    
     private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    // private Connection cn = postsql.conectar();
    private String sSQL = "";//para almacenar cadena de conexion 
    
       public DefaultTableModel mostrar(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        String[] titulos = {"ID Venta", "Producto", "Cantidad", "Fecha", "Uni. Medida", "Precio Uni. Med.", "Descripcion", "Total"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[8];//almacenar registros de cada uno de los titulos

        modelo = new DefaultTableModel(null, titulos);//original que funciona

        // sSQL = "select * from venta order by idventa ";
        sSQL = "select \"detalle_venta\".\"idventa\",\"venta\".\"descripcion\", \"nombre\",\"cantidad\",\"fecha\",\"unimedida\",\"preciounimed\",\"valorventa\" from \"detalle_venta\" "
                + "inner join \"producto\" on \"detalle_venta\".\"idproducto\"=\"producto\".\"idproducto\" inner join \"venta\" on \"detalle_venta\".\"idventa\"=\"venta\".\"idventa\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("fecha");
                registro[4] = rs.getString("unimedida");
                registro[5] = rs.getString("preciounimed");
                registro[6] = rs.getString("descripcion");
                registro[7] = rs.getString("valorventa");
                modelo.addRow(registro);

            }

            //tablaVentas.setModel(modelo);
             return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
             return null;
        }
        //postsql.cierraConexion();
    }    // cierre de metodo mostrar
       
          public boolean insertar(mVenta dato,String producto) {// metodo INSERTAR
        cn = postsql.conectar();
        String a = "(select sum (preciounimed *" + dato.getCantidad() + ") from producto where nombre like '%" + producto + "%')";
        String b = "(select idproducto from producto where nombre like '%" + producto + "%')";
        //String c = "(select idproducto from producto where nombre like '%" + producto + "%')";
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//Ajusta el formato del DateChooser
        //String fechaInicio = (txtFechaApe.getText());

        
        sSQL = "insert into venta (cantidad,descripcion,valorventa,fecha)"
                + //NumGalpon no se incluye por ser llave primaria
                "values (?,?," + a + ",?) ; insert into detalle_venta (idproducto) values (" + b + ")";

        // insert into detalle_venta (iddetalle,idproducto,idventa) values ('03',(select idproducto from producto where nombre like '%Huevo%'),'7')
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            // pst.setInt(1, Integer.parseInt(txtIdVenta.getText()));

            pst.setInt(1, dato.getCantidad());
            pst.setString(2, dato.getDescripcion());
            pst.setString(3, dato.getFecha());

            int n = pst.executeUpdate();

            if (n != 0) {//si n diferente de cero entonces se ingreso registros
                return true;                
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al Guardar los Datos");
                //si ocurre un error entonces envia el mensaje de error
                 return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
             return false;

        }
       // postsql.cierraConexion();
        //mostrar(""); //cargar la tabla galpon nuevamente para ver los cambios
    }//cierre de metodo insertar


             public boolean editar(mVenta dato, String producto) {// metodo editar datos de galpon
        //
        cn = postsql.conectar();
        //JOptionPane.showMessageDialog(rootPane, "el galpon es  : "+galpon+" y el ave es :"+ave);
        

        String a = "(select idproducto from producto where nombre like '%" + producto + "%')";
        sSQL = "update venta set cantidad=?,fecha=?,descripcion=?"
                + " WHERE idventa=" + dato.getIdVenta() + "; update detalle_venta set idproducto=" + a;

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dato.getCantidad());
            pst.setString(2,dato.getFecha());
            pst.setString(3, dato.getDescripcion());

            int n = pst.executeUpdate();

            if (n != 0) {//si n diferente de cero entonces se ingreso registros
                 return true;                
            } else {
                 return false;
                //JOptionPane.showMessageDialog(rootPane, "error al realizar la actualizacion de datos");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
              return false;

        }
       

    }//cierre de metodo editar


}
