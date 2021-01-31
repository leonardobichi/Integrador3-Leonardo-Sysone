package entidades;

import java.time.LocalDate;

public class DT extends Integrante {
    private LocalDate dirigio_desde;
    private LocalDate dirigio_hasta;
    private Equipo equipo;
    
    public DT() {
    }
    
    public DT(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    public DT(LocalDate dirigio_desde, LocalDate dirigio_hasta, int dni, String nombre, String apellido, Direccion direccion, String telefono, String email, Equipo equipo) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.dirigio_desde = dirigio_desde;
        this.dirigio_hasta = dirigio_hasta;
        this.equipo = equipo;
    }
    
    public LocalDate getDirigio_desde() {
        return dirigio_desde;
    }

    public void setDirigio_desde(LocalDate dirigio_desde) {
        this.dirigio_desde = dirigio_desde;
    }

    public LocalDate getDirigio_hasta() {
        return dirigio_hasta;
    }

    public void setDirigio_hasta(LocalDate dirigio_hasta) {
        this.dirigio_hasta = dirigio_hasta;
    }
    
    @Override
    public String toString() {
        return "DT{ nombre=" + super.getNombre() + ", apellido=" + super.getApellido() + ", dirige=" + equipo + " }";
    }
}