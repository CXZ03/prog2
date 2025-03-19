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
import practica.excepciones.ExcepcionMovimientoIlegal;
import practica.gui.Tablero;
import practica.juego.Puzzle;
import practica.utilidades.ColorConsola;

/**
 *
 * @author cxz03
 */
public class GestorTablero implements ActionListener, KeyListener {

    private Tablero tablero;
    private Puzzle logicaTablero;

    public GestorTablero(Tablero tablero, Puzzle logicaTablero) {
        this.tablero = tablero;
        iniciarTablero();
        this.logicaTablero = logicaTablero;
    }

    private void iniciarTablero() {
        tablero.addKeyListener(this);
        tablero.setFocusable(true);
        tablero.requestFocus();
    }

    private void gestionarTeclaW() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        logicaTablero.moverHaciaArriba();
        tablero.moverHaciaArriba(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    private void gestionarTeclaA() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        logicaTablero.moverHaciaIzquierda();
        tablero.moverHaciaIzquierda(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    private void gestionarTeclaS() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        logicaTablero.moverHaciaAbajo();
        tablero.moverHaciaAbajo(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    private void gestionarTeclaD() throws ExcepcionMovimientoIlegal {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        logicaTablero.moverHaciaDerecha();
        tablero.moverHaciaDerecha(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    private void gestionarTeclaPresionada(char letraTecla) {
        boolean jugadaLegal = true;
        switch (letraTecla) {
            case 'w':
            case 'W':
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'w'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaW();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
                break;

            case 'a':
            case 'A':
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'a'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaA();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
                break;
            case 's':
            case 'S':
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 's'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaS();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
                break;
            case 'd':
            case 'D':
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'd'" + ColorConsola.REINICIAR);
                try {
                    this.gestionarTeclaD();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
                break;
            default:
                System.out.println("---> DEBUG: key pressed <SIN ASIGNAR>");
        }
        if (jugadaLegal && logicaTablero.estaResuelto()) {
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
        gestionarTeclaPresionada(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
