/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Representa un cuadro de diálogo modal que contiene un formulario para
 * configurar la partida. Este cuadro bloquea las interacciones con la ventana
 * principal hasta que el usuario complete o cierre el diálogo.
 *
 * Utiliza un FormularioPuzle para recopilar los parámetros de la partida y un
 * botón para aceptar los datos ingresados.
 */
public class Formulario extends JDialog {

    // Dimensiones de la ventana
    private static final int ANCHO_VENTANA = 400; // Ancho predeterminado
    private static final int ALTO_VENTANA = 300; // Alto predeterminado
    private static final int ESPACIADO = 10; // Espaciado entre componentes
    private static final String TITULO = "CONFIGURACIÓN DE LA PARTIDA";
    private boolean aceptado = false; // Flag para si el usuario aceptó el formulario

    // Componentes del formulario
    private JPanel formulario; // Formulario para ingresar los parámetros de la partida
    private JTextField campoFilas; // Campo para el número de filas
    private JTextField campoColumnas; // Campo para el número de columnas
    private JTextField campoNombreJugador; // Campo para el nombre del jugador

    /**
     * Constructor que inicializa el cuadro de diálogo con un formulario y un
     * botón de aceptar.
     *
     * @param ventanaPadre La ventana principal desde la cual se lanza este
     * cuadro de diálogo.
     */
    public Formulario(JFrame ventanaPadre) {
        // Modal a true para que bloquee las acciones de la ventana principal
        super(ventanaPadre, TITULO, true);

        // Usamos BorderLayout para organizar los elementos
        this.setLayout(new BorderLayout());

        // Crear el formulario y colocarlo en el centro del diálogo
        inicializarFormulario();

        // Crear el botón "Aceptar" y añadir un gestor de eventos
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(e -> {
            // Verificar que los datos del formulario son válidos
            if (verificarNumeros() && verificarNombre()) {
                // Si los datos son correctos, marcar el formulario como aceptado y cerrar el diálogo
                aceptado = true;
                dispose();
            }
        });
        this.add(botonAceptar, BorderLayout.SOUTH);

        // Ajustar el tamaño del diálogo y colocarlo centrado respecto a la ventana padre
        this.pack();
        this.setLocationRelativeTo(ventanaPadre);
    }

    /**
     * Establece si el usuario aceptó el formulario.
     *
     * @param aceptado true si el formulario fue aceptado, de lo contrario
     * false.
     */
    public void aceptar(boolean aceptado) {
        this.aceptado = aceptado;
    }

    /**
     * Verifica si el formulario fue aceptado por el usuario.
     *
     * @return true si el formulario fue aceptado, de lo contrario false.
     */
    public boolean seAcepto() {
        return aceptado;
    }

    private void inicializarFormulario() {
        // Inicializamos el formualrio
        formulario = new JPanel();
        formulario.setLayout(new BoxLayout(formulario, BoxLayout.Y_AXIS));

        // Etiqueta y campo para el nombre del jugador
        JLabel etiquetaNombreJugador = new JLabel("Nombre del jugador:");
        campoNombreJugador = new JTextField(10);

        // Etiqueta y campo para el número de filas
        JLabel etiquetaFilas = new JLabel("Número de filas:");
        campoFilas = new JTextField(10);

        // Etiqueta y campo para el número de columnas
        JLabel etiquetaColumnas = new JLabel("Número de columnas:");
        campoColumnas = new JTextField(10);

        // Añadir elementos al panel con espaciado
        formulario.add(etiquetaNombreJugador);
        formulario.add(campoNombreJugador);
        formulario.add(Box.createVerticalStrut(ESPACIADO));
        formulario.add(etiquetaFilas);
        formulario.add(campoFilas);
        formulario.add(Box.createVerticalStrut(ESPACIADO));
        formulario.add(etiquetaColumnas);
        formulario.add(campoColumnas);
        formulario.add(Box.createVerticalStrut(ESPACIADO));

        add(formulario, BorderLayout.CENTER);

    }

    /**
     * Verifica si el campo del nombre del jugador tiene contenido y si comienza
     * con una letra mayúscula. Muestra mensajes de error o advertencia según el
     * caso.
     *
     * @return true si el nombre es válido, false en caso contrario.
     */
    public boolean verificarNombre() {
        // quitamos los espacios en blanco que hay a la izquierda y derecha del nombre con trim()
        String nombreJugador = campoNombreJugador.getText().trim();

        if (nombreJugador.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay nombre del jugador.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!Character.isUpperCase(nombreJugador.charAt(0))) {
            JOptionPane.showMessageDialog(this, "El nombre del jugador debe comenzar con una letra mayúscula.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Verifica si los valores ingresados en los campos de filas y columnas son
     * números enteros.
     *
     * @return true si ambos valores son válidos, false en caso contrario.
     */
    public boolean verificarNumeros() {
        try {
            int filas = Integer.parseInt(campoFilas.getText());
            int columnas = Integer.parseInt(campoColumnas.getText());
            if (filas < 3 || columnas < 3) {
                JOptionPane.showMessageDialog(this, "El tablero tiene que ser almenos 3x3.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Obtiene el número de filas ingresado en el formulario.
     *
     * @return El número de filas o -1 si no es un número válido.
     */
    public int getNumeroFilas() {
        int res = -1;
        try {
            res = Integer.parseInt(campoFilas.getText());
        } catch (NumberFormatException e) {
            System.err.println("Error: Formato erróneo de número de filas.");
        }
        return res;
    }

    /**
     * Obtiene el número de columnas ingresado en el formulario.
     *
     * @return El número de columnas o -1 si no es un número válido.
     */
    public int getNumeroColumnas() {
        int res = -1;
        try {
            res = Integer.parseInt(campoColumnas.getText());
        } catch (NumberFormatException e) {
            System.err.println("Error: Formato erróneo de número de columnas.");
        }
        return res;
    }

    /**
     * Obtiene el nombre del jugador ingresado en el formulario.
     *
     * @return El nombre del jugador como {@link String}.
     */
    public String getNombreJugador() {
        return campoNombreJugador.getText();
    }
}
