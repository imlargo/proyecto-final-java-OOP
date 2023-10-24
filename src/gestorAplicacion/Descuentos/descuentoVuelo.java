package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

public class descuentoVuelo extends Descuento implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int costoMillas = 1;

    public descuentoVuelo(Usuario user) {
        this.init(user);
        this.tipo = "Descuento Vuelo";
    }

    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        this.estado = "Usado";
        this.usar();
    }

}
