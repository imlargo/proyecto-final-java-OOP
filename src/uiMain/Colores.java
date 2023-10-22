package uiMain;

public class Colores {

    
    public static String colorTexto(String text, String color) {
        // Códigos ANSI para colores
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String WHITE = "\u001B[37m";
        String BLUE = "\u001B[34m";

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
            default:
                return text;
        }
    }

    public static String negrita(String text) {
        String NEGRITA = "\u001B[1m";
        String RESET = "\u001B[0m";
        return NEGRITA + text + RESET;
    }

    
}
