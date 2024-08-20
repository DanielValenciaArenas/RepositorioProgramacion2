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

    public static Empresa inicializarDatos(){
        //Aqui se crean las Listas (vacias por el momento) que contendrá la empresa
        Collection<Propietario> listaPropietarios = new LinkedList<>();
        Collection<Usuario> listaUsuarios = new LinkedList<>();
        Collection<VehiculoCarga> listaVehiculosCarga = new LinkedList<>();
        Collection<VehiculoTransporte> listaVehiculosTransporte = new LinkedList<>();

        // Se crean los Propietarios
        Propietario propietario1 = new Propietario("Monica", "1233456", "Monica@gmail.com",
                "312432123", 40,null, new LinkedList<>());
        Propietario propietario2 = new Propietario("Miguel", "6675427", "Miguel@gmail.com",
                "320420312", 40,null, new LinkedList<>());

        // Se crean los Vehiculos
        VehiculoTransporte vehiculoTransporte1 = new VehiculoTransporte("9KNB4", "NEW", "Moto",
                "Verde", propietario1, new LinkedList<>(), 2, new LinkedList<>());
        VehiculoTransporte vehiculoTransporte2 = new VehiculoTransporte("5FCD2", "NEW", "Carro",
                "Marrón", propietario2, new LinkedList<>(), 4, new LinkedList<>());
        VehiculoCarga vehiculoCarga1 = new VehiculoCarga("7JHU", "NEW", "Camion",
                "Negro", propietario1, new LinkedList<>(), 30.2, 8);
        VehiculoCarga vehiculoCarga2 = new VehiculoCarga("8GF6T", "NEW", "Camion",
                "Amarillo", propietario2, new LinkedList<>(), 24.4, 6);

        // Se asocian los vehiculos con los propietarios
        propietario1.getListaVehiculosAsociados().add(vehiculoTransporte1);
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga1);
        propietario2.getListaVehiculosAsociados().add(vehiculoTransporte2);
        propietario2.getListaVehiculosAsociados().add(vehiculoCarga2);

        // Se crean los usuarios
        Usuario usuario1 = new Usuario("Monica", "25", vehiculoTransporte1);
        Usuario usuario2 = new Usuario("Miguel", "21", vehiculoTransporte2);

        // Se asocian los usuarios a los vehiculos de transporte
        vehiculoTransporte1.getListaUsuariosAsociados().add(usuario1);
        vehiculoTransporte2.getListaUsuariosAsociados().add(usuario2);

        // Se agrega la info a las listas de la Empresa
        listaPropietarios.add(propietario1);
        listaPropietarios.add(propietario2);
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaVehiculosCarga.add(vehiculoCarga1);
        listaVehiculosCarga.add(vehiculoCarga2);
        listaVehiculosTransporte.add(vehiculoTransporte1);
        listaVehiculosTransporte.add(vehiculoTransporte2);

        // Se crea la empresa con las listas
        Empresa empresaTransporte = new Empresa (listaPropietarios, listaUsuarios, listaVehiculosCarga,
                listaVehiculosTransporte);

        return empresaTransporte;
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

}