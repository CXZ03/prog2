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
 * Representa la ventana principal de la aplicación, que extiende de JFrame.
 * Esta clase actúa como contenedor principal que incluye el tablero de juego,
 * el historial y la barra de menú. Utiliza un CardLayout para cambiar entre
 * diferentes paneles como el juego y el historial.
 */
public class Ventana extends JFrame {

    // Identificadores para los paneles utilizados por CardLayout
    public static final String PANEL_JUEGO = "panelJuego";
    public static final String PANEL_HISTORIAL = "panelHistorial";

    private static final String TITULO = "ROMPECABEZAS";

    private BarraMenu barraMenu;
    private Tablero tablero;
    private PanelHistorial panelHistorial;
    private CardLayout cardLayout;

    /**
     * Constructor que inicializa la ventana principal. Incluye la configuración
     * del tablero, el historial, la barra de menú y los parámetros visuales de
     * la ventana.
     */
    public Ventana() {
        // Lanzar el formulario para obtener los parámetros de la partida
        Formulario formularioResultado = lanzarFormulario();

        // Obtenemos la cantidad de columnas, filas y el nombre del jugador para crear la partida
        int numeroColumnas = formularioResultado.getNumeroColumnas();
        int numeroFilas = formularioResultado.getNumeroFilas();
        String nombreJugador = formularioResultado.getNombreJugador();

        // Inicializamos el Tablero y los gestores
        tablero = new Tablero(numeroColumnas, numeroFilas);
        Puzzle logicaTablero = new Puzzle(tablero, numeroColumnas, numeroFilas, nombreJugador);
        GestorTablero gestorTablero = new GestorTablero(tablero, logicaTablero);

        // Añadimos el menú y su gestor
        barraMenu = new BarraMenu();
        GestorBarraMenu gestorBarraMenu = new GestorBarraMenu(this, barraMenu, logicaTablero);

        // Inicializamos el panel del historial
        panelHistorial = new PanelHistorial();

        // Configuramos el layout manager como CardLayout
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Colocamos los componentes en la ventana
        colocarComponentes();

        // Mostramos por defecto la pantalla de juego
        cardLayout.show(this.getContentPane(), PANEL_JUEGO);

        // Configuramos los parámetros de la ventana
        setTitle(TITULO);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setMaximizedBounds(null);
        pack();
        setLocationRelativeTo(null); // Coloca la ventana en el centro después de ajustar su tamaño
    }

    /**
     * Cambia el panel visible en el CardLayout.
     *
     * @param nombrePanel Nombre del panel que se desea mostrar.
     */
    public void cambiarPanel(String nombrePanel) {
        cardLayout.show(this.getContentPane(), nombrePanel);
    }

    /**
     * Actualiza el contenido del panel de historial.
     */
    public void actualizarHistorial() {
        panelHistorial.cargarHistorial();
    }

    /**
     * Obtiene el tablero utilizado en la ventana.
     *
     * @return Tablero configurado en la ventana.
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Coloca los componentes principales (tablero, historial y barra de menú)
     * en la ventana.
     */
    private void colocarComponentes() {
        add(tablero, PANEL_JUEGO);
        add(panelHistorial, PANEL_HISTORIAL);
        setJMenuBar(barraMenu);
    }

    /**
     * Lanza un formulario modal para que el usuario especifique los parámetros
     * de la partida (filas, columnas, nombre del jugador).
     *
     * @return FormularioPuzle con los datos ingresados por el usuario.
     */
    private Formulario lanzarFormulario() {
        Formulario dialogo = new Formulario(this);
        dialogo.setVisible(true);

        // Verificar si el usuario aceptó el formulario
        if (!dialogo.seAcepto()) {
            // Termina el programa si el usuario no completa el formulario
            System.exit(0);
        }

        return dialogo;
    }
}
