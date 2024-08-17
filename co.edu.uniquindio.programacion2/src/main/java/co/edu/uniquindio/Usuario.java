package co.edu.uniquindio;

public class Usuario {
    private String nombre;
    private String edad;
    private VehiculoTransporte vehiculoTransporte;

    public Usuario(String nombre, String edad, VehiculoTransporte vehiculoTransporte) {
        this.nombre = nombre;
        this.edad = edad;
        this.vehiculoTransporte = vehiculoTransporte;
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
}
