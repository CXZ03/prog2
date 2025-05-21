/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package practica.definicion;

/**
 * Representa los códigos de color ANSI para formatear texto en la consola.
 *
 * Cada color tiene un código ANSI asociado que se puede usar para cambiar el
 * color del texto en la salida de la consola.
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

    private final String code; // Código ANSI del color

    /**
     * Constructor que asigna el código ANSI al color.
     *
     * @param code El código ANSI asociado al color.
     */
    ColorConsola(String code) {
        this.code = code;
    }

    /**
     * Retorna el código ANSI del color como una cadena.
     *
     * @return El código ANSI como una cadena de texto.
     */
    @Override
    public String toString() {
        return code;
    }
}
