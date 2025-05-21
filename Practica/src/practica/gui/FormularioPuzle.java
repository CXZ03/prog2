package practica.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un formulario gráfico para configurar los parámetros de un
 * rompecabezas. El formulario permite al usuario ingresar el nombre del
 * jugador, el número de filas y columnas. También valida los datos ingresados
 * antes de crear el rompecabezas.
 */
public class FormularioPuzle extends JPanel {

    // Dimensiones de la ventana
    private static final int ANCHO_VENTANA = 400; // Ancho predeterminado
    private static final int ALTO_VENTANA = 300; // Alto predeterminado
    private static final int ESPACIADO = 10; // Espaciado entre componentes

    // Componentes del formulario
    private JTextField campoFilas; // Campo para el número de filas
    private JTextField campoColumnas; // Campo para el número de columnas
    private JTextField campoNombreJugador; // Campo para el nombre del jugador

    /**
     * Constructor que inicializa el formulario con los campos necesarios.
     * Configura un diseño organizado con etiquetas y campos de texto.
     */
    public FormularioPuzle() {
        setLayout(new BorderLayout(ESPACIADO, ESPACIADO));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

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
        panelFormulario.add(etiquetaNombreJugador);
        panelFormulario.add(campoNombreJugador);
        panelFormulario.add(Box.createVerticalStrut(ESPACIADO));
        panelFormulario.add(etiquetaFilas);
        panelFormulario.add(campoFilas);
        panelFormulario.add(Box.createVerticalStrut(ESPACIADO));
        panelFormulario.add(etiquetaColumnas);
        panelFormulario.add(campoColumnas);
        panelFormulario.add(Box.createVerticalStrut(ESPACIADO));

        add(panelFormulario, BorderLayout.CENTER);
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
