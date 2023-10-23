package gestorAplicacion.Descuentos;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

public class descuentoVuelo extends Descuento {

    public static int costoMillas = 1;

    public descuentoVuelo(Usuario user, Boleto boleto) {
        this.user = user;
        this.boleto = boleto;
    }

    public int aplicarDescuento(){
        return 0;
    }
    
}
