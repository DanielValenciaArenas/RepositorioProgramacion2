package co.edu.uniquindio;

import java.util.Collection;

public class Propietario {
    private String nombre;
    private String cedula;
    private String email;
    private String celular;
    private Vehiculo vehiculoAsociado;
    private Collection<Vehiculo> listaVehiculosAsociados;

    public Propietario(String nombre, String cedula, String email, String celular, Vehiculo vehiculoAsociado,
                       Collection<Vehiculo> listaVehiculosAsociados) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.vehiculoAsociado = vehiculoAsociado;
        this.listaVehiculosAsociados = listaVehiculosAsociados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Vehiculo getVehiculoAsociado() {
        return vehiculoAsociado;
    }

    public void setVehiculoAsociado(Vehiculo vehiculoAsociado) {
        this.vehiculoAsociado = vehiculoAsociado;
    }

    public Collection<Vehiculo> getListaVehiculosAsociados() {
        return listaVehiculosAsociados;
    }

    public void setListaVehiculosAsociados(Collection<Vehiculo> listaVehiculosAsociados) {
        this.listaVehiculosAsociados = listaVehiculosAsociados;
    }
}