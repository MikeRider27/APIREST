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
public class MarcaDTO {

    private Integer id_marca;
    private String descripcion;
    
    public MarcaDTO(Integer id_marca) {
        this.id_marca = id_marca;
    }
    
    public MarcaDTO() {
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
