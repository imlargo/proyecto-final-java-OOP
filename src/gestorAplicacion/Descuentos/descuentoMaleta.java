package gestorAplicacion.Descuentos;

import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

public class descuentoMaleta extends Descuento implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int costoMillas = 20;
    public static int descuento = 20;

    public descuentoMaleta(Usuario user) {
        this.init(user);
        this.tipo = "Descuento de maleta";
    }

    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        float retorno = 0.2f;
        float valorEquipaje = (float) boleto.getValorEquipaje();
        boleto.setValorEquipaje((float) (valorEquipaje * 0.8));
        this.user.depositarDinero((int) (valorEquipaje * (retorno)));
        boleto.updateValorBase();
        this.usar();
    }
}