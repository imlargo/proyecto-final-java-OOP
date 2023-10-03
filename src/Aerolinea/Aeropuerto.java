package Aerolinea;

import java.util.ArrayList;
import Aerolinea.*;

public class Aeropuerto {

    public static ArrayList<Vuelo> generarVuelos(int cantidad) {

        ArrayList<Vuelo> vuelos = new ArrayList<>();
        /*
         * Regresa un array de vuelos
         */

        for (int i = 0; i < cantidad; i++) {
            // Generar vuelos y meterlos al array, devueve al array y puede mostrarse
            // Generar aleatoriamente
            String aerolinea = "";
            String id = "";
            String hSalida = "";
            String hLlegada = "";
            String destino = "";
            String origen = "";
            vuelos.add(new Vuelo(aerolinea, id, hSalida, hLlegada, destino, origen));
        }
        return vuelos;
    }

}
