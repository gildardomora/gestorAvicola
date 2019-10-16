package Consultas;

import Conexion.Conexion;
import Interfaz.FrmGalponEnSal;
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
import Modelos.mEntrada;
import Modelos.mSalida;

/**
 *
 * @author GIMORE
 */
public class fGalpon {

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

    public DefaultTableModel mostrarEntrada(String buscar) { //para mostrar registros de la tabla galpon

        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        establecerConexion();
        String[] titulos = {"ID", "TIPO DE AVE", "F. APERTURA.", "SALDO", "F. ENTRADA", "CANT ENTRANTE", "DESCRIPCION"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[7];//almacenar registros de cada uno de los titulos
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select \"id_entrada\",\"nombre_ave\",\"fecha_apertura\",\"saldo_aves\",\"fecha_entrada\",\"cantidad_entrada\",\"descripcion_entrada\" from \"galpon\" "
                + "inner join \"tipo_ave\" on \"galpon\".\"id_ave\"=\"tipo_ave\".\"id_ave\" inner join \"entrada\" on \"entrada\".\"id_galpon\"=\"galpon\".\"id_galpon\" where \"galpon\".\"id_galpon\" = '" + buscar + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_entrada");
                registro[1] = rs.getString("nombre_ave");
                registro[2] = rs.getString("fecha_apertura");
                registro[3] = rs.getString("saldo_aves");
                registro[4] = rs.getString("fecha_entrada");
                registro[5] = rs.getString("cantidad_entrada");
                registro[6] = rs.getString("descripcion_entrada");

                modelo.addRow(registro);
            }
            desconectarse();
            //tablaEntrada.setModel(modelo);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }    // cierre de metodo mostrarEntrada

    public DefaultTableModel mostrarSalida(String buscar) { //para mostrar registros de la tabla galpon
        DefaultTableModel modelo; //=(DefaultTableModel) tablaAdminGalpon.getModel(); // parte para obtener el modelo de tabla existente
        establecerConexion();
        String[] titulos = {"ID", "TIPO DE AVE", "F. APERTURA", "SALDO", "F. SALIDA", "CANT. SALIENTE", "DESCRIPCION"};//vector para los titulos para las columnas del Jtable

        String[] registro = new String[7];//almacenar registros de cada uno de los titulos
        //totalregistros=0;

        modelo = new DefaultTableModel(null, titulos);//original que funciona

        //sSQL = "select * from entrada order by identrada ";
        sSQL = "select \"id_salida\", \"nombre_ave\",\"fecha_apertura\",\"saldo_aves\",\"fecha_salida\",\"cantidad_salida\",\"descripcion_salida\" from \"galpon\" "
                + "inner join \"tipo_ave\" on \"galpon\".\"id_ave\"=\"tipo_ave\".\"id_ave\" inner join \"salida\" on \"salida\".\"id_galpon\"=\"galpon\".\"id_galpon\" where \"galpon\".\"id_galpon\" = '" + buscar + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {//navegacion de todos los registros
                registro[0] = rs.getString("id_salida");
                registro[1] = rs.getString("nombre_ave");
                registro[2] = rs.getString("fecha_apertura");
                registro[3] = rs.getString("saldo_galpon");
                registro[4] = rs.getString("fecha_salida");
                registro[5] = rs.getString("cantidad_salida");
                registro[6] = rs.getString("descripcion_salida");

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
            JOptionPane.showConfirmDialog(null, e);
        }

        String operacion = "+";
        cantidad = datoEnt.getCantidad(); //Integer.parseInt(txtCantidadEnt.getText());

        //JOptionPane.showMessageDialog(null, "recibi : " + cantidad);
        String a = "update \"galpon\" set \"saldo_galpon\" =" + saldoTotal + operacion + cantidad + " where \"id_galpon\" =" + datoEnt.getIdGalpon();
        // JOptionPane.showMessageDialog(null, "recibi : " + a);
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//Ajusta el formato del DateChooser

        //salida
        sSQL = "insert into \"entrada\" (\"fecha_entrada\",\"saldo_aves\",\"cantidad_entrada\",\"descripcion_entrada\",\"id_galpon\") values (?,?,?,?," + datoEnt.getIdGalpon() + ");" + a;
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, datoEnt.getFecha());
            pst.setInt(2, datoEnt.getsaldo_aves());

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
        sSQL = "insert into \"salida\" (\"fecha\",\"saldo_aves\",\"cantidad\",\"descripcion\",\"idgalpon\") values (?,?,?,?," + datoSal.getIdGalpon() + ");" + a;

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datoSal.getFecha());
            pst.setInt(2, datoSal.getsaldo_aves());
            pst.setInt(3, datoSal.getCantidad());
            pst.setString(4, datoSal.getDescripcion());
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
            Logger.getLogger(FrmGalponEnSal.class.getName()).log(Level.SEVERE, null, ex);
        }

        int cantidad = 0;//para almacenar la cantidad entrante o saliente

        String operacion = "+";
        cantidad = datos.getCantidad();

        //JOptionPane.showMessageDialog(rootPane, "recibi : " + cantidad);
        String a = "update \"galpon\" set \"saldo_galpon\" =" + saldoTotal + operacion + cantidad + " where \"id_galpon\" =" + datos.getIdGalpon();

        sSQL = "update \"entrada\" set \"fecha_entrada\"=?,\"saldo_aves\"=?,\"cantidad_entrada\"=?,\"descripcion_entrada\"=?"
                + " WHERE \"id_galpon\"=" + datos.getIdGalpon() + "and \"id_entrada\"=" + datos.getIdEntrada() + ";" + a;

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, datos.getFecha());
            pst.setInt(2, datos.getsaldo_aves());
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

    }

    public boolean editarSalida(mSalida dato) {// metodo editar datos de galpon el tipo es si es salida o entrada
        //
        cn = postsql.conectar();

        int saldoTotal = 0;
        try {
            saldoTotal = Integer.parseInt(contar(dato.getIdGalpon())); //pasa el valor del total del saldo de aves en el galpon recibido y lo asigna a la variable
        } catch (SQLException ex) {
            Logger.getLogger(FrmGalponEnSal.class.getName()).log(Level.SEVERE, null, ex);
        }

        int cantidad = 0;//para almacenar la cantidad entrante o saliente

        String operacion = "-";
        cantidad = dato.getCantidad();

        // JOptionPane.showMessageDialog(null, "recibi : " + cantidad);
        String a = "update \"galpon\" set \"saldo_aves\" =" + saldoTotal + operacion + cantidad + " where \"id_galpon\" =" + dato.getIdGalpon();

        sSQL = "update \"salida\" set \"fecha_salida\"=?,\"saldo_aves\"=?,\"cantidad_salida\"=?,\"descripcion_salida\"=?"
                + " WHERE \"id_galpon\"=" + dato.getIdGalpon() + "and \"id_salida\" =" + dato.getIdSalida() + ";" + a;

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dato.getFecha());
            pst.setInt(2, dato.getsaldo_aves());
            pst.setInt(3, dato.getCantidad());
            pst.setString(4, dato.getDescripcion());

            int n = pst.executeUpdate();

            return n != 0; //si n diferente de cero entonces se ingreso registros
            // JOptionPane.showMessageDialog(rootPane, "error al realizar la actualizacion de datos");

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }

    }

    public String contar(int galpon) throws SQLException { //para contar registros de tablas

        String n = "";
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
        sSQL = "select \"saldo_galpon\" from \"galpon\" where \"id_galpon\" =" + galpon;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);
        if (rs.next()) {
            //Si hay resultados obtengo el valor. 
            n = rs.getString(1);
        }

        return n;
    }    // cierre de metodo contar  

}
