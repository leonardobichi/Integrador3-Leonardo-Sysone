package interfaces;

import entidades.Equipo;
import java.util.List;

public interface EquipoDao {
    public List<Equipo> listar();
    public Equipo listarPorCUIT(int cuit);
    public boolean insertar(Equipo equipo);
    public boolean editar(Equipo equipo);
    public boolean eliminar(int cuit);
}
