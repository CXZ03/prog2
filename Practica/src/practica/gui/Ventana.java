/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import practica.excepciones.ExcepcionMovimientoIlegal;
import practica.excepciones.ExcepcionPuntoFueraDelTablero;

/**
 * Esta clase será un JFrame y funcionará como el contenedor del tablero
 * @author cxz03
 */
public class Ventana extends JFrame {
    private static final String TITULO = "ROMPECABEZAS";
    private Tablero tablero;
    
    public Ventana(Tablero tablero) {
        this.tablero = tablero;
        this.iniciarlizarComponentes();
        this.setTitle(TITULO);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setMaximizedBounds(null);
        this.pack();
        this.setLocationRelativeTo(null);   // después del método pack() para que se coloque al centro después de ajustar el tamaño de la ventana.
    }
    private void iniciarlizarComponentes() {
        this.add(tablero);
    }
}
