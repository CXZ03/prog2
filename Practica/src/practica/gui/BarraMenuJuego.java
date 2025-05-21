package practica.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import practica.gestor.GestorBarraMenu;

public class BarraMenuJuego extends JMenuBar {

    // Bloque de atributos del menu sobre juegos
    private JMenu menuJuego;
    private JMenuItem botonResolver;
    private JMenuItem botonMezclar;
    private JMenuItem botonSalir;

    // Bloque de atributos del menu para cambio de paneles
    private JMenu menuNavegar;
    private JMenuItem botonTablero;
    private JMenuItem botonHistorial;

    public BarraMenuJuego() {
        inicializarMenuJuego();
        inicializarMenuNavegar();
    }

    public void asignarGestorBarraMenu(GestorBarraMenu gestorBarraMenu) {
        // Añadir los gestores de eventos a los botones
        botonSalir.addActionListener(gestorBarraMenu);
        botonResolver.addActionListener(gestorBarraMenu);
        botonMezclar.addActionListener(gestorBarraMenu);
        botonTablero.addActionListener(gestorBarraMenu);
        botonHistorial.addActionListener(gestorBarraMenu);
    }

    public JMenuItem getBotonSalir() {
        return botonSalir;
    }

    public JMenuItem getBotonResolver() {
        return botonResolver;
    }

    public JMenuItem getBotonMezclar() {
        return botonMezclar;
    }

    public JMenuItem getBotonTablero() {
        return botonTablero;
    }

    public JMenuItem getBotonHistorial() {
        return botonHistorial;
    }

    private void inicializarMenuJuego() {
        // Crear el menu "Juego"
        menuJuego = new JMenu("Juego");

        // Crear los botones del menu "Juego"
        botonResolver = new JMenuItem("Resolver");
        botonMezclar = new JMenuItem("Mezclar");
        botonSalir = new JMenuItem("Salir");

        // Añadir los botones a menu "Juego"
        menuJuego.add(botonResolver);
        menuJuego.add(botonMezclar);
        menuJuego.add(botonSalir);

        // Añadir el menu "Juego" a la barra de menu
        add(menuJuego);
    }
    
    private void inicializarMenuNavegar() {
        // Crear el menu "Navegar"
        menuNavegar = new JMenu("Navegar");
        
        // Crear los botones del menu "Navegar"
        botonTablero = new JMenuItem("Tablero");
        botonHistorial = new JMenuItem("Historial");
        
        // Añadir los botones a menu "Navegar"
        menuNavegar.add(botonTablero);
        menuNavegar.add(botonHistorial);
        
        // Añadir el menu "Navegar" a la barra de menu
        add(menuNavegar);
    }
}
