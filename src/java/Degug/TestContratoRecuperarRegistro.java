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
public class TestContratoRecuperarRegistro {
     private ContratosDAO dao;
    private ContratosDTO dto;
    
     public TestContratoRecuperarRegistro() {
     
    
       
        dao = new ContratosDAOIMP();
       dto = dao.recuperarRegistro(2);
        System.out.println("Id recuperado = " + dto.getId());
        System.out.println("Nro Contrato recuperado = " + dto.getNro_contrato());
        System.out.println("Nombre llamado recuperado = " + dto.getNombre_llamdo());
        System.out.println("Fecha Inico recuperado = " + dto.getFecha_inicio());
        System.out.println("Fecha Fin recuperado = " + dto.getFecha_fin());
        System.out.println("Tipo de Contrato recuperado = " + dto.getTipocontrato().getDescrip());
    }
    
    public static void main(String[] args) {
        new TestContratoRecuperarRegistro();
    }
    
}
