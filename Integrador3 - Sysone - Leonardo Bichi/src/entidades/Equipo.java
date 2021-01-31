package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo {
    private String nombre;
    private LocalDate fecha_fundacion;
    private String nombre_presidente;
    private String apellido_presidente;
    private Direccion direccion;
    private String telefono;
    private String email;
    private LocalDate en_primera_desde;
    private LocalDate en_primera_hasta;
    private String categoria;
    private List<Jugador> listadoJugadores;
    private DT dt;
    private int cuit;
    
    public Equipo() {
    }
    
    public Equipo(int cuit, String nombre, String categoria) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.listadoJugadores = new ArrayList();
        this.categoria = categoria;
    }
    
    public Equipo(int cuit, String nombre, List<Jugador> listadoJugadores, String categoria) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.listadoJugadores = listadoJugadores;
        this.categoria = categoria;
    }

    public Equipo(int cuit, String nombre, LocalDate fecha_fundacion, String nombre_presidente, String apellido_presidente, Direccion direccion, String telefono, String email, LocalDate en_primera_desde, LocalDate en_primera_hasta, String categoria, List<Jugador> listadoJugadores, DT dt) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.fecha_fundacion = fecha_fundacion;
        this.nombre_presidente = nombre_presidente;
        this.apellido_presidente = apellido_presidente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.en_primera_desde = en_primera_desde;
        this.en_primera_hasta = en_primera_hasta;
        this.categoria = categoria;
        this.listadoJugadores = listadoJugadores;
        this.dt = dt;
    }
    
    public Equipo(int cuit, String nombre, String fecha_fundacion, String nombre_presidente, String apellido_presidente, Direccion direccion, String telefono, String email, String en_primera_desde, String en_primera_hasta, String categoria, List<Jugador> listadoJugadores, DT dt) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.fecha_fundacion = LocalDate.parse(fecha_fundacion, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.nombre_presidente = nombre_presidente;
        this.apellido_presidente = apellido_presidente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.en_primera_desde = LocalDate.parse(en_primera_desde, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.en_primera_hasta = LocalDate.parse(en_primera_hasta, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.categoria = categoria;
        this.listadoJugadores = listadoJugadores;
        this.dt = dt;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(LocalDate fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public String getNombre_presidente() {
        return nombre_presidente;
    }

    public void setNombre_presidente(String nombre_presidente) {
        this.nombre_presidente = nombre_presidente;
    }

    public String getApellido_presidente() {
        return apellido_presidente;
    }

    public void setApellido_presidente(String apellido_presidente) {
        this.apellido_presidente = apellido_presidente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEn_primera_desde() {
        return en_primera_desde;
    }

    public void setEn_primera_desde(LocalDate en_primera_desde) {
        this.en_primera_desde = en_primera_desde;
    }

    public LocalDate getEn_primera_hasta() {
        return en_primera_hasta;
    }

    public void setEn_primera_hasta(LocalDate en_primera_hasta) {
        this.en_primera_hasta = en_primera_hasta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Jugador> getListadoJugadores() {
        return listadoJugadores;
    }

    public void setListadoJugadores(List<Jugador> listadoJugadores) {
        this.listadoJugadores = listadoJugadores;
    }

    public DT getDt() {
        return dt;
    }

    public void setDt(DT dt) {
        this.dt = dt;
    }
    
    @Override
    public String toString() {
        return "Equipo{ cuit=" + cuit + " nombre=" + nombre + ", categoría=" + categoria + " }";
    }
    
    public boolean agregarJugador(Jugador jugador) {
        return listadoJugadores.add(jugador);
    }
    
    public List<Jugador> contarYOrdenarJugadores() {
        Collections.sort(listadoJugadores, (a, b) -> a.getNombre().compareTo(b.getNombre()));
        
        return listadoJugadores;
    }
    
    public List<Jugador> filtrarPorPosicion(Posicion posicion) {
        List<Jugador> listaFiltrada = new ArrayList();
        
        for (Jugador j : listadoJugadores) {
            for (HistorialJugadores h : j.getHistorialJugador()) {
                if ((h.getFecha_fin() == null || h.getFecha_fin().isAfter(LocalDate.now())) && h.getPosicion().getNombrePosicion().equals(posicion.getNombrePosicion())) {
                    listaFiltrada.add(j);
                }
            }
        }
        
        return listaFiltrada;
    }
}
