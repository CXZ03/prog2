package practica.gui;

import javax.swing.*;
import java.awt.*;

public class FormularioPuzle extends JPanel {

    // medidas de la ventana 
    private static final int ANCHO_VENTANA = 400;
    private static final int ALTO_VENTANA = 300;
    private static final int ESPACIADO = 10;

    // componentes necesarios para la ventana 
    private JTextField campoFilas;
    private JTextField campoColumnas;
    private JTextField campoNombreJugador;

    // Colocación con de los elementos en JPANEL= panelFormulalrio.
    public FormularioPuzle() {
        setLayout(new BorderLayout(ESPACIADO, ESPACIADO));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

        JLabel etiquetaNombreJugador = new JLabel("Nombre del jugador:");
        campoNombreJugador = new JTextField(10);

        JLabel etiquetaFilas = new JLabel("Número de filas:");
        campoFilas = new JTextField(10);

        JLabel etiquetaColumnas = new JLabel("Número de columnas:");
        campoColumnas = new JTextField(10);

        // Añadir elementos con espaciado
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

    // Metodo que verifica si el campo nombreJugador tiene contenido 
    // y tambien verifica si si el primer caracter es mayuscula. 
    // Salta mensaje especifico para cada uno de los casos 
    public boolean verificarNombre() {
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
     * Obtenemos el valor que el usuario ha insertado en en cada uno de los
     * campoos En caso de ser distintos, sentonces no es cuadrado, por lo que
     * salta el mensaje " las medidas no son cuadrados
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

    public int getNumeroFilas() {
        int res = -1;
        try {
            res = Integer.parseInt(campoFilas.getText());
        } catch (NumberFormatException e) {
            System.err.println("Error: Formato erroneo de numero de filas.");
        }
        return res;
    }

    public int getNumeroColumnas() {
        int res = -1;
        try {
            res = Integer.parseInt(campoColumnas.getText());
        } catch (NumberFormatException e) {
            System.err.println("Error: Formato erroneo de numero de columnas.");
        }
        return res;
    }

    public String getNombreJugador() {
        return campoNombreJugador.getText();
    }
}
