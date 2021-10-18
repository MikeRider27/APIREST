/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Degug;

import Model.Dao.TiposContratoDAO;
import Model.DaoImp.TiposContratoDAOIMP;
import Model.Dto.TiposContratoDTO;

/**
 *
 * @author mike
 */
public class TestTipoContratoModificar {
     private TiposContratoDAO dao;
    private TiposContratoDTO dto;
    
     public TestTipoContratoModificar() {
        dto = new TiposContratoDTO();
        dto.setId(1);
        dto.setDescrip("Contrato B Modificado");
       dto.setComentario("Prueba4");
       
        dao = new TiposContratoDAOIMP();
        if (dao.modificarRegistro(dto)) {
            System.out.println("Operación Exitosa");
        } else {
            System.out.println("Operación Erronea");
        }
    }
    
    public static void main(String[] args) {
        new TestTipoContratoModificar();
    }
    
}
