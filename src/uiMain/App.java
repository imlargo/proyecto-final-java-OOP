package uiMain;

import gestorAplicacion.Aerolinea.*;
import gestorAplicacion.Cuenta.*;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static GestionUsuario gestionUsuario = new GestionUsuario();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Usuario user = null;
        int opcion = 0;

        aviso("Bienvenido al programa");
        salto();
        // separador();
        // El usuario se debe serializar?

        do {
            user = gestionUsuario.getUser();

            if (user == null) {

                aviso("¡No hay sesión iniciada!");

                // Desea iniciar sesion o registrarse:
                System.out.println("1. Iniciar Sesión.");
                System.out.println("2. Registrarse.");

                opcion = scanner.nextInt();
                scanner.nextLine();

                separadorGrande();
                salto();

                switch (opcion) {
                    case 1:

                        // Iniciar sesion
                        do {
                            System.out.println("          Iniciar sesión             ");
                            salto();

                            System.out.print(" Mail: ");
                            String mail = scanner.nextLine();

                            System.out.print(" Contraseña: ");
                            String contrasena = scanner.nextLine();

                            salto(2);
                            separadorGrande();

                            user = gestionUsuario.iniciarSesion(mail, contrasena);
                            if (user == null) {
                                salto();
                                aviso("Usuario inválido, intente nuevamente");
                                salto();
                            }
                        } while (user == null);

                        salto();
                        aviso("Sesión iniciada con éxito");
                        salto();
                        break;

                    case 2:
                        // Registrar
                        do {
                            salto();
                            System.out.println("            Registrarse              ");
                            salto();

                            System.out.print(" Nombre: ");
                            String nombre = scanner.nextLine();

                            System.out.print(" Mail: ");
                            String mail = scanner.nextLine();

                            System.out.print(" Contraseña: ");
                            String contrasena = scanner.nextLine();
                            salto(2);
                            separadorGrande();

                            user = gestionUsuario.registrarUsuario(nombre, mail, contrasena);
                            if (user == null) {
                                salto();
                                aviso("El correo ya se encuentra registrado, intente nuevamente");
                                salto();
                            }
                        } while (user == null);

                        salto();
                        System.out.println("Usuario registrado con éxito");
                        salto();

                        break;

                    default:
                        user = null;
                        aviso("Opción incorrecta");
                        break;

                }

                /* Espacio para iniciar sesion cargando cuenta o creando y guardando */
            }

            while (opcion != 5 && user != null) {
                // System.out.println(user);

                System.out.println("Bienvenido " + user.getNombre());
                salto();
                separadorGrande();
                salto();
                System.out.println("                Menú                 ");
                salto();
                System.out.println(" 1. Comprar vuelo");
                System.out.println(" 2. Reasignar vuelo");
                System.out.println(" 3. Cancelar vuelo");
                System.out.println(" 4. Ver cuenta");
                System.out.println(" 5. Salir");
                salto(2);
                separadorGrande();

                System.out.print("> Seleccione una opción (1-5): ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        salto();
                        System.out.println(" - - - > Ha seleccionado la opción Comprar vuelo < - - -");
                        salto();
                        comprarVuelo(user);
                        separadorGrande();
                        break;

                    case 2:
                        salto();
                        System.out.println(" - - - > Ha seleccionado la opción Reasignar vuelo < - - -");
                        salto();
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
                        salto();
                        gestionCuenta(user);
                        user = gestionUsuario.getUser();
                        separadorGrande();
                        break;

                    case 5:
                        System.out.println("Saliendo del programa. ¡Adios!");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida (1-5).");
                        break;

                }
            }

        } while (true);

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
        ArrayList<Vuelo> vuelos = Vuelo.generarVuelos(5, origen, destino);

        separador();
        salto();

        // Mostrar información sobre los vuelos generados.
        System.out.println("#Vuelo - Origen - Destino");
        salto();
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            System.out.println(vuelo.getInfo());
        }

        salto();
        separador();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        System.out.println("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = scanner.nextInt();
        Vuelo vuelo = vuelos.get(indexVuelo);

        // Generar asientos VIP y económicos para el vuelo seleccionado.
        vuelo.generarAsientos(3, 5, 100);

        // Crear un boleto para el usuario con el origen, destino y vuelo seleccionados.
        Boleto boleto = new Boleto(origen, destino, user, vuelo);
        separador();

        // Mostrar los tipos de asientos disponibles y sus precios
        // System.out.println("Tipos de asientos disponibles:");

        // Mostrar información sobre los asientos disponibles en el vuelo.
        salto();
        System.out.println("   Asientos disponibles");
        salto();
        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            System.out.println(asiento.getInfo());
        }

        // Solicitar al usuario que seleccione un número de asiento.
        salto();
        System.out.println("Por favor, seleccione el número del asiento deseado: ");
        int indexAsiento = scanner.nextInt();
        Asiento asiento = asientos.get(indexAsiento - 1);
        boleto.setAsiento(asiento);

        // Si se selecciona y es valido se prosigue...

        // Se muestra una previsualizacion del precio
        separador();
        System.out.println("Previsualización del precio: " + boleto.getValor());
        separador();
        System.out.println("¿Desea continuar?");
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
                Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                maleta.asignarBoleto(boleto);
                boleto.addEquipaje(maleta);
                separador();
                System.out.println("Nuevo valor del boleto: ");
                System.out.println("-> $" + boleto.getValor());

                separador();
                System.out.println("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                exit = scanner.nextInt();

            } while (exit == 1);
        }

        // Mostrar los detalles de la compra y solicitar confirmación.
        salto();
        System.out.println("¿Desea finalizar la compra? Los detalles son los siguientes:");
        salto();
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
                salto();
                System.out.println("Boleto comprado con éxito. Detalles:");
                salto();
            } else {
                salto();
                System.out.println("Dinero insuficiente. Compra cancelada.");
                salto();
            }
        } else {
            salto();
            System.out.println("Compra cancelada.");
            salto();
        }

    }

    private static void reasignarVuelo(Usuario user) {
        Scanner scanner = new Scanner(System.in);

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        System.out.println("Información de los vuelos:");
        salto();

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            System.out.println(i + " - " + boleto.getInfo());
        }

        salto();
        separador();
        salto();

        System.out.println("Por favor, seleccione el número del vuelo deseado: ");
        int indexVueloTemp = scanner.nextInt();

        // Obtener el boleto seleccionado por el usuario
        Boleto boletoSelec = historial.get(indexVueloTemp);

        System.out.println("Vuelo seleccionado, información detallada:");
        salto();
        System.out.println(boletoSelec.getInfo());

        salto();
        separador();
        salto();

        System.out.println("Está seguro de reasignar el vuelo? (Escriba 1 para Confirmar, 0 para Cancelar):");
        int confirmacionTemp = scanner.nextInt();

        if (confirmacionTemp == 1) {
            // Limpiar
            boletoSelec.resetEquipaje();
            Asiento asientoPrevio = boletoSelec.getAsiento();
            asientoPrevio.desasignarBoleto();
            user.reasignarBoleto(boletoSelec);
            boletoSelec.resetEquipaje();
            // - - - - - - - -
        } else {
            System.out.println("Proceso cancelado, hasta luego!");
            return;

        }
        // Solicitar al usuario el origen del vuelo.
        String origen = boletoSelec.getOrigen();
        System.out.println("Origen: " + origen);

        // Solicitar al usuario el destino del vuelo.
        String destino = boletoSelec.getDestino();
        System.out.println("Destino: " + destino);

        // Ingrese la cantidad de vuelos a generar?

        // Generar una lista de n vuelos con el origen y destino proporcionados.
        ArrayList<Vuelo> vuelos = Vuelo.generarVuelos(5, origen, destino);

        separador();
        salto();

        // Mostrar información sobre los vuelos generados.
        System.out.println("#Vuelo - Origen - Destino");// Por mejorar
        salto();
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            System.out.println(vuelo.getInfo());
        }

        salto(2);
        separador();
        salto();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        System.out.println("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = scanner.nextInt();
        Vuelo vuelo = vuelos.get(indexVuelo);

        // Generar asientos VIP y económicos para el vuelo seleccionado.
        vuelo.generarAsientos(3, 5, 100);

        // Crear un boleto para el usuario con el origen, destino y vuelo seleccionados.
        boletoSelec.setVuelo(vuelo);
        separador();

        // Mostrar los tipos de asientos disponibles y sus precios
        // System.out.println("Tipos de asientos disponibles:");

        // Mostrar información sobre los asientos disponibles en el vuelo.
        salto();
        System.out.println("   Asientos disponibles:");
        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            System.out.println(asiento.getInfo());
        }

        // Solicitar al usuario que seleccione un número de asiento.
        salto(2);
        System.out.println("Por favor, seleccione el número del asiento deseado: ");
        int indexAsiento = scanner.nextInt();
        Asiento asiento = asientos.get(indexAsiento - 1);
        boletoSelec.reasignarAsiento(asiento);

        // Si se selecciona y es valido se prosigue...

        // Se muestra una previsualizacion del precio
        separador();
        System.out.println(
                "Previsualización del precio: " + boletoSelec.getValor() + " ,se agregará un recargo extra del 10%");
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
                Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                maleta.asignarBoleto(boletoSelec);
                boletoSelec.addEquipaje(maleta);

                System.out.println("Nuevo valor del boleto: ");
                System.out.println("-> $" + boletoSelec.getValor());

                separador();
                System.out.println("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                exit = scanner.nextInt();

            } while (exit == 1);
        }

        // Mostrar los detalles de la compra y solicitar confirmación.
        System.out.println("¿Desea finalizar la compra? Los detalles son los siguientes:");
        System.out.println(boletoSelec.getInfo());

        separador();
        System.out.println("Confirmar (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = scanner.nextInt();

        separador();
        if (confirmacion == 1) {
            // Comprobar si el usuario tiene suficiente dinero y, si es así, realizar la
            // compra.
            if (user.getDinero() - boletoSelec.getValor() >= 0) {
                user.comprarBoleto(boletoSelec);
                boletoSelec.setStatus("Reasignado");
                boletoSelec.asignarAsiento(asiento);
                System.out.println("Boleto comprado con éxito. Detalles:");
            } else {
                System.out.println("Dinero insuficiente. Compra cancelada.");
            }
        } else {
            System.out.println("Compra cancelada.");
        }

    }

    private static void cancelarVuelo(Usuario user) {
        // Mostrar la lista de vuelos
        // Seleccionar el vuelo
        // Cancelarlo (Se modifica el boleto y se cambian los valores)

        Scanner scanner = new Scanner(System.in);

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        System.out.println("Información de los vuelos:");
        salto();

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            System.out.println(i + " - " + boleto.getInfo());
        }

        salto();
        separador();
        salto();

        System.out.println("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = scanner.nextInt();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        System.out.println("Vuelo seleccionado, información detallada:");
        salto();
        System.out.println(boleto.getInfo());

        separador();

        System.out.println("Confirmar la cancelación (Escriba 1 para Confirmar, 0 para Cancelar):");
        int confirmacion = scanner.nextInt();

        separadorGrande();
        salto();

        if (confirmacion == 1) {
            // Realizar la cancelación del boleto
            boleto.setStatus("Cancelado");
            user.cancelarBoleto(boleto);
            Asiento asiento = boleto.getAsiento();
            asiento.desasignarBoleto();
            // Informar al usuario sobre la cancelación exitosa
            System.out.println("La cancelación se ha realizado con éxito.");
            salto();
        }

    }

    private static void gestionCuenta(Usuario user) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Boleto> historial = user.getHistorial();

        // Ver cuenta.
        separadorGrande();
        salto();
        System.out.println("¿Qué desea hacer?");
        salto();
        /*
         * Cerrar sesion e iniciar con una nueva
         * volver al menu
         * canjear millas
         * Check in
         */

        int opcion;
        do {

            // System.out.println("Menu");
            System.out.println("1. Ver informacion de la cuenta");
            System.out.println("2. Ver historial de vuelos");
            System.out.println("3. Hacer check-in");
            System.out.println("4. Canjear millas");
            System.out.println("5. Cerrar sesión");
            System.out.println("6. Volver al menú anterior");
            salto();
            System.out.print("> Seleccione una opción (1-6): ");
            opcion = scanner.nextInt();
            salto();

            // Imprimir las opciones

            switch (opcion) {
                case 1:
                    // Ver informacion de la cuenta
                    System.out.println("Estado de la cuenta");
                    salto();
                    separadorGrande();
                    salto();
                    System.out.println(user.getInfo());
                    // Agregar opcion para ver vuelos?

                    salto();

                    break;

                case 2:
                    // Ver historial de vuelos
                    System.out.println("Información de los vuelos:");

                    // Iterar a través del historial de boletos
                    for (int i = 0; i < historial.size(); i++) {
                        Boleto boleto = historial.get(i);
                        // Mostrar información de cada boleto en la lista
                        System.out.println(i + " - " + boleto.getInfo());
                    }

                    break;

                case 3:
                    // hacer check-in

                    break;

                case 4:
                    // Canjear millas
                    System.out.println("Canjear millas");
                    System.out.println("En este momento ustede posee n millas que equivalen a:");
                    System.out.println("Desea confirmar?");
                    System.out.println("Canjeado con éxito, n millas a m dinero, cuenta total: total");

                    break;

                case 5:
                    // Cerrar sesion
                    System.out.println("Cerrando sesión");
                    salto();
                    user = gestionUsuario.cerrarSesion(user);
                    opcion = 6;
                    break;

                case 6:
                    salto();
                    aviso("¡Volviendo al menu!");
                    salto();
                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 6);
    }


    private static void checkin(Usuario user) {
        // Mostrar la lista de vuelos
        // Seleccionar el vuelo
        // Cancelarlo (Se modifica el boleto y se cambian los valores)

        Scanner scanner = new Scanner(System.in);

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        System.out.println("Información de los vuelos:");

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            System.out.println(i + " - " + boleto.getInfo());
        }

        separador();

        System.out.println("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = scanner.nextInt();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        System.out.println("Vuelo seleccionado, información detallada:");
        System.out.println(boleto.getInfo());

        separador();

        System.out.println("Confirma el check-in? (Escriba 1 para Confirmar, 0 para Cancelar):");
        int confirmacion = scanner.nextInt();

        separador();

        if (confirmacion == 1) {
            // Realizar la cancelación del boleto
            boleto.setStatus("Confirmado");

            // Informar al usuario sobre la cancelación exitosa
            System.out.println("Realizado con éxito.");
        }
    }

    // Estetica
    private static void separador() {
        System.out.println(". . . . . . . . . . . . . . . . . . . . .");
    }

    private static void separadorGrande() {
        System.out.println("+ - - - - - - - - - - - - - - - - - +");
    }

    private static void salto() {
        System.out.print("\n");
    }

    private static void salto(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
        }
    }

    private static void aviso(String text) {
        System.out.println("> > > " + text + " < < <");
    }
}