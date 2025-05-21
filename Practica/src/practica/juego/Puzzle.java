/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.juego;

import java.util.Random;
import practica.definicion.Movimiento;
import practica.excepciones.ExcepcionMovimientoIlegal;
import practica.gui.Tablero;

/**
 *
 * @author cxz03
 */
public class Puzzle {

    private Tablero tablero;

    private String nombreJugador;
    private int[][] estadoPiezas;
    private int numFilas;
    private int numColumnas;
    private int xPuntoJugador;
    private int yPuntoJugador;
    private int contadorPasos;
    private boolean jugable;

    public Puzzle(Tablero tablero, int numColumnas, int numFilas, String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.tablero = tablero;
        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
        estadoPiezas = new int[numColumnas][numFilas];

        mezclar();
    }

    public void mezclar() {
        jugable = true;
        xPuntoJugador = 0;
        yPuntoJugador = 0;
        contadorPasos = 0;
        inicializarEstadoPiezas();
        mezclarPiezas();
        tablero.iniciarPiezas(estadoPiezas, xPuntoJugador, yPuntoJugador, numColumnas, numFilas);
        tablero.iniciarComponentes();
    }

    public void resolver() {
        jugable = true;
        xPuntoJugador = 0;
        yPuntoJugador = 0;
        contadorPasos = 0;
        inicializarEstadoPiezas();
        tablero.iniciarPiezas(estadoPiezas, xPuntoJugador, yPuntoJugador, numColumnas, numFilas);
        tablero.iniciarComponentes();
    }

    private void inicializarEstadoPiezas() {
        int numActual = 0;
        for (int j = 0; j < numFilas; j++) {
            for (int i = 0; i < numColumnas; i++) {
                estadoPiezas[i][j] = numActual++;
            }
        }
    }

    public void mezclarPiezas() {
        Random random = new Random();
        int randomI;
        int randomJ;
        int tmp;
        for (int i = 0; i < estadoPiezas.length; i++) {
            for (int j = 0; j < estadoPiezas[0].length; j++) {
                randomI = random.nextInt(estadoPiezas.length);
                randomJ = random.nextInt(estadoPiezas[0].length);
                tmp = estadoPiezas[i][j];
                estadoPiezas[i][j] = estadoPiezas[randomI][randomJ];
                estadoPiezas[randomI][randomJ] = tmp;
                if (esPuntoJugador(i, j)) {
                    xPuntoJugador = randomI;
                    yPuntoJugador = randomJ;
                } else if (esPuntoJugador(randomI, randomJ)) {
                    xPuntoJugador = i;
                    yPuntoJugador = j;
                }
            }
        }
    }

    private boolean esPuntoJugador(int x, int y) {
        return (xPuntoJugador == x && yPuntoJugador == y);
    }

    public void imprimirEstadoPiezas() {
        for (int i = 0; i < estadoPiezas.length; i++) {
            for (int j = 0; j < estadoPiezas[0].length; j++) {
                System.out.print(estadoPiezas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mover(Movimiento mov) throws ExcepcionMovimientoIlegal {
        // Si no es jugable no hacemos el movimiento
        if (!jugable) {
            return;
        }
        int xNueva = xPuntoJugador;
        int yNueva = yPuntoJugador;
        switch (mov) {
            case Movimiento.ARRIBA:
                if (yPuntoJugador <= 0) {
                    throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaArriba -> yPuntoJugador <= 0, no se puede mover hacia arriba");
                }
                yNueva--;
                break;
            case Movimiento.IZQUIERDA:
                if (xPuntoJugador <= 0) {
                    throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaIzquierda -> xPuntoJugador <= 0, no se puede mover hacia izquierda");
                }
                xNueva--;
                break;
            case Movimiento.ABAJO:
                if (yPuntoJugador >= numFilas - 1) {
                    throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaAbajo -> yPuntoJugador >= numFilas - 1, no se puede mover hacia abajo");
                }
                yNueva++;
                break;

            case Movimiento.DERECHA:
                if (xPuntoJugador >= numColumnas - 1) {
                    throw new ExcepcionMovimientoIlegal("Error: LogicaTablero.java -> moverHaciaDerecha -> xPuntoJugador >= numColumna - 1, no se puede mover hacia derecha");
                }
                xNueva++;
                break;
        }

        // Actualizar la parte gráfica
        intercambiarPiezas(xPuntoJugador, yPuntoJugador, xNueva, yNueva);
        tablero.intercambiarPieza(xPuntoJugador, yPuntoJugador, xNueva, yNueva);

        // Actualizar la posición
        xPuntoJugador = xNueva;
        yPuntoJugador = yNueva;

        // Aumentar el contador de pasos
        contadorPasos++;
    }

    private void intercambiarPiezas(int x1, int y1, int x2, int y2) {
        int tmp = estadoPiezas[x1][y1];
        estadoPiezas[x1][y1] = estadoPiezas[x2][y2];
        estadoPiezas[x2][y2] = tmp;
    }

    public boolean estaResuelto() {
        // Si no es jugable no puede ganar
        if (!jugable) {
            return false;
        }
        int numActual = 0;
        boolean resuelto = true;
        for (int j = 0; (j < numFilas) && resuelto; j++) {
            for (int i = 0; i < numColumnas; i++) {
                if (estadoPiezas[i][j] != numActual++) {
                    resuelto = false;
                }
            }
        }
        return resuelto;
    }

    public void setJugable(boolean jugable) {
        this.jugable = jugable;
    }

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public int getXPuntoJugador() {
        return xPuntoJugador;
    }

    public int getYPuntoJugador() {
        return yPuntoJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getContadorPasos() {
        return contadorPasos;
    }

    public int[][] getEstadoPiezas() {
        return estadoPiezas;
    }

}
