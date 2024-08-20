package co.edu.uniquindio;

public class Usuario {
    private String nombre;
    private String edad;
    private double peso;
    private VehiculoTransporte vehiculoTransporte;

    public Usuario(String nombre, String edad, VehiculoTransporte vehiculoTransporte, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.vehiculoTransporte = vehiculoTransporte;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public VehiculoTransporte getVehiculoTransporte() {
        return vehiculoTransporte;
    }

    public void setVehiculoTransporte(VehiculoTransporte vehiculoTransporte) {
        this.vehiculoTransporte = vehiculoTransporte;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
