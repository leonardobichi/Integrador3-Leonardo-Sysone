package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jugador extends Integrante {
    private LocalDate fecha_nacimiento;
    private LocalDate fecha_debut;
    private int partidos_jugados;
    private int goles;
    private double peso;
    private double altura;
    private List<HistorialJugadores> historialJugador;
    
    public Jugador() {
    }
    
    public Jugador(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.historialJugador = new ArrayList();
    }

    public Jugador(LocalDate fecha_nacimiento, LocalDate fecha_debut, int partidos_jugados, int goles, double peso, double altura, int dni, String nombre, String apellido, Direccion direccion, String telefono, String email) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_debut = fecha_debut;
        this.partidos_jugados = partidos_jugados;
        this.goles = goles;
        this.peso = peso;
        this.altura = altura;
        this.historialJugador = new ArrayList();
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public LocalDate getFecha_debut() {
        return fecha_debut;
    }

    public void setFecha_debut(LocalDate fecha_debut) {
        this.fecha_debut = fecha_debut;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public List<HistorialJugadores> getHistorialJugador() {
        return historialJugador;
    }

    public void setHistorialJugador(List<HistorialJugadores> historialJugador) {
        this.historialJugador = historialJugador;
    }
    
    public boolean agregarHistorial(HistorialJugadores historial) {
        return historialJugador.add(historial);
    }
    
    @Override
    public String toString() {
        String resultado = "Jugador{ nombre=" + super.getNombre() + ", apellido=" + super.getApellido();
        if (historialJugador != null) {
            resultado += ", HistorialJugador=";
            for (HistorialJugadores h : historialJugador) {
                resultado += h;
            }
        }
        return resultado;
    }
}
