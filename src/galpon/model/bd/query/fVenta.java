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
import galpon.model.dto.mVenta;

/**
 *
 * @author GIMORE
 */
public class fVenta {

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
        String[] titulos = {"ID Venta", "PRODUCTO", "CANTIDAD", "FECHA", "Uni. Medida", "Precio Uni. Med.", "Descripcion", "Total"};//vector para los titulos para las columnas del Jtable
        String[] registro = new String[8];//almacenar registros de cada uno de los titulos
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        // sSQL = "select * from venta order by idventa ";
        sSQL = "select \"detalle_venta\".\"id_venta\",\"venta\".\"descripcion_venta\", \"nombre_producto\",\"cantidad_venta\",\"fecha_venta\",\"uni_medida_producto\",\"precio_uni_producto\",\"valor_venta\" "
                + "from \"detalle_venta\" "
                + "inner join \"producto\" on \"detalle_venta\".\"id_producto\"=\"producto\".\"id_producto\" inner join \"venta\" on \"detalle_venta\".\"id_venta\"=\"venta\".\"id_venta\" "
                + "where \"nombre_producto\" like '%" + buscar + "%' or \"fecha_venta\" like '%" + buscar + "%' "
                + "order by \"id_venta\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_venta");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("cantidad_venta");
                registro[3] = rs.getString("fecha_venta");
                registro[4] = rs.getString("uni_medida_producto");
                registro[5] = rs.getString("precio_uni_producto");
                registro[6] = rs.getString("descripcion_venta");
                registro[7] = rs.getString("valor_venta");
                modelo.addRow(registro);

            }

            //tablaVentas.setModel(modelo);
            desconectarse();
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        //postsql.cierraConexion();
    }    // cierre de metodo mostrar

    public boolean insertar(mVenta dato, String producto, String usuario, String cliente) {// metodo INSERTAR
        establecerConexion();
        String a = "(select sum (\"precio_uni_producto\" *" + dato.getCantidad() + ") from \"producto\" where \"nombre_producto\" like '%" + producto + "%')";
        String b = "(select \"id_producto\" from \"producto\" where \"nombre_producto\" like '%" + producto + "%')";
        String c = null;
        if (!(cliente.isEmpty() || cliente.equals(""))) {
            c = cliente;
        }
        String d = "(select \"cod_usuario\" from \"usuario\" where \"login\"='" + usuario + "')";

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//Ajusta el formato del DateChooser
        //String fechaInicio = (txtFechaApe.getText());
        sSQL = "insert into \"venta\" (\"cantidad_venta\",\"descripcion_venta\",\"valor_venta\",\"fecha_venta\")"
                + //NumGalpon no se incluye por ser llave primaria
                "values (?,?," + a + ",?); "
                + "insert into \"detalle_venta\" (\"id_producto\",\"cod_usuario\",\"cod_cliente\") values (" + b + "," + d + "," + c + ");";

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
        establecerConexion();
        //JOptionPane.showMessageDialog(rootPane, "el galpon es  : "+galpon+" y el ave es :"+ave);

        String a = "(select \"id_producto\" from \"producto\" where \"nombre_producto\" like '%" + producto + "%')";
        sSQL = "update \"venta\" set \"cantidad_venta\"=?,\"fecha\"=?,\"descripcion_venta\"=?"
                + " WHERE \"id_venta\"=" + dato.getIdVenta() + "; update \"detalle_venta\" set \"id_producto\"=" + a;

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dato.getCantidad());
            pst.setString(2, dato.getFecha());
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
