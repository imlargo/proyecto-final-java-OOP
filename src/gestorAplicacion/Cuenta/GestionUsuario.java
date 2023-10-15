package gestorAplicacion.Cuenta;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.Aerolinea.*;

public class GestionUsuario {

    public ArrayList<Usuario> Usuarios = new ArrayList<>();
    public Usuario user = null;
    public ArrayList<Maleta> inventarioMaletas = new ArrayList<>();

    public GestionUsuario() {
        Usuario user = new Usuario("largo", "admin", "123", 0);
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

    public Usuario registrarUsuario(String nombre, String correo, String contrasena) {
        // Verificar si el correo electrónico y id están registrados
        for (Usuario usuario : Usuarios) {
            if (usuario.getMail().equals(correo)) {
                return null;
            }
        }
        // Si no está registrado, agregar el nuevo user
        Usuario usuario = new Usuario(nombre, correo, contrasena, 1);
        Usuarios.add(usuario);
        this.user = usuario;
        return usuario;
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

    

    // Rastrear maleta por ID
    public String rastrearMaleta(int tipo, int value) {

        switch (tipo) {
            case 1:
                // Rastreo por id de la maleta
                // Por cada boleto que tiene asociado un vuelo encuentra el asiento y las
                // maletas asociadas y tambien da informacion
                Boleto encontrado = null;
                for (Boleto boleto : this.user.getHistorial()) {
                    for (Maleta maleta : boleto.getEquipaje()) {
                        if (maleta.getId() == value) {
                            encontrado = boleto;
                            return "La maleta se encuentra en el vuelo X con info";
                        }
                    }
                }
                Asiento asiento = encontrado.getAsiento();

                break;

            case 2:
                // Rastreo de maleta en un vuelo
                break;

            case 3:
                // Tipo de equipaje
                break;

            default:
                break;
        }

        return null;
    }
}