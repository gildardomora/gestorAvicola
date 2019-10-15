/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import Interfaz.frmAdminGalpon;
import Interfaz.frmInicio;
import Interfaz.frmStock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelos.mProducto;

/**
 *
 * @author GIMORE
 */
public class fProducto {

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
        String[] titulos = {"ID", "NOMBRE", "UNI. MEDIDA", "DESCRIPCION", "PRECIO UNI. MEDIDA", "ID STOCK", "CATEGORIA"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[7];//almacenar registros de cada uno de los titulos
        //totalregistros=0;
        //modelo=new DefaultTableModel(titulos, ABORT);
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        sSQL = "select * from \"producto\" where \"nombre_producto\" like '%" + buscar + "%' order by \"id_producto\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_producto");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("uni_medida_producto");
                registro[3] = rs.getString("descripcion_producto");
                registro[4] = rs.getString("precio_uni_producto");
                registro[5] = rs.getString("id_stock_producto");
                registro[6] = rs.getString("categoria_producto");

                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }
            desconectarse();
            //tablaProducto.setModel(modelo);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }    // cierre de metodo

    public DefaultTableModel stock(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        establecerConexion();

        String[] titulos = {"ID ", "NOMBRE", "STOCK"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[3];//almacenar registros de cada uno de los titulos
        //totalregistros=0;
        //modelo=new DefaultTableModel(titulos, ABORT);
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        sSQL = "select * from \"producto\" inner join \"stock_producto\" on \"stock_producto\".\"id_stock_producto\"=\"producto\".\"id_stock_producto\" where \"nombre_producto\" like '%" + buscar + "%' order by \"id_producto\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_producto");
                registro[1] = rs.getString("nombre_producto");
                //  registro[2] = rs.getString("unimedida");
                //   registro[3] = rs.getString("descripcion");
                // registro[4] = rs.getString("preciounimed");
                registro[2] = rs.getString("cantidad_stock");

                //  totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }
            desconectarse();
            //tablaProducto.setModel(modelo);
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }    // cierre de metodo

    public boolean insertar(mProducto dato) {// metodo INSERTAR
        establecerConexion();
        sSQL
                = "insert into \"stock_producto\"  (\"cantidad_stock\") values ('0');"
                + "insert into \"producto\" (\"nombre_producto\",\"uni_medida_producto\",\"descripcion_producto\",\"precio_uni_producto\",\"categoria_producto\")"
                + "values (?,?,?,?,?);";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            //pst.setInt(1, dato.getIdProducto());

            pst.setString(1, dato.getNombre());
            pst.setString(2, dato.getUniMedida());
            pst.setString(3, dato.getDescripcion());
            pst.setInt(4, dato.getPrecioUniMed());
            pst.setString(5, dato.getCategoria());
            //   pst.setInt(5, 0);//inicia el stock del producto en catidad = 0

            int n = pst.executeUpdate();

            if (n != 0) {//si n diferente de cero entonces se ingreso registros
                desconectarse();
               insertarhistorial(dato);//para agregar al historial
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

    }//cierre de metodo
    
    public boolean insertarhistorial(mProducto dato) {// metodo INSERTAR
        establecerConexion();
String a="(select \"id_producto\" from \"producto\" where nombre_producto like '%" + dato.getNombre() + "%')";
JOptionPane.showMessageDialog(null, "valor de a: "+a);
        sSQL= "insert into \"stock_historial\" (id_stock_producto, fecha_modificado, nombre_usuario, cantidad_previa) values ("+a+",'"+ dato.getFecha() + "','" + frmInicio.usuarioActual + "','" + 0 + "')";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           
            int n = pst.executeUpdate();            
            
            if (n != 0) {//si n diferente de cero entonces se ingreso registros
                desconectarse();
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

    }//cierre de metodo

    public boolean editarStock(mProducto dato) {// metodo editar datos de galpon
        //
        establecerConexion();
        //JOptionPane.showMessageDialog(rootPane, "el galpon es  : "+galpon+" y el ave es :"+ave);
        String a = "(select id_stock_producto from producto where nombre_producto like '%"+dato.getNombre()+"%')";
        String b="(select cantidad_stock from stock_producto where id_stock_producto="+a+")";
        sSQL = "insert into \"stock_historial\" (id_stock_producto,fecha_modificado, nombre_usuario,cantidad_previa)"
                + " values ("+a+",'" + dato.getFecha() + "','" + frmInicio.usuarioActual + "'," + b + ");"
                + "update \"stock_producto\" set \"cantidad_stock\"=?"
                + " WHERE \"id_stock_producto\"=" + a+";";
        JOptionPane.showMessageDialog(null, a);
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            //  pst.setInt(1, Integer.parseInt(txtIdProducto.getText()));
            pst.setInt(1, dato.getStock());

            int n = pst.executeUpdate();
            desconectarse();
            return n != 0; //si n diferente de cero entonces se ingreso registros
            // JOptionPane.showMessageDialog(null, "error al realizar la actualizacion de datos");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }//cierre de metodo

    public boolean editar(mProducto dato) {// metodo editar datos de galpon
        //
        establecerConexion();

        sSQL = "update \"producto\" set \"nombre_producto\"=?,\"uni_medida_producto\"=?,\"descripcion_producto\"=?,\"precio_uni_producto\"=?"
                + " WHERE \"id_producto\"=" + dato.getIdProducto();

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dato.getNombre());
            pst.setString(2, dato.getUniMedida());
            pst.setString(3, dato.getDescripcion());
            pst.setInt(4, dato.getPrecioUniMed());
            //pst.setInt(5, dato.getStock());

            int n = pst.executeUpdate();
            desconectarse();
            return n != 0; //si n diferente de cero entonces se ingreso registros
            // JOptionPane.showMessageDialog(null, "error al realizar la actualizacion de datos");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }//cierre de metodo

    public boolean eliminar(mProducto dato) {//funcion eliminar registros de tabla galpon
        establecerConexion();
        String a = "";// para almacenar cadena de consulta
        String b = "";
        String c = "(select id_stock_producto from producto where id_producto="+dato.getIdProducto()+")";
         String d = "delete from stock_historial where id_stock_producto ="+c+";";
        String e = "delete from stock_producto where id_stock_producto ='"+c+"';";
       
        int confirmar = 0;
        int Prod = 0, Venta = 0;
        String msgProd = "", msgVenta = "";
        fContar contar = new fContar();
        //comprueba si hay producciones para ese producto
        if (contar.Contar("id_producto", Integer.toString(dato.getIdProducto()), "produccion") > 0) {
            Prod = 1;
            msgProd = "PRODUCCION";
            a = "delete from \"produccion\" where \"id_producto\"=" + dato.getIdProducto() + ";";
        }

        //comprueba si hay ventas para ese producto
        if (contar.Contar("id_producto", Integer.toString(dato.getIdProducto()), "detalle_venta") > 0) {
            Venta = 1;
            msgVenta = "VENTAS";
            b = "delete from \"detalle_venta\" where \"id_producto\"=" + dato.getIdProducto() + ";";
        }
              
        sSQL = a + b + d +"delete from \"producto\" where \"id_producto\"=? ;"+ e;
        if (Prod == 1 || Venta == 1) {
            confirmar = JOptionPane.showConfirmDialog(null, "El producto se encuentra en los "
                    + "\n registros  de " + msgProd + " , " + msgVenta
                    + "\n\n Si lo elimina, se eliminaran tambien"
                    + "\n todos los registros asociados en "
                    + "\n " + msgProd + " " + msgVenta, "confirmar", 2);
        }

        if (confirmar == 0) {
            
            try {
                 PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setInt(1, dato.getIdProducto());
                int n = pst.executeUpdate();
                desconectarse();
                return n != 0; //si n diferente de cero entonces se eliminó registros
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, ex);
                desconectarse();
                return false;
            }
                      
        }
        return false;
    }//cierre de metodo

    public int contar_stock() {
        establecerConexion();
        sSQL = "select sum(\"cantidad_stock\") as cantidad from \"stock_producto\"";
        //  + "select count(*) AS cantidad from \"" +tabla + "\" where  \""+campo+"\" ='"+ dato+"'";

        try {
            int cantidad = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
            desconectarse();
            return cantidad;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }//cierre metodo

    public void listarStock(String buscar) {
        establecerConexion();
        DefaultTableModel modelo = (DefaultTableModel) frmStock.tablaStock.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        sSQL = "SELECT * FROM \"producto\" inner join \"stock_producto\" on \"stock_producto\".\"id_stock_producto\" = \"producto\".\"id_stock_producto\" ";

        String registro[] = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id_producto");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("cantidad_stock");
                modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(fUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//

    public int cantidadProducto(mProducto dato) {
        establecerConexion();
        sSQL = "select sum(\"stock_producto\") as cantidad from \"producto\" where \"nombre_producto\"='" + dato.getNombre() + "' ";
        //  + "select count(*) AS cantidad from \"" +tabla + "\" where  \""+campo+"\" ='"+ dato+"'";

        try {
            int cantidad = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
            desconectarse();
            return cantidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }//cierre metodo

}
