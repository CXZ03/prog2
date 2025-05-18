/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import javax.swing.JFrame;
import practica.gestor.GestorTablero;
import practica.juego.Puzzle;

/**
 * Esta clase será un JFrame y funcionará como el contenedor del tablero
 *
 * @author cxz03
 */
public class Ventana extends JFrame {

    private static final String TITULO = "ROMPECABEZAS";
    private BarraMenuJuego barraMenu;
    private Tablero tablero;

    public Ventana() {
        // Lanzar el formulario para obtener los parametros de la partida
        FormularioPuzle formularioResultado = lanzarFormulario();

        inicializarTablero(formularioResultado.getNumeroColumnas(), formularioResultado.getNumeroFilas());

        colocarComponentes();
        
        // Añadir el menu
        barraMenu = new BarraMenuJuego();
        setJMenuBar(barraMenu);
        
        // Configurar parametros de la ventana
        setTitle(TITULO);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setMaximizedBounds(null);
        pack();
        setLocationRelativeTo(null);  // después del método pack() para que se coloque al centro después de ajustar el tamaño de la ventana.
    }

    private void colocarComponentes() {
        add(tablero);
    }

    private void inicializarTablero(int numeroColumna, int numeroFilas) {
        tablero = new Tablero(numeroColumna, numeroFilas);
        Puzzle logicaTablero = new Puzzle(tablero, numeroColumna, numeroFilas);
        GestorTablero gestorTablero = new GestorTablero(tablero, logicaTablero);
    }

    private FormularioPuzle lanzarFormulario() {
        DialogoFormulario dialogo = new DialogoFormulario(this);
        dialogo.setVisible(true);

        if (!dialogo.seAcepto()) {
            System.out.println("No se acepto el formulario");
            // Terminamos el programa si el usuario ha cerrado el formulario
            // dispose();  // NOTA: con dispose() se sigue ejecutando el contructor de Ventana y produce excepciones porque el formulario no esta completo
            System.exit(0);
        }

        return dialogo.getFormulario();
    }
}
