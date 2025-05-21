/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.excepciones;

/**
 * Excepción personalizada que se lanza cuando un punto se encuentra fuera del
 * tablero del rompecabezas.
 *
 * Extiende de {@link Exception} y permite proporcionar un mensaje personalizado
 * que describa el error.
 *
 * @author cxz03
 */
public class ExcepcionPuntoFueraDelTablero extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje descriptivo.
     *
     * @param mensaje El mensaje que describe el error.
     */
    public ExcepcionPuntoFueraDelTablero(String mensaje) {
        super(mensaje);
    }
}
