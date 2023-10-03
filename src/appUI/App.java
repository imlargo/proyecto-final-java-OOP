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

        do {
            System.out.println("   Menú:");
            System.out.println("1. Comprar vuelo");
            System.out.println("2. Reasignar vuelo");
            System.out.println("3. Cancelar vuelo");
            System.out.println("4. Ver cuenta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    comprarVuelo();
                    break;

                case 2:
                    reasignarVuelo();
                    break;

                case 3:
                    cancelarVuelo();
                    break;

                case 4:
                    verCuenta();
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

    private static void comprarVuelo() {
        /*
         * Podemos ir dejando una variable local q vaya llevando los valores, puede ser
         * una instancia
         * de boleto, y al final se asigna todo, se puede usar boleto para ir calculando
         * el precio y etc
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ha seleccionado la opción Comprar vuelo");
        System.out.println("Por favor ingrese el origen: ");
        String origen = scanner.nextLine();

        System.out.println("Por favor ingrese el destino: ");
        String destino = scanner.nextLine();

        // Despues de haber creado el orgien y el destino necesito generar los vuelos y
        // mostrarlos vuelo/precio por tipo de asiento
        // Generar - Mostrar vuelos
        ArrayList<Vuelo> vuelos = Aeropuerto.generarVuelos(5); // Cantidad de vuelos

        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            // Mostrar y enumerar (En proceso)
            System.out.println("....");
            System.out.println(i);
            System.out.println(vuelo.getInfo());
        }

        System.out.println("Selecciona por favor el vuelo: ");
        int indexVuelo = scanner.nextInt();
        // Lee y genera los asientos
        Vuelo vuelo = vuelos.get(indexVuelo);
        vuelo.generarAsientos(10, 5);

        System.out.println("Los tipos de asientos disponibles son los siguientes:");
        // Primero muestra los precios de cada tipo de asiento, luego
        // Muestra los asientos disponibles y su tipo:

        System.out.println("Los asientos disponibles son los siguientes:");

        System.out.println("Seleccione el numero de asiento disponible");
        // Si se selecciona y es valido se prosigue...
        // Se muestra una previsualizacion del precio

        System.out.println("Desea continuar?");

        // Si sí, sigue, sino, selecciona otro asiento

        System.out.println("Selecciona si va a añadir equipaje o no");

        // SI la respuesta es si, entonces agrega varios equipajes, sino, no
        // Cada vez q se agrega un equipaje se va mostrando una previsualizacion del
        // precio..
        // Segun la cantidad de equipaje y los precios de cada uni

        System.out.println("Desea finalizar la compra? los detalles serian:");
        // Se muestran todos los detalles de la compra y se pide la confirmacion para
        // pagar

        // Si se confirma se efectua el pago y se asigna todo.
        // --- nota, no se asigna nada hasta q se haya pagado y verificado ---
    }

    private static void reasignarVuelo() {
        System.out.println("Ha seleccionado la opción Reasignar vuelo");
        // Aquí puedes poner el código que deseas ejecutar para la Reasignar vuelo.
    }

    private static void cancelarVuelo() {
        System.out.println("Ha seleccionado la opción Cancelar vuelo");
        // Aquí puedes poner el código que deseas ejecutar para la Cancelar vuelo.
    }

    private static void verCuenta() {
        System.out.println("Ha seleccionado la opción Ver cuenta");
        // Aquí puedes poner el código que deseas ejecutar para la Ver cuenta.
    }

}
