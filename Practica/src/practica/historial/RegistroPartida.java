/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.historial;

import java.io.Serializable;

/**
 *
 * @author cxz03
 */
public class RegistroPartida implements Serializable {

    public static final RegistroPartida CENTINELA = new RegistroPartida(-1, -1, -1, "", "");

    private int numeroPasos;
    private int numeroColumnas;
    private int numeroFilas;
    private String nombreJugador;
    private String datePlayed;

    public RegistroPartida(int numeroPasos, int numeroColumnas, int numeroFilas, String nombreJugador, String datePlayed) {
        this.numeroPasos = numeroPasos;
        this.numeroColumnas = numeroColumnas;
        this.numeroFilas = numeroFilas;
        this.nombreJugador = nombreJugador;
        this.datePlayed = datePlayed;
    }

    public boolean esCentinela() {
        return (numeroPasos == CENTINELA.numeroPasos)
                && (numeroColumnas == CENTINELA.numeroColumnas)
                && (numeroFilas == CENTINELA.numeroFilas)
                && nombreJugador.equals(CENTINELA.nombreJugador)
                && datePlayed.equals(CENTINELA.datePlayed);
    }

    public int getNumeroPasos() {
        return numeroPasos;
    }

    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    public int getNumeroFilas() {
        return numeroFilas;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getDatePlayed() {
        return datePlayed;
    }

}
