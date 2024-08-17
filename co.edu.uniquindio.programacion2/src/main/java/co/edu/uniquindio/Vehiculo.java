package co.edu.uniquindio;
import java.util.Collection;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private String color;
    private Propietario propietarioAsociado;
    private Collection<Propietario> listaPropietariosAsociados;


    public Vehiculo(String placa, String modelo, String marca, String color, Propietario propietarioAsociado,
                    Collection<Propietario> listaPropietariosAsociados) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.propietarioAsociado = propietarioAsociado;
        this.listaPropietariosAsociados = listaPropietariosAsociados;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Propietario getPropietarioAsociado() {
        return propietarioAsociado;
    }

    public void setPropietarioAsociado(Propietario propietarioAsociado) {
        this.propietarioAsociado = propietarioAsociado;
    }

    public Collection<Propietario> getListaPropietariosAsociados() {
        return listaPropietariosAsociados;
    }

    public void setListaPropietariosAsociados(Collection<Propietario> listaPropietariosAsociados) {
        this.listaPropietariosAsociados = listaPropietariosAsociados;
    }
}
