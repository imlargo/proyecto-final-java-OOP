package gestorAplicacion.Descuentos;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;
import static uiMain.Estetica.*;

public class descuentoComida extends Descuento {

    public static int costoMillas = 1;
    
    public descuentoComida(Usuario user) {
        this.user = user;
        this.tipo = "";
    }

    public void aplicarDescuento(Boleto boleto) {
        this.boleto = boleto;
        this.usar();
    }

    public String getInfo() {
        return negrita("Tipo: ") + this.tipo + negrita(", Estado: ") + "Disponible";
    }
    
}
