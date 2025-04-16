import javax.swing.*;

public class MenuJuego {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Menu Juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Establecer la barra de menú en la ventana
        frame.setJMenuBar(generarMenu(frame));

        // Mostrar la ventana
        frame.setVisible(true);
    }

    public static JMenuBar generarMenu(JFrame frame) {
        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear el menú "Juego"
        JMenu menuJuego = new JMenu("Juego");

        // Crear los elementos del menú
        JMenuItem btnSalir = new JMenuItem("Salir");
        JMenuItem btnResolver = new JMenuItem("Resolver");
        JMenuItem btnMezclar = new JMenuItem("Mezclar");

        // Agregar escuchadores a los botones
        btnSalir.addActionListener(e -> System.exit(0));
        btnResolver.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Resolviendo..."));
        btnMezclar.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Mezclando..."));

        // Agregar los elementos al menú "Juego"
        menuJuego.add(btnSalir);
        menuJuego.add(btnResolver);
        menuJuego.add(btnMezclar);

        // Agregar el menú a la barra de menú
        menuBar.add(menuJuego);

        return menuBar;
    }
}
