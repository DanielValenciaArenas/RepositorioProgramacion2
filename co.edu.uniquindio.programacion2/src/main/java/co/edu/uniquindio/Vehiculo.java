package co.edu.uniquindio;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

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
    /*
    getters y setters
    Metodos para modificar y obtener los diferentes atributos de la clase
     */
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
                celularPropietario,40, null, new LinkedList<>());

        // Objeto VehiculoCarga
        VehiculoCarga vehiculoCarga = new VehiculoCarga(placaVehiculo, modeloVehiculo, marcaVehiculo, colorVehiculo,
                propietario, new LinkedList<>(), capacidadCargaVehiculo, numeroEjesVehiculo);

        // Se asocia el vehículo al propietario
        propietario.getListaVehiculosAsociados().add(vehiculoCarga);

        return propietario;
    }
}
