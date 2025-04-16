package practica.gui;

import javax.swing.*;
import java.awt.*;

public class FormularioPuzle extends JPanel {
    private JTextField txtFilas;
    private JTextField txtColumnas;
    private JButton btnGenerar;

    public FormularioPuzle() {
        setLayout(new BorderLayout(10, 10)); // Espaciado entre componentes

        // Panel con GridLayout para organizar los elementos
        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 10, 10)); 
        
        JLabel lblFilas = new JLabel("Número de filas:");
        JLabel lblColumnas = new JLabel("Número de columnas:");
        
        txtFilas = new JTextField();
        txtColumnas = new JTextField();
        btnGenerar = new JButton("Generar Puzle");
        btnGenerar.addActionListener(e -> verificarCuadrado());

        // Agregar elementos al mismo panel
        panelCampos.add(lblFilas);
        panelCampos.add(txtFilas);
        panelCampos.add(lblColumnas);
        panelCampos.add(txtColumnas);
        panelCampos.add(btnGenerar);

        add(panelCampos, BorderLayout.CENTER); // Ubicar todo el contenido en el centro
    }

    private void verificarCuadrado() {
        try {
            int filas = Integer.parseInt(txtFilas.getText());
            int columnas = Integer.parseInt(txtColumnas.getText());

            if (filas != columnas) { 
                JOptionPane.showMessageDialog(this, "Las medidas del puzle no son cuadradas.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                generarPuzle(filas, columnas);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generarPuzle(int filas, int columnas) {
        JOptionPane.showMessageDialog(this, "Generando un puzle de " + filas + "x" + columnas);
    }

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Formulario Puzle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Agregar el formulario al centro
        frame.add(new FormularioPuzle(), BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
