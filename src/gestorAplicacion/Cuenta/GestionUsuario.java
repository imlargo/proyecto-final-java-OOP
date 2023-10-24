package gestorAplicacion.Cuenta;

import java.io.Serializable;
import java.util.ArrayList;


import static uiMain.Estetica.*;
import gestorAplicacion.Aerolinea.*;

public class GestionUsuario implements  Serializable {

    private static final long serialVersionUID;

    public ArrayList<Usuario> Usuarios = new ArrayList<>();
    public Usuario user = null;
    public ArrayList<Maleta> inventarioMaletas = new ArrayList<>();

    public GestionUsuario() {
        Usuario user = new Usuario("imlargod", "admin", "123", 0);
        user.setDinero(1000);
        user.setMillas(120);
        Usuarios.add(user);
    }

    public Usuario iniciarSesion(String mail, String contrasena) {
        for (Usuario usuario : Usuarios) {
            if (usuario.getMail().equals(mail) && usuario.verificarContrasena(contrasena)) {
                this.user = usuario;
                return usuario;
            }
        }
        return null;
    }

    public Usuario cambiarContrasena(Usuario usuario, String contrasena, String nuevaContrasena) {

        if (usuario.verificarContrasena(contrasena)) {
            usuario.setContrasena(nuevaContrasena);
            return usuario;
        } else {
            return null;
        }
    }

    public Usuario getUser() {
        return this.user;
    }

    public Usuario cerrarSesion(Usuario user) {
        this.user = null;
        return null;
    }

    public void canjearMillas(){
        
    }
}