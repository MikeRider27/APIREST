/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DaoImp;

import Core.Conexion;
import Model.Dao.ContratosDAO;
import Model.Dto.ContratosDTO;
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
public class ContratosDAOIMP implements ContratosDAO {

    private String sql;
    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public ContratosDAOIMP() {
        conexion = new Conexion();
    }

    @Override
    public boolean agregarRegistro(ContratosDTO dto) {
        try {
            conexion.Transaccion(Conexion.TR.INICIAR);
            sql = "INSERT INTO public.contratos(nro_contrato, nombre_llamdo, fecha_inicio, fecha_fin, monto_contrato, id_tipo)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?);";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            ps.setString(1, dto.getNro_contrato());
            ps.setString(2, dto.getNombre_llamdo());
            ps.setTimestamp(3, dto.getFecha_inicio());
            ps.setTimestamp(4, dto.getFecha_fin());
            ps.setInt(5, dto.getMonto_contrato());
            ps.setInt(6, dto.getTipocontrato().getId());
            if (ps.executeUpdate() > 0) {
                conexion.Transaccion(Conexion.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(Conexion.TR.CANCELAR);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            conexion.Transaccion(Conexion.TR.CANCELAR);
            return false;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean modificarRegistro(ContratosDTO dto) {
        try {
            conexion.Transaccion(Conexion.TR.INICIAR);
            sql = "UPDATE public.contratos SET nro_contrato=?, nombre_llamdo=?, fecha_inicio=?, fecha_fin=?, monto_contrato=?, id_tipo=?"
                    + "  WHERE id=?;";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            ps.setString(1, dto.getNro_contrato());
            ps.setString(2, dto.getNombre_llamdo());
            ps.setTimestamp(3, dto.getFecha_inicio());
            ps.setTimestamp(4, dto.getFecha_fin());
            ps.setInt(5, dto.getMonto_contrato());
            ps.setInt(6, dto.getTipocontrato().getId());
            ps.setInt(7, dto.getId());
            if (ps.executeUpdate() > 0) {
                conexion.Transaccion(Conexion.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(Conexion.TR.CANCELAR);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            conexion.Transaccion(Conexion.TR.CANCELAR);
            return false;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean eliminarRegistro(ContratosDTO dto) {
        try {
            conexion.Transaccion(Conexion.TR.INICIAR);
            sql = "DELETE FROM  public.contratos  WHERE id=?;";
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
            Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            conexion.Transaccion(Conexion.TR.CANCELAR);
            return false;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ContratosDTO recuperarRegistro(Integer id) {
        try {
            ContratosDTO dto = null;
            sql = "SELECT c.id, c.nro_contrato, c.nombre_llamdo, c.fecha_inicio, c.fecha_fin, c.monto_contrato, c.id_tipo, t.descrip as tipo_contrato\n"
                    + "FROM public.contratos as c INNER JOIN tipos_contrato as t ON t.id = c.id_tipo\n"
                    + "WHERE c.id = ?";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = new ContratosDTO();
                dto.setId(rs.getInt("id"));
                dto.setNro_contrato(rs.getString("nro_contrato"));
                dto.setNombre_llamdo(rs.getString("nombre_llamdo"));
                dto.setFecha_inicio(rs.getTimestamp("fecha_inicio"));
                dto.setFecha_fin(rs.getTimestamp("fecha_fin"));
                dto.setMonto_contrato(rs.getInt("monto_contrato"));
                dto.setTipocontrato(new TiposContratoDTO(rs.getInt("id_tipo"), rs.getString("tipo_contrato")));
            }
            return dto;
        } catch (SQLException ex) {
            Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<ContratosDTO> recuperarRegistros() {
        try {
            ContratosDTO dto = null;
            List<ContratosDTO> lista;
            sql = "SELECT c.id, c.nro_contrato, c.nombre_llamdo, c.fecha_inicio, c.fecha_fin, c.monto_contrato, c.id_tipo, t.descrip as tipo_contrato\n"
                    + "FROM public.contratos as c INNER JOIN tipos_contrato as t ON t.id = c.id_tipo";
            ps = conexion.obtenerConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                dto = new ContratosDTO();
               dto.setId(rs.getInt("id"));
                dto.setNro_contrato(rs.getString("nro_contrato"));
                dto.setNombre_llamdo(rs.getString("nombre_llamdo"));
                dto.setFecha_inicio(rs.getTimestamp("fecha_inicio"));
                dto.setFecha_fin(rs.getTimestamp("fecha_fin"));
                dto.setMonto_contrato(rs.getInt("monto_contrato"));
                dto.setTipocontrato(new TiposContratoDTO(rs.getInt("id_tipo"), rs.getString("tipo_contrato")));
                lista.add(dto);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                conexion.cerrarConexion();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContratosDAOIMP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
