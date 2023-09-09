public class Boleto {
    
    private String id;
    private String tipo;
    private Usuario propietario;

    private String origen;
    private String destino;

    private int valor;
    private int init_valor;
    private Maleta[] equipaje;
    private Asiento asiento;
        
    public Boleto(String id, String tipo, Usuario propietario, Maleta[] equipaje, Asiento asiento, int init_valor, String origen, String destino) {
        
        this.origen = origen;
        this.destino = destino;

        this.id = id;
        this.tipo = tipo;
        this.propietario = propietario;
        this.valor = init_valor;
        this.equipaje = equipaje;
        this.asiento = asiento;
    }
    

    public void updateValor() {
        int valorEquipaje = 0;
        for (Maleta maleta : equipaje) {
            valorEquipaje += maleta.calcularPrecio();
        }
        this.valor = init_valor + valorEquipaje;
    }

    public void resetEquipaje() {
        this.equipaje = null;
        this.updateValor();
    }

    public String getOrigenDestino() {
        return this.origen + " - " + this.destino;
    }

}