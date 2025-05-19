package practica.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import practica.gestor.GestorBarraMenu;

public class BarraMenuJuego extends JMenuBar {

    private JMenu menuJuego;
    private JMenuItem botonSalir;
    private JMenuItem botonResolver;
    private JMenuItem botonMezclar;

    public BarraMenuJuego() {
        // Crear el munu "Juego"
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

    public void asignarGestorBarraMenu(GestorBarraMenu gestorBarraMenu) {
        // Añadir los gestores de eventos a los botones
        botonSalir.addActionListener(gestorBarraMenu);
        botonResolver.addActionListener(gestorBarraMenu);
        botonMezclar.addActionListener(gestorBarraMenu);
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

}
