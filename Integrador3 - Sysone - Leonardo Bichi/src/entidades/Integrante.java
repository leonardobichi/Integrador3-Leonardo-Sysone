package entidades;

public class Integrante {
    private int dni;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private String telefono;
    private String email;
    
    public Integrante() {
    }
    
    public Integrante(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public Integrante(int dni, String nombre, String apellido, Direccion direccion, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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
    
    @Override
    public String toString() {
        return "{ nombre= " + nombre + ", apellido=" + apellido + ", dni=" + dni + ", dirección=" + direccion + ", telefono=" + telefono + ", email=" + email + " }";
    }
}
