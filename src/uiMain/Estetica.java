package uiMain;

import java.util.Scanner;

// - - - Funciones de estetica - - - 

public class Estetica {

    public static String colorTexto(String text, String color) {
        // Códigos ANSI para colores
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String WHITE = "\u001B[37m";
        String BLUE = "\u001B[36m"; // Cambiado a cyan
        String PURPLE = "\u001B[35m";

        switch (color.toLowerCase()) {
            case "rojo":
                return RED + text + RESET;
            case "verde":
                return GREEN + text + RESET;
            case "amarillo":
                return YELLOW + text + RESET;
            case "blanco":
                return WHITE + text + RESET;
            case "azul":
                return BLUE + text + RESET;

            case "morado":
                return PURPLE + text + RESET;

            default:
                return text;
        }
    }

    public static String negrita(String text) {
        String NEGRITA = "\u001B[1m";
        String RESET = "\u001B[0m";
        return NEGRITA + text + RESET;
    }

    public static void printNegrita(String text) {
        System.out.println(negrita(text));
    }

    public static void salto() {
        System.out.print("\n");
    }

    public static void salto(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
        }
    }

    public static void aviso(String text) {
        System.out.println(negrita(("> > > " + text + " < < <")));
    }

    public static void identacion(String text, int n) {
        String cadena = "";
        for (int i = 0; i < n; i++) {
            cadena += "    ";
        }
        System.out.println(cadena + text);
    }

    public static void identacion(String text) {
        System.out.println("    " + text);
    }

    public static void titulo(String text) {
        System.out.println(negrita("# = = = " + text + " = = = #"));
    }

    // Prompts
    public static void promptIn(String text) {
        System.out.println(negrita(colorTexto(("> " + text), "azul")));
    }
    public static void promptOut(String text) {
        System.out.println(negrita(colorTexto(("> " + text), "morado")));
    }
    
    public static void promptError(String text) {
        System.out.println((colorTexto(("> " + text), "rojo")));
    }


    public static String inputS() {
        System.out.print("  > ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        // scanner.close();
        return s;
    }

    public static int inputI() {
        System.out.print("  > ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // scanner.close();
        return n;
    }
    
    public static double inputD() {
        System.out.print("  > ");
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        // scanner.close();
        return n;
    }

    public static void continuar() {
        promptOut("Presione enter para continuar");
        System.out.print("  >_");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
    }

    public static void separador() {
        salto();
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        salto();
    }

    public static void separadorGrande() {
        salto();
        System.out.println("+ = = = = = = = = = = = = = = = = = = = = = = = +");
        salto();
    }

    
    public static void seleccionado(String text) {
        System.out.println(negrita(colorTexto((" - - - > Seleccion: " + text + " < - - -"), "morado")));
    }

}
