
public class Maleta {
    
    private int id;

    private int peso;
    private int largo;
    private int ancho;

    private Pasajero propietario;
    private Boleto boleto;
    private String destino_origen;
    

    public Maleta(int id, int peso, int largo, int ancho, Pasajero propietario, Boleto boleto) {
        this.id = id;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.propietario = propietario;
        this.boleto = boleto;
        this.destino_origen = boleto.getOrigenDestino();
    }
    
    public int calcularPrecio() {
        return 0; //Crear formula para calcular el valor total con respecto al peso, largo y ancho
    }
}