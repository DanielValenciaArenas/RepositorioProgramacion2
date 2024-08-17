package co.edu.uniquindio;

import java.util.Collection;

public class Empresa {
    private Collection<Propietario> listaPropietarios;
    private Collection<Usuario> listaUsuarios;
    private Collection<VehiculoCarga> listaVehiculosCarga;
    private Collection<VehiculoTransporte> listaVehiculosTransporte;

    public Empresa(Collection<Propietario> listaPropietarios, Collection<Usuario> listaUsuarios,
                   Collection<VehiculoCarga> listaVehiculosCarga, Collection<VehiculoTransporte> listaVehiculosTransporte) {
        this.listaPropietarios = listaPropietarios;
        this.listaUsuarios = listaUsuarios;
        this.listaVehiculosCarga = listaVehiculosCarga;
        this.listaVehiculosTransporte = listaVehiculosTransporte;
    }

    public Collection<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(Collection<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPiropietarios;
    }

    public Collection<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Collection<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Collection<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }

    public void setListaVehiculosCarga(Collection<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }

    public Collection<VehiculoTransporte> getListaVehiculosTransporte() {
        return listaVehiculosTransporte;
    }

    public void setListaVehiculosTransporte(Collection<VehiculoTransporte> listaVehiculosTransporte) {
        this.listaVehiculosTransporte = listaVehiculosTransporte;
    }


}