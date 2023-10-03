package Aerolinea;

import java.io.Serializable;
import Aerolinea.Boleto;
import java.util.ArrayList;

public class Usuario {

	private int dinero;
	private String id;
	private int millas;
	private Boleto historial;

	public Usuario(int dinero, String id, int millas, Boleto historial) {
		this.dinero = dinero;
		this.id = id;
		this.millas = millas;
		this.historial = historial;
	}

	public void comprarBoleto() {

	}

	public void cancelarBoleto() {

	}

	public void reasignarAsiento() {

	}

	public void agregarMillas() {

	}

	public void quitarMillas() {

	}

	// ...get and set

	public int getDinero() {
		return this.dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMillas() {
		return this.millas;
	}

	public void setMillas(int millas) {
		this.millas = millas;
	}

	public Boleto getHistorial() {
		return this.historial;
	}

	public void setHistorial(Boleto historial) {
		this.historial = historial;
	}

}