import java.util.Scanner;


public class App {

    public static void main(String[] args) {


        System.out.println("Bienvenido")

        //haganme los mensajes para q diga las opciones disponibles
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Comprar vuelo");
            System.out.println("2. Reasignar vuelo");
            System.out.println("3. Cancelar vuelo");
            System.out.println("4. Ver cuenta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la Comprar vuelo");
                    // Aquí puedes poner el código que deseas ejecutar para la Comprar vuelo.
                    break;
                case 2:
                    System.out.println("Ha seleccionado la Reasignar vuelo");
                    // Aquí puedes poner el código que deseas ejecutar para la Reasignar vuelo.
                    break;
                case 3:
                    System.out.println("Ha seleccionado la Cancelar vuelo");
                    // Aquí puedes poner el código que deseas ejecutar para la Cancelar vuelo.
                    break;
                case 4:
                    System.out.println("Ha seleccionado la Ver cuenta");
                    // Aquí puedes poner el código que deseas ejecutar para la Ver cuenta.
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



    }

}
