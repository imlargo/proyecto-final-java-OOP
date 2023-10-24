package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

/**
 * La clase `descuentoVuelo` es una subclase de `Descuento` que representa un descuento aplicado a un vuelo al comprar un boleto de aerolínea. El descuento reduce el costo del vuelo y deposita un porcentaje del valor original en la cuenta del usuario.
 *
 * @see gestorAplicacion.Cuenta.Usuario
 * @see gestorAplicacion.Aerolinea.Boleto
 * @see gestorAplicacion.Descuentos.Descuento
 * @see uiMain.Estetica
 */
public class descuentoVuelo extends Descuento implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * El costo en millas de activar este descuento.
     */
    public static int costoMillas = 20;

    /**
     * El porcentaje de descuento aplicado al costo del vuelo.
     */
    public static int descuento = 20;

    /**
     * Constructor de la clase `descuentoVuelo` que inicializa el descuento para un usuario y establece su tipo como "Descuento Vuelo".
     *
     * @param user El usuario al que se aplica el descuento.
     */
    public descuentoVuelo(Usuario user) {
        this.init(user);
        this.tipo = "Descuento Vuelo";
    }

    /**
     * Aplica el descuento de vuelo a un boleto, reduciendo el costo del vuelo y depositando un porcentaje del valor original en la cuenta del usuario. Actualiza el valor base del boleto y marca el descuento como usado.
     *
     * @param boleto El boleto al que se aplica el descuento.
     */
    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        float retorno = 0.2f; // Porcentaje de retorno del costo del vuelo al usuario
        float valorVuelo = (float) boleto.getValorInicial();
        boleto.setValorInicial((float) (valorVuelo * 0.8)); // Aplicar el descuento al costo del vuelo
        this.user.depositarDinero((int) (valorVuelo * retorno)); // Depositar un porcentaje del valor original en la cuenta del usuario
        boleto.updateValorBase(); // Actualizar el valor base del boleto
        this.usar(); // Marcar el descuento como usado
    }
}

