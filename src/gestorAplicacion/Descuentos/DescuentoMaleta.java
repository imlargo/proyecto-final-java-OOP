package gestorAplicacion.Descuentos;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Aerolinea.*;

public class DescuentoMaleta extends Descuento{
    
    public int aplicarDescuento(Usuario usuario){
        switch (usuario.getMillas()){
            case 100:
            //Aplicar el 20%
            case 600:
            //Aplicar el 50%
            case 800:
            //Aplicar el 80%
            case 1000:
            //Aplicar el 100%
            
            default:
            return usuario.getMillas();
            //No tiene suficientes millas
        }
        

    }
}