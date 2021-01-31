package interfaces;

import entidades.Jugador;
import java.util.List;

public interface JugadorDao {
    public List<Jugador> listar();
    public Jugador listarPorDNI(int dni);
    public boolean insertar(Jugador jugador);
    public boolean editar(Jugador jugador);
    public boolean eliminar(int dni);
}
