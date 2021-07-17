/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.ui.styles;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author GIMORE
 */
public class estiloTabla {
   
    //Da el diseño de color a las tablas ---
    public void tabla(JTable tabla){
       tabla.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
               @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                l.setBorder(new LineBorder(Color.white));
                l.setBackground(new java.awt.Color(9, 66, 66));
                l.setForeground(new java.awt.Color(255, 255, 255));
               
                //l.setFont(new java.awt.Font("Arial", 1, 12));
                return l;
            }
        }); 
    }
        
      public static  void dimensioncols(JTable tabla) {
        tabla.getColumnModel().getColumn(0).setPreferredWidth(10);//ancho para la primer columna
        // tablaProducto.getColumnModel().getColumn(5).setPreferredWidth(15);//ancho para la primer columna
    }
    
}
