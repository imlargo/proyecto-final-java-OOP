package uiMain;

import static uiMain.Estetica.*;
import gestorAplicacion.Aerolinea.*;
import gestorAplicacion.Alimentos.Comida;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Descuentos.*;
import gestorAplicacion.Mascotas.*;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static GestionUsuario gestionUsuario = new GestionUsuario();

    public static void main(String[] args) {
        Usuario user = null; // Variable para almacenar instancia del usuario
        int opcion = 0; // Variable para almacenar la opción seleccionada

        // Función que imprime un separador visual en la consola
        separador();

        // Función que muestra un mensaje de bienvenida en color morado y negrita
        aviso(negrita(colorTexto("Bienvenido al programa", "morado")));

        // Otro separador
        separador();

        // Bucle principal del programa
        do {
            user = gestionUsuario.getUser(); // Obtiene la información del usuario

            if (user == null) {
                // Si no hay un usuario registrado

                // Muestra un mensaje de aviso
                aviso("¡No hay sesión iniciada!");

                // Salto de línea
                salto();

                // Ofrece dos opciones al usuario: Iniciar Sesión o Salir
                identacion("1. Iniciar Sesión.");
                identacion("2. Salir.");

                // Salto de línea
                salto();

                // Pide al usuario que ingrese una opción
                promptIn("Opcion:");
                opcion = inputI();

                // Separador grande
                separadorGrande();

                switch (opcion) {

                    case 1:
                        // Iniciar Sesión

                        int intentos = 0; // Variable para contar los intentos

                        do {
                            // Muestra un mensaje de inicio de sesión en color morado
                            identacion(negrita(colorTexto("Iniciar sesión", "morado")), 4);
                            salto();

                            // Pide al usuario que ingrese su correo
                            printNegrita("Mail:");
                            String mail = inputS();

                            // Pide al usuario que ingrese su contraseña
                            printNegrita("Contraseña:");
                            String contrasena = inputS();

                            // Separador grande
                            separadorGrande();

                            // Intenta iniciar sesión con el correo y la contraseña proporcionados
                            user = gestionUsuario.iniciarSesion(mail, contrasena);

                            if (user == null) {
                                // Si la sesión no se inicia con éxito, muestra un mensaje de error
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
                        // Muestra un mensaje de sesión iniciada con éxito en color verde
                        aviso(colorTexto("Sesión iniciada con éxito", "verde"));
                        salto();
                        // Muestra un mensaje de bienvenida personalizado
                        titulo(colorTexto(("Bienvenido " + user.getNombre() + " :)"), "morado"));
                        salto();

                        continuar();
                        break;

                    case 2:
                        // Si el usuario selecciona la opción 2, se sale del programa
                        System.out.println(colorTexto("Saliendo del programa. ¡Adios!", "morado"));
                        separadorGrande();
                        System.exit(0);

                    default:
                        // Si la opción ingresada no es válida, se establece user a null
                        user = null;
                        aviso(colorTexto("Opción incorrecta", "rojo"));
                        break;
                }
            }

            while (opcion != 6 && user != null) {
                // Bucle que se ejecuta mientras la opción no sea 6 (Salir) y haya un usuario
                // registrado

                // Separador grande
                separadorGrande();

                // Muestra un menú en color morado
                identacion(negrita(colorTexto("> - Menú - <", "morado")), 4);
                salto();
                identacion("1. Comprar vuelo");
                identacion("2. Reasignar vuelo");
                identacion("3. Cancelar vuelo");
                identacion("4. Gestion cuenta");
                identacion("5. Check in");
                identacion("6. Salir");
                separador();

                // Pide al usuario que seleccione una opción
                promptIn("Seleccione una opción (1-5): ");
                opcion = inputI();
                salto();

                switch (opcion) {
                    case 1:
                        // Opción 1: Comprar vuelo

                        salto();
                        seleccionado("Comprar vuelo");
                        separadorGrande();

                        // Llama a la función comprarVuelo pasando el objeto de usuario como argumento
                        comprarVuelo(user);
                        separadorGrande();
                        break;

                    case 2:
                        // Opción 2: Reasignar vuelo

                        salto();
                        seleccionado("Reasignar vuelo");
                        separadorGrande();

                        // Llama a la función reasignarVuelo pasando el objeto de usuario como argumento
                        reasignarVuelo(user);
                        separadorGrande();
                        break;

                    case 3:
                        // Opción 3: Cancelar vuelo

                        seleccionado("Cancelar vuelo");
                        separadorGrande();

                        // Llama a la función cancelarVuelo pasando el objeto de usuario como argumento
                        cancelarVuelo(user);
                        separadorGrande();
                        break;

                    case 4:
                        // Opción 4: Gestion de cuenta

                        seleccionado("Gestion de cuenta");
                        separadorGrande();

                        // Llama a la función gestionCuenta pasando el objeto de usuario como argumento
                        gestionCuenta(user);

                        // Actualiza el objeto de usuario después de la gestión de la cuenta
                        user = gestionUsuario.getUser();
                        separadorGrande();
                        break;

                    case 5:
                        // Opción 5: Check in

                        seleccionado("Check in");

                        // Actualiza el objeto de usuario después de realizar el check-in
                        user = gestionUsuario.getUser();
                        separadorGrande();

                        // Llama a la función checkin pasando el objeto de usuario como argumento
                        checkin(user);
                        separadorGrande();
                        user = gestionUsuario.getUser();
                        break;

                    case 6:
                        // Opción 6: Salir

                        separadorGrande();
                        // Muestra un mensaje de despedida en color morado y sale del programa
                        System.out.println(negrita(colorTexto("Saliendo del programa. ¡Adios!", "morado")));
                        System.exit(0);

                    default:
                        // Si la opción no es válida, muestra un mensaje de error en rojo
                        System.out.println(
                                colorTexto("Opción no válida. Por favor, seleccione una opción válida (1-5).", "rojo"));
                        break;
                }
            }
        } while (true); // El programa se ejecuta en un bucle infinito
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
        identacion(negrita("Vuelo - Origen - Destino"));
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
        identacion(negrita(colorTexto("Asientos disponibles", "morado")));
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
        System.out.println((negrita("Previsualización del precio: "))
                + colorTexto(("$" + boleto.getValor()), "verde"));
        salto();
        continuar();
        // Si sí, sigue, sino, selecciona otro asiento??

        separador();

        // Preguntar al usuario si desea añadir equipaje.
        promptIn("¿Desea añadir equipaje? Tiene derecho a llevar maximo 5 maletas. (1 si / 0 no)");
        int opcion = inputI();

        int cMaletas = 0;

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

                promptIn("Peso de la maleta (max 250Kg): ");
                int peso = inputI();

                promptIn("Ancho de la maleta (max 250cm): ");
                int ancho = inputI();

                promptIn("Largo de la maleta (max 250cm): ");
                int largo = inputI();

                promptIn("Alto de la maleta (max 250cm): ");
                int alto = inputI();

                // Agregar una maleta al boleto y mostrar el nuevo valor del boleto.
                Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                if (maleta.verificarRestricciones()) {

                    maleta.asignarBoleto(boleto);
                    boleto.addEquipaje(maleta);
                    cMaletas += 1;

                    separador();
                    System.out.println(negrita(colorTexto("Nuevo valor del boleto:", "morado")));
                    System.out.println((colorTexto("-> $" + boleto.getValor(), "verde")));
                    salto();
                    promptIn("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                    exit = inputI();

                } else {
                    salto();
                    promptError("La maleta excede las especificaciones maximas, intente nuevamente");
                    salto();
                }

            } while (exit == 1 && cMaletas != 5);
        }

        salto();
        printNegrita("Maletas agregadas con exito, cantidad de maletas: " + (boleto.getEquipaje()).size());
        continuar();

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
                System.out.println(negrita(colorTexto("Informacion y detalles:", "morado")));
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
            promptError("Compra cancelada.");
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

        if (!boletoSelec.getCheckInRealizado()) {
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
                System.out.println(colorTexto("Proceso cancelado, hasta luego!", "rojo"));
                return;

            }

            separadorGrande();
            // Solicitar al usuario el origen del vuelo.
            String origen = boletoSelec.getOrigen();
            identacion(colorTexto("Origen: ", "morado") + origen);

            // Solicitar al usuario el destino del vuelo.
            String destino = boletoSelec.getDestino();
            identacion(colorTexto("Destino: ", "morado") + destino);

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
            identacion(negrita(colorTexto("Asientos disponibles:", "morado")));
            ArrayList<Asiento> asientos = vuelo.getAsientos();
            salto();

            for (Asiento asiento : asientos) {
                identacion(asiento.getInfo(), 2);
            }

            // Solicitar al usuario que seleccione un número de asiento.
            salto();
            promptIn(
                    "Por favor, seleccione el número del asiento deseado, a este valor se le agregara un sobrecargo del 10%: ");
            int indexAsiento = inputI();
            Asiento asiento = asientos.get(indexAsiento - 1);
            boletoSelec.reasignarAsiento(asiento);

            // Si se selecciona y es valido se prosigue...

            // Se muestra una previsualizacion del precio
            separador();
            System.out.println("Previsualización del precio: " + colorTexto("$" + boletoSelec.getValor(), "verde")
                    + " ,se agregará un recargo extra del 10%");
            separador();

            // Preguntar al usuario si desea añadir equipaje.
            promptIn("¿Desea añadir equipaje? Tiene derecho a llevar maximo 5 maletas. (1 si / 0 no)");
            int opcion = inputI();

            int cMaletas = 0;

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

                    promptIn("Peso de la maleta (max 250Kg): ");
                    int peso = inputI();

                    promptIn("Ancho de la maleta (max 250cm): ");
                    int ancho = inputI();

                    promptIn("Largo de la maleta (max 250cm): ");
                    int largo = inputI();

                    promptIn("Alto de la maleta (max 250cm): ");
                    int alto = inputI();

                    // Agregar una maleta al boleto y mostrar el nuevo valor del boleto.
                    Maleta maleta = new Maleta(c, peso, largo, ancho, alto);
                    if (maleta.verificarRestricciones()) {

                        maleta.asignarBoleto(boletoSelec);
                        boletoSelec.addEquipaje(maleta);
                        cMaletas += 1;

                        separador();
                        System.out.println(negrita(colorTexto("Nuevo valor del boleto:", "morado")));
                        System.out.println((colorTexto("-> $" + boletoSelec.getValor(), "verde")));
                        salto();
                        promptIn("¿Desea agregar otro equipaje o continuar? (1 para Sí, 0 para No)");
                        exit = inputI();

                    } else {
                        salto();
                        promptError("La maleta excede las especificaciones maximas, intente nuevamente");
                        salto();
                    }

                } while (exit == 1 && cMaletas != 5);
            }

            salto();
            printNegrita("Maletas agregadas con exito, cantidad de maletas: " + cMaletas);
            continuar();
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
                    user.comprarBoletoReasig(boletoSelec);
                    boletoSelec.setStatus("Reasignado");
                    boletoSelec.asignarAsiento(asiento);
                    System.out.println(negrita(colorTexto("Boleto comprado con éxito. Detalles:", "morado")));
                    identacion(boletoSelec.getInfo());

                } else {
                    System.out.println(colorTexto("Dinero insuficiente. Compra cancelada.", "rojo"));
                }
            } else {
                System.out.println(colorTexto("Compra cancelada.", "rojo"));
            }
        } else {
            separador();
            System.out.println(colorTexto(
                    "Usted ya realizo el Check-in para este vuelo por lo tanto no es posible reasignar el vuelo",
                    "rojo"));
            continuar();
        }

    }

    private static void cancelarVuelo(Usuario user) {
        // Mostrar la lista de vuelos
        // Seleccionar el vuelo
        // Cancelarlo (Se modifica el boleto y se cambian los valores)

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
        int indexVuelo = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        separadorGrande();
        System.out.println(negrita(colorTexto("Vuelo seleccionado, información detallada:", "morado")));
        salto();
        identacion(boleto.getInfo());

        separadorGrande();

        if (boleto.getStatus() != "Cancelado") {
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
                System.out.println(colorTexto("La cancelación se ha realizado con éxito.", "verde"));
            } else {
                separador();
                System.out.println(colorTexto("Proceso cancelado", "rojo"));
                continuar();
            }
        } else {
            separador();
            System.out.println(colorTexto("Este vuelo ya fue cancelado", "rojo"));
            continuar();
        }
    }



    private static void gestionCuenta(Usuario user) {
        ArrayList<Boleto> historial = user.getHistorial(); // Obtiene el historial de boletos del usuario

        int opcion;
        do {
            // Muestra un menú para gestionar la cuenta del usuario
            separadorGrande();
            promptOut("¿Qué desea hacer?");
            salto();
            identacion("1. Ver información de la cuenta");
            identacion("2. Ver historial de vuelos");
            identacion("3. Depositar dinero");
            identacion("4. Canjear millas");
            identacion("5. Cerrar sesión");
            identacion("6. Volver al menú anterior");
            salto();

            // Pide al usuario que seleccione una opción
            promptIn("> Seleccione una opción (1-6):");
            opcion = inputI();
            salto();

            switch (opcion) {
                case 1:
                    // Opción 1: Ver información general de la cuenta

                    // Muestra el estado de la cuenta en color morado
                    separador();
                    identacion(negrita(colorTexto("Estado de la cuenta", "morado")), 4);
                    separadorGrande();
                    System.out.println(user.getInfo()); // Imprime la información de la cuenta
                    separadorGrande();
                    continuar();
                    salto();
                    break;

                case 2:
                    // Opción 2: Ver historial de vuelos

                    separador();

                    // Muestra información de los vuelos en color morado
                    salto();
                    System.out.println(negrita(colorTexto("Información de los vuelos:", "morado")));
                    salto();

                    // Itera a través del historial de boletos del usuario
                    for (int i = 0; i < historial.size(); i++) {
                        Boleto boleto = historial.get(i); // Obtiene un boleto del historial
                        // Muestra información de cada boleto en la lista
                        identacion(i + ". " + boleto.getInfo());
                    }

                    salto();
                    continuar();
                    salto();
                    break;

                case 3:
                    // Opción 3: Depositar dinero

                    // Pide al usuario que ingrese la cantidad de dinero que desea depositar
                    promptOut("Ingrese el valor que desea depositar: ");
                    int valor = inputI();
                    user.depositarDinero(valor); // Llama a la función para depositar dinero en la cuenta

                    salto();
                    System.out.println(colorTexto("Transacción realizada con éxito", "verde")); // Muestra un mensaje de
                                                                                                // éxito
                    separador();
                    break;

                case 4:
                    // Opción 4: Canjear millas

                    // Llama a la función canjearMillas pasando el objeto de usuario como argumento
                    canjearMillas(user);

                    salto();
                    break;

                case 5:
                    // Opción 5: Cerrar sesión

                    aviso(colorTexto("Cerrando sesión", "rojo")); // Muestra un mensaje de cierre de sesión en rojo
                    salto();
                    user = gestionUsuario.cerrarSesion(user); // Llama a la función para cerrar la sesión del usuario
                    opcion = 6; // Establece la opción en 6 para volver al menú anterior
                    salto();
                    break;

                case 6:
                    // Opción 6: Volver al menú

                    salto();
                    aviso(colorTexto("¡Volviendo al menú!", "verde")); // Muestra un mensaje de regreso al menú en verde
                    salto();
                    break;

                default:
                    aviso(colorTexto("Opción incorrecta", "rojo")); // Muestra un mensaje de opción incorrecta en rojo
                    salto();
                    break;
            }
        } while (opcion != 6); // Continúa el bucle hasta que la opción seleccionada sea 6
    }

    private static void checkin(Usuario user) {
        // Mostrar la lista de vuelos
        // Seleccionar el vuelo
        // Cancelarlo (Se modifica el boleto y se cambian los valores)

        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();

        System.out.println(colorTexto("Información de los vuelos:", "morado"));
        salto();

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            identacion(i + ". " + boleto.getInfo());
        }
        salto();

        promptIn("Por favor, seleccione el número del vuelo deseado:");
        int indexVuelo = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        separador();

        System.out.println(colorTexto("Vuelo seleccionado, información detallada:", "morado"));
        salto();
        identacion(boleto.getInfo());

        salto();
        continuar();

        int opcion;
        // verifica si ya se realizo el checkin para el vuelo
        // en caso de que ya se realizo el check in no dejaria entrar a este menu
        if (!boleto.getCheckInRealizado() && boleto.getStatus() != "Cancelado") {
            do {
                separadorGrande();

                // muestra el menu del check in
                identacion(negrita(colorTexto("Bienvenido al sistema de check-in del vuelo", "morado")), 3);

                salto();
                identacion("1. Realizar check-in");
                identacion("2. Mejorar asiento");
                identacion("3. Comprar servicios especiales");
                identacion("4. Volver al menú anterior");
                salto();

                promptIn("> Seleccione una opción (1-4): ");
                opcion = inputI();

                switch (opcion) {

                    case 1:
                        // realizar el check in
                        salto();
                        promptIn("Confirma el check-in? (Escriba 1 para Confirmar, 0 para Cancelar):");
                        int confirmacion = inputI();

                        separador();

                        if (confirmacion == 1) {
                            boleto.setStatus("Confirmado");
                            boleto.setCheckInRealizado(true);
                            System.out.println(colorTexto("CheckIn Realizado con éxito.", "verde"));
                        } else {
                            System.out.println(colorTexto("Proceso cancelado.", "rojo"));
                        }
                        continuar();
                        break;

                    case 2:
                        mejorarAsiento(boleto);
                        break;

                    case 3:
                        comprarServiciosEspeciales(boleto, user);
                        break;

                    case 4:
                        // Volver al menu (Listo)
                        salto();
                        aviso("¡Volviendo al menu!");
                        salto();
                        break;

                    default:

                        aviso(colorTexto("Opción incorrecta", "rojo"));
                        break;

                }

            } while (opcion != 4 && !boleto.getCheckInRealizado());
        } else {
            if (boleto.getStatus() == "Cancelado") {
                separador();
                System.out
                        .println(colorTexto("No es posible realizar el checkIn ya que el vuelo fue cancelado", "rojo"));
                continuar();
            } else {
                separador();
                System.out.println(colorTexto("Usted ya realizo el Check-in para este vuelo", "rojo"));
                continuar();
            }
        }
    }

    private static void mejorarAsiento(Boleto boleto) {
        Asiento asiento = boleto.getAsiento();
        // se verifica que el asiento sea economico
        // si es vip ya no se puede mejorar
        if (asiento.getTipo() == "Economico") {
            separador();
            promptIn("Desea mejorar su asiento a VIP?, esto tiene un costo de $25 (1 Si, 0 No)");
            int confirmacion = inputI();

            if (confirmacion == 1) {
                // Mejorar asiento
                salto();
                System.out.println(negrita(colorTexto("Informacion de su asiento:", "morado")));
                salto();

                identacion(asiento.getInfo());
                salto();

                // Hacer asiento vip
                ArrayList<Asiento> asientos = (boleto.getVuelo()).getAsientos();

                printNegrita(colorTexto("Asientos disponibles", "morado"));
                salto();
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

                    separador();
                    printNegrita(colorTexto("Mejora de asiento realizado con exito", "verde"));
                    salto();

                } else {

                    System.out.println(colorTexto("Dinero insuficiente, mejora cancelada", "rojo"));

                }
                continuar();
            }
        } else {
            separador();
            System.out.println(colorTexto("Su asiento ya es VIP", "verde"));
            separador();
            continuar();
        }
    }


    
    private static void comprarServiciosEspeciales(Boleto boleto, Usuario user) {

        int opcion;
        do {
            separador();
            identacion(negrita(colorTexto("Servicios disponibles", "morado")), 4);
            salto();

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

            separador();

            switch (opcion) {
                case 1:
                    comprarComidaCarta(boleto, user);
                    break;

                case 2:
                    viajarConMascota(boleto, user);
                    break;

                case 3:
                    contratarAcompanante(boleto, user);
                    break;

                case 4:
                    promptOut("Desea contratar un asistencia para pasajero con necesidades especiales?");
                    promptOut("Este servicio no tiene ningun costo (1/0)");
                    int respuesta = inputI();

                    if (respuesta == 1) {
                        boleto.anadirServiciosEspeciales(ServiciosEspeciales.ASISTENCIA_NECESIDADES_ESPECIALES);
                        salto();
                        printNegrita(colorTexto("Compra realizada con exito!", "verde"));
                    } else {
                        promptError("Cancelado");
                    }
                    break;

                case 5:
                    contratarTrasporteTerrestre(boleto, user);
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

                    aviso(colorTexto("Opción incorrecta", "rojo"));
                    continuar();
                    break;
            }

        } while (opcion != 7);
    }

    private static void comprarComidaCarta(Boleto boleto, Usuario user) {
        promptOut("Desea comprar el servicio de comida a la acarta durante el vuelo? Esto tiene un costo de $40");

        switch (confirmarTransaccion(user, ServiciosEspeciales.COMIDA_A_LA_CARTA.getPrecio())) {
            case 1:
                // anade a el servicio a la lista del boleto
                boleto.anadirServiciosEspeciales(ServiciosEspeciales.COMIDA_A_LA_CARTA);
                // realiza el pago del servicio
                boleto.getUser().realizarPago(ServiciosEspeciales.COMIDA_A_LA_CARTA.getPrecio());

                printNegrita(colorTexto("Compra realizada con exito!", "verde"));
                salto();
                continuar();
                break;

            case -1:
                promptError("Dinero insuficiente, compra cancelada");
                continuar();
                break;

            case 0:
                promptError("Cancelado");
                continuar();
                break;

            default:
                break;
        }
    }

    private static void viajarConMascota(Boleto boleto, Usuario user) {
        Animal mascota;

        // Se pregunta si la mascota es perro o gato
        promptIn("Desea viajar con un perro o un gato? ( 1. Perro 2. Gato)");
        int op = inputI();
        salto();

        // Se obtienen los datos de la mascota
        promptIn("Por favor ingrese el nombre de la mascota");
        String nombre = inputS();
        salto();

        promptIn("Por favor ingrese la raza de la mascota");
        String raza = inputS();
        salto();

        promptIn("Por favor ingrese el tamano de la mascota");
        double tamano = inputD();
        salto();

        promptIn("Por favor ingrese el peso de la mascota");
        double peso = inputD();
        salto();

        if (op == 1) {
            // Se crea una instancia de perro
            mascota = new Perro(nombre, raza, tamano, peso);
        } else {
            // Se crea una instancia de gato
            mascota = new Gato(nombre, raza, tamano, peso);
        }

        // Verifica que la mascota si pueda viajar en cabina o bodega y que no sobrepase
        // el limite de 1 en cabina y 2 en bodega
        if ((mascota.puedeViajarEnCabina() && boleto.getMascotasEnCabina() < 1)
                || (mascota.puedeViajarEnBodega() && boleto.getMascotasEnBodega() < 2)) {
            // Pregunta si desea llevarla en cabina
            promptIn("Desea llevar la mascota en cabina? (1 Si, 0 No) Esto tiene un costo de $40");
            int opcion = inputI();
            salto();

            // Si desea viajar en cabina
            if (opcion == 1) {
                // Verifica que si sea posible viajar en cabina
                if (mascota.puedeViajarEnCabina() && boleto.getMascotasEnCabina() < 1) {
                    // Confirma la transaccion
                    switch (confirmarTransaccion(user, ServiciosEspeciales.MASCOTA_EN_CABINA.getPrecio())) {
                        case 1:
                            // anade a el servicio a la lista del boleto
                            boleto.anadirServiciosEspeciales(ServiciosEspeciales.MASCOTA_EN_CABINA);
                            // Anade la mascota a la lista del boleto
                            boleto.anadirServiciosMascota(mascota);
                            // realiza el pago del servicio
                            boleto.getUser().realizarPago(ServiciosEspeciales.MASCOTA_EN_CABINA.getPrecio());

                            printNegrita(colorTexto("Compra realizada con exito!", "verde"));
                            salto();
                            continuar();
                            break;
                        case 0:
                            promptError("Cancelado");
                            continuar();
                            break;
                        case -1:
                            promptError("Dinero insuficiente, compra cancelada");
                            continuar();
                            break;
                        default:
                            break;
                    }
                } else if (boleto.getMascotasEnBodega() < 2) {
                    // Si no puede viajar en cabina se indica que va a aviajar en bodega
                    promptOut(
                            "La mascota no cumple las restricciones de la aerolinea para viajar en cabina o ya se cumplio el limite permitido.");
                    promptOut(" Puede viajar en bodega. Esto tiene un costo de $30");
                    // Se confirma la transaccion
                    switch (confirmarTransaccion(user, ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio())) {
                        case 1:
                            // anade a el servicio a la lista del boleto
                            boleto.anadirServiciosEspeciales(ServiciosEspeciales.MASCOTA_EN_BODEGA);
                            // Anade la mascota a la lista del boleto
                            boleto.anadirServiciosMascota(mascota);
                            // realiza el pago del servicio
                            boleto.getUser().realizarPago(ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio());
                            printNegrita(colorTexto("Compra realizada con exito!", "verde"));
                            salto();
                            continuar();
                            break;
                        case 0:
                            promptError("Cancelado");
                            continuar();
                            break;
                        case -1:
                            promptError("Dinero insuficiente, compra cancelada");
                            continuar();
                            break;
                        default:
                            break;
                    }
                } else {
                    aviso(colorTexto("No es posible viajar con la mascota en bodega ya se alcanzo el limite permitido",
                            "rojo"));
                    continuar();
                }
                // Si desea viajar en bodega
            } else if (boleto.getMascotasEnBodega() < 2) {
                promptOut("El viaje en bodega tiene un costo de $30");
                // Se confirma la transaccion
                switch (confirmarTransaccion(user, ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio())) {
                    case 1:
                        // anade a el servicio a la lista del boleto
                        boleto.anadirServiciosEspeciales(ServiciosEspeciales.MASCOTA_EN_BODEGA);
                        // Anade la mascota a la lista del boleto
                        boleto.anadirServiciosMascota(mascota);
                        // realiza el pago del servicio
                        boleto.getUser().realizarPago(ServiciosEspeciales.MASCOTA_EN_BODEGA.getPrecio());

                        printNegrita(colorTexto("Compra realizada con exito!", "verde"));
                        salto();
                        continuar();
                        break;
                    case 0:
                        promptError("Cancelado");
                        continuar();
                        break;
                    case -1:
                        promptError("Dinero insuficiente, compra cancelada");
                        continuar();
                        break;
                    default:
                        break;
                }
            } else {
                aviso(colorTexto("No es posible viajar con la mascota en bodega ya se alcanzo el limite permitido",
                        "rojo"));
                continuar();
            }
            // Si no se puede viajar de ninguna forma
        } else {
            aviso(colorTexto("La mascota no cumple con las restricciones de la aerolinea ", "rojo"));
            aviso(colorTexto("o ya se cumplio el limite permitido por lo tanto no puede viajar", "rojo"));
            continuar();
        }

    }


    private static void contratarAcompanante(Boleto boleto, Usuario user) {
        promptOut("Desea contratar un acompañante para el pasajero menor de edad? Esto tiene un costo de $15");

        switch (confirmarTransaccion(user, ServiciosEspeciales.ACOMPANANTE_PARA_MENOR.getPrecio())) {
            case 1:
                // anade a el servicio a la lista del boleto
                boleto.anadirServiciosEspeciales(ServiciosEspeciales.ACOMPANANTE_PARA_MENOR);
                // realiza el pago del servicio
                boleto.getUser().realizarPago(ServiciosEspeciales.ACOMPANANTE_PARA_MENOR.getPrecio());

                separador();
                printNegrita(colorTexto("Asignado con exito ✔", "verde"));
                salto();
                continuar();
                break;

            case -1:
                promptError("Dinero insuficiente, compra cancelada");
                continuar();
                break;

            case 0:
                promptError("Cancelado");
                continuar();
                break;

            default:
                break;
        }
    }

    private static void contratarTrasporteTerrestre(Boleto boleto, Usuario user) {
        promptOut("Desea contratar el servicio de transporte terrestre? Esto tiene un costo de $70");

        switch (confirmarTransaccion(user, ServiciosEspeciales.TRANSPORTE_TERRESTRE.getPrecio())) {
            case 1:
                // anade a el servicio a la lista del boleto
                boleto.anadirServiciosEspeciales(ServiciosEspeciales.TRANSPORTE_TERRESTRE);
                // realiza el pago del servicio
                boleto.getUser().realizarPago(ServiciosEspeciales.TRANSPORTE_TERRESTRE.getPrecio());

                separador();
                printNegrita(colorTexto("Compra realizada con exito!", "verde"));
                salto();
                continuar();
                break;

            case -1:
                promptError("Dinero insuficiente, compra cancelada");
                continuar();
                break;

            case 0:
                promptError("Cancelado");
                continuar();
                break;

            default:
                break;
        }
    }

    private static void verServiciosContratados(Boleto boleto) {
        if (boleto.getServiciosContratados().size() != 0) {
            System.out.println(colorTexto(("Usted tiene los siguientes servicios contratados"), "morado"));
            salto();
            int index = 0;
            for (ServiciosEspeciales servicio : boleto.getServiciosContratados()) {
                identacion(negrita("Servicio: ") + servicio.getServicio() + " por un valor de: $"
                        + colorTexto("" + servicio.getPrecio(), "verde"));
                if (servicio == ServiciosEspeciales.MASCOTA_EN_CABINA
                        || servicio == ServiciosEspeciales.MASCOTA_EN_BODEGA) {
                    System.out.println("	-" + boleto.getMascotas().get(index));
                    index++;
                }
            }

            continuar();
        } else {
            System.out.println(colorTexto("No tiene servicios contratados", "morado"));

            continuar();
        }
    }

    private static int confirmarTransaccion(Usuario user, int valor) {

        promptIn("Confirmar Transaccion (Escriba 1 para Confirmar, 0 para Cancelar)");
        int confirmacion = inputI();
        salto();

        if (confirmacion == 1) {
            if (user.getDinero() >= valor) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }



    private static void canjearMillas(Usuario user) {

        /*
         * Permite al usuario canjear millas por ciertos descuentos
         * 
         * Estructura y proceso:
         * Se le da a el usuario las opciones disponibles para canjear sus millas
         * Selecciona la opcion y se pide confirmacion, al confirmar, se descuentan las
         * millas, se instancia el tipo de descuento
         * Si el usuario decide aplicar el descuendo instantaneamente se procede a hacer
         * el proceso
         * Si no, se guarda el boleto en una lista de descuentos asociada al usuario,
         * posteriormente el usuario puede aplicar el descuento
         * usando la opcion 4. Aplicar descuentos
         */
        seleccionado("Canjear millas");
        separadorGrande();
        identacion("Hola " + colorTexto(user.getNombre(), "verde"), 3);
        salto();

        int opcion;

        do {

            identacion("En este momento usted posee " + colorTexto("" + user.getMillas(), "morado") + " millas");
            salto();

            promptOut("Escoja en que desea canjear sus millas");
            salto();

            // System.out.println("Menu");
            identacion("1. Mejora de silla" + " (" + upgradeAsiento.costoMillas + ")");
            identacion("2. Descuento vuelo" + " (" + descuentoVuelo.costoMillas + ")");
            identacion("3. Descuento maleta" + " (" + descuentoMaleta.costoMillas + ")");
            identacion("4. Aplicar descuentos");
            identacion("5. Ver descuentos del usuario");
            identacion("6. Volver al menú anterior");
            salto();
            promptIn("> Seleccione una opción (1-6): ");
            opcion = inputI();

            separador();

            // Imprimir las opciones

            switch (opcion) {
                case 1:
                    switch (verificarMillas(user, upgradeAsiento.costoMillas)) {
                        case 1:
                            user.descontarMillas(upgradeAsiento.costoMillas);

                            printNegrita("Canjeado con éxito, millas restantes: "
                                    + colorTexto("" + user.getMillas(), "verde"));
                            separador();
                            promptIn("Desea aplicar el descuendo de una vez? (1 si / 0 no)");
                            int aplicar = inputI();

                            if (aplicar == 1) {
                                Descuento descuento = new upgradeAsiento(user);
                                millasAsiento(user, descuento);
                            } else {
                                Descuento descuento = new upgradeAsiento(user);
                                descuento.guardar();
                                separador();
                                printNegrita(colorTexto(
                                        "Se guardo el descuento en su cuenta, puedes aplicarlo cuando desees",
                                        "verde"));
                                salto();
                                continuar();
                                separador();
                            }
                            break;

                        case -1:
                            promptError("Millas insuficientes!");
                            break;
                        case 0:
                            promptError("Operacion cancelada");
                            break;
                        default:
                            break;
                    }

                    break;

                case 2:

                    switch (verificarMillas(user, descuentoVuelo.costoMillas)) {

                        case 1:

                            user.descontarMillas(descuentoVuelo.costoMillas);

                            printNegrita("Canjeado con éxito, millas restantes: "
                                    + colorTexto("" + user.getMillas(), "verde"));
                            separador();
                            promptIn("Desea aplicar el descuendo de una vez? (1 si / 0 no)");
                            int aplicar = inputI();

                            if (aplicar == 1) {
                                Descuento descuento = new descuentoVuelo(user);
                                millasVuelo(user, descuento);
                            } else {
                                Descuento descuento = new descuentoVuelo(user);
                                descuento.guardar();
                                separador();
                                printNegrita(colorTexto(
                                        "Se guardo el descuento en su cuenta, puedes aplicarlo cuando desees",
                                        "verde"));
                                salto();
                                continuar();
                                separador();
                            }

                            break;

                        case -1:
                            promptError("Millas insuficientes!");
                            break;
                        case 0:
                            promptError("Operacion cancelada");
                            break;
                        default:
                            break;

                    }
                    break;

                case 3:
                    // Con este cupon se tiene derecho a un % de descuento al del precio TOTAL de
                    // maletas en un vuelo
                    // Se puede aplicar directamente aqui (seleccionando un vuelo y recibiendo %) o
                    // al llamar el check in
                    switch (verificarMillas(user, descuentoMaleta.costoMillas)) {
                        case 1:

                            user.descontarMillas(descuentoMaleta.costoMillas);
                            printNegrita("Canjeado con éxito, millas restantes: "
                                    + colorTexto("" + user.getMillas(), "verde"));
                            separador();
                            promptIn("Desea aplicar el descuendo de una vez? (1 si / 0 no)");
                            int aplicar = inputI();

                            if (aplicar == 1) {

                                Descuento descuento = new descuentoMaleta(user);
                                millasMaleta(user, descuento);
                            } else {
                                Descuento descuento = new descuentoMaleta(user);
                                descuento.guardar();
                                separador();
                                printNegrita(colorTexto(
                                        "Se guardo el descuento en su cuenta, puedes aplicarlo cuando desees",
                                        "verde"));
                                salto();
                                continuar();
                                separador();
                            }
                            break;

                        case -1:
                            promptError("Millas insuficientes!");
                            break;
                        case 0:
                            promptError("Operacion cancelada");
                            break;
                        default:
                            break;
                    }
                    break;

                case 4:
                    // Aplicar descuento

                    ArrayList<Descuento> descuentos = verDescuentos(user, 1);

                    separador();

                    // Solicitar al usuario que seleccione un vuelo y se selecciona.
                    promptIn("Por favor, seleccione el número del descuento deseado: ");
                    int index = inputI();
                    Descuento descuento = descuentos.get(index);

                    switch (descuento.getTipo()) {
                        case "Mejora de asiento":
                            millasAsiento(user, descuento);
                            break;

                        case "Descuento Vuelo":
                            millasVuelo(user, descuento);
                            break;

                        case "Descuento de maleta":
                            millasMaleta(user, descuento);
                            break;

                        default:
                            break;
                    }

                    break;

                case 5:
                    // Ver descuento
                    promptIn("Desea ver solo los descuentos disponibles/canjeados o los aplicados tambien (1 / 0)");
                    int op = inputI();
                    verDescuentos(user, op);
                    salto();
                    continuar();
                    break;

                case 6:
                    aviso(colorTexto("Volviendo al menu", "rojo"));
                    separador();
                    break;

                default:
                    aviso(colorTexto("Opción incorrecta", "rojo"));
                    break;
            }

            separadorGrande();

        } while (opcion != 6);
    }

    private static void millasAsiento(Usuario user, Descuento descuento) {

        Boleto boleto = selecBoleto(user);
        Asiento asiento = boleto.getAsiento();
        // se verifica que el asiento sea economico
        // si es vip ya no se puede mejorar

        if (asiento.getTipo() == "Economico") {

            // Hacer asiento vip
            ArrayList<Asiento> asientos = (boleto.getVuelo()).getAsientos();

            printNegrita(colorTexto("Asientos disponibles", "morado"));
            salto();
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
            boleto.upgradeAsientoMillas(asiento, newAsiento);
            descuento.aplicarDescuento(boleto);

            separador();
            printNegrita(colorTexto("Mejora de asiento realizado con exito", "verde"));
            salto();

            printNegrita(colorTexto("Detalles del nuevo asiento:", "morado"));
            salto();
            identacion((boleto.getAsiento()).getInfo());
            salto();
            continuar();

        } else {

            descuento.guardar();

            separador();
            printNegrita(colorTexto(
                    "Su asiento ya es VIP, se guardo el descuento en su cuenta", "verde"));
            salto();
            continuar();
            separador();

        }

    }

    private static void millasVuelo(Usuario user, Descuento descuento) {
        Boleto boleto = selecBoleto(user);
        descuento.aplicarDescuento(boleto);

        // Listo, su costo de maleta ha sdo reducido en un % y se ha regresado el dinero
        printNegrita(colorTexto("Se ha aplicado un " +
                descuentoVuelo.descuento + "% de descuento en el valor de su vuelo, ahorro de: "
                + ("$" + ((int) (boleto.getValorInicial() * (0.2)))), "verde"));

        salto();
        continuar();
    }




    private static ArrayList<Descuento> verDescuentos(Usuario user, int op) {

        separador();

        ArrayList<Descuento> descuentos = user.getDescuentos();
        identacion(negrita(colorTexto("Descuentos disponibles:", "morado")), 4);
        salto();

        if (op == 1) {
            // Iterar a través del historial de boletos
            for (int i = 0; i < descuentos.size(); i++) {
                Descuento descuento = descuentos.get(i);

                if (descuento.isUsado() == false) {
                    // Mostrar información de cada boleto en la lista
                    identacion(i + ". " + descuento.getInfo());

                }
            }
        } else {
            // Iterar a través del historial de boletos
            for (int i = 0; i < descuentos.size(); i++) {
                Descuento descuento = descuentos.get(i);
                // Mostrar información de cada boleto en la lista
                identacion(i + ". " + descuento.getInfo());
            }
        }

        return descuentos;
    }

    public static Boleto selecBoleto(Usuario user) {
        // Obtener el historial de boletos del usuario
        ArrayList<Boleto> historial = user.getHistorial();
        salto();
        printNegrita(colorTexto("Información de los vuelos:", "morado"));
        salto();

        // Iterar a través del historial de boletos
        for (int i = 0; i < historial.size(); i++) {
            Boleto boleto = historial.get(i);
            // Mostrar información de cada boleto en la lista
            identacion(i + ". " + boleto.getInfo());
        }
        salto();

        promptIn("Por favor, seleccione el número del vuelo deseado:");
        int indexVuelo = inputI();

        // Obtener el boleto seleccionado por el usuario
        Boleto boleto = historial.get(indexVuelo);

        separador();

        System.out.println(colorTexto("Vuelo seleccionado, información detallada:", "morado"));
        salto();
        identacion(boleto.getInfo());

        salto();
        continuar();
        salto();
        return boleto;
    }

    private static int verificarMillas(Usuario user, int valor) {

        promptIn("Confirmar canjeo de millas (1 si / 0 no)");
        int confirmacion = inputI();
        salto();

        if (confirmacion == 1) {
            if (user.getMillas() >= valor) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    private static void millasMaleta(Usuario user, Descuento descuento) {
        Boleto boleto = selecBoleto(user);
        descuento.aplicarDescuento(boleto);

        // Listo, su costo de maleta ha sdo reducido en un % y se ha regresado el dinero
        printNegrita(colorTexto("Se ha aplicado un " +
                descuentoMaleta.descuento + "% de descuento en el costo de su equipaje, ahorro de: $"
                + ("" + ((int) (boleto.getValorInicial() * 0.2))), "verde"));

        salto();
        continuar();
    }

}
