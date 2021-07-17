/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.ui.styles;

import javax.swing.JButton;

/**
 *
 * @author GIMORE
 */
public class estiloBoton {
        public static void botonColor(JButton boton, String colortexto,String colorfondo){
     // boton.setBorder(new LineBorder(new java.awt.Color(255, 255, 255),2));
     int [] texto=new int[3];
     int [] fondo=new int[3];
     
     switch (colortexto){
         case"blanco":
             texto[0]=255;
             texto[1]=255;
             texto[2]=255;
             break;
              case"verdeOscuro":
             texto[0]=9;
             texto[1]=66;
             texto[2]=66;
             break;
         default:
             texto[0]=9;
             texto[1]=66;
             texto[2]=66;
            
     }
     
     switch(colorfondo){
         case"verdeOscuro":
             fondo[0]=9;
             fondo[1]=66;
             fondo[2]=66;
             break;
         case"rojoOscuro":
             fondo[0]=153;
             fondo[1]=0;
             fondo[2]=0;
             break;
         default:
             fondo[0]=255;
             fondo[1]=255;
             fondo[2]=255;
             
     }
      boton.setBackground(new java.awt.Color(fondo[0],fondo[1],fondo[2]));     
      boton.setForeground(new java.awt.Color(texto[0],texto[1],texto[2]));     
      
  }
  
  
    
}
