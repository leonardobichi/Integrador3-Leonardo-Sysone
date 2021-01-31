package interfaces;

import entidades.HistorialJugadores;
import java.util.List;

public interface HistorialJugadorDao {
    public List<HistorialJugadores> listarPorDNI(int dni);
    public boolean insertar(HistorialJugadores historial);
    public boolean editar(HistorialJugadores historial);
    public boolean eliminar(int dni);
}
