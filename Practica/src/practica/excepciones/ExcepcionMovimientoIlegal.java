// Autores: David González Lastra y Xiaozhe Cheng

package practica.excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta realizar un movimiento
 * ilegal en el rompecabezas.
 *
 * Extiende de Exception y permite proporcionar un mensaje personalizado que
 * describa el error.
 *
 * @author cxz03
 */
public class ExcepcionMovimientoIlegal extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje descriptivo.
     *
     * @param mensaje El mensaje que describe el error.
     */
    public ExcepcionMovimientoIlegal(String mensaje) {
        super(mensaje);
    }
}
