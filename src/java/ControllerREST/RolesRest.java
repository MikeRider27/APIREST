/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerREST;

import Core.Util;
import Model.DaoImp.RolDAOIMP;
import Model.Dto.RespuestaREST;
import Model.Dto.RolDTO;
import com.google.gson.Gson;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mike
 */
@Path("Roles")
public class RolesRest {

    private RolDTO dto;
    private RolDAOIMP dao;
    private RespuestaREST respuestaDTO;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(String test) {
        return " Bienvenidos a la Aplicación del REST " + test;
    }

    @GET
    @Path("registros")
    @Produces(MediaType.APPLICATION_JSON)
    public String recuperarRegistros() {
        dao = new RolDAOIMP();
        return new Gson().toJson(dao.recuperarRegistros());
    }

    @GET
    @Path("registro")
    @Produces(MediaType.APPLICATION_JSON)
    public String recuperarRegistro(@QueryParam("id") Integer id) {
        dao = new RolDAOIMP();
        RolDTO dto = dao.recuperarRegistro(id);
        if (dto != null) {
            return new Gson().toJson(dto);
        } else {
            dto = new RolDTO();
            dto.setDescripcion("Valor enviado no localizado");
            return new Gson().toJson(dto);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertar(InputStream json) {
        respuestaDTO = new RespuestaREST();
        Gson gson = new Gson();
        dto = gson.fromJson(Util.getJson(json), RolDTO.class);
        System.out.println("id_rol=" + dto.getId_rol());
        System.out.println("descripion=" + dto.getDescripcion());

        dao = new RolDAOIMP();
        if (dao.agregarRegistro(dto) == true) {
            respuestaDTO.setMensaje("Operación Exitosa");
            return new Gson().toJson(respuestaDTO);
        } else {
            respuestaDTO.setMensaje("Error durante la Operación");
            return new Gson().toJson(respuestaDTO);
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String modificacion(InputStream json) {
        respuestaDTO = new RespuestaREST();
        Gson gson = new Gson();
        dto = gson.fromJson(Util.getJson(json), RolDTO.class);
        dao = new RolDAOIMP();
        if (dao.modificarRegistro(dto) == true) {
            respuestaDTO.setMensaje("Operación Exitosa");
            return new Gson().toJson(respuestaDTO);
        } else {
            respuestaDTO.setMensaje("Error durante la Operación");
            return new Gson().toJson(respuestaDTO);
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String eliminar(@QueryParam("id") Integer id) {
        respuestaDTO = new RespuestaREST();
        dao = new RolDAOIMP();
        Boolean resp = dao.eliminarRegistro(new RolDTO(id));
        if (resp == false) {
            respuestaDTO.setMensaje("Error durante la eliminación del registro");
            return new Gson().toJson(respuestaDTO);
        } else {
            respuestaDTO.setMensaje("Registro eliminado en forma exitosa");
            return new Gson().toJson(respuestaDTO);
        }
    }

}
