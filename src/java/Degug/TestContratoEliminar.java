/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Degug;

import Model.Dao.ContratosDAO;
import Model.DaoImp.ContratosDAOIMP;
import Model.Dto.ContratosDTO;
import Model.Dto.TiposContratoDTO;

import java.sql.Timestamp;

/**
 *
 * @author mike
 */
public class TestContratoEliminar {
     private ContratosDAO dao;
    private ContratosDTO dto;
    
     public TestContratoEliminar() {
     
        dto = new ContratosDTO();
        
  
        
        dto.setId(1);
      
       
        dao = new ContratosDAOIMP();
        if (dao.eliminarRegistro(dto)) {
            System.out.println("Operación Exitosa");
        } else {
            System.out.println("Operación Erronea");
        }
    }
    
    public static void main(String[] args) {
        new TestContratoEliminar();
    }
    
}
