package entidades;

public enum Posicion {
    DEFENSOR("DEFENSOR"),
    MEDIOCAMPISTA("MEDIOCAMPISTA"),
    DELANTERO("DELANTERO"),
    ARQUERO("ARQUERO");
    
    private String nombrePosicion;
    
    private Posicion(String nombrePosicion) {
        this.nombrePosicion = nombrePosicion;
    }
    
    public String getNombrePosicion() {
        return nombrePosicion;
    }
}
