package gestorAplicacion.Aerolinea;

/**
 * La interfaz RestriccionesMaleta define las restricciones comunes que se aplican a una maleta
 * en una aerolínea, como el peso, el largo, el ancho y el alto.
 */
public interface RestriccionesMaleta {
    /**
     * Peso máximo permitido para una maleta en kilogramos.
     */
    public int peso = 60;

    /**
     * Largo máximo permitido para una maleta en centímetros.
     */
    public int largo = 250;

    /**
     * Ancho máximo permitido para una maleta en centímetros.
     */
    public int ancho = 250;

    /**
     * Alto máximo permitido para una maleta en centímetros.
     */
    public int alto = 250;

    /**
     * Verifica si una maleta cumple con las restricciones de peso, largo, ancho y alto.
     * @return true si la maleta cumple con las restricciones, false en caso contrario.
     */
    public boolean verificarRestricciones();
}
