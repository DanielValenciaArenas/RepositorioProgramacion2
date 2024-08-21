package co.edu.uniquindio;

import java.util.Collection;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga(String placa, String modelo, String marca, String color, Propietario propietarioAsociado,
                         Collection<Propietario> listaPropietariosAsociados, double capacidadCarga, int numeroEjes) {
        super(placa, modelo, marca, color, propietarioAsociado, listaPropietariosAsociados);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }
    /*
    getters y setters
    Metodos para modificar y obtener los diferentes atributos de la clase
     */
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }
}
