/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.historial;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Esta clase extiende de ObjectOutputStream y está diseñada para escribir
 * objetos de tipo RegistroPartida en un archivo que almacena un historial de
 * partidas. Proporciona un método específico para escribir una partida en el
 * archivo.
 */
public class EscritorFicheroHistorial extends ObjectOutputStream {

    /**
     * Constructor que inicializa el flujo de salida a partir de un
     * OutputStream.
     *
     * @param out El flujo de salida donde se escribirán los objetos de tipo
     * RegistroPartida.
     * @throws FileNotFoundException Si el archivo asociado al flujo no se
     * encuentra.
     * @throws IOException Si ocurre un error al inicializar el flujo de salida.
     */
    public EscritorFicheroHistorial(OutputStream out) throws FileNotFoundException, IOException {
        super(out);
    }

    /**
     * Escribe un objeto de tipo RegistroPartida en el flujo de salida.
     *
     * @param partidaAGuardar La partida que se desea guardar en el archivo.
     * @throws IOException Si ocurre un error al escribir el objeto en el flujo.
     */
    public void escribirPartida(RegistroPartida partidaAGuardar) throws IOException {
        writeObject(partidaAGuardar);
    }
}
