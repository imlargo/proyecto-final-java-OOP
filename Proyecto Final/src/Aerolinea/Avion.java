package Aerolinea;

import java.io.Serializable;// clase para serializar
import 



public class Avion implements Serializable{ // se crea la clase e implementa serializacion

	private Static final long serialVersionUID ; // atributo con el codigo de serializacion 
	 
	private Asiento asientos; // se crean los atributos requeridos para la clase
	private final String AEROLINEA;
	private final String ID;
	private String horarioSalida;
	private String horarioLlegada;
	private final String DESTINO;
	private final String ORIGEN;
	private Maleta[] equipajes;// en esta lista se guardarán los equipajes con su respectiva especificacion
	
	public Avion(String aerolinea ,private id, String tiempoSalida, String tiempoLlegada,String Destino,String origen) {
		this.AEROLINEA = aerolinea;
		this.ID = id;
		this.horarioSalida =tiempoSalida;
		this.horarioLlegada = tiempoLlegada;
		this.DESTINO = Destino;
		this.ORIGEN = origen ;
		
	}

	public void addEquipaje( equipaje ){//añade equipaje a la lista de equipajes
		
		this.equipajes.add(equipaje);

	}

	public void deleteEquipaje( equipaje){
		
		this.equipajes.delete(equipaje);

	}


	public void  setHorarioSalida(String horariosalida){

		this.horarioSalida =  horario;

	}
	public void  setHorarioLlegada(String horariollegada){

		this.horarioLlegada = horariollegada;

	}
	public Asiento  getAsientos(){

		return this.asientos;

	}

	public String  getAerolinea(){
		
		return this.AEROLINEA;
		
	}
	public String  getId(){

		return this.ID;
		
	}
	public String  getHorarioSalida(){
		
		return this.horarioSalida;
		
	}
	public void  getHorarioLlegada(){

		return this.horarioLlegada;
		
	}
	public String  getDestino(){

		return this.DESTINO;
		
	}
	public void  getOrigen(){

		return this.ORIGEN;
		
	}
	public Maleta[]  getEquipajes(){

		return this.equipajes;
		
	}

}

