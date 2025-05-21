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
 * Representa la lógica principal de un juego de rompecabezas (Puzzle). 
 * Administra el estado del tablero, la posición del jugador, las piezas y 
 * las operaciones necesarias para mezclar, mover y resolver el rompecabezas.
 */
public class Puzzle {

    private Tablero tablero; // Representación gráfica del tablero
    private String nombreJugador; // Nombre del jugador
    private int[][] estadoPiezas; // Matriz que representa el estado del rompecabezas
    private int numFilas; // Número de filas del tablero
    private int numColumnas; // Número de columnas del tablero
    private int xPuntoJugador; // Posición X actual del punto "jugador"
    private int yPuntoJugador; // Posición Y actual del punto "jugador"
    private int contadorPasos; // Contador de pasos realizados por el jugador
    private boolean jugable; // Indica si el rompecabezas está en estado jugable

    /**
     * Constructor que inicializa un rompecabezas con un tablero, dimensiones 
     * y el nombre del jugador.
     * 
     * @param tablero Representación gráfica del tablero.
     * @param numColumnas Número de columnas del tablero.
     * @param numFilas Número de filas del tablero.
     * @param nombreJugador Nombre del jugador.
     */
    public Puzzle(Tablero tablero, int numColumnas, int numFilas, String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.tablero = tablero;
        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
        estadoPiezas = new int[numColumnas][numFilas];

        mezclar(); // Inicializa y mezcla el tablero al crear el puzzle
    }

    /**
     * Inicializa, mezcla las piezas y prepara el tablero para jugar.
     */
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

    /**
     * Resuelve el tablero reiniciándolo al estado inicial ordenado.
     */
    public void resolver() {
        jugable = false;
        xPuntoJugador = 0;
        yPuntoJugador = 0;
        contadorPasos = 0;
        inicializarEstadoPiezas();
        tablero.iniciarPiezas(estadoPiezas, xPuntoJugador, yPuntoJugador, numColumnas, numFilas);
        tablero.iniciarComponentes();
    }

    /**
     * Inicializa el estado de las piezas en orden secuencial.
     */
    private void inicializarEstadoPiezas() {
        int numActual = 0;
        for (int j = 0; j < numFilas; j++) {
            for (int i = 0; i < numColumnas; i++) {
                estadoPiezas[i][j] = numActual++;
            }
        }
    }

    /**
     * Mezcla las piezas del tablero de manera aleatoria.
     */
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

    /**
     * Verifica si las coordenadas corresponden al punto actual del jugador.
     * 
     * @param x Coordenada X.
     * @param y Coordenada Y.
     * @return {@code true} si es el punto del jugador, de lo contrario {@code false}.
     */
    private boolean esPuntoJugador(int x, int y) {
        return (xPuntoJugador == x && yPuntoJugador == y);
    }

    /**
     * Imprime el estado actual de las piezas en consola.
     */
    public void imprimirEstadoPiezas() {
        for (int i = 0; i < estadoPiezas.length; i++) {
            for (int j = 0; j < estadoPiezas[0].length; j++) {
                System.out.print(estadoPiezas[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Realiza un movimiento del jugador en el tablero.
     * 
     * @param mov Dirección del movimiento.
     * @throws ExcepcionMovimientoIlegal Si el movimiento es inválido.
     */
    public void mover(Movimiento mov) throws ExcepcionMovimientoIlegal {
        if (!jugable) {
            return; // Si no es jugable, no se realiza el movimiento
        }
        int xNueva = xPuntoJugador;
        int yNueva = yPuntoJugador;
        switch (mov) {
            case Movimiento.ARRIBA:
                if (yPuntoJugador <= 0) {
                    throw new ExcepcionMovimientoIlegal("No se puede mover hacia arriba");
                }
                yNueva--;
                break;
            case Movimiento.IZQUIERDA:
                if (xPuntoJugador <= 0) {
                    throw new ExcepcionMovimientoIlegal("No se puede mover hacia la izquierda");
                }
                xNueva--;
                break;
            case Movimiento.ABAJO:
                if (yPuntoJugador >= numFilas - 1) {
                    throw new ExcepcionMovimientoIlegal("No se puede mover hacia abajo");
                }
                yNueva++;
                break;
            case Movimiento.DERECHA:
                if (xPuntoJugador >= numColumnas - 1) {
                    throw new ExcepcionMovimientoIlegal("No se puede mover hacia la derecha");
                }
                xNueva++;
                break;
        }
        intercambiarPiezas(xPuntoJugador, yPuntoJugador, xNueva, yNueva);
        tablero.intercambiarPieza(xPuntoJugador, yPuntoJugador, xNueva, yNueva);
        xPuntoJugador = xNueva;
        yPuntoJugador = yNueva;
        contadorPasos++;
    }

    /**
     * Intercambia dos piezas en el tablero.
     * 
     * @param x1 Coordenada X de la primera pieza.
     * @param y1 Coordenada Y de la primera pieza.
     * @param x2 Coordenada X de la segunda pieza.
     * @param y2 Coordenada Y de la segunda pieza.
     */
    private void intercambiarPiezas(int x1, int y1, int x2, int y2) {
        int tmp = estadoPiezas[x1][y1];
        estadoPiezas[x1][y1] = estadoPiezas[x2][y2];
        estadoPiezas[x2][y2] = tmp;
    }

    /**
     * Verifica si el rompecabezas está resuelto.
     * 
     * @return {@code true} si está resuelto, de lo contrario {@code false}.
     */
    public boolean estaResuelto() {
        if (!jugable) {
            return false;
        }
        int numActual = 0;
        for (int j = 0; j < numFilas; j++) {
            for (int i = 0; i < numColumnas; i++) {
                if (estadoPiezas[i][j] != numActual++) {
                    return false;
                }
            }
        }
        return true;
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