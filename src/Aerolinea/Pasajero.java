package Aerolinea;

import java.io.Serializable;
import Aerolinea.Maleta;
import Aerolinea.Usuario;
import java.util.ArrayList;

public class Pasajero {
    private static final long serialVersionUID;

    private String nombre;
    private boolean trabajador;
    private Maleta equipaje;
    private Usuario cuenta;

    public Pasajero(String nombre, boolean trabajador, Maleta equipaje, Usuario cuenta) {
        this.nombre = nombre;
        this.trabajador = trabajador;
        this.equipaje = equipaje;
        this.cuenta = cuenta;
    }

    public void comprarBoleto() {

    }

    // ...get and set

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTrabajador() {
        return this.trabajador;
    }

    public boolean getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(boolean trabajador) {
        this.trabajador = trabajador;
    }

    public Maleta getEquipaje() {
        return this.equipaje;
    }

    public void setEquipaje(Maleta equipaje) {
        this.equipaje = equipaje;
    }

    public Usuario getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Usuario cuenta) {
        this.cuenta = cuenta;
    }

}