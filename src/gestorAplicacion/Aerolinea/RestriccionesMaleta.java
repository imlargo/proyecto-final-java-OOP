package gestorAplicacion.Aerolinea;

public interface RestriccionesMaleta {
    public int peso = 60;
    public int largo = 250;
    public int ancho = 250;
    public int alto = 250;

    public boolean verificarRestricciones();
}
