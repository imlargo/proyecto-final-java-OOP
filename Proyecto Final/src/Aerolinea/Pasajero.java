package Aerolinea;

import java.io.Serializable;
import Maleta;
import Usuario;

public class Pasajero {
    private static final long serialVersionUID; 

    private String nombre;
    private boolean trabajador;
    private Maleta equipaje;
    private Usuario cuenta;
    
    public Pasajero(String nombre, boolean trabajador, Maleta equipaje, Usuario cuenta) {
    	this.nombre = nombre;
    	this.trabajador = trabajador;
    	this.equipaje = equipaje;
    	this.cuenta = cuenta;
    }
    
    public void comprarBoleto() {
    	
    }
	
}