/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import practica.gui.BarraMenuJuego;
import practica.gui.Ventana;
import practica.juego.Puzzle;

/**
 *
 * @author cxz03
 */
public class GestorBarraMenu implements ActionListener {

    private Ventana ventana;
    private BarraMenuJuego barraMenu;
    private Puzzle puzzle;

    public GestorBarraMenu(Ventana ventana, BarraMenuJuego barraMenu, Puzzle puzzle) {
        this.ventana = ventana;
        this.barraMenu = barraMenu;
        this.barraMenu.asignarGestorBarraMenu(this);
        this.puzzle = puzzle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        // Identificamos que boton ha sido comparando la referencia
        if (source == barraMenu.getBotonResolver()) {
            puzzle.resolver();
        } else if (source == barraMenu.getBotonMezclar()) {
            puzzle.mezclar();
        } else if (source == barraMenu.getBotonSalir()) {
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
