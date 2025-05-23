/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practica.definicion;

import java.awt.event.KeyEvent;

/**
 * Representa los movimientos posibles dentro del rompecabezas. Cada movimiento
 * corresponde a una dirección: ARRIBA, ABAJO, IZQUIERDA o DERECHA.
 */
public enum Movimiento {
    ARRIBA,
    ABAJO,
    IZQUIERDA,
    DERECHA;

    /**
     * Obtiene el movimiento correspondiente cuando una tecla es presionada. Las
     * teclas asignadas son: - 'w' o tecla flecha arriba para ARRIBA - 's' o
     * tecla flecha abajo para ABAJO - 'a' o tecla izquierda para IZQUIERDA -
     * 'd' o tecla flecha derecha para DERECHA
     *
     * @param key La tecla presionada.
     * @return El movimiento correspondiente, o null si la tecla no está
     * asignada.
     */
    public static Movimiento obtenerMovimiento(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                return ARRIBA;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                return ABAJO;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                return IZQUIERDA;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                return DERECHA;
            default:
                return null;
        }
    }
}
