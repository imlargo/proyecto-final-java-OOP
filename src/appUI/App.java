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
        String nombre = null;
        String id = null;

        /* Espacio para iniciar sesion cargando cuenta o creando y guardando */
        separadorGrande();
        System.out.println("Registrarse");
        System.out.print("Nombre : ");
        nombre = scanner.nextLine();
        System.out.print("ID: ");
        id = scanner.nextLine();
        
        
        Usuario user = new Usuario(nombre, id);
        user.setDinero(1000);
        user.setMillas(120);

        do {
            
            separadorGrande();
            System.out.println("Menú:");
            System.out.println("1. Comprar vuelo");
            System.out.println("2. Reasignar vuelo");
            System.out.println("3. Cancelar vuelo");
            System.out.println("4. Ver cuenta");
            System.out.println("5. Salir");
            separadorGrande();

            System.out.print("> Seleccione una opción (1-5): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" - - - > Ha seleccionado la opción Comprar vuelo < - - -");
                    System.out.println("");
                    comprarVuelo(user);
                    separadorGrande();
                    break;

                case 2:
                    System.out.println(" - - - > Ha seleccionado la opción Reasignar vuelo < - - -");
                    System.out.println("");
                    reasignarVuelo(user);
                    separadorGrande();
                    break;

                case 3:
                    System.out.println(" - - - > Ha seleccionado la opción Cancelar vuelo < - - -");
                    System.out.println("");
                    cancelarVuelo(user);
                    separadorGrande();
                    break;

                case 4:
                    System.out.println(" - - - > Ha seleccionado la opción Ver cuenta < - - -");

                    verCuenta(user);
                    separadorGrande();
                    break;

                case 5:
                    System.out.println("Saliendo del programa. ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida (1-5).");
                    break;

            }

        } while (opcion != 5 && (nombre != null && id != null));
    }

    private static void comprarVuelo(Usuario user) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el origen del vuelo.
        System.out.println("Por favor ingrese el origen: ");
        String origen = scanner.nextLine();

        // Solicitar al usuario el destino del vuelo.
        System.out.println("Por favor ingrese el destino: ");
        String destino = scanner.nextLine();

        // Ingrese la cantidad de vuelos a generar?

        // Generar una lista de n vuelos con el origen y destino proporcionados.
        ArrayList<Vuelo> vuelos = Aeropuerto.generarVuelos(5, origen, destino);

        separador();

        // Mostrar información sobre los vuelos generados.
        System.out.println("#Vuelo - Origen - Destino");
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            System.out.println(vuelo.getInfo());
        }

        separador();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        System.out.println("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = scanner.nextInt();
        Vuelo vuelo = vuelos.get(indexVuelo);

        // Generar asientos VIP y económicos para el vuelo seleccionado.
        vuelo.generarAsientos(3, 5);

        // Crear un boleto para el usuario con el origen, destino y vuelo seleccionados.
        Boleto boleto = new Boleto(origen, destino, user, vuelo);
        separador();

        // Mostrar los tipos de asientos disponibles y sus precios
        System.out.println("Tipos de asientos disponibles:");

        // Mostrar información sobre los asientos disponibles en el vuelo.
        System.out.println("Asientos disponibles:");
        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            System.out.println(asiento.getInfo());
        }

        // Solicitar al usuario que seleccione un número de asiento.
        System.out.println("Por favor, seleccione el número del asiento deseado: ");
        int indexAsiento = scanner.nextInt();
        Asiento asiento = asientos.get(indexAsiento - 1);
        boleto.setAsiento(asiento);

        // Si se selecciona y es valido se prosigue...

        // Se muestra una previsualizacion del precio
        separador();
        System.out.println("Previsualizacion del precio: " + boleto.getValor());
        separador();
        System.out.println("Desea continuar?");
        // Si sí, sigue, sino, selecciona otro asiento??

        separador();

        // Preguntar al usuario si desea añadir equipaje.
        System.out.println("¿Desea añadir equipaje? (Escriba 1 para Sí, 0 para No)");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            // Cada vez q se agrega un equipaje se va mostrando una previsualizacion del
            // precio..
            // Segun la cantidad de equipaje y los precios de cada uni
            int exit = 1;
            int c = 0;

            do {
                c += 1;
                separador();
                // Solicitar información sobre el equipaje a agregar.

                System.out.print("Peso de la maleta: ");
                int peso = scanner.nextInt();

                System.out.print("Ancho de la maleta: ");
                int ancho = scanner.nextInt();

                System.out.print("Largo de la maleta: ");
                int largo = scanner.nextInt();

                System.out.print("Alto de la maleta: ");
                int alto = scanner.nextInt();

                // Agregar una maleta al boleto y mostrar el nuevo valor del boleto.
                boleto.addEquipaje(new Maleta(c, peso, largo, ancho, alto, boleto));
                System.out.println("Nuevo valor del boleto: ");
                System.out.println("-> $" + boleto.getValor());

                separador();
                System.out.println("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                exit = scanner.nextInt();

            } while (exit == 1);
        }

        // Mostrar los detalles de la compra y solicitar confirmación.
        System.out.println("¿Desea finalizar la compra? Los detalles son los siguientes:");
        System.out.println(boleto.getInfo());

        separador();
        System.out.println("Confirmar (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = scanner.nextInt();

        separador();
        if (confirmacion == 1) {
            // Comprobar si el usuario tiene suficiente dinero y, si es así, realizar la
            // compra.
            if (user.getDinero() - boleto.getValor() >= 0) {
                user.comprarBoleto(boleto);
                boleto.asignarAsiento(asiento);
                System.out.println("Boleto comprado con éxito. Detalles:");
            } else {
                System.out.println("Dinero insuficiente. Compra cancelada.");
            }
        } else {
            System.out.println("Compra cancelada.");
        }

    }

    private static void reasignarVuelo(Usuario user) {

    
    }

    private static void cancelarVuelo(Usuario user) {
        //Mostrar la lista de vuelos
        //Seleccionar el vuelo
        //Cancelarlo (Se modifica el boleto y se cambian los valores)

        Scanner scanner = new Scanner(System.in);

        ArrayList<Boleto> historial = user.getHistorial();

        System.out.println("#Vuelo - Origen - Destino");
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            System.out.println(i + "- " + boleto.getInfo());
        }
    
        separador();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        System.out.println("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = scanner.nextInt();
        Boleto boleto = historial.get(indexVuelo);
    
        // Mostrar los detalles de la compra y solicitar confirmación.
        System.out.println("Vuelo seleccionado, info:");
        System.out.println(boleto.getInfo());

        separador();
        System.out.println("Confirmar la cancelacion (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = scanner.nextInt();

        separador();
        if (confirmacion == 1) {
            //Des-asignar todo
            boleto.setStatus("Cancelado con exito");
            user.cancelarBoleto(boleto);
            Asiento asiento = boleto.getAsiento();
            asiento.desasignarBoleto();
        }
       

    }

    private static void verCuenta(Usuario user) {
        //Ver cuenta.
    	System.out.println("Estado de la cuenta");
    	separadorGrande();
    	System.out.println(user.getInfo());
    }

    private static void separador() {
        System.out.println(". . . . . . . . . . . . .");
    }

    private static void separadorGrande() {
        System.out.println("+ - - - - - - - - - - - - - - - - - +");
    }
}