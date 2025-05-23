/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gestor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import practica.definicion.Movimiento;
import practica.excepciones.ExcepcionMovimientoIlegal;
import practica.gui.Tablero;
import practica.juego.Puzzle;
import practica.definicion.ColorConsola;
import practica.gui.PanelHistorial;
import practica.historial.EscritorConcatenadoFicheroHistorial;
import practica.historial.EscritorFicheroHistorial;
import practica.historial.RegistroPartida;

/**
 * Gestiona los eventos asociados al tablero del rompecabezas. Detecta las
 * teclas presionadas, actualiza el estado del juego y guarda los datos del
 * historial cuando el rompecabezas es resuelto.
 *
 * Implementa KeyListener para manejar eventos de teclado.
 */
public class GestorTablero implements KeyListener {

    private Tablero tablero; // El tablero gráfico del rompecabezas
    private Puzzle puzzle; // Lógica del rompecabezas

    /**
     * Constructor que inicializa el gestor del tablero.
     *
     * @param tablero El tablero gráfico del rompecabezas.
     * @param puzzle La lógica del rompecabezas.
     */
    public GestorTablero(Tablero tablero, Puzzle puzzle) {
        this.tablero = tablero;
        iniciarTablero();
        this.puzzle = puzzle;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se utiliza en este caso
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Gestionar la tecla presionada y determinar el movimiento
        gestionarTeclaPresionada(Movimiento.obtenerMovimiento(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No se utiliza en este caso
    }

    /**
     * Configura el tablero para escuchar eventos de teclado.
     */
    private void iniciarTablero() {
        tablero.addKeyListener(this);
        tablero.setFocusable(true);
        tablero.requestFocus();
    }

    /**
     * Gestiona la tecla presionada y ejecuta el movimiento correspondiente.
     *
     * @param mov El movimiento asociado a la tecla presionada.
     */
    private void gestionarTeclaPresionada(Movimiento mov) {
        // Miramos si es un movimiento válidoĺ
        if (mov == null) {
            return;
        }
        
        boolean jugadaLegal = true; // Flag por si hay alguna jugada ilegal

        switch (mov) {
            case Movimiento.ARRIBA -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'w'" + ColorConsola.REINICIAR);
                try {
                    gestionarTeclaW();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }
            case Movimiento.IZQUIERDA -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'a'" + ColorConsola.REINICIAR);
                try {
                    gestionarTeclaA();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }
            case Movimiento.ABAJO -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 's'" + ColorConsola.REINICIAR);
                try {
                    gestionarTeclaS();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }
            case Movimiento.DERECHA -> {
                System.out.println(ColorConsola.AMARILLO + "---> DEBUG: key pressed 'd'" + ColorConsola.REINICIAR);
                try {
                    gestionarTeclaD();
                } catch (ExcepcionMovimientoIlegal ex) {
                    System.err.println(ex.getMessage());
                    jugadaLegal = false;
                }
            }
            default ->
                System.out.println("---> DEBUG: key pressed <SIN ASIGNAR>");
        }

        // Si el movimiento es legal y el rompecabezas está resuelto, manejar la victoria
        if (jugadaLegal && puzzle.estaResuelto()) {
            // Enseñamos el mensaje de felicitación
            JOptionPane.showMessageDialog(tablero, "¡Has ganado!", "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/personas-aplaudiendo-stock.jpg"));

            // Guardar la partida en el historial
            guardarPartida(new RegistroPartida(
                    puzzle.getContadorPasos(),
                    puzzle.getNumColumnas(),
                    puzzle.getNumFilas(),
                    puzzle.getNombreJugador(),
                    LocalDateTime.now().toString()
            ));

            // Reiniciar el estado del juego
            puzzle.resolver();
        }
    }

    /**
     * Guarda los datos de la partida en el historial.
     *
     * @param partidaAGuardar Los datos de la partida a guardar.
     */
    private void guardarPartida(RegistroPartida partidaAGuardar) {
        File ficheroHistorial = new File(PanelHistorial.RUTA_HISTORIAL);
        boolean concatenar = ficheroHistorial.exists() && (ficheroHistorial.length() > 0);

        // Guardar la partida en el fichero
        try (FileOutputStream fos = new FileOutputStream(ficheroHistorial, concatenar); EscritorFicheroHistorial escritorFicheroHistorial = concatenar
                ? new EscritorConcatenadoFicheroHistorial(fos)
                : new EscritorFicheroHistorial(fos)) {
            escritorFicheroHistorial.escribirPartida(partidaAGuardar);
        } catch (IOException ex) {
            Logger.getLogger(GestorTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para gestionar movimientos específicos
    private void gestionarTeclaW() throws ExcepcionMovimientoIlegal {
        puzzle.mover(Movimiento.ARRIBA);
    }

    private void gestionarTeclaA() throws ExcepcionMovimientoIlegal {
        puzzle.mover(Movimiento.IZQUIERDA);
    }

    private void gestionarTeclaS() throws ExcepcionMovimientoIlegal {
        puzzle.mover(Movimiento.ABAJO);
    }

    private void gestionarTeclaD() throws ExcepcionMovimientoIlegal {
        puzzle.mover(Movimiento.DERECHA);
    }
}
