/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerREST;

import Core.Util;
import Model.DaoImp.ColorDAOIMP;
import Model.Dto.RespuestaREST;
import Model.Dto.ColorDTO;
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
@Path("Color")
public class ColorRest {

    private ColorDTO dto;
    private ColorDAOIMP dao;
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
        dao = new ColorDAOIMP();
        return new Gson().toJson(dao.recuperarRegistros());
    }

    @GET
    @Path("registro")
    @Produces(MediaType.APPLICATION_JSON)
    public String recuperarRegistro(@QueryParam("id") Integer id) {
        dao = new ColorDAOIMP();
        ColorDTO dto = dao.recuperarRegistro(id);
        if (dto != null) {
            return new Gson().toJson(dto);
        } else {
            dto = new ColorDTO();
            dto.setDescripcion("Valor enviado no localizado");
            return new Gson().toJson(dto);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertar(InputStream json) {
        respuestaDTO = new RespuestaREST();
        Gson gson = new Gson();
        dto = gson.fromJson(Util.getJson(json), ColorDTO.class);
        System.out.println("id_color=" + dto.getId_color());
        System.out.println("descripion=" + dto.getDescripcion());

        dao = new ColorDAOIMP();
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
        dto = gson.fromJson(Util.getJson(json), ColorDTO.class);
        dao = new ColorDAOIMP();
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
        dao = new ColorDAOIMP();
        Boolean resp = dao.eliminarRegistro(new ColorDTO(id));
        if (resp == false) {
            respuestaDTO.setMensaje("Error durante la eliminación del registro");
            return new Gson().toJson(respuestaDTO);
        } else {
            respuestaDTO.setMensaje("Registro eliminado en forma exitosa");
            return new Gson().toJson(respuestaDTO);
        }
    }

}
