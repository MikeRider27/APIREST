/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Core.BaseSQL;
import Model.Dto.UsuarioDTO;

/**
 *
 * @author dgtic-miguel
 */
public interface UsuarioDAO extends BaseSQL<UsuarioDTO>{
    boolean validarUsuario(UsuarioDTO dto);
    
}
