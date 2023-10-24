package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

/**
 * La clase `upgradeAsiento` es una subclase de `Descuento` que representa un descuento que se aplica para mejorar el asiento en un boleto de aerolínea. Este descuento cambia el estado del descuento a "Usado" al aplicarse.
 *
 * @see gestorAplicacion.Cuenta.Usuario
 * @see gestorAplicacion.Aerolinea.Boleto
 * @see gestorAplicacion.Descuentos.Descuento
 * @see uiMain.Estetica
 */
public class upgradeAsiento extends Descuento implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * El costo en millas de activar este descuento.
     */
    public static int costoMillas = 20;

    /**
     * Constructor de la clase `upgradeAsiento` que inicializa el descuento para un usuario y establece su tipo como "Mejora de asiento".
     *
     * @param user El usuario al que se aplica el descuento.
     */
    public upgradeAsiento(Usuario user) {
        this.init(user);
        this.tipo = "Mejora de asiento";
    }

    /**
     * Aplica la mejora de asiento a un boleto cambiando el estado del descuento a "Usado". No realiza cambios en el costo del asiento ni en la cuenta del usuario, ya que este descuento solo marca la mejora de asiento como aplicada.
     *
     * @param boleto El boleto al que se aplica la mejora de asiento.
     */
    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        this.estado = "Usado"; // Cambia el estado del descuento a "Usado"
        this.usar(); // Marca el descuento como usado
    }
}
