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
public class TestTipoContratoRecuperarRegistros {
     private TiposContratoDAO dao;
    private TiposContratoDTO dto;
    
     public TestTipoContratoRecuperarRegistros() {
     
       
        dao = new TiposContratoDAOIMP();
         for (TiposContratoDTO x : dao.recuperarRegistros()) {
            System.out.println("Id recuperado = " + x.getId());
            System.out.println("Descripcion recuperado = " + x.getDescrip());
            System.out.println("Comentario recuperado " + x.getComentario());
            System.out.println("---------------------------------------------------------------------------");
        }
    
    }
    
    public static void main(String[] args) {
        new TestTipoContratoRecuperarRegistros();
    }
    
}
