
public class Asiento {
    
    private int n_asiento;
    private String tipo;
    
    private Pasajero pasajero;
    private Boleto boleto;

    //Constructor asiento.
    public Asiento(int n_asiento, String tipo) {
        this.n_asiento = n_asiento;
        this.tipo = tipo;
    }
    
    public void asignarPasajero(Pasajero pasajero, Boleto boleto) {
        this.pasajero = pasajero;
        this.boleto = boleto;
    }

    public void resetAsiento() {
        this.tipo = null;
        this.pasajero = null;
        this.n_asiento = null;
        this.boleto = null;
    }
}