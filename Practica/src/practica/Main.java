/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica;

import practica.gestor.GestorTablero;
import practica.gui.Tablero;
import practica.gui.Ventana;
import practica.juego.Puzzle;

/**
 *
 * @author cxz03
 */
public class Main {
    public static int N_COLUMNAS = 3;
    public static int N_FILAS = 3;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero tablero = new Tablero(N_COLUMNAS, N_FILAS);
        Puzzle logicaTablero = new Puzzle(N_COLUMNAS, N_FILAS);
        GestorTablero gestorTablero = new GestorTablero(tablero, logicaTablero);
        new Ventana(tablero).setVisible(true);
    }    
}
