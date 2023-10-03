package Aerolinea;

import Aerolinea.Pasajero;

public class Asiento {

    private String tipo;
    private Pasajero pasajero;
    private int n_silla;
    private boolean disponible = true;

    public Asiento(String tipo, int n_silla) {
        this.tipo = tipo;
        this.n_silla = n_silla;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.disponible = false;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
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

}
