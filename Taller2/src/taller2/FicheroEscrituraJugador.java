/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author cxz03
 */
public class FicheroEscrituraJugador {

    private ObjectOutputStream escritorObjectoFichero;
    
    /**
     * Constructor que asigna la ruta al fichero de escritura.
     * 
     * @param rutaFichero Ruta al fichero de escritura.
     * @param concatenar True si quieres que se concatene el contenido, false para escribir desde el principio.
     * @throws FileNotFoundException Excepción cuando no se encuentra un fichero.
     * @throws IOException Excepción a la hora de realizar IO.
     */
    public FicheroEscrituraJugador(String rutaFichero, boolean concatenar) throws FileNotFoundException, IOException {
        escritorObjectoFichero = new ObjectOutputStream(new FileOutputStream(rutaFichero, concatenar));
    }
    
    /**
     * Escribe un objeto Jugador al fichero.
     * 
     * @param jugadorAEscribir objeto Jugador a escribir.
     */
    public void escribirJugador(Jugador jugadorAEscribir) throws IOException {
        escritorObjectoFichero.writeObject(jugadorAEscribir);
    }
    
    /**
     * Cierra el fichero.
     * 
     * @throws IOException 
     */
    public void cerrar() throws IOException {
        escritorObjectoFichero.close();
    }
}