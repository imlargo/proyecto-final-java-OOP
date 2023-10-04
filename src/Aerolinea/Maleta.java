package Aerolinea;

import java.io.Serializable;
import java.util.ArrayList;

public class Maleta implements Serializable {

    private final static long serialVersionUID = 0;

    private int id;

    private int peso;
    private int largo;
    private int ancho;
    private int alto; // Al fin y al cabo es un volumen

    private Pasajero pasajero; //
    private Boleto boleto;
    private String destino_origen;

    public Maleta(int id, int peso, int largo, int ancho, int alto, Boleto boleto) {
        this.id = id;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.boleto = boleto;
        this.pasajero = boleto.getPasajero();
        this.destino_origen = boleto.getOrigenDestino();
    }

    public int calcularPrecio() {
        return (1/2) * (this.peso + ((this.alto * this.ancho * this.largo) / 10)) + 5; // Crear formula para calcular el valor total con respecto al peso, largo y alto
    }


    //...Metodos get y set...

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return this.ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Boleto getBoleto() {
        return this.boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public String getDestino_origen() {
        return this.destino_origen;
    }

    public void setDestino_origen(String destino_origen) {
        this.destino_origen = destino_origen;
    }


}