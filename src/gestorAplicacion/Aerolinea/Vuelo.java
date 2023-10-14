package gestorAplicacion.Aerolinea;

import java.io.Serializable;// clase para serializar
import java.util.ArrayList;

public class Vuelo implements Serializable { // se crea la clase e implementa serializacion

	private static final long serialVersionUID = 0; // atributo con el codigo de serializacion

	ArrayList<Asiento> asientos = new ArrayList<>();
	private final String AEROLINEA;
	private final String ID;
	private String horarioSalida;
	private String horarioLlegada;
	private final String DESTINO;
	private final String ORIGEN;
	private ArrayList<Maleta> equipajes = new ArrayList<>();

	public Vuelo(String origen, String destino, String aerolinea, String id, String tiempoSalida, String tiempoLlegada) {
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
            String aerolinea = "Latam";
            String id = Integer.toString(i);
            String hSalida = "69:69";
            String hLlegada = "";
            vuelos.add(new Vuelo(origen, destino, aerolinea, id, hSalida, hLlegada));
        }
        return vuelos;
    }

	public void generarAsientos(int economicos, int premium, float base) {
		/*
		 * Dependiendo de la cantidad que se le pase, genera n asientos de tipo vip y
		 * j asientos de tipo economico
		 */

		for (int i = 1; i <= premium; i++) {
			this.asientos.add(new Asiento("Vip", i, (float)(base*1.25)));
		}
		for (int j = premium+1; j <= premium + economicos; j++) {
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
		String info = "Id: " + this.ID + ", Origen: " + this.ORIGEN + ", Destino: " + this.DESTINO;
		return info;
	}


	//...Metodos get y set...

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
