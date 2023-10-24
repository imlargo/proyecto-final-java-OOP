package gestorAplicacion.Aerolinea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import static uiMain.Estetica.*;

/**
 * La clase Vuelo representa un vuelo de una aerolínea con información sobre el origen, destino,
 * aerolínea, identificador, horario de salida y llegada, asientos y equipajes.
 */
public class Vuelo implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Asiento> asientos = new ArrayList<>();
    private final String AEROLINEA;
    private final String ID;
    private String horarioSalida;
    private String horarioLlegada;
    private final String DESTINO;
    private final String ORIGEN;
    private ArrayList<Maleta> equipajes = new ArrayList<>();

    /**
     * Constructor de la clase Vuelo.
     *
     * @param origen       El origen del vuelo.
     * @param destino      El destino del vuelo.
     * @param aerolinea    El nombre de la aerolínea.
     * @param id           El identificador del vuelo.
     * @param tiempoSalida El horario de salida del vuelo.
     * @param tiempoLlegada El horario de llegada del vuelo.
     */
    public Vuelo(String origen, String destino, String aerolinea, String id, String tiempoSalida, String tiempoLlegada) {
        this.AEROLINEA = aerolinea;
        this.ID = id;
        this.horarioSalida = tiempoSalida;
        this.horarioLlegada = tiempoLlegada;
        this.DESTINO = destino;
        this.ORIGEN = origen;
    }

    /**
     * Genera una lista de vuelos aleatorios.
     *
     * @param cantidad Cantidad de vuelos a generar.
     * @param origen   Origen de los vuelos.
     * @param destino  Destino de los vuelos.
     * @return Una lista de vuelos generados aleatoriamente.
     */
    public static ArrayList<Vuelo> generarVuelos(int cantidad, String origen, String destino) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String aerolinea = "Nn";
            String id = Integer.toString(i);
            String hSalida = generarHora();
            String hLlegada = "Nn";
            vuelos.add(new Vuelo(origen, destino, aerolinea, id, hSalida, hLlegada));
        }
        return vuelos;
    }

    /**
     * Genera una hora de salida aleatoria.
     *
     * @return Una hora de salida aleatoria en formato HH:mm a.m.
     */
    public static String generarHora() {
        String[] horas = {
                "08:00 AM",
                "09:15 AM",
                "10:30 AM",
                "11:45 AM",
                "12:00 PM",
                "01:15 PM",
                "02:30 PM",
                "03:45 PM",
                "04:00 PM",
                "05:15 PM"
        };
        Random rand = new Random();
        return horas[rand.nextInt(horas.length)];
    }

    /**
     * Genera asientos para el vuelo, incluyendo asientos económicos y VIP.
     *
     * @param economicos Cantidad de asientos económicos a generar.
     * @param premium    Cantidad de asientos VIP a generar.
     * @param base       Precio base para los asientos económicos.
     */
    public void generarAsientos(int economicos, int premium, float base) {
        for (int i = 1; i <= premium; i++) {
            this.asientos.add(new Asiento("Vip", i, (float) (base * 1.25)));
        }
        for (int j = premium + 1; j <= premium + economicos; j++) {
            this.asientos.add(new Asiento("Economico", j, base));
        }
    }

    /**
     * Obtiene la información del vuelo en formato "Origen - Destino".
     *
     * @return La información del vuelo en formato "Origen - Destino".
     */
    public String getOrigenDestino() {
        return this.ORIGEN + " - " + this.DESTINO;
    }

    /**
     * Obtiene la información del vuelo.
     *
     * @return La información del vuelo en formato de cadena.
     */
    public String getInfo() {
        String info = "Id: " + this.ID + ", Origen: " + this.ORIGEN + ", Destino: " + this.DESTINO +
                ", Hora salida: " + this.horarioSalida;
        return info;
    }

    // Métodos get y set...

    public ArrayList<Asiento> getAsientos() {
        return this.asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }

    public String getAEROLINEA() {
        return this.AEROLINEA;
    }

    public String getID() {
        return this.ID;
    }

    public String getHorarioSalida() {
        return this.horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public String getHorarioLlegada() {
        return this.horarioLlegada;
    }

    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public String getDESTINO() {
        return this.DESTINO;
    }

    public String getORIGEN() {
        return this.ORIGEN;
    }

    public ArrayList<Maleta> getEquipajes() {
        return this.equipajes;
    }

    public void setEquipajes(ArrayList<Maleta> equipajes) {
        this.equipajes = equipajes;
    }
}
