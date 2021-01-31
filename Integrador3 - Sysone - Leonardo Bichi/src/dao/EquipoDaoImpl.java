package dao;

import conexion.Conexion;
import entidades.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.EquipoDao;

public class EquipoDaoImpl implements EquipoDao {

    @Override
    public List<Equipo> listar() {
        Conexion conex = new Conexion();
        String sql = "SELECT * FROM equipos";
        List<Equipo> listadoEquipos = new ArrayList();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Equipo e = new Equipo();
                    e.setCuit(rs.getInt("cuit"));
                    e.setNombre(rs.getString("nombre"));
                    e.setCategoria(rs.getString("categoria"));
                    listadoEquipos.add(e);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listadoEquipos;
    }

    @Override
    public Equipo listarPorCUIT(int cuit) {
        Conexion conex = new Conexion();
        String sql = "SELECT * FROM equipos WHERE cuit = " + cuit;
        Equipo eq = new Equipo();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    eq.setCuit(rs.getInt("cuit"));
                    eq.setNombre(rs.getString("nombre"));
                    eq.setCategoria(rs.getString("categoria"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return eq;
    }

    @Override
    public boolean insertar(Equipo equipo) {
        Conexion conex = new Conexion();
        String sql = "INSERT INTO equipos VALUES (" + equipo.getCuit() + ", '" + equipo.getNombre() + "', '" + equipo.getCategoria() + "')";
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Equipo equipo) {
        Conexion conex = new Conexion();
        String sql = "UPDATE equipos SET nombre = '" + equipo.getNombre() + "', categoria = '" + equipo.getCategoria() + "' WHERE cuit = " + equipo.getCuit();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int cuit) {
        Conexion conex = new Conexion();
        String sql = "DELETE FROM equipos WHERE cuit = " + cuit;
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}