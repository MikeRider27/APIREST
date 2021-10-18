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
public class TestTipoContratoRecuperarRegistro {

    private TiposContratoDAO dao;
    private TiposContratoDTO dto;

    public TestTipoContratoRecuperarRegistro() {

        dao = new TiposContratoDAOIMP();
        dto = dao.recuperarRegistro(1);
        System.out.println("Id recuperado = " + dto.getId());
        System.out.println("Descripcion recuperado = " + dto.getDescrip());
        System.out.println("Comentario recuperado = " + dto.getComentario());
    }

    public static void main(String[] args) {
        new TestTipoContratoRecuperarRegistro();
    }

}
