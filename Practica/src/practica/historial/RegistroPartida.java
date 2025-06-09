// Autores: David González Lastra y Xiaozhe Cheng

package practica.historial;

import java.io.Serializable;

/**
 * Representa un registro de una partida, almacenando información como el número
 * de pasos, las dimensiones del tablero, el nombre del jugador y la fecha en
 * que se jugó. También incluye una instancia especial denominada "centinela"
 * para identificar situaciones especiales.
 *
 * Esta clase implementa la interfaz Serializable, lo que permite que los
 * objetos de esta clase sean serializados y almacenados en archivos.
 */
public class RegistroPartida implements Serializable {

    /**
     * Objeto centinela para identificar registros especiales o marcadores de
     * finalización en flujos de datos.
     */
    public static final RegistroPartida CENTINELA = new RegistroPartida(-1, -1, -1, "", "");

    private int numeroPasos;
    private int numeroColumnas;
    private int numeroFilas;
    private String nombreJugador;
    private String datePlayed;

    /**
     * Constructor para inicializar un registro de partida con los detalles
     * proporcionados.
     *
     * @param numeroPasos Número de pasos realizados en la partida.
     * @param numeroColumnas Número de columnas del tablero.
     * @param numeroFilas Número de filas del tablero.
     * @param nombreJugador Nombre del jugador que jugó la partida.
     * @param datePlayed Fecha en la que se jugó la partida.
     */
    public RegistroPartida(int numeroPasos, int numeroColumnas, int numeroFilas, String nombreJugador, String datePlayed) {
        this.numeroPasos = numeroPasos;
        this.numeroColumnas = numeroColumnas;
        this.numeroFilas = numeroFilas;
        this.nombreJugador = nombreJugador;
        this.datePlayed = datePlayed;
    }

    /**
     * Verifica si este registro de partida es igual al objeto centinela.
     *
     * @return true si este registro es el centinela; false en caso contrario.
     */
    public boolean esCentinela() {
        return (numeroPasos == CENTINELA.numeroPasos)
                && (numeroColumnas == CENTINELA.numeroColumnas)
                && (numeroFilas == CENTINELA.numeroFilas)
                && nombreJugador.equals(CENTINELA.nombreJugador)
                && datePlayed.equals(CENTINELA.datePlayed);
    }

    /**
     * Obtiene el número de pasos realizados en la partida.
     *
     * @return El número de pasos realizados.
     */
    public int getNumeroPasos() {
        return numeroPasos;
    }

    /**
     * Obtiene el número de columnas del tablero de la partida.
     *
     * @return El número de columnas del tablero.
     */
    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    /**
     * Obtiene el número de filas del tablero de la partida.
     *
     * @return El número de filas del tablero.
     */
    public int getNumeroFilas() {
        return numeroFilas;
    }

    /**
     * Obtiene el nombre del jugador que jugó la partida.
     *
     * @return El nombre del jugador.
     */
    public String getNombreJugador() {
        return nombreJugador;
    }

    /**
     * Obtiene la fecha en que se jugó la partida.
     *
     * @return La fecha en formato de cadena.
     */
    public String getDatePlayed() {
        return datePlayed;
    }

}
