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
public class CiudadDTO {

    private Integer id_ciudad;
    private String descripcion;
    
    public CiudadDTO(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    public CiudadDTO() {
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
