// Autores: David González Lastra y Xiaozhe Cheng

package practica.gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import practica.gui.BarraMenu;
import practica.gui.Ventana;
import practica.juego.Puzzle;

/**
 * Clase que gestiona los eventos de acción generados por la barra de menú del
 * juego. Permite realizar acciones como resolver, mezclar, salir del juego, y
 * cambiar entre paneles.
 *
 * Implementa ActionListener para manejar los eventos de los botones del menú.
 */
public class GestorBarraMenu implements ActionListener {

    private Ventana ventana; // La ventana principal del juego
    private BarraMenu barraMenu; // La barra de menú asociada
    private Puzzle puzzle; // La lógica del rompecabezas

    /**
     * Constructor que inicializa el gestor con la ventana, barra de menú y
     * lógica del rompecabezas.
     *
     * @param ventana La ventana principal del juego.
     * @param barraMenu La barra de menú que será gestionada.
     * @param puzzle La lógica del rompecabezas.
     */
    public GestorBarraMenu(Ventana ventana, BarraMenu barraMenu, Puzzle puzzle) {
        this.ventana = ventana;
        this.barraMenu = barraMenu;
        this.barraMenu.asignarGestorBarraMenu(this); // Asignar este gestor como listener de la barra de menú
        this.puzzle = puzzle;
    }

    /**
     * Maneja los eventos de acción generados por los botones de la barra de
     * menú.
     *
     * @param e El evento de acción generado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();

        // Identificar el botón presionado y ejecutar la acción correspondiente
        if (source == barraMenu.getBotonResolver()) {
            puzzle.resolver();
        } else if (source == barraMenu.getBotonMezclar()) {
            puzzle.mezclar();
        } else if (source == barraMenu.getBotonSalir()) {
            // Acabar el programa
            System.exit(0);
        } else if (source == barraMenu.getBotonTablero()) {
            ventana.cambiarPanel(Ventana.PANEL_JUEGO);
            ventana.getTablero().requestFocus();
        } else if (source == barraMenu.getBotonHistorial()) {
            ventana.cambiarPanel(Ventana.PANEL_HISTORIAL);
            ventana.actualizarHistorial();
        }
    }
}
