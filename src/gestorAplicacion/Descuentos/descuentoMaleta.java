package gestorAplicacion.Descuentos;
import java.io.Serializable;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

import static uiMain.Estetica.*;

public class descuentoMaleta extends Descuento implements  Serializable{

    //private static final long serialVersionUID;
    
    public static int costoMillas = 1;

    public descuentoMaleta(Usuario user) {
        this.user = user;
        this.tipo = "";
    }

    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        this.usar();
    }

    public String getInfo() {
        return "";
    }
}