package entidades;

import java.time.LocalDate;

public class HistorialJugadores {
    private int dni_jugador;
    private int cuit_equipo;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Posicion posicion;

    public HistorialJugadores() {
    }
    
    public HistorialJugadores(int dni_jugador, int cuit_equipo, LocalDate fecha_inicio, Posicion posicion) {
        this.dni_jugador = dni_jugador;
        this.cuit_equipo = cuit_equipo;
        this.fecha_inicio = fecha_inicio;
        this.posicion = posicion;
    }

    public HistorialJugadores(int dni_jugador, int cuit_equipo, LocalDate fecha_inicio, LocalDate fecha_fin, Posicion posicion) {
        this.dni_jugador = dni_jugador;
        this.cuit_equipo = cuit_equipo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.posicion = posicion;
    }

    public int getDni_jugador() {
        return dni_jugador;
    }

    public void setDni_jugador(int dni_jugador) {
        this.dni_jugador = dni_jugador;
    }

    public int getCuit_equipo() {
        return cuit_equipo;
    }

    public void setCuit_equipo(int cuit_equipo) {
        this.cuit_equipo = cuit_equipo;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    
    public boolean consultarSiJugoPorFecha(LocalDate fecha) {
        if (fecha_fin != null) return (fecha_inicio.isBefore(fecha) || fecha_inicio.isEqual(fecha)) && (fecha_fin.isAfter(fecha) || fecha_fin.isEqual(fecha));
        return (fecha_inicio.isBefore(fecha) || fecha_inicio.isEqual(fecha)) && (LocalDate.now().isAfter(fecha) || fecha_fin.isEqual(fecha));
    }

    @Override
    public String toString() {
        return "{" + "cuit_equipo=" + cuit_equipo + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", posicion=" + posicion + '}';
    }
}
