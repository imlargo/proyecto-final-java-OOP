package gestorAplicacion.Aerolinea;

import java.util.Random;

import java.io.Serializable;// clase para serializar
import java.util.ArrayList;
import java.util.Random;

import static uiMain.Estetica.*;

public class Vuelo implements Serializable { // se crea la clase e implementa serializacion
	private static final long serialVersionUID = 1L;

	ArrayList<Asiento> asientos = new ArrayList<>();
	private final String AEROLINEA;
	private final String ID;
	private String horarioSalida;
	private String horarioLlegada;
	private final String DESTINO;
	private final String ORIGEN;
	private ArrayList<Maleta> equipajes = new ArrayList<>();

	public Vuelo(String origen, String destino, String aerolinea, String id, String tiempoSalida,
			String tiempoLlegada) {
		this.AEROLINEA = aerolinea;
		this.ID = id;
		this.horarioSalida = tiempoSalida;
		this.horarioLlegada = tiempoLlegada;
		this.DESTINO = destino;
		this.ORIGEN = origen;
	}

	public static ArrayList<Vuelo> generarVuelos(int cantidad, String origen, String destino) {

		ArrayList<Vuelo> vuelos = new ArrayList<>();

		for (int i = 0; i < cantidad; i++) {
			// Generar vuelos y meterlos al array, devueve al array y puede mostrarse
			// Generar aleatoriamente
			String aerolinea = "Nn";
			String id = Integer.toString(i);
			String hSalida = generarHora();
			String hLlegada = "Nn";
			vuelos.add(new Vuelo(origen, destino, aerolinea, id, hSalida, hLlegada));
		}
		return vuelos;
	}

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

	public void generarAsientos(int economicos, int premium, float base) {
		/*
		 * Dependiendo de la cantidad que se le pase, genera n asientos de tipo vip y
		 * j asientos de tipo economico
		 */

		for (int i = 1; i <= premium; i++) {
			this.asientos.add(new Asiento("Vip", i, (float) (base * 1.25)));
		}
		for (int j = premium + 1; j <= premium + economicos; j++) {
			this.asientos.add(new Asiento("Economico", j, base));
		}
	}

	public String getOrigenDestino() {
		return this.ORIGEN + " - " + this.DESTINO;
	}

	public String getInfo() {
		/*
		 * Regresa como string la informacion de origen - destino
		 */
		String info = "Id: " + this.ID + ", Origen: " + this.ORIGEN + ", Destino: " + this.DESTINO + ", Hora salida: "
				+ this.horarioSalida;
		return info;
	}

	// ...Metodos get y set...

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
