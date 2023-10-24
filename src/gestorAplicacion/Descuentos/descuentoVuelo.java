package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

public class descuentoVuelo extends Descuento implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int costoMillas = 20;
    public static int descuento = 20;

    public descuentoVuelo(Usuario user) {
        this.init(user);
        this.tipo = "Descuento Vuelo";
    }

    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        float retorno = 0.2f;
        float valorVuelo = (float) boleto.getValorInicial();
        boleto.setValorInicial((float) (valorVuelo * 0.8));
        this.user.depositarDinero((int) (valorVuelo * (retorno)));
        boleto.updateValorBase();
        this.usar();
    }

}
