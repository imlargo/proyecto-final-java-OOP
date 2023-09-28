package basedatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectoOutputStream;
import java.io.PrintWriter;
import Aerolinea.*;


public class Serializador {
    private static File rutaTempAvion =  new File("src//basedatos//temp");
    private static File[] FileAvion = new listFile("src//Aerolinea//Avion");
    private static File rutaTempBoleto =  new File("src//basedatos//temp");
    private static File rutaTempMaleta =  new File("src//basedatos//temp");
    private static File rutaTempPasajero =  new File("src//basedatos//temp");
    private static File rutaTempUsuario =  new File("src//basedatos//temp");

    for (File RutaTempArchivoAvion : rutaTempAvion){
        try{
            PwAvion = new PrintWriter(RutaTempArchivoAvion)
        } catch(FileNotFoundException e ){
            e.PrintStackTrace()

        }
    }
         


}