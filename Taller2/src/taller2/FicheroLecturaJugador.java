/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author cxz03
 */
public class FicheroLecturaJugador {

    private ObjectInputStream lectorObjectoFichero;
    private String nombreFichero;

    /**
     * Constructor que asigna la ruta del fichero de lectura,
     *
     * @param rutaFichero
     * @throws FileNotFoundException
     * @throws IOException
     */
    public FicheroLecturaJugador(String rutaFichero) throws FileNotFoundException, IOException {
        File ficheroLectura = new File(rutaFichero);
        nombreFichero = ficheroLectura.getName();
        lectorObjectoFichero = new ObjectInputStream(new FileInputStream(ficheroLectura));
    }

    /**
     * Lee el siguiente jugador que hay en el fichero.
     *
     * @return Jugador leido
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Jugador leerJugador() throws IOException, ClassNotFoundException {
        return (Jugador) lectorObjectoFichero.readObject();
    }

    /**
     * Cierra el fichero.
     *
     * @throws IOException
     */
    public void cerrar() throws IOException {
        lectorObjectoFichero.close();
    }

    /**
     * Devuelve el nombre del fichero.
     *
     * @return el nombre del fichero
     */
    public String getNombreFichero() {
        return nombreFichero;
    }
}
