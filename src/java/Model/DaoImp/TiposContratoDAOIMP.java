/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoImp;

import Core.Conexion;
import Model.Dao.TiposContratoDAO;
import Model.Dto.TiposContratoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mike
 */
public class TiposContratoDAOIMP implements TiposContratoDAO {
    private String sql;
    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public TiposContratoDAOIMP() {
        conexion = new Conexion();
    }

    @Override
    public boolean agregarRegistro(TiposContratoDTO dto) {
       try {
            conexion.Transaccion(Conexion.TR.INICIAR);
            sql = "INSERT INTO public.tipos_contrato(descrip, comentario) VALUES (?, ?);";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            ps.setString(1, dto.getDescrip());
            ps.setString(2, dto.getComentario());            
            if (ps.executeUpdate() > 0) {
                conexion.Transaccion(Conexion.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(Conexion.TR.CANCELAR);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            conexion.Transaccion(Conexion.TR.CANCELAR);
            return false;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean modificarRegistro(TiposContratoDTO dto) {
        try {
            conexion.Transaccion(Conexion.TR.INICIAR);
            sql = "UPDATE public.tipos_contrato SET descrip=?, comentario=? WHERE id=?;";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            ps.setString(1, dto.getDescrip());
            ps.setString(2, dto.getComentario());          
            ps.setInt(3, dto.getId());
            if (ps.executeUpdate() > 0) {
                conexion.Transaccion(Conexion.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(Conexion.TR.CANCELAR);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            conexion.Transaccion(Conexion.TR.CANCELAR);
            return false;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean eliminarRegistro(TiposContratoDTO dto) {
    try {
            conexion.Transaccion(Conexion.TR.INICIAR);
            sql = "DELETE FROM  public.tipos_contrato  WHERE id=?;";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            ps.setInt(1, dto.getId());
            if (ps.executeUpdate() > 0) {
                conexion.Transaccion(Conexion.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(Conexion.TR.CANCELAR);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            conexion.Transaccion(Conexion.TR.CANCELAR);
            return false;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public TiposContratoDTO recuperarRegistro(Integer id) {
    try {
            TiposContratoDTO dto = null;
            sql = "SELECT id, descrip, comentario FROM public.tipos_contrato WHERE id = ? ";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = new TiposContratoDTO();
                dto.setId(rs.getInt("id"));
                dto.setDescrip(rs.getString("descrip"));
                dto.setComentario(rs.getString("comentario"));           
            }
            return dto;
        } catch (SQLException ex) {
            Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<TiposContratoDTO> recuperarRegistros() {
    try {
            TiposContratoDTO dto = null;
            List<TiposContratoDTO> lista;
            sql = "SELECT id, descrip, comentario FROM public.tipos_contrato";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                dto = new TiposContratoDTO();
                dto.setId(rs.getInt("id"));
                dto.setDescrip(rs.getString("descrip"));
                dto.setComentario(rs.getString("comentario"));             
                lista.add(dto);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TiposContratoDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
