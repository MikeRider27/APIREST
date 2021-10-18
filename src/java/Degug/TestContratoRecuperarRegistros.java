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
public class TestContratoRecuperarRegistros {

    private ContratosDAO dao;
    private ContratosDTO dto;

    public TestContratoRecuperarRegistros() {

        dto = new ContratosDTO();

        dao = new ContratosDAOIMP();
        for (ContratosDTO x : dao.recuperarRegistros()) {
            System.out.println("Id recuperado = " + x.getId());
            System.out.println("Nro Contrato recuperado = " + x.getNro_contrato());
            System.out.println("Nombre llamado recuperado = " + x.getNombre_llamdo());
            System.out.println("Fecha Inico recuperado = " + x.getFecha_inicio());
            System.out.println("Fecha Fin recuperado = " + x.getFecha_fin());
            System.out.println("Tipo de Contrato recuperado = " + x.getTipocontrato().getDescrip());
            System.out.println("---------------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        new TestContratoRecuperarRegistros();
    }

}
