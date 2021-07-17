/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.controller;


import galpon.ConstantesConfig;
import galpon.ui.principal.InicioEscritorioForm;
import galpon.ui.principal.InicioForm;

/**
 *
 * @author GIMORE
 */
public class InicioEscritorioController {

    private InicioEscritorioForm inicioEscF;

    public InicioEscritorioController(InicioEscritorioForm inicioEscF) {
        this.inicioEscF = inicioEscF;
        this.inicioEscF.lblVersion.setText(ConstantesConfig.VERSION);
        
         if (InicioForm.lblTipo.getText().equals("Estandar")) {
            InicioEscritorioForm.btnGestUsuarios.setEnabled(false);
            //frmInicioEscritorio.btnGestUsuarios.hide();
        }
    }

}
