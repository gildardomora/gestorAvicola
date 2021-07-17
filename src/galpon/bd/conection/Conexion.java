/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.bd.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;

/**
 *
 * @author GIMORE
 */
public class Conexion {

    public String db = "granja_avicola";//nombre de la base de datos
    public String url = "jdbc:postgresql://localhost:5432/" + db; // "jdbc:mysql://127.0.0.1/"+db;//direccion de coneccion
    // public String url= "jdbc:postgresql://192.168.0.103:5432/" +db; // "jdbc:mysql://127.0.0.1/"+db;//direccion de coneccion
    public String user = "postgres";//nombre de usuario
    public String pass = "postgres";//contraseña
    private Connection link = null; // inicializa link de conexion   

    public Conexion() {
    }

    public Connection conectar() {

        try {
            Class.forName("org.postgresql.Driver");//("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
            System.err.println("Conectado");
            // JOptionPane.showMessageDialog(null, "Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            // JOptionPane.showConfirmDialog(null, e);//muestra en un mensaje de confirmacion el error que se presente
            JOptionPane.showMessageDialog(null, "  NO SE PUDO ESTABLECER CONEXION CON LA BASE DE DATOS  \n "
                    + "\n          (-_-;) \n "
                    + "\n Verifique la Conexion...",
                    "ERROR DE CONEXION", JOptionPane.ERROR_MESSAGE);
          //  return null;
           System.exit(0);
        }
        return link;//regresa el link
    }

    public void cierraConexion() {
        try {
            link.close();
            System.out.println("Se desconectó de la BD");
            //JOptionPane.showMessageDialog(null, "Se desconectó de la BD");
        } catch (Exception e) {
            System.out.println("Error al desconectarse de la BD ");
            //JOptionPane.showMessageDialog(null, "Error al desconectarse de la BD");
        }
    }

}

// codigo extra para conexion en posgresql
//
//    public void establecer_conexion() {
//        if (conexion != null) {
//            return;
//        }
//        //    public String url="jdbc:mysql://127.0.0.1/"+db;//direccion de coneccion
//        String url = "jdbc:postgresql://localhost:5433/granja_avicola";
//
//        try {
//            Class.forName("org.postgresql.Driver");
//            conexion = DriverManager.getConnection(url, "postgres", "postgres");
//            if (conexion != null) {
//                JOptionPane.showMessageDialog(null, "Conectado a la base de datos");
//                System.out.println("Conexion ok");
//
//            }
//
//        } catch (Exception e) {
//            //System.out.println("Conexion paila");
//            JOptionPane.showMessageDialog(null, "Error: No se pudo Conectar a la BD");
//        }
//    }
//
//    public void cierraConexion() {
//        try {
//            conexion.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al desconectarse de la BD");
//        }
//    }
