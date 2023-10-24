package gestorAplicacion.Mascotas;

import java.util.ArrayList;
import java.io.Serializable;



/**
 * La clase `Gato` es una subclase de `Animal` que representa a un gato como una mascota. Proporciona atributos específicos como el tamaño y el peso, así como métodos para determinar si un gato puede viajar en la cabina o en la bodega de carga de un avión. También incluye una lista de razas excluidas de volar en la cabina y en la bodega.
 */
public class Gato extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private double tamano; // Tamaño del gato
    private double peso;  // Peso del gato

    /**
     * Una lista de razas excluidas de volar en la cabina de un avión.
     */
    private static ArrayList<String> razasExcluidasCabina = new ArrayList<>();

    /**
     * Una lista de razas excluidas de volar en la bodega de carga de un avión.
     */
    private static ArrayList<String> razasExcluidasBodega = new ArrayList<>();

    /**
     * El peso máximo permitido en la bodega de carga de un avión.
     */
    private static final double PESO_MAXIMO_BODEGA = 20.0;

    /**
     * El tamaño máximo permitido en la bodega de carga de un avión.
     */
    private static final double TAMANO_MAXIMO_BODEGA = 30.0;

    /**
     * El peso máximo permitido en la cabina de un avión.
     */
    private static final double PESO_MAXIMO_CABINA = 6.0;

    /**
     * El tamaño máximo permitido en la cabina de un avión.
     */
    private static final double TAMANO_MAXIMO_CABINA = 15.0;

    static {
        // Agregar las razas que están excluidas de volar en la cabina
        razasExcluidasCabina.add("Siamés");
        razasExcluidasCabina.add("Bengal");
        razasExcluidasCabina.add("Sphynx");
        razasExcluidasCabina.add("Persa");

        // Agregar las razas que están excluidas de volar en la bodega
        razasExcluidasBodega.add("Bengal");
        razasExcluidasBodega.add("Siames");
    }

    /**
     * Constructor de la clase `Gato` que inicializa el nombre, la raza, el tamaño y el peso del gato.
     *
     * @param nombre El nombre del gato.
     * @param raza La raza del gato.
     * @param tamano El tamaño del gato.
     * @param peso El peso del gato.
     */
    public Gato(String nombre, String raza, double tamano, double peso) {
        super(nombre, raza);
        this.tamano = tamano;
        this.peso = peso;
    }

    /**
     * Obtiene el peso del gato.
     *
     * @return El peso del gato.
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Establece el peso del gato.
     *
     * @param peso El peso del gato.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el tamaño del gato.
     *
     * @return El tamaño del gato.
     */
    public double getTamano() {
        return this.tamano;
    }

    /**
     * Establece el tamaño del gato.
     *
     * @param tamano El tamaño del gato.
     */
    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    /**
     * Determina si el gato puede viajar en la cabina de un avión verificando su raza, peso y tamaño.
     *
     * @return true si el gato puede viajar en la cabina; false en caso contrario.
     */
    @Override
    public boolean puedeViajarEnCabina() {
        if (!razasExcluidasCabina.contains(raza) && getPeso() <= PESO_MAXIMO_CABINA
                && getTamano() <= TAMANO_MAXIMO_CABINA) {
            return true;
        }
        return false;
    }

    /**
     * Determina si el gato puede viajar en la bodega de carga de un avión verificando su raza, peso y tamaño.
     *
     * @return true si el gato puede viajar en la bodega; false en caso contrario.
     */
    @Override
    public boolean puedeViajarEnBodega() {
        if (!razasExcluidasBodega.contains(raza) && getPeso() <= PESO_MAXIMO_BODEGA
                && getTamano() <= TAMANO_MAXIMO_BODEGA) {
            return true;
        }
        return false;
    }

    /**
     * Representación en forma de cadena de un objeto `Gato`.
     *
     * @return Una cadena que representa las características del gato.
     */
    public String toString() {
        return "nombre: " + this.getNombre() + ", raza: " + this.getRaza() + ", especie: Gato";
    }
}
