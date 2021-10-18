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
public class TestContratoAgregar {
     private ContratosDAO dao;
    private ContratosDTO dto;
    
     public TestContratoAgregar() {
     
        dto = new ContratosDTO();
        
        String fecha_inicio = "2021-10-12 01:24:23";
        String fecha_fin = "2021-10-15 01:24:23";
        dto.setNro_contrato("005AC");
       dto.setNombre_llamdo("Concurso");
       dto.setFecha_inicio(Timestamp.valueOf(fecha_inicio));
       dto.setFecha_fin(Timestamp.valueOf(fecha_fin));
       dto.setMonto_contrato(10000);
       dto.setTipocontrato(new TiposContratoDTO(1));
       
        dao = new ContratosDAOIMP();
        if (dao.agregarRegistro(dto)) {
            System.out.println("Operación Exitosa");
        } else {
            System.out.println("Operación Erronea");
        }
    }
    
    public static void main(String[] args) {
        new TestContratoAgregar();
    }
    
}
