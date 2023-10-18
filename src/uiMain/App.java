package uiMain;

import gestorAplicacion.Aerolinea.*;
import gestorAplicacion.Cuenta.*;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static GestionUsuario gestionUsuario = new GestionUsuario();

    public static void main(String[] args) {

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
                identacion("1. Iniciar Sesión.");
                identacion("2. Registrarse.");

                opcion = inputI();

                separadorGrande();
                salto();

                switch (opcion) {

                    case 1:

                        // Iniciar sesion
                        do {
                            identacion("Iniciar sesión", 4);
                            salto();

                            System.out.println("Mail: ");
                            String mail = inputS();

                            System.out.println("Contraseña: ");
                            String contrasena = inputS();

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
                        titulo("Bienvenido " + user.getNombre() + ":)");
                        salto();

                        continuar();
                        break;
                    case 2:
                        // Registrar
                        do {
                            salto();
                            identacion("Registrarse", 4);
                            salto();

                            System.out.println("Nombre: ");
                            String nombre = inputS();

                            System.out.println("Mail: ");
                            String mail = inputS();

                            System.out.println("Contraseña: ");
                            String contrasena = inputS();
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
                        titulo("Bienvenido " + user.getNombre() + ":)");
                        salto();

                        continuar();
                        break;

                    default:
                        user = null;
                        aviso("Opción incorrecta");
                        break;

                }

                /* Espacio para iniciar sesion cargando cuenta o creando y guardando */
            }

            while (opcion != 6 && user != null) {
                // System.out.println(user);
                separadorGrande();
                salto();
                identacion("Menú", 4);
                salto();
                identacion("1. Comprar vuelo");
                identacion("2. Reasignar vuelo");
                identacion("3. Cancelar vuelo");
                identacion("4. Ver cuenta");
                identacion("5. Check in");
                identacion("6. Salir");
                salto(2);
                separador();

                prompt("Seleccione una opción (1-5): ");
                opcion = inputI();

                switch (opcion) {
                    case 1:
                        salto();
                        System.out.println(" - - - > Ha seleccionado la opción Comprar vuelo < - - -");
                        salto();

                        separadorGrande();
                        comprarVuelo(user);
                        separadorGrande();
                        break;

                    case 2:
                        salto();
                        System.out.println(" - - - > Ha seleccionado la opción Reasignar vuelo < - - -");
                        salto();

                        separadorGrande();
                        reasignarVuelo(user);
                        separadorGrande();
                        break;

                    case 3:
                        System.out.println(" - - - > Ha seleccionado la opción Cancelar vuelo < - - -");
                        salto();
                        separadorGrande();
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
                        System.out.println(" - - - > Ha seleccionado la opción Check-in < - - -");
                        salto();
                        user = gestionUsuario.getUser();
                        separadorGrande();
                        checkin(user);
                        separadorGrande();
                        user = gestionUsuario.getUser();

                        break;

                    case 6:
                        System.out.println("Saliendo del programa. ¡Adios!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida (1-5).");
                        break;

                }
            }

        } while (true);

    }

    private static void comprarVuelo(Usuario user) {

        // Solicitar al usuario el origen del vuelo.
        prompt("Por favor ingrese el origen: ");
        String origen = inputS();

        // Solicitar al usuario el destino del vuelo.
        prompt("Por favor ingrese el destino: ");
        String destino = inputS();

        // Ingrese la cantidad de vuelos a generar?

        // Generar una lista de n vuelos con el origen y destino proporcionados.
        ArrayList<Vuelo> vuelos = Vuelo.generarVuelos(5, origen, destino);

        separador();
        salto();

        // Mostrar información sobre los vuelos generados.
        identacion("Vuelo - Origen - Destino");
        salto();
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            identacion(vuelo.getInfo(), 2);
        }

        salto();
        separador();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        prompt("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = inputI();
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
        identacion("Asientos disponibles");
        salto();
        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            identacion(asiento.getInfo(), 2);
        }

        // Solicitar al usuario que seleccione un número de asiento.
        salto();
        prompt("Por favor, seleccione el número del asiento deseado: ");
        int indexAsiento = inputI();
        Asiento asiento = asientos.get(indexAsiento - 1);
        boleto.setAsiento(asiento);

        // Si se selecciona y es valido se prosigue...

        // Se muestra una previsualizacion del precio
        separador();
        System.out.println("Previsualización del precio: " + boleto.getValor());
        separador();

        continuar();
        // Si sí, sigue, sino, selecciona otro asiento??

        separador();

        // Preguntar al usuario si desea añadir equipaje.
        prompt("¿Desea añadir equipaje? (Escriba 1 para Sí, 0 para No)");
        int opcion = inputI();

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

                prompt("Peso de la maleta: ");
                int peso = inputI();

                prompt("Ancho de la maleta: ");
                int ancho = inputI();

                prompt("Largo de la maleta: ");
                int largo = inputI();

                prompt("Alto de la maleta: ");
                int alto = inputI();

                // Agregar una maleta al boleto y mostrar el nuevo valor del boleto.
                Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                maleta.asignarBoleto(boleto);
                boleto.addEquipaje(maleta);
                separador();
                System.out.println("Nuevo valor del boleto: ");
                System.out.println("-> $" + boleto.getValor());

                separador();
                prompt("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                exit = inputI();

            } while (exit == 1);
        }

        // Mostrar los detalles de la compra y solicitar confirmación.
        salto();
        prompt("¿Desea finalizar la compra? Los detalles son los siguientes:");
        salto();
        identacion(boleto.getInfo());

        separador();

        prompt("Confirmar (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = inputI();

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

                salto();
                System.out.println("Informacion y detalles:");
                identacion(boleto.getInfo());
                continuar();
                // Mostrar los detalles del vuelo
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

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        identacion("Información de los vuelos:");
        salto();

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            identacion(i + ". " + boleto.getInfo(), 2);
        }

        salto();
        separador();
        salto();

        prompt("Por favor, seleccione el número del vuelo deseado: ");
        int indexVueloTemp = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boletoSelec = historial.get(indexVueloTemp);

        System.out.println("Vuelo seleccionado, información detallada:");
        salto();
        identacion(boletoSelec.getInfo());

        salto();
        separador();
        salto();

        prompt("Está seguro de reasignar el vuelo? (Escriba 1 para Confirmar, 0 para Cancelar):");
        int confirmacionTemp = inputI();

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
        identacion("Origen: " + origen);

        // Solicitar al usuario el destino del vuelo.
        String destino = boletoSelec.getDestino();
        identacion("Destino: " + destino);

        // Ingrese la cantidad de vuelos a generar?

        // Generar una lista de n vuelos con el origen y destino proporcionados.
        ArrayList<Vuelo> vuelos = Vuelo.generarVuelos(5, origen, destino);

        separador();
        salto();

        // Mostrar información sobre los vuelos generados.
        identacion("Vuelo - Origen - Destino");// Por mejorar
        salto();
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            identacion(vuelo.getInfo(), 2);
        }

        salto(2);
        separador();
        salto();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        prompt("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = inputI();
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
        identacion("Asientos disponibles:");
        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            identacion(asiento.getInfo(), 2);
        }

        // Solicitar al usuario que seleccione un número de asiento.
        salto(2);
        prompt("Por favor, seleccione el número del asiento deseado: ");
        int indexAsiento = inputI();
        Asiento asiento = asientos.get(indexAsiento - 1);
        boletoSelec.reasignarAsiento(asiento);

        // Si se selecciona y es valido se prosigue...

        // Se muestra una previsualizacion del precio
        separador();
        System.out.println(
                "Previsualización del precio: " + boletoSelec.getValor() + " ,se agregará un recargo extra del 10%");
        separador();

        // Preguntar al usuario si desea añadir equipaje.
        prompt("¿Desea añadir equipaje? (Escriba 1 para Sí, 0 para No)");
        int opcion = inputI();

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

                prompt("Peso de la maleta: ");
                int peso = inputI();

                prompt("Ancho de la maleta: ");
                int ancho = inputI();

                prompt("Largo de la maleta: ");
                int largo = inputI();

                prompt("Alto de la maleta: ");
                int alto = inputI();

                // Agregar una maleta al boleto y mostrar el nuevo valor del boleto.
                Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                maleta.asignarBoleto(boletoSelec);
                boletoSelec.addEquipaje(maleta);

                System.out.println("Nuevo valor del boleto: ");
                identacion("-> $" + boletoSelec.getValor());

                separador();
                prompt("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                exit = inputI();

            } while (exit == 1);
        }

        // Mostrar los detalles de la compra y solicitar confirmación.
        prompt("¿Desea finalizar la compra? Los detalles son los siguientes:");
        identacion(boletoSelec.getInfo());

        separador();
        prompt("Confirmar (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = inputI();

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

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        identacion("Información de los vuelos:");
        salto();

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            identacion(i + ". " + boleto.getInfo(), 2);
        }

        salto();
        separador();
        salto();

        prompt("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        separador();
        System.out.println("Vuelo seleccionado, información detallada:");
        salto();
        identacion(boleto.getInfo());

        separador();

        prompt("Confirmar la cancelación (Escriba 1 para Confirmar, 0 para Cancelar):");
        int confirmacion = inputI();

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
        ArrayList<Boleto> historial = user.getHistorial();

        // Ver cuenta.
        separadorGrande();
        salto();
        prompt("¿Qué desea hacer?");
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
            identacion("1. Ver informacion de la cuenta");
            identacion("2. Ver historial de vuelos");
            identacion("3. Canjear millas");
            identacion("4. Cerrar sesión");
            identacion("5. Volver al menú anterior");
            salto();
            prompt("> Seleccione una opción (1-5): ");
            opcion = inputI();
            salto();

            // Imprimir las opciones

            switch (opcion) {
                case 1:
                    // Ver informacion general de la cuenta
                    System.out.println("Estado de la cuenta");
                    salto();
                    separadorGrande();
                    salto();
                    System.out.println(user.getInfo());
                    salto();
                    separadorGrande();

                    salto();
                    continuar();
                    salto();

                    break;

                case 2:
                    // Ver historial de vuelos y visualizar informacion (Casi Listo)
                    salto();
                    identacion("Información de los vuelos:");

                    // Iterar a través del historial de boletos
                    for (int i = 0; i < historial.size(); i++) {
                        Boleto boleto = historial.get(i);
                        // Mostrar información de cada boleto en la lista
                        identacion(i + ". " + boleto.getInfo(), 2);
                    }

                    salto();
                    continuar();
                    salto();

                    break;

                case 3:
                    // Canjear millas
                    canjearMillas(user);
                    break;

                case 4:
                    // Cerrar sesion (Listo)
                    aviso("Cerrando sesión");
                    salto();
                    user = gestionUsuario.cerrarSesion(user);
                    opcion = 5;
                    break;

                case 5:
                    // Volver al menu (Listo)
                    salto();
                    aviso("¡Volviendo al menu!");
                    salto();
                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 5);
    }

    private static void checkin(Usuario user) {
        // Mostrar la lista de vuelos
        // Seleccionar el vuelo
        // Cancelarlo (Se modifica el boleto y se cambian los valores)

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        salto();
        System.out.println("Información de los vuelos:");

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            identacion(i + ". " + boleto.getInfo());
        }
        salto();

        prompt("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        separador();
        salto();

        identacion("Vuelo seleccionado, información detallada:");
        identacion(boleto.getInfo(), 2);

        Asiento asiento = boleto.getAsiento();
        identacion("Informacion de su asiento:");
        identacion(asiento.getInfo(), 2);

        salto();
        continuar();
        separador();

        // Upgrate de asiento
        //
        prompt("Desea cambiar o hacer un upgrate a su asiento? (1 si, 0 no)");
        int confirmacion = inputI();

        if (confirmacion == 1) {
            // Mejorar asiento

            salto();

            System.out.println("Informacion de su asiento:");
            identacion(asiento.getInfo());

            salto();

            // Hacer asiento vip o hacer cosas adicionales
            prompt("Desea pasarse a asiento Vip?");
            confirmacion = inputI();

            if (confirmacion == 1) {
                // Mostrar asientos disponibles y permitir seleccionar el nuevo asiento vip

                ArrayList<Asiento> asientos = (boleto.getVuelo()).getAsientos();

                for (Asiento asientoTemp : asientos) {
                    if (asientoTemp.getTipo().equals("Vip")) {
                        identacion(asientoTemp.getInfo(), 2);
                    }
                }

                salto();
                prompt("Por favor, seleccione el número del asiento deseado: ");
                int indexAsiento = inputI();
                // ... Cmabiar y reasignar todo

                Asiento newAsiento = asientos.get(indexAsiento - 1);
                boleto.upgradeAsiento(asiento, newAsiento);
                // Maletas y equoaje
            }

        }

        System.out.println("Confirma el check-in? (Escriba 1 para Confirmar, 0 para Cancelar):");
        confirmacion = inputI();

        separador();

        if (confirmacion == 1) {
            // Realizar la cancelación del boleto
            boleto.setStatus("Confirmado");

            // Informar al usuario sobre la cancelación exitosa
            System.out.println("Realizado con éxito.");
        } else {
            return;
        }

        // Despues de hacer el check in se le da al usuario la opcion de agregar mas
        // cosas

        prompt("Le gustaria agregar servicios adicionales?");

        // Que servicios adicionales se podrian pensar?

        prompt("Agregar comida, 0 - 1");

        int exit;

        int alimento;
        int cantidad;
        do {

            if (asiento.getTipo().equals("Vip")) {

                // Cliente vip deberia tener mas beneficios
                /*
                 * Almuerzo
                 * Vino
                 * Tines
                 * Tales
                 * 
                 */

                prompt("Selecciona una opcion:");
                alimento = inputI();

                prompt("Cantidad:");
                cantidad = inputI();

                switch (alimento) {
                    case 1:
                        // Crea isntancia del alimento
                        // Se la asigna al array de los alimentos en boleto
                        // Le asigna el boleto a cada alimento y el nombre del usuario
                        // El menu va asociado a un solo usuario, boleto y asiento q tiene alimentacion

                        break;

                    default:
                        break;
                }

                prompt("Desea agregar mas o continuar? (1 mas - 0 salir)");
                exit = inputI();

            } else {

                // LO mismo de arriba pero sin tnatos beneficios

                prompt("Desea agregar mas o continuar? (1 mas - 0 salir)");
                exit = inputI();
            }

        } while (exit != 0);

        // Alimentacion: menu de compas
        // Definir productos y precios
        // mostrar informacion de confirmacion

        separadorGrande();
        salto();

        System.out.println("Completado con exito, informacion detallada:");
        salto();

        identacion("Informacion del Vuelo");
        identacion(boleto.getInfo(), 2);
        salto();

        identacion("Informacion del asiento");
        identacion(asiento.getInfo(), 2);
        salto();

        identacion("Informacion adicional");
        identacion("null", 2);
        salto();

        continuar();
    }

    private static void canjearMillas(Usuario user) {

        /*
         * Saludar al usuario
         * Le dices q tiene n millas
         * - Descuentos
         * - Mejoras de silla (upgrates)
         * - Comida, cupon para x comidas
         */

        /*
         * Requerimientos (Backend).
         * CLases para la comida (inferfaz de clase)
         * Asignar los descuentos al usuario (arraylist)
         * Cupones de cierto tipo, para cada cosa, descuentos, mejoras de sulla,
         * comida,comida en si (derecho a un almuerzo)
         * Todo eso se asigna tambien al boleto y a la silla y debe ir de la mano con la
         * funcionalidad checkin
         * Cada descuento puede ser una sublclasse de un descuento, quye al momento de
         * ejecutar el metodo sobreescrito aplicar descuento, dependiendo del tiepo
         * Se haga x o y procedimien.
         */

        /*
         * Por hacer:
         * crear diferentes tipos de descuentos en una clase abstracta q implementen
         * diferentes metodos "".aplicar()"
         * Descuentos en upgrade de asiento
         * Descuentos al momento de comprar
         * Descuento al momento de pagar comida
         * Comida en si, por ejemplo un cupon para un almuerzo
         */

         /*Implementar clase abstracta o interfaz para comidas y como integrarlo con el usuario */


        System.out.println(" - - - > Ha seleccionado la opción Canjear millas < - - -");
        salto();
        separadorGrande();
        salto();
        identacion("Hola " + colorTexto(user.getNombre()), 3);
        salto();
        identacion("En este momento usted posee " + user.getMillas() + " millas");
        salto();
        prompt("Escoja en lo que desea canjear sus millas");
        salto();
        int opcion;

        do {

            // System.out.println("Menu");
            identacion("1. Mejora de silla");
            identacion("2. Cupón para comida");
            identacion("3. Descuento vuelo");
            identacion("4. Descuento maleta");
            identacion("5. Volver al menú anterior");
            salto();
            prompt("> Seleccione una opción (1-5): ");
            opcion = inputI();
            salto();

            // Imprimir las opciones

            switch (opcion) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 5);

        System.out.println("Canjeado con éxito, n millas a m dinero, cuenta total: total");
    }


    // Estetica
    private static void separador() {
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
    }

    private static void separadorGrande() {
        System.out.println("+ = = = = = = = = = = = = = = = = = = = = = = = +");
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

    private static void identacion(String text, int n) {
        String cadena = "";
        for (int i = 0; i < n; i++) {
            cadena += "    ";
        }
        System.out.println(cadena + text);
    }

    private static void identacion(String text) {
        System.out.println("    " + text);
    }

    private static void titulo(String text) {
        System.out.println("# = = = " + text + " = = = #");
    }

    private static void prompt(String text) {
        System.out.println("> " + text);
    }

    private static String inputS() {
        System.out.print("  > ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // scanner.close();
        return s;
    }

    private static int inputI() {
        System.out.print("  > ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    private static void continuar() {
        prompt("Presione enter para continuar");
        System.out.print("  >_");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
    }

    public static String colorTexto(String text) {
        // , String color
        // Códigos ANSI para colores
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_WHITE = "\u001B[37m";

        // Mensajes con colores
        return ANSI_GREEN + text + ANSI_RESET;
        /*
         * System.out.println(ANSI_GREEN + text+ ANSI_RESET);
         * System.out.println(ANSI_YELLOW + text + ANSI_RESET);
         */
    }

}

// SI el usuario ya hizo check in no puede reasignar, solo cancelar y se pierde

/*
 * Canejar millas por mejorar tipo de sillas y descuento en la maleta y comida
 * alimenacion, con una clase abstracta y un menu q se le asigna una cantidad x
 * de alimentos
 */
