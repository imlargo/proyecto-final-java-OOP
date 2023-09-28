package Aerolinea;

import java.io.Serializable;
import Boleto;

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
    
}