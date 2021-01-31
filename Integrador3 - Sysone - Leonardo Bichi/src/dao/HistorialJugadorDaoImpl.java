package dao;

import conexion.Conexion;
import entidades.HistorialJugadores;
import entidades.Posicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.HistorialJugadorDao;

public class HistorialJugadorDaoImpl implements HistorialJugadorDao {

    @Override
    public List<HistorialJugadores> listarPorDNI(int dni) {
        Conexion conex = new Conexion();
        String sql = "SELECT * FROM historial_jugadores WHERE dni_jugador = " + dni;
        List<HistorialJugadores> listadoHistoriales = new ArrayList();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HistorialJugadores h = new HistorialJugadores();
                    h.setDni_jugador(rs.getInt("dni_jugador"));
                    h.setCuit_equipo(rs.getInt("cuit_equipo"));
                    if(rs.getDate("fecha_inicio") != null ) h.setFecha_inicio(rs.getDate("fecha_inicio").toLocalDate());
                    if(rs.getDate("fecha_fin") != null ) h.setFecha_fin(rs.getDate("fecha_fin").toLocalDate());
                    if ("delantero".equalsIgnoreCase(rs.getString("posicion"))) h.setPosicion(Posicion.DELANTERO);
                    if ("defensor".equalsIgnoreCase(rs.getString("posicion"))) h.setPosicion(Posicion.DEFENSOR);
                    if ("mediocampista".equalsIgnoreCase(rs.getString("posicion"))) h.setPosicion(Posicion.MEDIOCAMPISTA);
                    if ("arquero".equalsIgnoreCase(rs.getString("posicion"))) h.setPosicion(Posicion.ARQUERO);
                    listadoHistoriales.add(h);
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
        return listadoHistoriales;
    }

    @Override
    public boolean insertar(HistorialJugadores historial) {
        Conexion conex = new Conexion();
        String fecha_inicio = historial.getFecha_inicio() != null ? "'" + historial.getFecha_inicio().toString() + "'" : null;
        String fecha_fin = historial.getFecha_fin() != null ? "'" + historial.getFecha_fin().toString() + "'" : null;
        
        String sql = "INSERT INTO historial_jugadores (dni_jugador, cuit_equipo, fecha_inicio, fecha_fin, posicion) VALUES (" + historial.getDni_jugador() + ", " + historial.getCuit_equipo() + ", " + fecha_inicio + ", " + fecha_fin + ", '" + historial.getPosicion() + "')";
        
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
    public boolean editar(HistorialJugadores historial) {
        Conexion conex = new Conexion();
        String fecha_inicio = historial.getFecha_inicio() != null ? "'" + historial.getFecha_inicio().toString() + "'" : null;
        String fecha_fin = historial.getFecha_fin() != null ? "'" + historial.getFecha_fin().toString() + "'" : null;
        
        String sql = "UPDATE historial_jugadores SET dni_jugador = " + historial.getDni_jugador() + ", cuit_equipo = " + historial.getCuit_equipo() + ", fecha_inicio = " + fecha_inicio + ", fecha_fin = " + fecha_fin + ", posicion = '" + historial.getPosicion() + "' WHERE dni_jugador = " + historial.getDni_jugador();
        
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
    public boolean eliminar(int dni) {
        Conexion conex = new Conexion();
        String sql = "DELETE FROM historial_jugadores WHERE dni_jugador = " + dni;
        
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