package Cuenta;

import java.io.Serializable;

import Aerolinea.*;
import java.util.ArrayList;

public class GestionUsuario {

    public ArrayList<Usuario> Usuarios = new ArrayList<>();
    public Usuario user;
    public ArrayList<Maleta> inventarioMaletas = new ArrayList<>();

    public GestionUsuario() {
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

    /*
     * public String cambiarContrasena(Usuario user) {
     * String newContrasena;
     * String confirContrasena;
     * do {
     * System.out.print("Nueva contraseña: ");
     * newContrasena = scanner.nextLine();
     * System.out.println("Confirmar contraseña: ");
     * confirContrasena = scanner.nextLine();
     * if (!newContrasena.equals(confirContrasena)) {
     * System.out.
     * println("Las contraseñas no coinciden, por favor inténtelo de nuevo");
     * }
     * } while (newContrasena.equals(confirContrasena));
     * user.setContrasena(newContrasena);
     * return user.getContrasena();
     * }
     * 
     * 
     * //Rastrear maleta por ID
     * public String rastreoMaleta(int id){
     * Maleta maleta = GestionUsuario.inventarioMaletas.get(id);
     * if (maleta != null) {
     * return
     * "Estado de la maleta con Id( "+id+") y a nombre de ("+maleta.getPasajero().
     * getNombre()+"): "+ maleta.getEstado();
     * } else {
     * return "Maleta no encontrada";
     * }
     * }
     */

}