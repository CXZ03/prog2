/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.historial;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Esta clase extiende de EscritorFicheroHistorial y está diseñada para escribir
 * datos en un archivo de historial sin sobrescribir el contenido existente.
 * Sobrescribe el encabezado del flujo para permitir que se concatenen nuevos
 * objetos al archivo.
 */
public class EscritorConcatenadoFicheroHistorial extends EscritorFicheroHistorial {

    /**
     * Constructor que inicializa el flujo de salida para escribir en el
     * archivo.
     *
     * @param out El flujo de salida donde se escribirán los objetos.
     * @throws FileNotFoundException Si el archivo asociado al flujo no se
     * encuentra.
     * @throws IOException Si ocurre un error al inicializar el flujo de salida.
     */
    public EscritorConcatenadoFicheroHistorial(OutputStream out) throws FileNotFoundException, IOException {
        super(out);
    }

    /**
     * Sobrescribe el método writeStreamHeader() para evitar escribir un nuevo
     * encabezado en el flujo de salida. Esto permite que los objetos se
     * concatenen al archivo existente sin sobrescribir su contenido.
     *
     * @throws IOException Si ocurre un error al restablecer el flujo.
     */
    @Override
    protected void writeStreamHeader() throws IOException {
        reset(); // Restablece el flujo para evitar escribir un encabezado duplicado.
    }
}
