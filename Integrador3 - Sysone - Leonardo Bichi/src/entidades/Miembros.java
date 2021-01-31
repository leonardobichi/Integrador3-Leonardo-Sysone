package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Miembros {
    
    public List<Jugador> listarJugPorEquipoYFecha(Equipo equipo, LocalDate fecha) {
        List<Jugador> filtroJug = new ArrayList();
        equipo.getListadoJugadores().forEach(j -> {
            j.getHistorialJugador().forEach(h -> {
                Integer cuit1 = h.getCuit_equipo();
                Integer cuit2 = equipo.getCuit();
                if (h.consultarSiJugoPorFecha(fecha) && (cuit1.equals(cuit2))) filtroJug.add(j);
            });
        });
        return filtroJug;
        
    }
        
    public void mostrarJugPorEquipoYFecha(List<Equipo> equipos, LocalDate fecha) {
        equipos.forEach(e -> {
            List<Jugador> listaFec = listarJugPorEquipoYFecha(e, fecha);
            if (listaFec.size() > 0) System.out.println("\nEn " + e.getNombre() + " jugaron " + listaFec.size() + " jugadores durante " + fecha + ":");
            Collections.sort(listaFec, (Jugador j1, Jugador j2) -> j1.getNombre().compareTo(j2.getNombre()));
            listaFec.forEach(System.out::println);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        });
    }        
}
