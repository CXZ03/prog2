/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import practica.gui.BarraMenuJuego;
import practica.juego.Puzzle;

/**
 *
 * @author cxz03
 */
public class GestorBarraMenu implements ActionListener {

    private BarraMenuJuego barraMenu;
    private Puzzle puzzle;

    public GestorBarraMenu(BarraMenuJuego barraMenu, Puzzle puzzle) {
        this.barraMenu = barraMenu;
        this.barraMenu.asignarGestorBarraMenu(this);
        this.puzzle = puzzle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        // Identificamos que boton ha sido comparando la referencia
        if (source == barraMenu.getBotonResolver()) {
            System.out.println("Resolver...");
            
            puzzle.resolver();
        } else if (source == barraMenu.getBotonMezclar()) {
            System.out.println("Mezclar...");
        } else if (source == barraMenu.getBotonSalir()) {
            System.out.println("Salir...");
        }
    }
}
