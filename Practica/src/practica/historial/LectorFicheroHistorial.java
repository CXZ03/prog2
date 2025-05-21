/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.historial;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author cxz03
 */
public class LectorFicheroHistorial extends ObjectInputStream {

    public LectorFicheroHistorial(String rutaFichero) throws FileNotFoundException, IOException {
        super(new FileInputStream(rutaFichero));
    }

    public String leerTodo() throws IOException, ClassNotFoundException {
        // Inicializamos un text vacio para escribir el historial
        String historialCompleto = "";

        try {
            // Contador para saber el numero de la partida actual
            int numeroPartida = 1;

            // Leemos el primer objeto
            RegistroPartida actualRegistroPartida;

            // Leemos hasta el final del fichero
            while (true) {
                // Leemos el objeto
                actualRegistroPartida = (RegistroPartida) readObject();
                
                // Construirmos el texto del historial con el objeto leido
                historialCompleto += "Partida " + numeroPartida + "\n";
                historialCompleto += "\tNombre del jugador: " + actualRegistroPartida.getNombreJugador() + "\n";
                historialCompleto += "\tDimensión: " + actualRegistroPartida.getNumeroColumnas() + " x " + actualRegistroPartida.getNumeroFilas() + "\n";
                historialCompleto += "\tNúmero de pasos: " + actualRegistroPartida.getNumeroPasos() + "\n";
                historialCompleto += "\tFecha jugada: " + actualRegistroPartida.getDatePlayed() + "\n";
                
                // Aumentamos el indece del objeto leido
                numeroPartida++;
            }
        } catch (EOFException e) {
            // Se ha llegado al final de fichero, salimos del bucle
        }

        return historialCompleto;
    }
}
