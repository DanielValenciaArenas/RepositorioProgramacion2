package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

import static co.edu.uniquindio.Vehiculo.registroPropietarioVehiculo;

public class Main {
    public static void main(String[] args) {
        Empresa empresaTransporte = inicializarDatos();
        Propietario propietario = registroPropietarioVehiculo();
        calcularPasajerosTransportados();

        empresaTransporte.mostarEnRangoDeEdad();

        //Filtrar usuarios según peso
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de peso para filtrar usuarios: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        Empresa.mostrarUsuariosPorPeso(empresaTransporte, peso);  // Corregido

        // Contar usuarios por placa
        System.out.print("Ingrese la placa del vehículo de transporte para contar usuarios: ");
        String placa = scanner.nextLine();
        Empresa.contarUsuariosPorPlaca(empresaTransporte, placa);  // Corregido
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

    public static void calcularPasajerosTransportados(){

        // Se crean los 3 vehiculos
        VehiculoTransporte vehiculo1 = new VehiculoTransporte("KKK245", "Modelo1", "Marca1",
                "Rojo", null, null, 50, null);
        VehiculoTransporte vehiculo2 = new VehiculoTransporte("LLL123", "Modelo2", "Marca2",
                "Amarillo", null, null, 40, null);
        VehiculoTransporte vehiculo3 = new VehiculoTransporte("ZZZ332", "Modelo3", "Marca3",
                "Cafe", null, null, 30, null);

        // Se agregan los vehiculos a una lista
        Collection<VehiculoTransporte> vehiculosTransporte = new LinkedList<>();
        vehiculosTransporte.add(vehiculo1);
        vehiculosTransporte.add(vehiculo2);
        vehiculosTransporte.add(vehiculo3);

        // Se captura la placa del vehiculo (Consola)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la placa del vehículo para consultar los pasajeros transportados: ");
        String placaBuscada = scanner.nextLine();

        // Se busca el vehiculo por placa y se muestra cuantos pasajeros transportó
        boolean encontrado = false;
        for (VehiculoTransporte vehiculo : vehiculosTransporte) {
            if (vehiculo.getPlaca().equals(placaBuscada)) {
                System.out.println("El vehículo con placa " + placaBuscada +
                        " transportó " + vehiculo.getMaxPasajeros() +
                        " pasajeros hoy.");
                encontrado = true;
                break;
            }
        }

        if (encontrado == false) {
            System.out.println("No se ha encontrado un vehículo con la placa: " + placaBuscada);
        }
    }

}