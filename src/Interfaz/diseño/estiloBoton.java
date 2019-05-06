/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.diseño;

import javax.swing.JButton;

/**
 *
 * @author GIMORE
 */
public class estiloBoton {
        public static void botonConMouse(JButton boton){
     // boton.setBorder(new LineBorder(new java.awt.Color(255, 255, 255),2));
      boton.setBackground(new java.awt.Color(9,66,66));
      boton.setForeground(new java.awt.Color(255,255,255));     
      
  }
  
  public static void botonSinMouse(JButton boton){
   //boton.setBorder(new LineBorder(new java.awt.Color(9, 66, 66),0));
        boton.setBackground(new java.awt.Color(255,255,255));
      boton.setForeground(new java.awt.Color(9,66,66));
  }
    
}
