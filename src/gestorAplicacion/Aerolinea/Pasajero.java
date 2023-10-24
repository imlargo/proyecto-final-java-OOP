package gestorAplicacion.Aerolinea;

import java.io.Serializable;

import gestorAplicacion.Aerolinea.Maleta;
import gestorAplicacion.Cuenta.*;

import java.util.ArrayList;


import static uiMain.Estetica.*;

public class Pasajero implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private Usuario user;
    private Boleto boleto;

    public Pasajero(Usuario user, Boleto boleto) {
        this.nombre = user.getNombre();
        this.boleto = boleto;
    }

    // ...Metodos get y set...

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
}