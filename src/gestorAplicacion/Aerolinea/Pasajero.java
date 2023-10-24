package gestorAplicacion.Aerolinea;

import java.io.Serializable;

import gestorAplicacion.Cuenta.Usuario;
import java.util.ArrayList;

import static uiMain.Estetica.*;

/**
 * La clase Pasajero representa a un pasajero asociado a un usuario que ha comprado un boleto, se asigna a un asiento.
 * para un vuelo. Contiene información sobre el nombre del pasajero, su usuario y el boleto asociado.
 */
public class Pasajero implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private Usuario user;
    private Boleto boleto;

    /**
     * Constructor de la clase Pasajero.
     * @param user El usuario al que pertenece el pasajero.
     * @param boleto El boleto asociado al pasajero.
     */
    public Pasajero(Usuario user, Boleto boleto) {
        this.nombre = user.getNombre();
        this.user = user;
        this.boleto = boleto;
    }

    /**
     * Obtiene el nombre del pasajero.
     * @return El nombre del pasajero.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del pasajero.
     * @param nombre El nuevo nombre del pasajero.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el usuario al que pertenece el pasajero.
     * @return El usuario asociado al pasajero.
     */
    public Usuario getUser() {
        return this.user;
    }

    /**
     * Establece el usuario al que pertenece el pasajero.
     * @param user El nuevo usuario asociado al pasajero.
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * Obtiene el boleto asociado al pasajero.
     * @return El boleto asociado al pasajero.
     */
    public Boleto getBoleto() {
        return this.boleto;
    }

    /**
     * Establece el boleto asociado al pasajero.
     * @param boleto El nuevo boleto asociado al pasajero.
     */
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
}
