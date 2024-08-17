package co.edu.uniquindio;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa empresaTransporte = inicializarDatos();
        Propietario propietario = registroPropietarioVehiculo();

    }

    public static Empresa inicializarDatos(){
        //Aqui se crean las Listas (vacias por el momento) que contendrá la empresa
        Collection<Propietario> listaPropietarios = new LinkedList<>();
        Collection<Usuario> listaUsuarios = new LinkedList<>();
        Collection<VehiculoCarga> listaVehiculosCarga = new LinkedList<>();
        Collection<VehiculoTransporte> listaVehiculosTransporte = new LinkedList<>();

        // Se crean los Propietarios
        Propietario propietario1 = new Propietario("Monica", "1233456", "Monica@gmail.com",
                "312432123", null, new LinkedList<>());
        Propietario propietario2 = new Propietario("Miguel", "6675427", "Miguel@gmail.com",
                "320420312", null, new LinkedList<>());

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

    public static Propietario registroPropietarioVehiculo(){
        Scanner scanner = new Scanner(System.in);

        // Captura los datos del propietario
        System.out.print("Ingrese el nombre del propietario: ");
        String nombrePropietario = scanner.nextLine();

        System.out.print("Ingrese la cédula del propietario: ");
        String cedulaPropietario = scanner.nextLine();

        System.out.print("Ingrese el email del propietario: ");
        String emailPropietario = scanner.nextLine();

        System.out.print("Ingrese el celular del propietario: ");
        String celularPropietario = scanner.nextLine();

        // Captura los datos del vehículo
        System.out.print("Ingrese la placa del vehículo: ");
        String placaVehiculo = scanner.nextLine();

        System.out.print("Ingrese el modelo del vehículo: ");
        String modeloVehiculo = scanner.nextLine();

        System.out.print("Ingrese la marca del vehículo: ");
        String marcaVehiculo = scanner.nextLine();

        System.out.print("Ingrese el color del vehículo: ");
        String colorVehiculo = scanner.nextLine();

        System.out.print("Ingrese la capacidad de carga del vehículo: ");
        double capacidadCargaVehiculo = scanner.nextDouble();

        System.out.print("Ingrese el número de ejes del vehículo: ");
        int numeroEjesVehiculo = scanner.nextInt();

        // Objeto Propietario
        Propietario propietario = new Propietario(nombrePropietario, cedulaPropietario, emailPropietario,
                celularPropietario, null, new LinkedList<>());

        // Objeto VehiculoCarga
        VehiculoCarga vehiculoCarga = new VehiculoCarga(placaVehiculo, modeloVehiculo, marcaVehiculo, colorVehiculo,
                propietario, new LinkedList<>(), capacidadCargaVehiculo, numeroEjesVehiculo);

        // Se asocia el vehículo al propietario
        propietario.getListaVehiculosAsociados().add(vehiculoCarga);

        return propietario;
    }

    public void calcularPasajerosTransportados(){

    }

}