package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;
import static uiMain.Estetica.*;
/**
 * La clase `descuentoMaleta` es una subclase de `Descuento` que representa un descuento aplicado a una maleta de un usuario al comprar un boleto de aerolínea. El descuento reduce el costo del equipaje y deposita un porcentaje del valor original en la cuenta del usuario.
 *
 * @see gestorAplicacion.Cuenta.Usuario
 * @see gestorAplicacion.Aerolinea.Boleto
 * @see gestorAplicacion.Descuentos.Descuento
 * @see uiMain.Estetica
 */
public class descuentoMaleta extends Descuento implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * El costo en millas de activar este descuento.
     */
    public static int costoMillas = 20;

    /**
     * El porcentaje de descuento aplicado al costo del equipaje.
     */
    public static int descuento = 20;

    /**
     * Constructor de la clase `descuentoMaleta` que inicializa el descuento para un usuario y establece su tipo como "Descuento de maleta".
     *
     * @param user El usuario al que se aplica el descuento.
     */
    public descuentoMaleta(Usuario user) {
        this.init(user);
        this.tipo = "Descuento de maleta";
    }

    /**
     * Aplica el descuento de maleta a un boleto, reduciendo el costo del equipaje y depositando un porcentaje del valor original en la cuenta del usuario. Actualiza el valor base del boleto y marca el descuento como usado.
     *
     * @param boleto El boleto al que se aplica el descuento.
     */
    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        float retorno = 0.2f; // Porcentaje de retorno del costo del equipaje al usuario
        float valorEquipaje = (float) boleto.getValorEquipaje();
        boleto.setValorEquipaje((float) (valorEquipaje * 0.8)); // Aplicar el descuento al costo del equipaje
        this.user.depositarDinero((int) (valorEquipaje * retorno)); // Depositar un porcentaje del valor original en la cuenta del usuario
        boleto.updateValorBase(); // Actualizar el valor base del boleto
        this.usar(); // Marcar el descuento como usado
    }
}
