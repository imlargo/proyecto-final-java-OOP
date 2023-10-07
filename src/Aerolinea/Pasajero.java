package Aerolinea;

import java.io.Serializable;
import Aerolinea.Maleta;
import Aerolinea.Usuario;
import java.util.ArrayList;

public class Pasajero {
    private static final long serialVersionUID = 0;

    private String nombre;
    private Usuario user;
    private Boleto boleto;

    private boolean trabajador;


    public Pasajero(Usuario user, Boleto boleto) {
        this.nombre = user.getNombre();
        this.boleto = boleto;
    }

    //...Metodos get y set...

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Boleto getBoleto() {
        return this.boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
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


}