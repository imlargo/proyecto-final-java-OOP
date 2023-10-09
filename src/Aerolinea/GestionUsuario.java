package Aerolinea;

import java.io.Serializable;
import Aerolinea.Boleto;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionUsuario {
    Scanner scanner = new Scanner(System.in);
    private Usuario user;
    private ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();

    public GestionUsuario() {

    }

    public Boolean registrarUsuario(Usuario user) {
        // Verificar si el correo electrónico y id están registrados
        for (Usuario usuario : Usuarios) {
            if (usuario.getCorreo_electronico().equals(user.getCorreo_electronico())) {
                System.out.println("Este correo electrónico ya está registrado");
                return false;
            }
            if (usuario.getId().equals(user.getId())) {
                System.out.println("Este id ya está registrado");
                return false;
            }
        }
        // Si no está registrado, agregar el nuevo user
        Usuarios.add(user);
        System.out.println("Registro exitoso");
        return true;
    }

    public String cambiarContrasena(Usuario user) {
        String newContrasena;
        String confirContrasena;
        do {
            System.out.print("Nueva contraseña: ");
            newContrasena = scanner.nextLine();
            System.out.println("Confirmar contraseña: ");
            confirContrasena = scanner.nextLine();
            if (!newContrasena.equals(confirContrasena)) {
                System.out.println("Las contraseñas no coinciden, por favor inténtelo de nuevo");
            }
        } while (newContrasena.equals(confirContrasena));
        user.setContrasena(newContrasena);
        return user.getContrasena();
    }

    public Usuario iniciarSesion(String correo_electronico, String id, String contrasena) {
        for (Usuario usuario : Usuarios) {
            if (usuario.getCorreo_electronico().equals(correo_electronico) && (usuario.getId().equals(id))
                    && usuario.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso");
                return usuario;
            }
        }
        System.out.println("Datos incorrectos");
        return null;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.Usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }

}