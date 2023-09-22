
public class Pasajero {

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