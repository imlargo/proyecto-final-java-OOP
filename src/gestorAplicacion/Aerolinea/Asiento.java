package gestorAplicacion.Aerolinea;

import gestorAplicacion.Aerolinea.Pasajero;

public class Asiento {

    private String tipo;
    private Pasajero pasajero;
    private int n_silla;
    private boolean disponible = true;
    private String status = "Disponible";
    private Boleto boleto;
    private final float valor;

    public Asiento(String tipo, int n_silla, float valor) {
        this.tipo = tipo;
        this.n_silla = n_silla;
        this.valor = valor;
    }

    public void asignarBoleto(Boleto boleto) {
        this.boleto = boleto;
        this.pasajero = boleto.getPasajero();
        this.disponible = false;
    }

    public void desasignarBoleto() {
        this.boleto = null;
        this.pasajero = null;
        this.disponible = false;
    }

    public String getInfo() {
        return n_silla + ". Tipo: " + tipo + ", Valor: $" + valor; // Muestra la info del asiento
    }

    // ...Metodos get y set...


    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public int getN_silla() {
        return this.n_silla;
    }

    public void setN_silla(int n_silla) {
        this.n_silla = n_silla;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public boolean getDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boleto getBoleto() {
        return this.boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public float getValor() {
        return this.valor;
    }

  

}
