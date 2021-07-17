/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galpon.controller;

import galpon.model.bd.query.UsuarioModel;
import galpon.ui.usuarios.RegistrarUsuarioForm;
import galpon.ui.usuarios.UsuariosForm;

/**
 *
 * @author GIMORE
 */
public class UsuarioController {

    private UsuarioModel usuarioM;
    private RegistrarUsuarioForm regUsuarioF;
    private UsuariosForm usuariosF;

    public static String usuarioActual = "";

    public UsuarioController(UsuarioModel usuarioM, RegistrarUsuarioForm regUsuarioF, UsuariosForm usuariosF) {
        this.usuarioM = usuarioM;
        this.regUsuarioF = regUsuarioF;
        this.usuariosF = usuariosF;

    }

}
