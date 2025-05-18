package practica.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraMenuJuego extends JMenuBar {
    
    private JMenu menuJuego;
    private JMenuItem botonSalir;
    private JMenuItem botonResolver;
    private JMenuItem botonMezclar;

    public BarraMenuJuego() {
        // Crear el munu "Juego"
        menuJuego = new JMenu("Juego");
        
        // Crear los botones del menu "Juego"
        botonSalir = new JMenuItem("Salir");
        botonResolver = new JMenuItem("Resolver");
        botonMezclar = new JMenuItem("Mezclar");
        
        // Añadir los gestores de eventos a los botones
        botonSalir.addActionListener(e -> System.exit(0));
        botonResolver.addActionListener(e -> System.out.println("Resolviendo..."));
        botonMezclar.addActionListener(e -> System.out.println("Mezclando..."));
        
        // Añadir los botones a menu "Juego"
        menuJuego.add(botonSalir);
        menuJuego.add(botonResolver);
        menuJuego.add(botonMezclar);
        
        // Añadir el menu "Juego" a la barra de menu
        add(menuJuego);
    }
}
