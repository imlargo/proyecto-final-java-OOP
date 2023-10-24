package gestorAplicacion.Mascotas;


/**
 * La clase abstracta `Animal` sirve como una base para representar diferentes tipos de animales que pueden viajar en una aerolínea. Proporciona atributos comunes como el nombre y la raza, y define métodos abstractos para determinar si el animal puede viajar en la cabina o en la bodega de carga de un avión.
 */
public abstract class Animal {
    protected String nombre; // Nombre del animal
    protected String raza;  // Raza del animal

    /**
     * Constructor de la clase `Animal` que inicializa el nombre y la raza del animal.
     *
     * @param nombre El nombre del animal.
     * @param raza La raza del animal.
     */
    public Animal(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }
    
    /**
     * Obtiene el nombre del animal.
     *
     * @return El nombre del animal.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Establece el nombre del animal.
     *
     * @param nombre El nombre del animal.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la raza del animal.
     *
     * @return La raza del animal.
     */
    public String getRaza() {
        return this.raza;
    }
    
    /**
     * Establece la raza del animal.
     *
     * @param raza La raza del animal.
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    /**
     * Método abstracto que debe ser implementado en las subclases para determinar si el animal puede viajar en la cabina de un avión.
     *
     * @return true si el animal puede viajar en la cabina; false en caso contrario.
     */
    public abstract boolean puedeViajarEnCabina();
    
    /**
     * Método abstracto que debe ser implementado en las subclases para determinar si el animal puede viajar en la bodega de carga de un avión.
     *
     * @return true si el animal puede viajar en la bodega de carga; false en caso contrario.
     */
    public abstract boolean puedeViajarEnBodega();
}
