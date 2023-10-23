package gestorAplicacion.Descuentos;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

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

    protected int millasNecesarias;
    protected double porcentajeDescuento;


    public int getMillasNecesarias() {
        return this.millasNecesarias;
    }

    public void setMillasNecesarias(int millasNecesarias) {
        this.millasNecesarias = millasNecesarias;
    }
    
    public double getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public abstract int aplicarDescuento(Usuario usuario);


    

}