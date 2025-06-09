// Autores: David González Lastra y Xiaozhe Cheng

package practica.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import practica.gestor.GestorBarraMenu;

/**
 * Representa la barra de menú principal del juego. Este menú incluye opciones
 * relacionadas con el juego (resolver, mezclar, salir) y navegación entre
 * diferentes paneles (tablero e historial).
 *
 * La barra de menú puede asignar un gestor de eventos que maneje las acciones
 * de los botones.
 */
public class BarraMenu extends JMenuBar {

    // Bloque de atributos del menú sobre juegos
    private JMenu menuJuego;
    private JMenuItem botonResolver;
    private JMenuItem botonMezclar;
    private JMenuItem botonSalir;

    // Bloque de atributos del menú para cambio de paneles
    private JMenu menuNavegar;
    private JMenuItem botonTablero;
    private JMenuItem botonHistorial;

    /**
     * Constructor que inicializa los menús y sus elementos.
     */
    public BarraMenu() {
        inicializarMenuJuego();
        inicializarMenuNavegar();
    }

    /**
     * Asigna un gestor de eventos para manejar las acciones de los botones del
     * menú.
     *
     * @param gestorBarraMenu Gestor que manejará los eventos de los botones.
     */
    public void asignarGestorBarraMenu(GestorBarraMenu gestorBarraMenu) {
        // Añadir los gestores de eventos a los botones
        botonSalir.addActionListener(gestorBarraMenu);
        botonResolver.addActionListener(gestorBarraMenu);
        botonMezclar.addActionListener(gestorBarraMenu);
        botonTablero.addActionListener(gestorBarraMenu);
        botonHistorial.addActionListener(gestorBarraMenu);
    }

    /**
     * Obtiene el botón "Salir".
     *
     * @return El botón "Salir".
     */
    public JMenuItem getBotonSalir() {
        return botonSalir;
    }

    /**
     * Obtiene el botón "Resolver".
     *
     * @return El botón "Resolver".
     */
    public JMenuItem getBotonResolver() {
        return botonResolver;
    }

    /**
     * Obtiene el botón "Mezclar".
     *
     * @return El botón "Mezclar".
     */
    public JMenuItem getBotonMezclar() {
        return botonMezclar;
    }

    /**
     * Obtiene el botón "Tablero".
     *
     * @return El botón "Tablero".
     */
    public JMenuItem getBotonTablero() {
        return botonTablero;
    }

    /**
     * Obtiene el botón "Historial".
     *
     * @return El botón "Historial".
     */
    public JMenuItem getBotonHistorial() {
        return botonHistorial;
    }

    /**
     * Inicializa y configura el menú "Juego" con sus botones.
     */
    private void inicializarMenuJuego() {
        // Crear el menú "Juego"
        menuJuego = new JMenu("Juego");

        // Crear los botones del menú "Juego"
        botonResolver = new JMenuItem("Resolver");
        botonMezclar = new JMenuItem("Mezclar");
        botonSalir = new JMenuItem("Salir");

        // Añadir los botones al menú "Juego"
        menuJuego.add(botonResolver);
        menuJuego.add(botonMezclar);
        menuJuego.add(botonSalir);

        // Añadir el menú "Juego" a la barra de menú
        add(menuJuego);
    }

    /**
     * Inicializa y configura el menú "Navegar" con sus botones.
     */
    private void inicializarMenuNavegar() {
        // Crear el menú "Navegar"
        menuNavegar = new JMenu("Navegar");

        // Crear los botones del menú "Navegar"
        botonTablero = new JMenuItem("Tablero");
        botonHistorial = new JMenuItem("Historial");

        // Añadir los botones al menú "Navegar"
        menuNavegar.add(botonTablero);
        menuNavegar.add(botonHistorial);

        // Añadir el menú "Navegar" a la barra de menú
        add(menuNavegar);
    }
}
