package uiMain;

import static uiMain.Estetica.*;
import gestorAplicacion.Aerolinea.*;
import gestorAplicacion.Alimentos.Comida;
import gestorAplicacion.Cuenta.*;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static GestionUsuario gestionUsuario = new GestionUsuario();

    public static void main(String[] args) {

        Usuario user = null;
        int opcion = 0;

        aviso(negrita(colorTexto("Bienvenido al programa", "morado")));
        salto();
        // separador();
        // El usuario se debe serializar?

        do {
            user = gestionUsuario.getUser();

            if (user == null) {

                aviso(colorTexto("¡No hay sesión iniciada!", "rojo"));

                // Desea iniciar sesion o registrarse:
                identacion("1. Iniciar Sesión.");
                identacion("2. Registrarse.");
                identacion("3. Salir.");
                opcion = inputI();

                separadorGrande();

                switch (opcion) {

                    case 1:

                        // Iniciar sesion
                        int intentos = 0;
                        do {
                            identacion(negrita(colorTexto("Iniciar sesión", "morado")), 4);
                            salto();

                            printNegrita("Mail:");
                            String mail = inputS();

                            printNegrita("Contraseña:");
                            String contrasena = inputS();

                            separadorGrande();

                            user = gestionUsuario.iniciarSesion(mail, contrasena);
                            if (user == null) {
                                salto();
                                aviso(colorTexto("Usuario inválido o no existe, intente nuevamente", "rojo"));
                                salto();
                                intentos++;
                            }

                        } while (user == null && intentos < 3);

                        if (intentos >= 3) {
                            break;
                        }

                        salto();
                        aviso(colorTexto("Sesión iniciada con éxito", "verde"));
                        salto();
                        titulo(colorTexto(("Bienvenido " + user.getNombre() + " :)"), "morado"));
                        salto();

                        continuar();
                        break;
                    case 2:
                        // Registrar
                        salto();
                        identacion(negrita(colorTexto("Registrarse", "morado")), 4);
                        salto();

                        printNegrita("Nombre:");
                        String nombre = inputS();

                        printNegrita("Mail:");
                        String mail = inputS();

                        printNegrita("Contraseña:");
                        String contrasena = inputS();
                        
                        separadorGrande();

                        user = gestionUsuario.registrarUsuario(nombre, mail, contrasena);
                        if (user == null) {
                            salto();
                            aviso(colorTexto("El correo ya se encuentra registrado", "rojo"));
                            salto();
                            break;
                        }

                        salto();
                        System.out.println(colorTexto("Usuario registrado con éxito", "verde"));
                        salto();
                        titulo(colorTexto(("Bienvenido " + user.getNombre() + ":)"), "morado"));
                        salto();

                        continuar();
                        break;

                    case 3:
                        System.out.println(colorTexto("Saliendo del programa. ¡Adios!", "morado"));
                        separadorGrande();
                        System.exit(0);

                    default:
                        user = null;
                        aviso(colorTexto("Opción incorrecta", "rojo"));
                        break;

                }

                /* Espacio para iniciar sesion cargando cuenta o creando y guardando */
            }

            while (opcion != 6 && user != null) {
                // System.out.println(user);
                separadorGrande();

                identacion(negrita(colorTexto("> - Menú - <", "morado")), 4);
                salto();
                identacion("1. Comprar vuelo");
                identacion("2. Reasignar vuelo");
                identacion("3. Cancelar vuelo");
                identacion("4. Ver cuenta");
                identacion("5. Check in");
                identacion("6. Salir");
                separador();

                promptOut("Seleccione una opción (1-5): ");
                opcion = inputI();

                switch (opcion) {
                    case 1:
                        salto();
                        seleccionado("Comprar vuelo");
                        separadorGrande();
                        comprarVuelo(user);
                        separadorGrande();
                        break;

                    case 2:
                        salto();
                        seleccionado("Reasignar vuelo");
                        separadorGrande();
                        reasignarVuelo(user);
                        separadorGrande();
                        break;

                    case 3:
                        seleccionado("Cancelar vuelo");
                        separadorGrande();
                        cancelarVuelo(user);
                        separadorGrande();
                        break;

                    case 4:
                        seleccionado("Gestion de cuenta");
                        separadorGrande();
                        gestionCuenta(user);
                        user = gestionUsuario.getUser();
                        separadorGrande();
                        break;

                    case 5:
                        seleccionado("Check in");
                        user = gestionUsuario.getUser();
                        separadorGrande();
                        checkin(user);
                        separadorGrande();
                        user = gestionUsuario.getUser();
                        break;

                    case 6:
                        separadorGrande();
                        System.out.println(negrita(colorTexto("Saliendo del programa. ¡Adios!", "morado")));
                        System.exit(0);

                    default:
                        System.out.println(colorTexto("Opción no válida. Por favor, seleccione una opción válida (1-5).", "rojo"));
                        break;

                }
            }

        } while (true);

    }

    private static void comprarVuelo(Usuario user) {

        // Solicitar al usuario el origen del vuelo.
        promptIn("Por favor ingrese el origen: ");
        String origen = inputS();

        // Solicitar al usuario el destino del vuelo.
        promptIn("Por favor ingrese el destino: ");
        String destino = inputS();

        // Ingrese la cantidad de vuelos a generar?

        // Generar una lista de n vuelos con el origen y destino proporcionados.
        ArrayList<Vuelo> vuelos = Vuelo.generarVuelos(5, origen, destino);

        separador();

        // Mostrar información sobre los vuelos generados.
        identacion("Vuelo - Origen - Destino");
        salto();
        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            identacion(vuelo.getInfo(), 2);
        }

        separador();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        promptIn("Por favor, seleccione el número del vuelo deseado: ");
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
        identacion(colorTexto("Asientos disponibles", "morado"));
        salto();

        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            identacion(asiento.getInfo(), 2);
        }

        // Solicitar al usuario que seleccione un número de asiento.
        salto();
        promptIn("Por favor, seleccione el número del asiento deseado: ");
        int indexAsiento = inputI();
        Asiento asiento = asientos.get(indexAsiento - 1);
        boleto.setAsiento(asiento);

        // Si se selecciona y es valido se prosigue...

        // Se muestra una previsualizacion del precio
        separador();
        System.out.println("Previsualización del precio: " + colorTexto(("$" + boleto.getValor()), "verde"));
        salto();
        continuar();
        // Si sí, sigue, sino, selecciona otro asiento??

        separador();

        // Preguntar al usuario si desea añadir equipaje.
        promptIn("¿Desea añadir equipaje? (Escriba 1 para Sí, 0 para No)");
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

                promptIn("Peso de la maleta: ");
                int peso = inputI();

                promptIn("Ancho de la maleta: ");
                int ancho = inputI();

                promptIn("Largo de la maleta: ");
                int largo = inputI();

                promptIn("Alto de la maleta: ");
                int alto = inputI();

                // Agregar una maleta al boleto y mostrar el nuevo valor del boleto.
                Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                maleta.asignarBoleto(boleto);
                boleto.addEquipaje(maleta);

                separador();

                System.out.println(negrita(colorTexto("Nuevo valor del boleto:", "morado")));
                System.out.println(negrita(colorTexto("-> $" + boleto.getValor(), "verde")));
                salto();
                promptIn("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                exit = inputI();

            } while (exit == 1);
        }

        // Mostrar los detalles de la compra y solicitar confirmación.
        separadorGrande();
        promptOut("¿Desea finalizar la compra? Los detalles son los siguientes:");
        salto();

        identacion(boleto.getInfo());
        separadorGrande();

        promptIn("Confirmar (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = inputI();

        separadorGrande();

        if (confirmacion == 1) {
            // Comprobar si el usuario tiene suficiente dinero y, si es así, realizar la
            // compra.
            if (user.getDinero() - boleto.getValor() >= 0) {
                user.comprarBoleto(boleto);
                boleto.asignarAsiento(asiento);

                System.out.println(negrita(colorTexto("Boleto comprado con éxito.", "verde")));
                salto();
                System.out.println("Informacion y detalles:");
                salto();
                identacion(boleto.getInfo());
                salto();

                continuar();
                // Mostrar los detalles del vuelo
            } else {
                salto();
                System.out.println(colorTexto("Dinero insuficiente. Compra cancelada.", "rojo"));
                salto();
            }
        } else {
            salto();
            System.out.println(colorTexto("Compra cancelada.", "rojo"));
            salto();
        }

    }

    private static void reasignarVuelo(Usuario user) {

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        identacion(negrita(colorTexto("Información de los vuelos:", "morado")));
        salto();

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            identacion(i + ". " + boleto.getInfo(), 2);
        }

        separador();

        promptIn("Por favor, seleccione el número del vuelo deseado: ");
        int indexVueloTemp = inputI();
        // Obtener el boleto seleccionado por el usuario
        Boleto boletoSelec = historial.get(indexVueloTemp);

        separadorGrande();
        System.out.println("Vuelo seleccionado, información detallada:");
        salto();
        identacion(boletoSelec.getInfo());

        separador();

        promptIn("Está seguro de reasignar el vuelo? (Escriba 1 para Confirmar, 0 para Cancelar):");
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

        separadorGrande();
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

        // Mostrar información sobre los vuelos generados.
        identacion("Vuelo - Origen - Destino");// Por mejorar
        salto();

        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo vuelo = vuelos.get(i);
            identacion(vuelo.getInfo(), 2);
        }

        separador();

        // Solicitar al usuario que seleccione un vuelo y se selecciona.
        promptIn("Por favor, seleccione el número del vuelo deseado: ");
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
        identacion("Asientos disponibles:");
        ArrayList<Asiento> asientos = vuelo.getAsientos();

        for (Asiento asiento : asientos) {
            identacion(asiento.getInfo(), 2);
        }

        // Solicitar al usuario que seleccione un número de asiento.
        salto();
        promptIn("Por favor, seleccione el número del asiento deseado: ");
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
        promptIn("¿Desea añadir equipaje? (Escriba 1 para Sí, 0 para No)");
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
                promptIn("Peso de la maleta: ");
                int peso = inputI();

                promptIn("Ancho de la maleta: ");
                int ancho = inputI();

                promptIn("Largo de la maleta: ");
                int largo = inputI();

                promptIn("Alto de la maleta: ");
                int alto = inputI();

                // Agregar una maleta al boleto y mostrar el nuevo valor del boleto.
                Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                maleta.asignarBoleto(boletoSelec);
                boletoSelec.addEquipaje(maleta);

                System.out.println("Nuevo valor del boleto: ");
                identacion("-> $" + boletoSelec.getValor());

                separador();

                promptIn("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                exit = inputI();

            } while (exit == 1);
        }

        // !!! Error !!! Error !!! Error !!!

        // Mostrar los detalles de la compra y solicitar confirmación.
        separadorGrande();

        promptOut("¿Desea finalizar la compra? Los detalles son los siguientes:");
        salto();
        identacion(boletoSelec.getInfo());

        separadorGrande();
        promptIn("Confirmar (Escriba 1 para Confirmar, 0 para Cancelar)");
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

        separador();

        promptIn("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        separadorGrande();
        System.out.println("Vuelo seleccionado, información detallada:");
        salto();
        identacion(boleto.getInfo());

        separadorGrande();

        promptIn("Confirmar la cancelación (Escriba 1 para Confirmar, 0 para Cancelar):");
        int confirmacion = inputI();

        separadorGrande();

        if (confirmacion == 1) {
            // Realizar la cancelación del boleto
            boleto.setStatus("Cancelado");
            user.cancelarBoleto(boleto);
            Asiento asiento = boleto.getAsiento();
            asiento.desasignarBoleto();
            // Informar al usuario sobre la cancelación exitosa
            System.out.println("La cancelación se ha realizado con éxito.");
        }

    }

    private static void gestionCuenta(Usuario user) {
        ArrayList<Boleto> historial = user.getHistorial();

        // Ver cuenta.
        separadorGrande();

        promptOut("¿Qué desea hacer?");
        salto();

        int opcion;
        do {

            // System.out.println("Menu");
            identacion("1. Ver informacion de la cuenta");
            identacion("2. Ver historial de vuelos");
            identacion("3. Depositar dinero");
            identacion("4. Canjear millas");
            identacion("5. Cerrar sesión");
            identacion("6. Volver al menú anterior");
            salto();

            promptIn("> Seleccione una opción (1-6): ");
            opcion = inputI();
            salto();

            // Imprimir las opciones

            switch (opcion) {
                case 1:
                    // Ver informacion general de la cuenta
                    System.out.println("Estado de la cuenta");
                    separadorGrande();
                    System.out.println(user.getInfo());
                    separadorGrande();

                    continuar();
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
                    // Depositar dinero
                    promptIn("Ingrese el valor que desea depositar: ");
                    int valor = inputI();
                    user.depositarDinero(valor);
                    break;

                case 4:
                    // Canjear millas
                    canjearMillas(user);
                    break;

                case 5:
                    // Cerrar sesion (Listo)
                    aviso("Cerrando sesión");
                    salto();
                    user = gestionUsuario.cerrarSesion(user);
                    opcion = 6;
                    break;

                case 6:
                    // Volver al menu (Listo)
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

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        System.out.println("Información de los vuelos:");
        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            identacion(i + ". " + boleto.getInfo());
        }
        salto();

        promptIn("Por favor, seleccione el número del vuelo deseado: ");
        int indexVuelo = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        separador();

        identacion("Vuelo seleccionado, información detallada:");
        identacion(boleto.getInfo(), 2);

        salto();
        continuar();
        separador();

        int opcion;
        // verifica si ya se realizo el checkin para el vuelo
        // en caso de que ya se realizo el check in no dejaria entrar a este menu
        if (!boleto.getCheckInRealizado()) {
            do {
                // muestra el menu del check in
                System.out.println("Bienvenido al sistema de check-in del vuelo");
                identacion("1. Realizar check-in");
                identacion("2. Mejorar asiento");
                identacion("3. Comprar servicios especiales");
                identacion("4. Volver al menú anterior");
                salto();
                promptIn("> Seleccione una opción (1-4): ");
                opcion = inputI();
                salto();

                switch (opcion) {

                    case 1:
                        // realizar el check in
                        System.out.println("Confirma el check-in? (Escriba 1 para Confirmar, 0 para Cancelar):");
                        int confirmacion = inputI();

                        separador();

                        if (confirmacion == 1) {
                            boleto.setStatus("Confirmado");
                            boleto.setCheckInRealizado(true);
                            System.out.println("CheckIn Realizado con éxito.");
                        } else {
                            System.out.println("Proceso cancelado.");

                        }
                        break;

                    case 2:
                        mejorarAsiento(boleto);
                        break;

                    case 3:
                        comprarServiciosEspeciales(boleto);
                        break;

                    case 4:
                        // Volver al menu (Listo)
                        salto();
                        aviso("¡Volviendo al menu!");
                        salto();
                        break;

                    default:
                        System.out.println("Opción incorrecta");
                        break;

                }

            } while (opcion != 4 && !boleto.getCheckInRealizado());
        } else {
            System.out.println("Usted ya realizo el Check-in para este vuelo");
        }
    }

    private static void mejorarAsiento(Boleto boleto) {
        Asiento asiento = boleto.getAsiento();
        // se verifica que el asiento sea economico
        // si es vip ya no se puede mejorar
        if (asiento.getTipo() == "Economico") {
            promptIn("Desea mejorar su asiento a VIP?, esto tiene un costo de $25 (1 Si, 0 No)");
            int confirmacion = inputI();

            if (confirmacion == 1) {
                // Mejorar asiento
                salto();
                System.out.println("Informacion de su asiento:");
                identacion(asiento.getInfo());
                salto();
                continuar();

                // Hacer asiento vip
                ArrayList<Asiento> asientos = (boleto.getVuelo()).getAsientos();
                for (Asiento asientoTemp : asientos) {
                    if (asientoTemp.getTipo().equals("Vip")) {
                        identacion(asientoTemp.getInfo(), 2);
                    }
                }
                salto();
                promptIn("Por favor, seleccione el número del asiento deseado: ");
                int indexAsiento = inputI();
                // ... Cambiar y reasignar todo
                Asiento newAsiento = asientos.get(indexAsiento - 1);
                Usuario user = boleto.getUser();
                if (user.getDinero() >= 25) {
                    boleto.upgradeAsiento(asiento, newAsiento);
                    boleto.getUser().realizarPago(25);
                    System.out.println("Mejora de asiento realizado con exito");
                } else {
                    System.out.println("Dinero insuficiente, mejora cancelada");
                }
            }
        } else {
            System.out.println("Su asiento ya es VIP");
        }
    }

    private static void comprarServiciosEspeciales(Boleto boleto) {

        ArrayList<ServiciosEspeciales> serviciosContratados = new ArrayList<>();
        int opcion;
        do {
            System.out.println("Tenemos los siguientes servicios disponibles");
            identacion("1. Comida a la carta");
            identacion("2. Viaje con mascota");
            identacion("3. Acompañante para menor de edad");
            identacion("4. Asistencia para pasajero con necesidades especiales");
            identacion("5. Transporte terrestre");
            identacion("6. Ver servicios contratados");
            identacion("7. Volver al menú anterior");
            salto();
            promptIn("> Seleccione una opción (1-7): ");
            opcion = inputI();
            salto();

            switch (opcion) {
                case 1:
                    // anade el servicio a la lista del bloque
                    serviciosContratados.addAll(comprarComidaCarta(boleto));
                    // anade la lista de servicios al boleto
                    boleto.anadirServiciosEspeciales(serviciosContratados);
                    // limpia la lista de servicios para evitar duplicados al asignarse al boleto
                    serviciosContratados.clear();
                    break;

                case 2:
                    // anade el servicio a la lista del bloque
                    serviciosContratados.addAll(viajarConMascota(boleto));
                    // anade la lista de servicios al boleto
                    boleto.anadirServiciosEspeciales(serviciosContratados);
                    // limpia la lista de servicios para evitar duplicados al asignarse al boleto
                    serviciosContratados.clear();
                    break;

                case 3:
                    // anade el servicio a la lista del bloque
                    serviciosContratados.addAll(contratarAcompañante(boleto));
                    // anade la lista de servicios al boleto
                    boleto.anadirServiciosEspeciales(serviciosContratados);
                    // limpia la lista de servicios para evitar duplicados al asignarse al boleto
                    serviciosContratados.clear();
                    break;

                case 4:
                    promptIn("Desea contartar un asistencia para pajero con necesidades especiales? (1. Si 2. No)");
                    promptOut("Este servicio no tiene ningun costo");
                    int respuesta = inputI();
                    if (respuesta == 1) {
                        // anade el servicio a la lista del bloque
                        serviciosContratados.add(ServiciosEspeciales.ASISTENCIA_NECESIDADES_ESPECIALES);
                        // anade la lista de servicios al boleto
                        boleto.anadirServiciosEspeciales(serviciosContratados);
                        System.out.println("Compra realizada con exito");
                        // limpia la lista de servicios para evitar duplicados al asignarse al boleto
                        serviciosContratados.clear();
                    }
                    break;

                case 5:
                    // anade el servicio a la lista del bloque
                    serviciosContratados.addAll(contratarTrasporteTerrestre(boleto));
                    // anade la lista de servicios al boleto
                    boleto.anadirServiciosEspeciales(serviciosContratados);
                    // limpia la lista de servicios para evitar duplicados al asignarse al boleto
                    serviciosContratados.clear();
                    break;

                case 6:
                    verServiciosContratados(boleto);
                    break;

                case 7:
                    // Volver al menu (Listo)
                    salto();
                    aviso("¡Volviendo al menu!");
                    salto();
                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 7);
    }

    private static ArrayList<ServiciosEspeciales> comprarComidaCarta(Boleto boleto) {
        ArrayList<ServiciosEspeciales> servicios = new ArrayList<>();
        promptIn("Desea comprar el servicio de comida a la acarta durante el vuelo? (1. Si 2. No)");
        promptOut("Esto tiene un costo de $40");
        int opcion = inputI();

        if (opcion == 1) {
            // verifica que tenga suficiente dinero en la cuenta
            if (boleto.getUser().getDinero() >= ServiciosEspeciales.COMIDA_A_LA_CARTA.getPrecio()) {
                if (confirmarTransaccion()) {
                    // anade a el servicio a la lista
                    servicios.add(ServiciosEspeciales.COMIDA_A_LA_CARTA);
                    // realiza el pago del servicio
                    boleto.getUser().realizarPago(ServiciosEspeciales.COMIDA_A_LA_CARTA.getPrecio());
                }
            } else {
                System.out.println("Dinero insuficiente, compra cancelada");
            }
        }
        return servicios;
    }

    private static ArrayList<ServiciosEspeciales> viajarConMascota(Boleto boleto) {
        ArrayList<ServiciosEspeciales> servicios = new ArrayList<>();
        promptIn("Por favor ingrese el peso de la amascota");
        int peso = inputI();
        // verifica que el peso no exceda el maximo permitido para volar de 50kg
        if (peso > 50) {
            aviso("El peso excede el máximo permitido de 50 kg");
        } else {
            promptIn("Desea llevar la mascota en cabina? (1 Si, 0 No)");
            promptOut("Esto tiene un costo de $40");
            int opcion = inputI();
            if (opcion == 1) {
                // verifica que el peso no exceda el peso maximo para volar en cabina de 10kg
                if (peso <= 10) {
                    // verifica que tenga suficiente dinero en la cuenta
                    if (boleto.getUser().getDinero() >= ServiciosEspeciales.MASCOTA_EN_CABINA.getPrecio()) {
                        if (confirmarTransaccion()) {
                            // anade a el servicio a la lista
                            servicios.add(ServiciosEspeciales.MASCOTA_EN_CABINA);
                            // realiza el pago del servicio
                            boleto.getUser().realizarPago(ServiciosEspeciales.MASCOTA_EN_CABINA.getPrecio());
                        }
                    } else {
                        System.out.println("Dinero insuficiente, compra cancelada");
                    }
                } else {
                    promptOut(
                            "El peso de la mascota supera el maximo permitido para cabina, solo se puede llevar en bodega");
                    promptOut("Esto tiene un costo de $30");
                    // verifica que tenga suficiente dinero en la cuenta
                    if (boleto.getUser().getDinero() >= ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio()) {
                        if (confirmarTransaccion()) {
                            // anade a el servicio a la lista
                            servicios.add(ServiciosEspeciales.MASCOTA_EN_BODEGA);
                            // realiza el pago del servicio
                            boleto.getUser().realizarPago(ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio());
                        }
                    } else {
                        System.out.println("Dinero insuficiente, compra cancelada");
                    }
                }
            } else {
                // verifica que tenga suficiente dinero en la cuenta
                if (boleto.getUser().getDinero() >= ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio()) {
                    if (confirmarTransaccion()) {
                        // anade a el servicio a la lista
                        servicios.add(ServiciosEspeciales.MASCOTA_EN_BODEGA);
                        // realiza el pago del servicio
                        boleto.getUser().realizarPago(ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio());
                    }
                } else {
                    System.out.println("Dinero insuficiente, compra cancelada");
                }
            }
        }
        return servicios;
    }

    private static ArrayList<ServiciosEspeciales> contratarAcompañante(Boleto boleto) {
        ArrayList<ServiciosEspeciales> servicios = new ArrayList<>();
        promptIn("Desea contratar un acompañante para el pasajero menor de edad? (1. Si 2. No)");
        promptOut("Esto tiene un costo de $15");
        int opcion = inputI();

        if (opcion == 1) {
            // verifica que tenga suficiente dinero en la cuenta
            if (boleto.getUser().getDinero() >= ServiciosEspeciales.ACOMPAÑANTE_PARA_MENOR.getPrecio()) {
                if (confirmarTransaccion()) {
                    // anade a el servicio a la lista
                    servicios.add(ServiciosEspeciales.ACOMPAÑANTE_PARA_MENOR);
                    // realiza el pago del servicio
                    boleto.getUser().realizarPago(ServiciosEspeciales.ACOMPAÑANTE_PARA_MENOR.getPrecio());
                }
            } else {
                System.out.println("Dinero insuficiente, compra cancelada");
            }
        }
        return servicios;
    }

    private static ArrayList<ServiciosEspeciales> contratarTrasporteTerrestre(Boleto boleto) {
        ArrayList<ServiciosEspeciales> servicios = new ArrayList<>();
        promptIn("Desea contratar el servicio de transporte terrestre? (1. Si 2. No)");
        promptOut("Esto tiene un costo de $70");
        int opcion = inputI();

        if (opcion == 1) {
            // verifica que tenga suficiente dinero en la cuenta
            if (boleto.getUser().getDinero() >= ServiciosEspeciales.TRANSPORTE_TERRESTRE.getPrecio()) {
                if (confirmarTransaccion()) {
                    // anade a el servicio a la lista
                    servicios.add(ServiciosEspeciales.TRANSPORTE_TERRESTRE);
                    // realiza el pago del servicio
                    boleto.getUser().realizarPago(ServiciosEspeciales.TRANSPORTE_TERRESTRE.getPrecio());
                }
            } else {
                System.out.println("Dinero insuficiente, compra cancelada");
            }
        }
        return servicios;
    }

    private static void verServiciosContratados(Boleto boleto) {
        if (boleto.getServiciosContratados().size() != 0) {
            System.out.println("Usted tiene los siguientes servicios contratados");
            for (ServiciosEspeciales servicio : boleto.getServiciosContratados()) {
                System.out.println("Servicio: " + servicio.getServicio() + " por un valor de: " + servicio.getPrecio());
            }
        } else {
            System.out.println("No tiene servicios contratados");
        }
    }

    private static boolean confirmarTransaccion() {

        promptIn("Confirmar (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = inputI();
        if (confirmacion == 1) {
            System.out.println("Compra realizada con exito");
            return true;
        }
        System.out.println("Compra cancelada");
        return false;
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

        /*
         * Implementar clase abstracta o interfaz para comidas y como integrarlo con el
         * usuario
         */

        System.out.println(" - - - > Ha seleccionado la opción Canjear millas < - - -");
        separadorGrande();
        identacion("Hola " + colorTexto(user.getNombre(), "verde"), 3);
        salto();
        identacion("En este momento usted posee " + user.getMillas() + " millas");
        salto();
        promptOut("Escoja en lo que desea canjear sus millas");
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
            promptIn("> Seleccione una opción (1-5): ");
            opcion = inputI();
            salto();

            // Imprimir las opciones

            switch (opcion) {
                case 1:
                    // Con este descuento se tiene derecho a una mejora TOTAL de silla instantanea
                    // Se puede aplicar directamente aqui o al llamar el check in
                    break;

                case 2:
                    // Con este descuento se tiene derecho a un alimento en especifico de una lista
                    // de seleccionables
                    // Se puede aplicar directamente aqui o al llamar el check in
                    break;

                case 3:
                    // Con este cupon se tiene derecho a un % de descuento al pagar un vuelo
                    // Se puede aplicar directamente aqui (seleccionando un vuelo y recibiendo %) o
                    // al llamar el check in
                    break;

                case 4:
                    // Con este cupon se tiene derecho a un % de descuento al del precio TOTAL de
                    // maletas en un vuelo
                    // Se puede aplicar directamente aqui (seleccionando un vuelo y recibiendo %) o
                    // al llamar el check in
                    break;

                case 5:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 5);

        System.out.println("Canjeado con éxito, n millas a m dinero, cuenta total: total");
    }

}

// SI el usuario ya hizo check in no puede reasignar, solo cancelar y se pierde

/*
 * Canejar millas por mejorar tipo de sillas y descuento en la maleta y comida
 * alimenacion, con una clase abstracta y un menu q se le asigna una cantidad x
 * de alimentos
 */
