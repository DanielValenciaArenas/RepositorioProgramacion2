package co.edu.uniquindio;

import java.util.Collection;
import java.util.Scanner;

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

    public void mostrarMayoresDe(int edad){
        System.out.println("los propietarios mayores de " + edad + " son:");
        for(Propietario propietario : listaPropietarios){
            if(propietario.getEdad() >=edad){
                System.out.println(propietario.getNombre());
            }
        }

    }

    public void mostarEnRangoDeEdad(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese la edad minima del rango");
        int edadMin = scanner.nextInt();
        System.out.println("Ingrese la edad maxima del rango");
        int edadMax = scanner.nextInt();
        System.out.println("los propietarios en el rango de edad entre " + edadMin + " y " + edadMax + " son:");
        scanner.close();
        for(Propietario propietario : listaPropietarios){
            if(propietario.getEdad() >= edadMin && propietario.getEdad() <= edadMax){
                System.out.println(propietario.getNombre());
            }
        }
    }

    public Collection<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(Collection<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
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