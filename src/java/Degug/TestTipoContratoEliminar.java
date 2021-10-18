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
public class TestTipoContratoEliminar {
     private TiposContratoDAO dao;
    private TiposContratoDTO dto;
    
     public TestTipoContratoEliminar() {
        dto = new TiposContratoDTO();
         dto.setId(2);
       
        dao = new TiposContratoDAOIMP();
        if (dao.eliminarRegistro(dto)) {
            System.out.println("Operación Exitosa");
        } else {
            System.out.println("Operación Erronea");
        }
    }
    
    public static void main(String[] args) {
        new TestTipoContratoEliminar();
    }
    
}
