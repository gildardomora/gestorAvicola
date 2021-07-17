/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.controller;

import galpon.model.bd.query.UsuarioModel;
import galpon.model.dto.UsuarioDto;
import galpon.ui.aves.AvesForm;
import galpon.ui.galpones.AdminGalponForm;
import galpon.ui.gastos.GastosForm;
import galpon.ui.login.LoginForm;
import galpon.ui.principal.InicioEscritorioForm;
import galpon.ui.principal.InicioForm;
import static galpon.ui.principal.InicioForm.escritorio;
import galpon.ui.produccion.ProduccionForm;
import galpon.ui.productos.ProductosForm;
import static galpon.ui.styles.estiloBoton.botonColor;
import galpon.ui.ventas.VentasForm;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GIMORE
 */
public class InicioController implements ActionListener, MouseListener {

    private InicioForm inicioF;
    private InicioEscritorioForm inicioEscritorioF;

    public InicioController(InicioForm inicioF, InicioEscritorioForm inicioEscritorioF) {
        this.inicioF = inicioF;
        this.inicioEscritorioF = inicioEscritorioF;
        this.inicioF.toFront();
        this.inicioF.setVisible(true);
        this.inicioF.setLocationRelativeTo(null);
        this.inicioF.setExtendedState(MAXIMIZED_BOTH);// maximizar el formulario
        this.inicioF.escritorio.add(inicioEscritorioF);
        this.inicioEscritorioF.setVisible(true);
        this.inicioEscritorioF.toFront();
        try {
            inicioEscritorioF.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.inicioF.btnProductos.addActionListener(this);
        this.inicioF.btnAves.addActionListener(this);
        this.inicioF.btnGalpones.addActionListener(this);
        this.inicioF.btnHome.addActionListener(this);
        this.inicioF.btnProduccion.addActionListener(this);
        this.inicioF.btnGastos.addActionListener(this);
        this.inicioF.btnVentas.addActionListener(this);
        this.inicioF.btnVentas.addMouseListener(this);
        this.inicioF.btnCerrarSesion.addActionListener(this);

    }
    
        private void validarDatoTipoNumero(String dato) {
        int num;
        try {
            num = Integer.parseInt(dato);
            //JOptionPane.showMessageDialog(rootPane,"No se admiten letras en: ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se admiten letras en: ");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(" code: " + e);
        if (e.getSource() == inicioF.btnProductos) {
            ProductosForm productosF = new ProductosForm();
            ProductoController productosC = new ProductoController(productosF);
            int ancho = escritorio.getWidth();
            int altura = escritorio.getHeight();
            productosF.setSize(ancho, altura);
            escritorio.add(productosF);
            productosF.show();
            return;
        }
        if (e.getSource() == inicioF.btnAves) {
            AvesForm aveF = new AvesForm();
            AveController aveC=new AveController(aveF);
            int ancho = escritorio.getWidth();
            int altura = escritorio.getHeight();
            aveF.setSize(ancho, altura);
            escritorio.add(aveF);
            aveF.show();
            return;
        }
        if (e.getSource() == inicioF.btnGalpones) {
            AdminGalponForm admingalpon = new AdminGalponForm();
            int ancho = escritorio.getWidth();
            int altura = escritorio.getHeight();
            admingalpon.setSize(ancho, altura);
            escritorio.removeAll();
            escritorio.add(admingalpon);
            admingalpon.show();
            return;
        }
        if (e.getSource() == inicioF.btnHome) {
            //InicioEscritorioForm inicioEscritorioF = new InicioEscritorioForm();
            InicioEscritorioController inicioEscritorioC = new InicioEscritorioController(inicioEscritorioF);
            int ancho = escritorio.getWidth();
            int altura = escritorio.getHeight();
            inicioEscritorioF.setSize(ancho, altura);
            escritorio.removeAll();
            escritorio.add(inicioEscritorioF);
            inicioEscritorioF.show();
            return;
        }
        if (e.getSource() == inicioF.btnProduccion) {
            ProduccionForm produccion = new ProduccionForm();
            int ancho = escritorio.getWidth();
            int altura = escritorio.getHeight();
            produccion.setSize(ancho, altura);
            escritorio.removeAll();
            escritorio.add(produccion);
            produccion.show();
            return;
        }
        if (e.getSource() == inicioF.btnGastos) {
            GastosForm gastos = new GastosForm();
            int ancho = InicioForm.escritorio.getWidth();
            int altura = InicioForm.escritorio.getHeight();
            gastos.setSize(ancho, altura);
            escritorio.removeAll();
            escritorio.add(gastos);
            gastos.show();
            return;
        }
        if (e.getSource() == inicioF.btnVentas) {
            VentasForm venta = new VentasForm();
            int ancho = escritorio.getWidth();
            int altura = escritorio.getHeight();
            venta.setSize(ancho, altura);
            escritorio.add(venta);
            venta.show();
            return;
        }
        if (e.getSource() == inicioF.btnCerrarSesion) {
            int confirmar = JOptionPane.showConfirmDialog(inicioF, UsuarioController.usuarioActual + "\n Desea cerrar la Sesion ?", "Confirmar", 2);
            if (confirmar == 0) {
                inicioF.dispose();
                LoginForm loginF = new LoginForm();
                UsuarioModel usuarioM = new UsuarioModel();
                // InicioForm inicioF = new InicioForm();
                UsuarioDto usuarioDto = new UsuarioDto();
                loginF.setVisible(true);
                LoginController loginC = new LoginController(loginF, usuarioM, inicioF, usuarioDto);
            }
            return;
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
   }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent() == inicioF.btnVentas) {
            botonColor(inicioF.btnVentas, "blanco", "verdeOscuro");
          
        }
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent() == inicioF.btnVentas) {
            botonColor(inicioF.btnVentas, "verdeOscuro", "blanco");
            return;
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
