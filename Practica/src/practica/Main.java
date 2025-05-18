package practica;

import practica.gui.Ventana;

/**
 * Clase donde simplemente tiene la funcion main donde se empieza a ejecutar el
 * programa
 */
public class Main {

    /**
     * Se crea la ventana principal del juego.
     *
     * @param args No se necesita argumento de entrada.
     */
    public static void main(String[] args) {
        new Ventana().setVisible(true);
    }
}
