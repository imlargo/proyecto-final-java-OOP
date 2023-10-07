package Aerolinea;

import java.util.ArrayList;
import Aerolinea.*;

public class Aeropuerto {

    public static ArrayList<Vuelo> generarVuelos(int cantidad, String origen, String destino) {

        
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        /*
         * Regresa un array de vuelos
         */

        for (int i = 0; i < cantidad; i++) {
            // Generar vuelos y meterlos al array, devueve al array y puede mostrarse
            // Generar aleatoriamente
            String aerolinea = "Latam";
            String id = Integer.toString(i);
            String hSalida = "69:69";
            String hLlegada = "";    
            vuelos.add(new Vuelo(origen, destino, aerolinea, id, hSalida, hLlegada));
        }
        return vuelos;
    }

}
