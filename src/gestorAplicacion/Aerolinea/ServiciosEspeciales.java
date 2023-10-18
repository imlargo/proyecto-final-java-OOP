package gestorAplicacion.Aerolinea;

public enum ServiciosEspeciales {
	COMIDA_A_LA_CARTA("Comida a la carta", 40),
	MASCOTA_EN_CABINA("Mascota en cabina", 50),
	MASCOTA_EN_BODEGA("Mascota en bodega", 30),
	ACOMPAÑANTE_PARA_MENOR("Acompañante para menor", 30),
	ASISTENCIA_NECESIDADES_ESPECIALES("Asistencia para pasajero con necesidades especiales", 0),
	TRANSPORTE_TERRESTRE("Transporte terrestre", 50);
		
	private String servicio;
	private float precio;
		
	ServiciosEspeciales(String servicio, float precio) {
		this.servicio = servicio;
		this.precio = precio;
	}
		 
	String getServicio() {
		return this.servicio;
	}
		
	float getPrecio() {
		return this.precio;
	}	
}
