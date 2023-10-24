package gestorAplicacion.Cuenta;

import java.io.Serializable;
import java.util.ArrayList;

import static uiMain.Estetica.*;
import gestorAplicacion.Aerolinea.*;
import gestorAplicacion.Descuentos.Descuento;

/**
 * La clase Usuario representa a un usuario del sistema, con información sobre
 * su nombre, correo electrónico,
 * contraseña, saldo, millas, historial de boletos comprados y descuentos
 * canjeados.
 */

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private int dinero;
	private int id;
	private String nombre;
	private int millas;
	private ArrayList<Boleto> historial = new ArrayList<Boleto>();
	private String mail;
	private String contrasena;

	// ....
	private ArrayList<Descuento> descuentos = new ArrayList<>(); // Lista de descuentos canjeados con millas

	/**
	 * Constructor de la clase Usuario que inicializa un usuario con su nombre,
	 * correo electrónico, contraseña y ID.
	 *
	 * @param nombre     El nombre del usuario.
	 * @param mail       El correo electrónico del usuario.
	 * @param contrasena La contraseña del usuario.
	 * @param id         El ID del usuario.
	 */
	public Usuario(String nombre, String mail, String contrasena, int id) {
		this.nombre = nombre;
		this.id = id;
		this.mail = mail;
		this.contrasena = contrasena;
	}

	/**
	 * Realiza la compra de un boleto y actualiza el saldo y millas del usuario.
	 *
	 * @param boleto El boleto a comprar.
	 */
	public void comprarBoleto(Boleto boleto) {
		this.dinero -= boleto.getValor();
		this.millas += boleto.getValor() * 0.1;
		this.historial.add(boleto);
		boleto.setStatus("Comprado");
	}

	/**
	 * Realiza la compra de un boleto reasignado sin actualizar el historial de
	 * boletos ya que ya se encuentra ahi.
	 * Relacion con la funcionalidad reasignar vuelo
	 * 
	 * @param boleto El boleto a comprar.
	 */
	public void comprarBoletoReasig(Boleto boleto) {
		this.dinero -= boleto.getValor();
		this.millas += boleto.getValor() * 0.1;
		boleto.setStatus("Comprado");
	}

	/**
	 * Reasigna un boleto y actualiza el saldo y millas del usuario.
	 * Funcionalidad reasignar vuelo
	 * 
	 * @param boleto El boleto a reasignar.
	 */
	public void reasignarBoleto(Boleto boleto) {
		this.dinero += (int) (((float) boleto.getValor()) * 0.9f);
		this.millas -= (int) ((float) boleto.getValor() * 0.1f);
	}

	/**
	 * Cancela un boleto y actualiza el saldo y millas del usuario.
	 * Fucnionalidad cancelar vuelo
	 * 
	 * @param boleto El boleto a cancelar.
	 */
	public void cancelarBoleto(Boleto boleto) {
		this.dinero += (boleto.getValor() * 0.5);
		this.millas -= (boleto.getValor() * 0.1);
	}

	/**
	 * Obtiene información del usuario, incluyendo su nombre, ID, saldo, millas,
	 * cantidad de vuelos comprados y descuentos canjeados.
	 *
	 * @return Información del usuario en formato de cadena.
	 */
	public String getInfo() {
		return "Usuario: " + this.nombre + "   ID -" + this.id +
				"\nBalance: " + this.dinero + "\nMillas: " + this.millas +
				"\nVuelos comprados: " + this.historial.size() +
				"\nDescuentos canjeados: " + this.descuentos.size();
	}

	/**
	 * Verifica si la contraseña proporcionada coincide con la contraseña del
	 * usuario.
	 *
	 * @param contrasena La contraseña a verificar.
	 * @return True si la contraseña coincide, False si no coincide.
	 */
	public Boolean verificarContrasena(String contrasena) {
		if (this.contrasena.equals(contrasena)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deposita una cantidad de dinero en la cuenta del usuario.
	 *
	 * @param valor La cantidad de dinero a depositar.
	 */
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