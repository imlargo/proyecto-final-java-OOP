package Aerolinea;

import java.io.Serializable;
import java.util.ArrayList;

import Aerolinea.*;

public class Boleto implements Serializable {
    private static final long serialVersionUID = 0;

    private String id;
    private String tipo;
    private Usuario user;
    private String status = "Comprado";
    private String origen;
    private String destino;

    private int valor;

    private ArrayList<Maleta> equipaje = new ArrayList<>();
    private Asiento asiento;
    private Pasajero pasajero;
    
    //...precios
    private int valorInicial;
    private int valorEquipaje;
    //precios...

    private Vuelo vuelo;

    public Boleto (String origen, String destino, Usuario propietario, Vuelo vuelo) {
        this.origen = origen;
        this.destino = destino;
        this.user = propietario;
        this.vuelo = vuelo;
        this.pasajero = new Pasajero(propietario, this);
    }

    public void updateValor() {
        int temp = 0;
        for (Maleta maleta : equipaje) {
            temp += maleta.calcularPrecio();
        }
        this.valorEquipaje = temp;
        this.valor = this.valorInicial + this.valorEquipaje;
    }


    public void asignarAsiento(Asiento asiento) {
        this.asiento = asiento;
        asiento.asignarBoleto(this);
        this.valorInicial = asiento.getValor();
        this.tipo = asiento.getTipo();
    }

    public void resetEquipaje() {
        this.equipaje = null;
        this.valor = 0;
    }

    public String getOrigenDestino() {
        return this.origen + " - " + this.destino;
    }

    public void addEquipaje(Maleta maleta) {
        this.equipaje.add(maleta);
        this.updateValor();
    }
    public String getInfo() {
        return "Precio: " + this.valor +  ", Tipo: " + this.tipo + ", Numero de asiento: " + this.asiento.getN_silla() + "...";
    }


    //...Metodos get y set...


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArrayList<Maleta> getEquipaje() {
        return this.equipaje;
    }

    public void setEquipaje(ArrayList<Maleta> equipaje) {
        this.equipaje = equipaje;
    }

    public Asiento getAsiento() {
        return this.asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
        this.valorInicial = asiento.getValor();
        this.tipo = asiento.getTipo();
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public int getValorInicial() {
        return this.valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorEquipaje() {
        return this.valorEquipaje;
    }

    public void setValorEquipaje(int valorEquipaje) {
        this.valorEquipaje = valorEquipaje;
    }

    public Vuelo getVuelo() {
        return this.vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }


}