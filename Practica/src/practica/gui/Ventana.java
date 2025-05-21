/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import practica.gestor.GestorBarraMenu;
import practica.gestor.GestorTablero;
import practica.juego.Puzzle;

/**
 * Esta clase será un JFrame y funcionará como el contenedor del tablero
 *
 * @author cxz03
 */
public class Ventana extends JFrame {

    // Identificadores para los paneles de CardLayout;
    public static final String PANEL_JUEGO = "panelJuego";
    public static final String PANEL_HISTORIAL = "panelHistorial";

    // Titula de la ventana
    private static final String TITULO = "ROMPECABEZAS";

    private BarraMenuJuego barraMenu;
    private Tablero tablero;
    private PanelHistorial panelHistorial;
    private CardLayout cardLayout;

    public Ventana() {
        // Lanzar el formulario para obtener los parametros de la partida
        FormularioPuzle formularioResultado = lanzarFormulario();

        // Obtenemos la cantidad de columnas y filas, y el nombre del jugador para crear la partida
        int numeroColumnas = formularioResultado.getNumeroColumnas();
        int numeroFilas = formularioResultado.getNumeroFilas();
        String nombreJugador = formularioResultado.getNombreJugador();

        // Inicializar el Tablero
        tablero = new Tablero(numeroColumnas, numeroFilas);
        Puzzle logicaTablero = new Puzzle(tablero, numeroColumnas, numeroFilas, nombreJugador);
        GestorTablero gestorTablero = new GestorTablero(tablero, logicaTablero);

        // Añadir el menu
        barraMenu = new BarraMenuJuego();
        GestorBarraMenu gestorBarraMenu = new GestorBarraMenu(this, barraMenu, logicaTablero);

        // Inicializar el panel del historial
        panelHistorial = new PanelHistorial();

        // Asignar el layout manager
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Colocamos los componentes en la ventana
        colocarComponentes();

        // Mostramos por default la pantalla de juego
        cardLayout.show(this.getContentPane(), PANEL_JUEGO);

        // Configurar parametros de la ventana
        setTitle(TITULO);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setMaximizedBounds(null);
        pack();
        setLocationRelativeTo(null);  // después del método pack() para que se coloque al centro después de ajustar el tamaño de la ventana.
    }

    public void cambiarPanel(String nombrePanel) {
        cardLayout.show(this.getContentPane(), nombrePanel);
    }

    public void actualizarHistorial() {
        panelHistorial.cargarHistorial();
    }

    public Tablero getTablero() {
        return tablero;
    }

    private void colocarComponentes() {
        add(tablero, PANEL_JUEGO);
        add(panelHistorial, PANEL_HISTORIAL);
        setJMenuBar(barraMenu);
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
