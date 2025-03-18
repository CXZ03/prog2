/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.juego;

import practica.excepciones.ExcepcionMovimientoIlegal;

/**
 *
 * @author cxz03
 */
public class LogicaTablero {

    private int[][] estadoPiezas;
    private int numFilas;
    private int numColumnas;
    private int xPuntoJugador = 0;
    private int yPuntoJugador = 0;

    public LogicaTablero(int numColumnas, int numFilas) {
        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
        this.estadoPiezas = new int[numColumnas][numFilas];
        inicializarEstadoPiezas();
    }

    private void inicializarEstadoPiezas() {
        int numActual = 0;
        for (int j = 0; j < numFilas; j++) {
            for (int i = 0; i < numColumnas; i++) {
                estadoPiezas[i][j] = numActual++;
            }
        }
    }

    public void moverHaciaArriba() throws ExcepcionMovimientoIlegal {
        if (yPuntoJugador <= 0) {
            throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaArriba -> yPuntoJugador <= 0, no se puede mover hacia arriba");
        }
        intercambiarPiezas(xPuntoJugador, yPuntoJugador, xPuntoJugador, yPuntoJugador - 1);
        yPuntoJugador--;
    }

    public void moverHaciaAbajo() throws ExcepcionMovimientoIlegal {
        if (yPuntoJugador >= numFilas - 1) {
            throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaAbajo -> yPuntoJugador >= numFilas - 1, no se puede mover hacia abajo");
        }
        intercambiarPiezas(xPuntoJugador, yPuntoJugador, xPuntoJugador, yPuntoJugador + 1);
        yPuntoJugador++;
    }

    public void moverHaciaIzquierda() throws ExcepcionMovimientoIlegal {
        if (xPuntoJugador <= 0) {
            throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaIzquierda -> xPuntoJugador <= 0, no se puede mover hacia izquierda");
        }
        intercambiarPiezas(xPuntoJugador, yPuntoJugador, xPuntoJugador - 1, yPuntoJugador);
        xPuntoJugador--;
    }

    public void moverHaciaDerecha() throws ExcepcionMovimientoIlegal {
        if (xPuntoJugador >= numColumnas - 1) {
            throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaDerecha -> xPuntoJugador >= numColumna - 1, no se puede mover hacia derecha");
        }
        intercambiarPiezas(xPuntoJugador, yPuntoJugador, xPuntoJugador + 1, yPuntoJugador);
        xPuntoJugador++;
    }

    private void intercambiarPiezas(int x1, int y1, int x2, int y2) {
        int tmp = estadoPiezas[x1][y1];
        estadoPiezas[x1][y1] = estadoPiezas[x2][y2];
        estadoPiezas[x2][y2] = tmp;
    }
    
    public boolean estaResuelto() {
        int numActual = 0;
        boolean resuelto = true;
        for (int j = 0; (j < numFilas) && resuelto; j++) {
            for (int i = 0; i < numColumnas; i++) {
                if (estadoPiezas[i][j] != numActual++){
                    resuelto = false;
                }
            }
        }
        return resuelto;
    }

    public int getXPuntoJugador() {
        return xPuntoJugador;
    }

    public int getYPuntoJugador() {
        return yPuntoJugador;
    }
    
    
}
