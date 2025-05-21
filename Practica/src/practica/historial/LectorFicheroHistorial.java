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
 * Esta clase extiende de ObjectInputStream para leer objetos de un archivo
 * que contiene un historial de partidas. Proporciona un método para leer 
 * y construir un historial completo de todas las partidas almacenadas en el archivo.
 */
public class LectorFicheroHistorial extends ObjectInputStream {

    /**
     * Constructor que inicializa el flujo de entrada a partir de la ruta del fichero.
     *
     * @param rutaFichero La ruta del fichero desde donde se leerán los objetos.
     * @throws FileNotFoundException Si el fichero especificado no se encuentra.
     * @throws IOException Si ocurre un error al abrir o leer el flujo.
     */
    public LectorFicheroHistorial(String rutaFichero) throws FileNotFoundException, IOException {
        super(new FileInputStream(rutaFichero));
    }

    /**
     * Lee todos los objetos del archivo y construye un historial completo 
     * en formato de texto. Cada partida se representa con información relevante 
     * como el nombre del jugador, las dimensiones del juego, el número de pasos 
     * y la fecha en que se jugó.
     *
     * @return Una cadena de texto que contiene el historial completo de partidas.
     * @throws IOException Si ocurre un error al leer del flujo.
     * @throws ClassNotFoundException Si algún objeto leído no puede ser deserializado.
     */
    public String leerTodo() throws IOException, ClassNotFoundException {
        // Inicializamos un texto vacío para almacenar el historial completo
        String historialCompleto = "";

        try {
            // Contador para identificar el número de la partida actual
            int numeroPartida = 1;

            // Variable para almacenar el objeto actualmente leído del archivo
            RegistroPartida actualRegistroPartida;

            // Bucle para leer objetos hasta que se alcance el final del archivo
            while (true) {
                // Leemos un objeto del flujo y lo convertimos en RegistroPartida
                actualRegistroPartida = (RegistroPartida) readObject();
                
                // Construimos el historial con los detalles de la partida actual
                historialCompleto += "Partida " + numeroPartida + "\n";
                historialCompleto += "\tNombre del jugador: " + actualRegistroPartida.getNombreJugador() + "\n";
                historialCompleto += "\tDimensión: " + actualRegistroPartida.getNumeroColumnas() + " x " + actualRegistroPartida.getNumeroFilas() + "\n";
                historialCompleto += "\tNúmero de pasos: " + actualRegistroPartida.getNumeroPasos() + "\n";
                historialCompleto += "\tFecha jugada: " + actualRegistroPartida.getDatePlayed() + "\n";
                
                // Aumentamos el índice para la siguiente partida
                numeroPartida++;
            }
        } catch (EOFException e) {
            // Se ha llegado al final del fichero, se interrumpe el bucle
        }

        // Retornamos el historial completo en formato de texto
        return historialCompleto;
    }
}