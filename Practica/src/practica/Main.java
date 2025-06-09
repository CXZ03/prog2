// Autores: David González Lastra y Xiaozhe Cheng

package practica;

import practica.gui.Ventana;

/**
 * Clase principal donde inicia la ejecución del programa. Contiene el método
 * main() que crea y muestra la ventana principal del juego.
 */
public class Main {

    /**
     * Método principal que se ejecuta al iniciar el programa.
     *
     * @param args No se requieren argumentos de entrada para este programa.
     */
    public static void main(String[] args) {
        // Crear y mostrar la ventana principal
        new Ventana().setVisible(true);
    }
}
