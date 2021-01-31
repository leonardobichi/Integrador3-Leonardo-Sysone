package entidades;

import dao.EquipoDaoImpl;
import dao.HistorialJugadorDaoImpl;
import dao.JugadorDaoImpl;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

//DAO
        
        EquipoDaoImpl eqDao = new EquipoDaoImpl();
        JugadorDaoImpl jugDao = new JugadorDaoImpl();
        HistorialJugadorDaoImpl hisDao = new HistorialJugadorDaoImpl();

//Listar equipos/Jugadores
        
        List<Equipo> listadoEquipos = eqDao.listar();
        List<Jugador> listadoJugadores = jugDao.listar();

//Cantidad de equipos en AFA ordenados alfabeticamente
        
        System.out.println("CANTIDAD DE EQUIPOS EN AFA");
        Collections.sort(listadoEquipos, (Equipo a, Equipo b) -> a.getNombre().compareTo(b.getNombre()));
        System.out.println("La AFA tiene " + listadoEquipos.size() + " equipos que son: \n");
        listadoEquipos.forEach(System.out::println); 

//Asignar jugadores a cada equipo
        
        listadoEquipos.forEach(e -> {
            e.setListadoJugadores(new ArrayList());
            listadoJugadores.forEach(j -> {
                j.getHistorialJugador().forEach(h -> {
                    Integer cuit1 = (Integer) h.getCuit_equipo();
                    Integer cuit2 = (Integer) e.getCuit();
                    if (cuit1.equals(cuit2)) e.agregarJugador(j);
                });
            });
        });

//Defensores de cada equipo
        System.out.println("\nCANTIDAD DE DEFENSORES EN CADA EQUIPO");
        listadoEquipos.forEach(e -> {
            List<Jugador> listaFiltrada = e.filtrarPorPosicion(Posicion.DEFENSOR);
            if (listaFiltrada.size() > 0) {
                System.out.println("\nEn " + e.getNombre() + " hay " + listaFiltrada.size() + " " + (listaFiltrada.size() > 1 ? "defensores:": "defensor:"));
                listaFiltrada.forEach(System.out::println);
            }
        });
        
//Consulta que jugadores jugaron en cierta fecha
        
        System.out.println("\nJUGADORES QUE JUGARON EN LA FECHA 2020/01/01");
        Miembros miembros = new Miembros();
        LocalDate fecha = LocalDate.of(2020, 01, 01);
        miembros.mostrarJugPorEquipoYFecha(listadoEquipos, fecha);
    }
}