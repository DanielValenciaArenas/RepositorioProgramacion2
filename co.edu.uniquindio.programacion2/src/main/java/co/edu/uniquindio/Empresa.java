package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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
/*
getters y setters
Metodos para modificar y obtener los diferentes atributos de la clase
 */
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
    /*
Metodo para obtener el número de usuarios que superan determinado peso.
@param peso
 */

    public static void mostrarUsuariosPorPeso(Empresa empresaTransporte, double peso) {
        Collection<Usuario> usuariosFiltrados = new ArrayList<>();

        // Iterar sobre la lista de usuarios de la empresa
        for (Usuario usuario : empresaTransporte.getListaUsuarios()) {
            // Obtener el vehículo de transporte asociado al usuario
            VehiculoTransporte vehiculoTransporte = usuario.getVehiculoTransporte();

            // Verificar si el usuario tiene un vehículo de transporte asociado
            if (vehiculoTransporte != null) {
                // Comprobar la capacidad de los vehículos de carga
                for (VehiculoCarga vehiculoCarga : empresaTransporte.getListaVehiculosCarga()) {
                    // Comprobar si la capacidad de carga es mayor que el peso especificado
                    if (vehiculoCarga.getCapacidadCarga() > peso) {
                        // Si cumple la condición, añadir el usuario a la lista de filtrados
                        usuariosFiltrados.add(usuario);
                        break; // Salir del ciclo cuando un vehículo ya cumple la condición
                    }
                }
            }
        }

        // Mostrar resultados
        if (usuariosFiltrados.isEmpty()) {
            System.out.println("No hay usuarios con vehículos que superen el peso especificado.");
        } else {
            System.out.println("Usuarios que cumplen con el criterio:");
            for (Usuario usuario : usuariosFiltrados) {
                System.out.println(usuario.getNombre() + " - Edad: " + usuario.getEdad());
            }
        }
    }

 /*
Metodo para indicar el número de pasajeros transportados en un vehiculo según la placa
 */

    public static void contarUsuariosPorPlaca(Empresa empresaTransporte, String placa) {
        for (VehiculoTransporte vehiculoTransporte : empresaTransporte.getListaVehiculosTransporte()) {
            if (vehiculoTransporte.getPlaca().equals(placa)) {
                int numeroUsuarios = vehiculoTransporte.getListaUsuariosAsociados().size();
                System.out.println("Número de usuarios que se movilizaron en el vehículo con placa " + placa + ": " + numeroUsuarios);
                return;
            }
        }
        System.out.println("No se encontró el vehículo con la placa especificada.");
    }
/*
Metodo para obtener el número de propietarios que son mayores  de 40 años.
@param edad
 */

    public void mostrarMayoresDe(int edad){
        System.out.println("los propietarios mayores de " + edad + " son:");
        for(Propietario propietario : listaPropietarios){
            if(propietario.getEdad() > edad){
                System.out.println(propietario.getNombre());
            }
        }

    }
/*
Metodo que muestra los usuarios que se encuentran en un rango de edad
 */

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

}