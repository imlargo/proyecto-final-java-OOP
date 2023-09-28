import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        //Crear las instancias de las clases
        //Se crea una cuenta, y un usuario, etc
     
        System.out.println("Bienvenido");

        //haganme los mensajes para q diga las opciones disponibles
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

    private void comprarVuelo(){
        /*
        Podemos ir dejando una variable local q vaya llevando los valores, puede ser una instancia
        de boleto, y al final se asigna todo, se puede usar boleto para ir calculando el precio y etc
        */

        System.out.println("Ha seleccionado la opción Comprar vuelo");
        System.out.println('Por favor ingrese el orgien'); 
        System.out.println('Por favor ingrese el destino');
        //Despues de haber creado el orgien y el destino necesito generar los vuelos
        //Mostrar vuelos
        //Necesitamos generar vuelos
        

        System.out.println('Selecciona por favor el vuelo');

        System.out.println('Los tipos de asientos disponibles son los siguientes:');
        //Primero muestra los precios de cada tipo de asiento, luego
        //Muestra los asientos disponibles y su tipo:
        System.out.println('Los asientos disponibles son los siguientes:');

        System.out.println('Seleccione el numero de asiento disponible');
        //Si se selecciona y es valido se prosigue...
        //Se muestra una previsualizacion del precio

        System.out.println('Desea continuar?');

        //Si sí, sigue, sino, selecciona otro asiento

        System.out.println('Selecciona si va a añadir equipaje o no');

        // SI la respuesta es si, entonces agrega varios equipajes, sino, no
        //Cada vez q se agrega un equipaje se va mostrando una previsualizacion del precio..
        //Segun la cantidad de equipaje y los precios de cada uni

        System.out.println('Desea finalizar la compra? los detalles serian:');
        //Se muestran todos los detalles de la compra y se pide la confirmacion para pagar

        //Si se confirma se efectua el pago y se asigna todo.
        //--- nota, no se asigna nada hasta q se haya pagado y verificado ---
    }

    private void reasignarVuelo() {
        System.out.println("Ha seleccionado la opción Reasignar vuelo");
        // Aquí puedes poner el código que deseas ejecutar para la Reasignar vuelo.
    }

    private void cancelarVuelo() {
        System.out.println("Ha seleccionado la opción Cancelar vuelo");
        // Aquí puedes poner el código que deseas ejecutar para la Cancelar vuelo.
    }

    private void verCuenta() {
        System.out.println("Ha seleccionado la opción Ver cuenta");
        // Aquí puedes poner el código que deseas ejecutar para la Ver cuenta.
    }

    public void generarVuelos(int cantidad) {
        /*
         * vuels = array
         * Imprime y muestra los vuelos
         * 
         * - Vuelos debe tener un metodo q sea para imprimir el vuelo
         * 
         */
        Vuelo vuelos[] = new Vuelos();

        for (int i = 0; i < cantidad; i++) {
            // Generar vuelos y meterlos al array, devueve al array y puede mostrarse

        }

    }

}
