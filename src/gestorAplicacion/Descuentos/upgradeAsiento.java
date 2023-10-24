package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

public class upgradeAsiento extends Descuento implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int costoMillas = 20;

    public upgradeAsiento(Usuario user) {
        this.init(user);
        this.tipo = "Mejora de asiento";
    }

    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        this.estado = "Usado";
        this.usar();
    }

}
