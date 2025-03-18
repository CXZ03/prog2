/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import practica.excepciones.ExcepcionMovimientoIlegal;
import practica.gui.Tablero;
import practica.juego.LogicaTablero;

/**
 *
 * @author cxz03
 */
public class GestorTablero implements ActionListener, KeyListener {

    private Tablero tablero;
    private LogicaTablero logicaTablero;

    public GestorTablero(Tablero tablero, LogicaTablero logicaTablero) {
        this.tablero = tablero;
        iniciarTablero();
        this.logicaTablero = logicaTablero;
    }

    private void iniciarTablero() {
        tablero.addKeyListener(this);
        tablero.setFocusable(true);
        tablero.requestFocus();
    }

    private void gestionarTeclaW() {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        try {
            logicaTablero.moverHaciaArriba();
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;     // Error no actualizamos el tablero
        }
        tablero.moverHaciaArriba(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    private void gestionarTeclaA() {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        try {
            logicaTablero.moverHaciaIzquierda();
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;
        }
        tablero.moverHaciaIzquierda(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    private void gestionarTeclaS() {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        try {
            logicaTablero.moverHaciaAbajo();
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;
        }
        tablero.moverHaciaAbajo(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    private void gestionarTeclaD() {
        int xPuntoJugadorOrigen = logicaTablero.getXPuntoJugador();
        int yPuntoJugadorOrigen = logicaTablero.getYPuntoJugador();
        try {
            logicaTablero.moverHaciaDerecha();
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;
        }
        tablero.moverHaciaDerecha(xPuntoJugadorOrigen, yPuntoJugadorOrigen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
            case 'W':
                System.out.println("---> DEBUG: key pressed 'w'");
                this.gestionarTeclaW();
                break;
            case 'a':
            case 'A':
                System.out.println("---> DEBUG: key pressed 'a'");
                this.gestionarTeclaA();
                break;
            case 's':
            case 'S':
                System.out.println("---> DEBUG: key pressed 's'");
                this.gestionarTeclaS();
                break;
            case 'd':
            case 'D':
                System.out.println("---> DEBUG: key pressed 'd'");
                this.gestionarTeclaD();
                break;
            default:
                System.out.println("---> DEBUG: key pressed <SIN ASIGNAR>");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
