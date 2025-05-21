/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practica.definicion;

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
     * teclas asignadas son: 
     * - 'w' para ARRIBA 
     * - 's' para ABAJO 
     * - 'a' para IZQUIERDA 
     * - 'd' para DERECHA
     *
     * @param key La tecla presionada.
     * @return El movimiento correspondiente, o null si la tecla no está
     * asignada.
     */
    public static Movimiento obtenerMovimiento(char key) {
        switch (Character.toLowerCase(key)) {
            case 'w':
                return ARRIBA;
            case 's':
                return ABAJO;
            case 'a':
                return IZQUIERDA;
            case 'd':
                return DERECHA;
            default:
                return null;
        }
    }
}
