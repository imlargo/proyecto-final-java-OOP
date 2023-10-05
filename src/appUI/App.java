package appUI;

import Aerolinea.*;
import java.util.Scanner;
import java.util.ArrayList;

public class App {


    public static void main(String[] args) {

        // Crear las instancias de las clases
        // Se crea una cuenta, y un usuario, etc

        System.out.println("Bienvenido");

        // haganme los mensajes para q diga las opciones disponibles
        Scanner scanner = new Scanner(System.in);
        int opcion;

        /* Espacio para iniciar sesion cargando cuenta o creando y guardando */
        Usuario user = new Usuario(1);

        do {
            System.out.println("+ - - - - - - - - - - - - - +");
            System.out.println("Menú:");
            System.out.println("1. Comprar vuelo");
            System.out.println("2. Reasignar vuelo");
            System.out.println("3. Cancelar vuelo");
            System.out.println("4. Ver cuenta");
            System.out.println("5. Salir");
            System.out.println("+ - - - - - - - - - - - - - +");

            System.out.print("> Seleccione una opción (1-5): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" - - - > Ha seleccionado la opción Comprar vuelo < - - -");
                    System.out.println("");
                    comprarVuelo(user);
                    System.out.println("+ - - - - - - - - - - - - - +");
                    break;

                case 2:
                    System.out.println(" - - - > Ha seleccionado la opción Reasignar vuelo < - - -");
                     System.out.println("");
                     reasignarVuelo(user);
                    System.out.println("+ - - - - - - - - - - - - - +");
                    break;

                case 3:
                    System.out.println(" - - - > Ha seleccionado la opción Cancelar vuelo < - - -");
                     System.out.println("");
                    cancelarVuelo(user);
                    System.out.println("+ - - - - - - - - - - - - - +");
                    break;

                case 4:
                    System.out.println(" - - - > Ha seleccionado la opción Ver cuenta < - - -");

                    verCuenta(user);
                    System.out.println("+ - - - - - - - - - - - - - +");
                    break;

                case 5:
                    System.out.println("Saliendo del programa. ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida (1-5).");
                    break;

            }

        } while (opcion != 5);

        scanner.close();
        System.out.println("Bye");

    }

    private static void comprarVuelo(Usuario user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese el origen: ");
        String origen = scanner.nextLine();

        System.out.println("Por favor ingrese el destino: ");
        String destino = scanner.nextLine();

        // Ingrese la cantidad de vuelos a generar?

        //Al recibir el origen y destino se generan n vuelos y se muestran.
        ArrayList<Vuelo> vuelos = Aeropuerto.generarVuelos(5, origen, destino); // Cantidad de vuelos

        separador();
        System.out.println("#Vuelo - Origen - Destino");
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            System.out.println(vuelo.getInfo());
        }

        separador();
        System.out.println("Selecciona por favor el vuelo: ");
        int indexVuelo = scanner.nextInt();

        //Selecciona el vuelo y genera m asientos vip y n asientos economicos
        Vuelo vuelo = vuelos.get(indexVuelo);
        vuelo.generarAsientos(3, 5);
        //Se genera el boleto que al final se confirmara
        Boleto boleto = new Boleto(origen, destino, user, vuelo);
        
        
        separador();
        System.out.println("Los tipos de asientos disponibles son los siguientes:");

        // Primero muestra los precios de cada tipo de asiento, luego
        // Muestra los asientos disponibles y su tipo:

        System.out.println("Los asientos disponibles son los siguientes:");
        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            System.out.println(asiento.getInfo());
        }

        separador();
        System.out.println("Seleccione el numero de asiento disponible");
        int indexAsiento = scanner.nextInt();
        Asiento asiento = asientos.get(indexAsiento - 1);
        boleto.setAsiento(asiento);
        // Si se selecciona y es valido se prosigue...
        // Se muestra una previsualizacion del precio

        separador();
        System.out.println("Desea continuar?");
        // Si sí, sigue, sino, selecciona otro asiento??

        separador();
        System.out.println("Selecciona si va a añadir equipaje o no");
        int opcion = scanner.nextInt();
        // SI la respuesta es si, entonces agrega varios equipajes, sino, no

        if (opcion == 1) {
            // Cada vez q se agrega un equipaje se va mostrando una previsualizacion del
            // precio..
            // Segun la cantidad de equipaje y los precios de cada uni
            int exit = 1;
            int c = 0;

            do {
                c += 1;
                
                separador();
                System.out.print("> Ingrese el peso de la maleta: ");
                int peso = scanner.nextInt();

                System.out.print("> Ingrese el valor del ancho de la maleta: ");
                int ancho = scanner.nextInt();

                System.out.print("> Ingrese el valor del largo de la maleta: ");
                int largo = scanner.nextInt();

                System.out.print("> Ingrese el valor del alto de la maleta: ");
                int alto = scanner.nextInt();

                boleto.addEquipaje(new Maleta(c, peso, largo, ancho, alto, boleto));
                System.out.println("Valor nuevo del boleto: ");
                System.out.println("-> $" + boleto.getValor());

                separador();
                System.out.println("Desea agregar un equipaje mas o continuar? 1/0");
                exit = scanner.nextInt();

            } while (exit == 1);
        }

        separador();
        System.out.println("Desea finalizar la compra? los detalles serian:");
        // Se muestran todos los detalles de la compra y se pide la confirmacion para
        // pagar
        System.out.println(boleto.getInfo());

        separador();
        System.out.println("Confirmar, escriba 1/0");
        int confirmacion = scanner.nextInt();
        
        separador();
        if (confirmacion == 1) {
            if (user.getDinero() - boleto.getValor() >= 0) {
                user.comprarBoleto(boleto);
                boleto.asignarAsiento(asiento);
                System.out.println("Boleto comprado con exito, detalles:");
            } else {
                System.out.println("Dinero insuficiente, compra cancelada.");
            }
        } else {
            System.out.println("cancelado ñao ñao");
        }
    }

    private static void separador() {
        System.out.println(". . . . . . . . . . . . .");
    }

    private static void reasignarVuelo(Usuario user) {
        // Aquí puedes poner el código que deseas ejecutar para la Reasignar vuelo.
    }

    private static void cancelarVuelo(Usuario user) {
        // Aquí puedes poner el código que deseas ejecutar para la Cancelar vuelo.
    }

    private static void verCuenta(Usuario user) {
        // Aquí puedes poner el código que deseas ejecutar para la Ver cuenta.
    }
}
