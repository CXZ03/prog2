/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practica.definicion;

/**
 *
 * @author cxz03
 */
public enum Movimiento {
    ARRIBA,
    ABAJO,
    IZQUIERDA,
    DERECHA;
    
    /**
     * Obtiene el movimiento correspondiente a una tecla presionada.
     */
    public static Movimiento obtenerMovimiento(char key) {
        switch (Character.toLowerCase(key)) {
            case 'w': return ARRIBA;
            case 's': return ABAJO;
            case 'a': return IZQUIERDA;
            case 'd': return DERECHA;
            default: return null;
        }
    }
}
