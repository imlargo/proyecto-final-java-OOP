package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

public class descuentoMaleta extends Descuento implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int costoMillas = 1;

    public descuentoMaleta(Usuario user) {
        this.init(user);
        this.tipo = "Descuento de maleta";
    }

    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;

        this.estado = "Usado";
        this.usar();
    }

}