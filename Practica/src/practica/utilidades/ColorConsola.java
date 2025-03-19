/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practica.utilidades;

/**
 *
 * @author cxz03
 */
public enum ColorConsola {
    REINICIAR("\u001B[0m"),
    NEGRO("\u001B[30m"),
    ROJO("\u001B[31m"),
    VERDE("\u001B[32m"),
    AMARILLO("\u001B[33m"),
    AZUL("\u001B[34m"),
    PURPURA("\u001B[35m"),
    CIAN("\u001B[36m"),
    BLANCO("\u001B[37m");

    private final String code;

    ColorConsola(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
