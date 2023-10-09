package Aerolinea;

import java.io.Serializable;
import Aerolinea.Boleto;
import java.util.ArrayList;

public class GestionUsuario{
    private Usuario user;
    private ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();

    public GestionUsuario(){

    }
    public Boolean registrarUsuario(Usuario user){
        //Verificar si el correo electrónico y id están registrados
        for (Usuario usuario: Usuarios){
            if (usuario.getCorreo_electronico().equals(user.getCorreo_electronico())){
                System.out.println("Este correo electrónico ya está registrado" );
                return false;
            }
            if (usuario.getId().equals(user.getId())){
                System.out.println("Este id ya está registrado" );
                return false;
            }
        }
        //Si no está registrado, agregar el nuevo user
        Usuarios.add(user);
        System.out.println("Registro exitoso");
        return true;
    }
}