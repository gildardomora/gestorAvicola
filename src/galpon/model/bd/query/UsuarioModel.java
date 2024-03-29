/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.model.bd.query;

import galpon.bd.conection.Conexion;
import galpon.ui.usuarios.UsuariosForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import galpon.model.dto.UsuarioDto;

/**
 *
 * @author GIMORE
 */
public class UsuarioModel {

    private Conexion postsql = new Conexion();
    private Connection cn = null; //variable de conexion de sql
    private String sSQL = "";//para almacenar cadena de conexion 
    public Integer totalRegistros; // Obtener los registros

    public int ContarUsuarios() {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
        sSQL = "select count(*) AS cantidadUsuarios from \"usuario\"";

        try {
            int cantidad = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidadUsuarios");
            }
            return cantidad;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }//cierre metodo

    public int ContarAdmins() {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
        sSQL = "select count(login) AS cantidadAdmins from \"usuario\" where \"tipo_usuario\"='Administrador'";

        try {
            int cantidad = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidadAdmins");
            }
            return cantidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }//cierre metodo

    /*
     * se consulta si existe el usuario con las credenciales traidas del login
     */
    public DefaultTableModel validarSesion(String usuario, String password) { 
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
            DefaultTableModel modelo;
            /*  String[] titulos = {"COD", "NOMBRE", "DIRECCION", "TELEFONO", "EMAIL", "LOGIN", "PASS", "ESTADO", "ACCESO"};
        String[] registro = new String[9];
             */
            String[] titulos = {"ID", "LOGIN", "PASS", "ESTADO", "TIPO DE USUARIO"};
            String[] registro = new String[5];
            totalRegistros = 0;
            modelo = new DefaultTableModel(null, titulos);

            /* sSQL = "select p.cod_persona , p.nombre_persona , p.direccion ,"
                + "p.telefono , p.email , u.login , u.password , u.estado ,"
                + "u.acceso from persona p inner join usuario "
                + " u on p.cod_persona = u.cod_usuario where u.login ='" + usuario + "' "
                + " and u.password ='" + password + "' and estado = 'Activo'";
             */
            sSQL = "select * from \"usuario\" where \"login\"='" + usuario + "' and \"password\" ='" + password + "'";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);

                while (rs.next()) {
                    registro[0] = rs.getString("cod_usuario");
                    registro[1] = rs.getString("login");
                    registro[2] = rs.getString("password");
                    registro[3] = rs.getString("estado_usuario");
                    registro[4] = rs.getString("tipo_usuario");
                    totalRegistros = totalRegistros + 1;
                    modelo.addRow(registro);
                }
                return modelo;

            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);
                return null;
        }
    }//cierre metodo validarSesion

    public DefaultTableModel mostrarUsuario(String buscar) {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        DefaultTableModel modelo;
        String[] titulos = {"ID", "LOGIN", "PASS", "ESTADO", "TIPO DE USUARIO"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);//original que funciona

        sSQL = "SELECT * FROM \"usuario\" WHERE \"login\" "
                + "LIKE '%" + buscar + "%' ORDER by \"cod_usuario\" ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("cod_usuario");
                registro[1] = rs.getString("login");
                registro[2] = rs.getString("password");
                registro[3] = rs.getString("estado_usuario");
                registro[4] = rs.getString("tipo_usuario");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }

    }//cierre metodo

    public boolean agregar(UsuarioDto dato) {
        cn = postsql.conectar();
        sSQL = "INSERT INTO \"usuario\" (\"cedula_persona\",\"login\","
                + "\"password\",\"estado_usuario\",\"tipo_usuario\") "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dato.getCedula_persona());
            pst.setString(2, dato.getLogin_usuario());
            pst.setString(3, dato.getPassword_usuario());
            pst.setString(4, dato.getEstado_usuario());
            pst.setString(5, dato.getTipo_Usuario());
            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }// cierre metodo agregar

    public void listar(String buscar) {
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL
        DefaultTableModel modelo = (DefaultTableModel) UsuariosForm.tblListaUsuarios.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        sSQL = "SELECT * FROM \"usuario\" ";
        String registro[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("cod_usuario");
                registro[1] = rs.getString("login");
                registro[2] = rs.getString("password");
                registro[3] = rs.getString("estado_usuario");
                registro[4] = rs.getString("tipo_usuario");
                modelo.addRow(registro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean eliminar(UsuarioDto datos) {
        cn = postsql.conectar();
        //sSQL = "delete from persona where cod_persona = ?";
        sSQL = "DELETE FROM \"usuario\" WHERE \"login\" = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            //PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            // pst.setInt(1, datos.getCod_persona());
            pst.setString(1, datos.getLogin_usuario());

            int N = pst.executeUpdate();
            //int N2 = pst2.executeUpdate();
            return N != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    } //cierre funcion eliminar

    public int verificar(String datos) {
        cn = postsql.conectar();
        //String login = FrmUsuario.txtLogin.getText();
        //JOptionPane.showMessageDialog(null,"recibi : " +datos);
        sSQL = "SELECT COUNT(login) AS login FROM \"usuario\" WHERE \"login\" = '" + datos + "'";

        try {
            int loginResultante = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                loginResultante = rs.getInt("login");
            }

            return loginResultante;

        } catch (Exception e) {
            return 0;
        }
        //return false;
    }

    public String tipo(String usuario) throws SQLException { //para contar registros de tablas
        String n = "";
        cn = postsql.conectar(); // asigna la cadena de conexion a la variable de conexion SQL

        // sSQL = "select * from venta order by idventa ";
        sSQL = "SELECT \"tipo_usuario\" FROM \"usuario\" WHERE \"login\"='" + usuario + "'";

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);
        if (rs.next()) {
            //Si hay resultados obtengo el valor. 
            n = rs.getString(1);
        }

        //postsql.cierraConexion();
        return n;
    }    // cierre de metodo contar  
}
