/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase lee la lista de los nombre del fichero de nombre de jugadores
 *
 * @author cxz03
 */
public class FicheroLecturaNombreJugador {

    private final String RUTA_FICHERO_NOMBRE_JUGADOR;

    /**
     * Constructor que especifica la ruta del fichero de nombres.
     * 
     * @param rutaFicheroNombreJugador ruta del fichero de nombres.
     * @throws FileNotFoundException no se ha encontrado el fichero.
     */
    public FicheroLecturaNombreJugador(String rutaFicheroNombreJugador) throws FileNotFoundException {
        RUTA_FICHERO_NOMBRE_JUGADOR = rutaFicheroNombreJugador;
    }
    
    /**
     * Lee en el fichero RUTA_FICHERO_NOMBRE_JUGADOR la cantidad de jugadores.
     * 
     * @param cantidad cantidad de jugadores a leer.
     * @return la lista de los nombres de jugador.
     * @throws IOException
     * @throws EOFException no hay tantos nombres de jugadores como la cantidad espacificada.
     */
    public String[] leerNombresJugador(int cantidad) throws IOException, EOFException {
        // Creamos un array vacio de resultado y inicializamos el BufferedReader
        String nombresJugador[] = new String[cantidad];
        BufferedReader lectorFichero = new BufferedReader(new FileReader(RUTA_FICHERO_NOMBRE_JUGADOR));
        
        // Leemos los nombres del fichero que cada uno ocupa una linea
        for (int i = 0; i < cantidad; i++) {
            nombresJugador[i] = lectorFichero.readLine();
        }
        
        // Cerramos el lector de fichero
        lectorFichero.close();
        
        // Devolvemos la lista de nombres
        return nombresJugador;
    }
}
