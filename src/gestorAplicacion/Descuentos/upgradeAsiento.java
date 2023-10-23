package gestorAplicacion.Descuentos;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

public class upgradeAsiento extends Descuento {
    public static int costoMillas = 1;

    public upgradeAsiento(Usuario user, Boleto boleto) {
        this.user = user;
        this.boleto = boleto;
    }

    public int aplicarDescuento() {
        return 0;
    }
}
