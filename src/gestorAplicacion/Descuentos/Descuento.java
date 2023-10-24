package gestorAplicacion.Descuentos;

import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

/**
 * La clase abstracta `Descuento` es la base para implementar descuentos en un sistema de gestión de aerolíneas. 
 * Proporciona una estructura común para los diferentes tipos de descuentos que se pueden aplicar en el sistema.
 *
 * @see gestorAplicacion.Cuenta.Usuario
 * @see gestorAplicacion.Aerolinea.Boleto
 * @see uiMain.Estetica
 */
public abstract class Descuento {

    protected Boleto boleto; // El boleto al que se aplica el descuento
    protected Usuario user; // El usuario al que se asigna el descuento
    protected boolean usado = false; // Indica si el descuento ha sido usado
    protected String tipo; // El tipo de descuento
    protected String estado; // El estado del descuento (Disponible o Usado)
    protected Boolean guardado = false; // Indica si el descuento ha sido guardado en la cuenta del usuario

    /**
     * Marca el descuento como usado y lo guarda.
     */
    public void usar() {
        this.estado = "Usado";
        this.usado = true;
        guardar();
    }

    /**
     * Comprueba si el descuento ha sido usado.
     *
     * @return true si el descuento ha sido usado; false en caso contrario.
     */
    public Boolean isUsado() {
        return this.usado;
    }

    /**
     * Obtiene el tipo de descuento.
     *
     * @return El tipo de descuento.
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * Guarda el descuento en la cuenta del usuario si aún no ha sido guardado.
     */
    public void guardar() {
        if (!this.guardado) {
            this.user.addDescuento(this);
            this.guardado = true;
        }
    }

    /**
     * Inicializa el descuento con el usuario y establece su estado como "Disponible".
     *
     * @param user El usuario al que se asigna el descuento.
     */
    public void init(Usuario user) {
        this.user = user;
        this.estado = "Disponible";
    }

    /**
     * Método abstracto que debe ser implementado en las subclases para aplicar el descuento a un boleto.
     *
     * @param boleto El boleto al que se aplica el descuento.
     */
    public abstract void aplicarDescuento(Boleto boleto);

    /**
     * Obtiene información sobre el descuento, incluyendo su tipo y estado.
     *
     * @return Una cadena que representa la información del descuento.
     */
    public String getInfo() {
        return negrita("Tipo: ") + this.tipo + negrita(", Estado: ") + this.estado;
    }
}
