package Aerolinea;

import java.io.Serializable;
import 



public class Avion implements Serializable{

	private Static final long serialVersionUID ;
	
	private Asiento asientos;
	private final String AEROLINEA;
	private final String ID;
	private String horarioSalida;
	private String horarioLlegada;
	private final String DESTINO;
	private final String ORIGEN;
	private Maleta[] equipajes;
	
	public Avion(String aerolinea ,private id, String tiempoSalida, String tiempoLlegada,String Destino,String origen) {
		this.AEROLINEA = aerolinea;
		this.ID = id;
		this.horarioSalida =tiempoSalida;
		this.horarioLlegada = tiempoLlegada;
		this.DESTINO = Destino;
		this.ORIGEN = origen ;
		
	}

	public void addEquipaje( equipaje ){

	}

	public void deleteEquipaje( equipaje){

	}


	public void  set(){

	}
	public void  set(){

	}
	public void  set(){

	}
	public void  set(){

	}
	public void  set(){

	}
	public void  set(){

	}
}

