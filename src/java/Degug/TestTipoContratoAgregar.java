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
public class TestTipoContratoAgregar {
     private TiposContratoDAO dao;
    private TiposContratoDTO dto;
    
     public TestTipoContratoAgregar() {
        dto = new TiposContratoDTO();
        dto.setDescrip("Contrato B");
       dto.setComentario("Prueba456");
       
        dao = new TiposContratoDAOIMP();
        if (dao.agregarRegistro(dto)) {
            System.out.println("Operación Exitosa");
        } else {
            System.out.println("Operación Erronea");
        }
    }
    
    public static void main(String[] args) {
        new TestTipoContratoAgregar();
    }
    
}
