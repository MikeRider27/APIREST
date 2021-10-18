/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dto;

/**
 *
 * @author mike
 */
public class TiposContratoDTO {

    private Integer id;
    private String descrip;
    private String comentario;

    public TiposContratoDTO() {
    }

    public TiposContratoDTO(Integer id) {
        this.id = id;
    }

    public TiposContratoDTO(Integer id, String descrip) {
        this.id = id;
        this.descrip = descrip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    

}
