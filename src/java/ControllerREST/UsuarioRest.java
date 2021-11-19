/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerREST;

import Core.Util;
import Model.DaoImp.UsuarioDAOIMP;
import Model.Dto.RespuestaREST;
import Model.Dto.UsuarioDTO;
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
@Path("Usuario")
public class UsuarioRest {

    private UsuarioDTO dto;
    private UsuarioDAOIMP dao;
    private RespuestaREST respuestaDTO;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(String test) {
        return " Bienvenidos a la Aplicación del REST " + test;
    }

    @POST
    @Path("validar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String validarUsuario(InputStream json) {
        respuestaDTO = new RespuestaREST();
        Gson gson = new Gson();
        UsuarioDTO usuarioDTO;

        usuarioDTO = gson.fromJson(Util.getJson(json), UsuarioDTO.class);

        if (usuarioDTO != null) {
            System.out.println("usuario " + usuarioDTO.getNick());
            System.out.println("clave " + usuarioDTO.getPassword());

        }

        UsuarioDAOIMP usuarioDAO = new UsuarioDAOIMP();
        if (usuarioDAO.validarUsuario(usuarioDTO) == true) {
            respuestaDTO.setMensaje("Token generado en forma exitosa");
            respuestaDTO.setToken(usuarioDAO.getToken());
            return new Gson().toJson(respuestaDTO);
        } else {
            respuestaDTO.setMensaje("Error durante la Operación");
            return new Gson().toJson(respuestaDTO);
        }
    }

    @GET
    @Path("registros")
    @Produces(MediaType.APPLICATION_JSON)
    public String recuperarRegistros() {
        dao = new UsuarioDAOIMP();
        return new Gson().toJson(dao.recuperarRegistros());
    }

    @GET
    @Path("registro")
    @Produces(MediaType.APPLICATION_JSON)
    public String recuperarRegistro(@QueryParam("id") Integer id) {
        dao = new UsuarioDAOIMP();
        UsuarioDTO dto = dao.recuperarRegistro(id);
        if (dto != null) {
            return new Gson().toJson(dto);
        } else {
            dto = new UsuarioDTO();
            dto.setNombre("Valor enviado no localizado");
            return new Gson().toJson(dto);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertar(InputStream json) {

        System.out.println(Util.getJson(json));
        respuestaDTO = new RespuestaREST();
        Gson gson = new Gson();
        dto = gson.fromJson(Util.getJson(json), UsuarioDTO.class);

        dao = new UsuarioDAOIMP();
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
        dto = gson.fromJson(Util.getJson(json), UsuarioDTO.class);    
            dao = new UsuarioDAOIMP();
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
        dao = new UsuarioDAOIMP();
        Boolean resp = dao.eliminarRegistro(new UsuarioDTO(id));
        if (resp == false) {
            respuestaDTO.setMensaje("Error durante la eliminación del registro");
            return new Gson().toJson(respuestaDTO);
        } else {
            respuestaDTO.setMensaje("Registro eliminado en forma exitosa");
            return new Gson().toJson(respuestaDTO);
        }

    }
    
    
    @PUT
    @Path("desactivar")
    @Produces(MediaType.APPLICATION_JSON)
    public String desactivar(@QueryParam("id") Integer id) {
        respuestaDTO = new RespuestaREST();
        dao = new UsuarioDAOIMP();
        Boolean resp = dao.inactivarUsuario(new UsuarioDTO(id));
        if (resp == false) {
            respuestaDTO.setMensaje("Error durante la desactivacion");
            return new Gson().toJson(respuestaDTO);
        } else {
            respuestaDTO.setMensaje("Registro desactivado en forma exitosa");
            return new Gson().toJson(respuestaDTO);
        }

    }

}
