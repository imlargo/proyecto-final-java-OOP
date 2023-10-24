package gestorAplicacion.Descuentos;

import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

/*
        * Requerimientos (Backend).
        * CLases para la comida (inferfaz de clase)
        * Asignar los descuentos al usuario (arraylist)
        * Cupones de cierto tipo, para cada cosa, descuentos, mejoras de sulla,
        * comida,comida en si (derecho a un almuerzo)
        * Todo eso se asigna tambien al boleto y a la silla y debe ir de la mano con la
        * funcionalidad checkin
        * Cada descuento puede ser una sublclasse de un descuento, quye al momento de
        * ejecutar el metodo sobreescrito aplicar descuento, dependiendo del tiepo
        * Se haga x o y procedimien.
        */

/*
 * Por hacer:
 * crear diferentes tipos de descuentos en una clase abstracta q implementen
 * diferentes metodos "".aplicar()"
 * Descuentos en upgrade de asiento
 * Descuentos al momento de comprar
 * Descuento al momento de pagar comida
 * Comida en si, por ejemplo un cupon para un almuerzo
 */

/*
 * Implementar clase abstracta o interfaz para comidas y como integrarlo con el
 * usuario
 */

public abstract class Descuento {

    protected Boleto boleto;
    protected Usuario user;
    protected boolean usado = false;
    protected String tipo;
    protected String estado;
    protected Boolean guardado = false;
    protected abstract int costoMillas;

    public void usar() {
        this.estado = "Usado";
        this.usado = true;
        guardar();
    }

    public Boolean isUsado() {
        return this.usado;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void guardar() {
        if (this.guardado == false) {
            this.user.addDescuento(this);
            this.guardado = true;
        }
    }

    public void init(Usuario user) {
        this.user = user;
        this.estado = "Disponible";
    }

    public abstract void aplicarDescuento(Boleto boleto);

    public String getInfo() {
        return negrita("Tipo: ") + this.tipo + negrita(", Estado: ") + this.estado;
    }
}