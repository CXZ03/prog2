/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica.definicion.Movimiento;
import practica.excepciones.ExcepcionMovimientoIlegal;
import practica.gui.Tablero;
import practica.juego.Puzzle;
import practica.definicion.ColorConsola;

/**
 *
 * @author cxz03
 */
public class GestorTablero implements ActionListener, KeyListener {

    private Tablero tablero;
    private Puzzle puzzle;

    public GestorTablero(Tablero tablero, Puzzle puzzle) {
        this.tablero = tablero;
        iniciarTablero();
        this.puzzle = puzzle;
    }

    private void iniciarTablero() {
        tablero.addKeyListener(this);
        tablero.setFocusable(true);
        tablero.requestFocus();
    }

    private void gestionarTeclaW() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = puzzle.getXPuntoJugador();
        int yPuntoJugadorOrigen = puzzle.getYPuntoJugador();
        puzzle.mover(Movimiento.ARRIBA);
    }

    private void gestionarTeclaA() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = puzzle.getXPuntoJugador();
        int yPuntoJugadorOrigen = puzzle.getYPuntoJugador();
        puzzle.mover(Movimiento.IZQUIERDA);
    }

    private void gestionarTeclaS() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = puzzle.getXPuntoJugador();
        int yPuntoJugadorOrigen = puzzle.getYPuntoJugador();
        puzzle.mover(Movimiento.ABAJO);
    }

    private void gestionarTeclaD() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = puzzle.getXPuntoJugador();
        int yPuntoJugadorOrigen = puzzle.getYPuntoJugador();
        puzzle.mover(Movimiento.DERECHA);
    }

    private void gestionarTeclaPresionada(Movimiento mov) {
        boolean jugadaLegal = true;
        switch (mov) {
            case Movimiento.ARRIBA -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'w'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaW();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }

            case Movimiento.IZQUIERDA -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'a'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaA();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }
            case Movimiento.ABAJO -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 's'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaS();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }
            case Movimiento.DERECHA -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'd'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaD();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }
            default -> System.out.println("---> DEBUG: key pressed <SIN ASIGNAR>");
        }
        if (jugadaLegal && puzzle.estaResuelto()) {
            System.out.println("HAS GANADO");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gestionarTeclaPresionada(Movimiento.obtenerMovimiento(e.getKeyChar()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
