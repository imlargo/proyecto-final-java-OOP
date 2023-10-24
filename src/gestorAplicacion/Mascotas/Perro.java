package gestorAplicacion.Mascotas;

import java.util.ArrayList;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * La clase `Perro` es una subclase de `Animal` que representa a un perro como mascota. Proporciona atributos específicos como el tamaño y el peso, así como métodos para determinar si un perro puede viajar en la cabina o en la bodega de carga de un avión. También incluye una lista de razas excluidas de volar en la cabina y en la bodega.
 */
public class Perro extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private double tamano; // Tamaño del perro
    private double peso;  // Peso del perro

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
    private static final double PESO_MAXIMO_BODEGA = 30.0;

    /**
     * El tamaño máximo permitido en la bodega de carga de un avión.
     */
    private static final double TAMANO_MAXIMO_BODEGA = 30.0;

    /**
     * El peso máximo permitido en la cabina de un avión.
     */
    private static final double PESO_MAXIMO_CABINA = 8.0;

    /**
     * El tamaño máximo permitido en la cabina de un avión.
     */
    private static final double TAMANO_MAXIMO_CABINA = 20.0;

    static {
        // Agregar las razas que están excluidas de volar en la cabina
        razasExcluidasCabina.add("Bulldog");
        razasExcluidasCabina.add("Dóberman");
        razasExcluidasCabina.add("Pitbull");
        razasExcluidasCabina.add("Rottweiler");

        // Agregar las razas que están excluidas de volar en la bodega
        razasExcluidasBodega.add("Pitbull");
        razasExcluidasBodega.add("Rottweiler");
    }

    /**
     * Constructor de la clase `Perro` que inicializa el nombre, la raza, el tamaño y el peso del perro.
     *
     * @param nombre El nombre del perro.
     * @param raza La raza del perro.
     * @param tamano El tamaño del perro.
     * @param peso El peso del perro.
     */
    public Perro(String nombre, String raza, double tamano, double peso) {
        super(nombre, raza);
        this.tamano = tamano;
        this.peso = peso;
    }

    /**
     * Obtiene el peso del perro.
     *
     * @return El peso del perro.
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Establece el peso del perro.
     *
     * @param peso El peso del perro.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el tamaño del perro.
     *
     * @return El tamaño del perro.
     */
    public double getTamano() {
        return this.tamano;
    }

    /**
     * Establece el tamaño del perro.
     *
     * @param tamano El tamaño del perro.
     */
    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    /**
     * Determina si el perro puede viajar en la cabina de un avión verificando su raza, peso y tamaño.
     *
     * @return true si el perro puede viajar en la cabina; false en caso contrario.
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
     * Determina si el perro puede viajar en la bodega de carga de un avión verificando su raza, peso y tamaño.
     *
     * @return true si el perro puede viajar en la bodega; false en caso contrario.
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
     * Representación en forma de cadena de un objeto `Perro`.
     *
     * @return Una cadena que representa las características del perro.
     */
    public String toString() {
        return "nombre: " + this.getNombre() + ", raza: " + this.getRaza() + ", especie: Perro";
    }
}
