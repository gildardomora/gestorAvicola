/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.model.bd.query;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author GIMORE
 */
public class pruebas {


    public pruebas() {
    }
    
    public static void main (String args[] ){
       
        Date date = new Date();
     
        
        
           java.util.Date fecha = date;//almacena la fecha en formato Date
        long fechaP = fecha.getTime();
        java.sql.Date fechaProd = new java.sql.Date(fechaP);//establece el formato compatible con sql
        
//long fechaP = Integer.parseInt(cal.getTime());
     //   java.sql.Date fechaProd = new java.sql.Date(fechaP);//establece el formato compatible con sql

    JOptionPane.showMessageDialog(null, fechaProd);
    }
    
}
