package gestorAplicacion.Cuenta;

import java.io.Serializable;
import java.util.ArrayList;

import static uiMain.Estetica.*;
import gestorAplicacion.Aerolinea.*;
import gestorAplicacion.Descuentos.Descuento;


public class Usuario implements  Serializable {
	//private static final long serialVersionUID;

	private int dinero;
	private int id;
	private String nombre;
	private int millas;
	private ArrayList<Boleto> historial = new ArrayList<Boleto>();
	private String mail;
	private String contrasena;

	// ....
	private ArrayList<Descuento> descuentos = new ArrayList<>();

	public Usuario(String nombre, String mail, String contrasena, int id) {
		this.nombre = nombre;
		this.id = id;
		this.mail = mail;
		this.contrasena = contrasena;
	}

	public void comprarBoleto(Boleto boleto) {
		this.dinero -= boleto.getValor();
		this.millas += boleto.getValor() * 0.1;
		this.historial.add(boleto);
		boleto.setStatus("Comprado");
	}

	public void reasignarBoleto(Boleto boleto) {
		this.dinero += (boleto.getValor() * 0.9);
		this.millas -= (boleto.getValor() * 0.1);
	}

	public void cancelarBoleto(Boleto boleto) {
		this.dinero += (boleto.getValor() * 0.5);
		this.millas -= (boleto.getValor() * 0.1);
	}

	public String getInfo() {
		return "Usuario: " + this.nombre + "   ID -" + this.id +
				"\nBalance: " + this.dinero + "\nMillas: " + this.millas +
				"\nVuelos comprados: " + this.historial.size();
	}


	public Boolean verificarContrasena(String contrasena) {
		if (this.contrasena.equals(contrasena)) {
			return true;
		} else {
			return false;
		}
	}

	public void depositarDinero(int valor) {
		this.dinero += valor;
	}

	public void realizarPago(int valor) {
		this.dinero -= valor;
	}

	public void addDescuento(Descuento descuento) {
		this.descuentos.add(descuento);
	}

	

	public void descontarMillas(int valor) {
		this.millas -= valor;
	}

	// ...get and set
	public int getDinero() {
		return this.dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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


	public ArrayList<Descuento> getDescuentos() {
		return this.descuentos;
	}

	public void setHistorial(ArrayList<Boleto> historial) {
		this.historial = historial;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}