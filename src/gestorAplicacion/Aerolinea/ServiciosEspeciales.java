package gestorAplicacion.Aerolinea;

public enum ServiciosEspeciales {
	COMIDA_A_LA_CARTA("Comida a la carta", 40),
	MASCOTA_EN_CABINA("Mascota en cabina", 40),
	MASCOTA_EN_BODEGA("Mascota en bodega", 30),
	ACOMPANANTE_PARA_MENOR("Acompañante para menor", 15),
	ASISTENCIA_NECESIDADES_ESPECIALES("Asistencia para pasajero con necesidades especiales", 0),
	TRANSPORTE_TERRESTRE("Transporte terrestre", 70);

	private String servicio;
	private int precio;

	ServiciosEspeciales(String servicio, int precio) {
		this.servicio = servicio;
		this.precio = precio;
	}

	public String getServicio() {
		return this.servicio;
	}

	public int getPrecio() {
		return this.precio;
	}
}