package gestorAplicacion.Aerolinea;

import java.io.Serializable;
import gestorAplicacion.Aerolinea.*;
import static uiMain.Estetica.*;

/**
 * Clase que representa un asiento en una aerolínea que esta contenido en un vuelo.
 */

public class Asiento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipo; // Tipo de asiento (ejemplo: "Económico", "Primera Clase")
    private Boolean vip; // Indica si es un asiento VIP o no
    private Pasajero pasajero; // Pasajero asignado al asiento
    private int n_silla; // Número de silla del asiento
    private boolean disponible = true; // Indica si el asiento está disponible o no
    private String status = "Disponible"; // Estado del asiento (ejemplo: "Disponible", "Asignado")
    private Boleto boleto; // Boleto asociado al asiento
    private final float valor; // Valor base del asiento

    /**
     * Constructor de la clase Asiento.
     *
     * @param tipo  Tipo de asiento.
     * @param n_silla  Número de silla.
     * @param valor  Valor del asiento.
     */
    public Asiento(String tipo, int n_silla, float valor) {
        this.tipo = tipo;
        this.n_silla = n_silla;
        this.valor = valor;
    }

    /**
     * Asigna un boleto al asiento, marcándolo como "Asignado" y asociando un pasajero.
     *
     * @param boleto  Boleto a asignar.
     */
    public void asignarBoleto(Boleto boleto) {
        this.boleto = boleto;
        this.pasajero = boleto.getPasajero();
        this.disponible = false;
        this.status = "Asignado";
    }

    /**
     * Desasigna el boleto del asiento, marcándolo como "Disponible" y desvinculando al pasajero.
     */
    public void desasignarBoleto() {
        this.boleto = null;
        this.pasajero = null;
        this.disponible = true;
        this.status = "Disponible";
    }

    /**
     * Obtiene la información del asiento.
     *
     * @return  Información del asiento en formato de cadena.
     */
    public String getInfo() {
        return n_silla + ". Tipo: " + tipo + ", Valor: $" + valor;
    }

    // Métodos de acceso (Getters y Setters)

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
