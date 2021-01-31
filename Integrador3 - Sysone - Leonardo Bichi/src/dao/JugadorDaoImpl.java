package dao;

import conexion.Conexion;
import entidades.HistorialJugadores;
import entidades.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.JugadorDao;

public class JugadorDaoImpl implements JugadorDao {
    HistorialJugadorDaoImpl hdao = new HistorialJugadorDaoImpl();

    @Override
    public List<Jugador> listar() {
        Conexion conex = new Conexion();
        String sql = "SELECT * FROM jugadores";
        List<Jugador> listadoJugadores = new ArrayList();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Jugador j = new Jugador();
                    j.setDni(rs.getInt("dni"));
                    j.setNombre(rs.getString("nombre"));
                    j.setApellido(rs.getString("apellido"));
                    List<HistorialJugadores> listadoHistorial = hdao.listarPorDNI(j.getDni());
                    if (listadoHistorial != null) j.setHistorialJugador(listadoHistorial);
                    listadoJugadores.add(j);
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
        return listadoJugadores;
    }

    @Override
    public Jugador listarPorDNI(int dni) {
        Conexion conex = new Conexion();
        String sql = "SELECT * FROM jugadores WHERE dni = " + dni;
        Jugador jug = new Jugador();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    jug.setDni(rs.getInt("dni"));
                    jug.setNombre(rs.getString("nombre"));
                    jug.setApellido(rs.getString("apellido"));
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
        return jug;
    }

    @Override
    public boolean insertar(Jugador jugador) {
        Conexion conex = new Conexion();
        String sql = "INSERT INTO jugadores VALUES (" + jugador.getDni() + ", '" + jugador.getNombre() + "', '" + jugador.getApellido() + "')";
        
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
    public boolean editar(Jugador jugador) {
        Conexion conex = new Conexion();
        String sql = "UPDATE jugadores SET nombre = '" + jugador.getNombre() + "', apellido = '" + jugador.getApellido() + "' WHERE dni = " + + jugador.getDni();
        
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
        String sql = "DELETE FROM jugadores WHERE dni = " + dni;
        
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
