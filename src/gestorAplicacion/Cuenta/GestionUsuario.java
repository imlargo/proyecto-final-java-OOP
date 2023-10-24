package gestorAplicacion.Cuenta;

import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicacion.Aerolinea.*;
import static uiMain.Estetica.*;

/**
 * La clase GestionUsuario se encarga de gestionar a los usuarios, incluyendo iniciar sesión,
 * cambiar contraseñas y llevar un inventario de maletas.
 */
public class GestionUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public ArrayList<Usuario> Usuarios = new ArrayList<>();
    public Usuario user = null;
    public ArrayList<Maleta> inventarioMaletas = new ArrayList<>();

    /**
     * Constructor de la clase GestionUsuario que inicializa un usuario de ejemplo y lo agrega a la lista de usuarios.
     */
    public GestionUsuario() {
        Usuario user = new Usuario("Jaime A. Guzman", "usuario@gmail.com", "123", 0);
        user.setDinero(2000);
        user.setMillas(150);
        Usuarios.add(user);
    }

    /**
     * Inicia sesión de un usuario utilizando su dirección de correo electrónico y contraseña.
     *
     * @param mail       La dirección de correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     * @return El usuario que ha iniciado sesión o null si no se encuentra.
     */
    public Usuario iniciarSesion(String mail, String contrasena) {
        for (Usuario usuario : Usuarios) {
            if (usuario.getMail().equals(mail) && usuario.verificarContrasena(contrasena)) {
                this.user = usuario;
                return usuario;
            }
        }
        return null;
    }

    /**
     * Cambia la contraseña de un usuario si la contraseña actual es correcta.
     *
     * @param usuario         El usuario que desea cambiar su contraseña.
     * @param contrasena      La contraseña actual del usuario.
     * @param nuevaContrasena La nueva contraseña que se desea establecer.
     * @return El usuario con su contraseña cambiada o null si la contraseña actual es incorrecta.
     */
    public Usuario cambiarContrasena(Usuario usuario, String contrasena, String nuevaContrasena) {
        if (usuario.verificarContrasena(contrasena)) {
            usuario.setContrasena(nuevaContrasena);
            return usuario;
        } else {
            return null;
        }
    }

    /**
     * Obtiene el usuario actualmente conectado.
     *
     * @return El usuario actualmente conectado o null si no hay una sesión activa.
     */
    public Usuario getUser() {
        return this.user;
    }

    /**
     * Cierra la sesión del usuario actual.
     *
     * @param user El usuario cuya sesión se va a cerrar.
     * @return Null para indicar que no hay un usuario en sesión.
     */
    public Usuario cerrarSesion(Usuario user) {
        this.user = null;
        return null;
    }
}
