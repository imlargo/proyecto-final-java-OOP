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
	private String correo_electronico;
	private String contrasena;

	public Usuario(int dinero) {
		this.dinero = dinero;
	}

	// No sería mejor este constructor?
	public Usuario(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
	}

	public Usuario(String nombre, String id, String correo_electronico, String contrasena) {
		this.nombre = nombre;
		this.id = id;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
	}

	public void comprarBoleto(Boleto boleto) {
		this.dinero -= boleto.getValor();
		this.millas += boleto.getValor() * 0.1;
		this.historial.add(boleto);
	}

	public void cancelarBoleto(Boleto boleto) {
		this.dinero += (boleto.getValor() * 0.5);
		this.millas -= (boleto.getValor() * 0.1);
	}

	public String getInfo() {
		return "Nombre: " + this.nombre + " / ID: " + this.id +
				"\nBalance: " + this.dinero + "\nMillas: " + this.millas +
				"\nVuelos comprados: " + this.historial.size();
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

	public String getCorreo_electronico() {
		return this.correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}