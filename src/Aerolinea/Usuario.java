package Aerolinea;

import java.io.Serializable;
import Aerolinea.Boleto;
import java.util.ArrayList;

public class Usuario {

	private int dinero;
	private String id;
	private String nombre;
	private int millas;
	private ArrayList<Boleto> historial = new ArrayList<Boleto>();

	public Usuario() {
	}

	public void comprarBoleto(Boleto boleto) {
		this.dinero -= boleto.getValor();
		this.millas += boleto.getValor() * 0.1;
		this.historial.add(boleto);	
	}

	public void cancelarBoleto(Boleto boleto) {
		boleto.setStatus("Cancelado");

	}

	public void reasignarAsiento() {

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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMillas() {
		return this.millas;
	}

	public void setMillas(int millas) {
		this.millas = millas;
	}

	public ArrayList<Boleto> getHistorial() {
		return this.historial;
	}

	public void setHistorial(ArrayList<Boleto> historial) {
		this.historial = historial;
	}


}