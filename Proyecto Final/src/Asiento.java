
public class Asiento {
    
    private int n_asiento;
    private String tipo;
    
    private Pasajero pasajero;
    private Boleto boleto;

    
    public Asiento(int n_asiento, String tipo) {
        this.n_asiento = n_asiento;
        this.tipo = tipo;
    }
    
    public void asignarPasajero(Pasajero pasajero, Boleto boleto) {
        this.pasajero = pasajero;
        this.boleto = boleto;
    }

    public void resetAsiento() {
        self.tipo = null;
        self.pasajero = null;
        self.n_asiento = null;
        self.boleto = null;
    }
}