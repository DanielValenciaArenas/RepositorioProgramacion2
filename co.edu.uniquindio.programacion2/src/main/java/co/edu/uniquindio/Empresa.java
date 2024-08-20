package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

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

}