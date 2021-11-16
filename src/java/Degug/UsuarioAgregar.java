/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Degug;

import Model.Dao.UsuarioDAO;
import Model.DaoImp.UsuarioDAOIMP;
import Model.Dto.UsuarioDTO;
import Model.Dto.RolDTO;

import java.sql.Timestamp;

/**
 *
 * @author mike
 */
public class UsuarioAgregar {
     private UsuarioDAO dao;
    private UsuarioDTO dto;
    
     public UsuarioAgregar() {
     
        dto = new UsuarioDTO();
        

        dto.setNombre("Miguel Cabañas");
       dto.setNick("MC");
       dto.setPassword("456");
       dto.setRol(new RolDTO(2));
    
       
        dao = new UsuarioDAOIMP();
        if (dao.agregarRegistro(dto)) {
            System.out.println("Operación Exitosa");
        } else {
            System.out.println("Operación Erronea");
        }
    }
    
    public static void main(String[] args) {
        new UsuarioAgregar();
    }
    
}
