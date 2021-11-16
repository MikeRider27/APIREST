
package Model.Dao;

import Core.BaseSQL;
import Model.Dto.UsuarioRESTDTO;

/**
 *
 * @author Juan
 */
public interface UsuarioRESTDAO extends BaseSQL<UsuarioRESTDTO>{
   boolean validarUsuario(UsuarioRESTDTO dto);
}
