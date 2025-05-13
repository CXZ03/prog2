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
    private JButton botonGenerarPuzle;

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

        botonGenerarPuzle = new JButton("Generar Puzle");
        botonGenerarPuzle.addActionListener(e -> verificarPuzle());

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
        panelFormulario.add(botonGenerarPuzle);

        add(panelFormulario, BorderLayout.CENTER);
    }

    //Metodo que comprueba si las medidas son cuatradas y cumple criterios de nombre, 
   //si esto pasa, lanza generar puzle 
    private void verificarPuzle() {
        if (verificarNombre() && verificarSiEsCuadrado()) {
            generarPuzle();
        }
    }

      // Metodo que verifica si el campo nombreJugador tiene contenido 
     // y tambien verifica si si el primer caracter es mayuscula. 
    // Salta mensaje especifico para cada uno de los casos 
    private boolean verificarNombre() {
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
/*
   Obtenemos el valor que el usuario ha insertado en en cada uno de los campoos 
    En caso de ser distintos, sentonces no es cuadrado, por  lo que salta el mensaje  " las medidas no son cuadrados 
    */
    private boolean verificarSiEsCuadrado() {
        try {
            int filas = Integer.parseInt(campoFilas.getText());
            int columnas = Integer.parseInt(campoColumnas.getText());

            if (filas != columnas) {
                JOptionPane.showMessageDialog(this, "Las medidas del puzle no son cuadradas.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Generar pulze se encarga de obtener los datos ya comprobados y mmuestrar el mensaje. con el puzle que va a generar 
     */
////
////// private void generarPuzle() {
//////        String nombreJugador = campoNombreJugador.getText().trim();
//////        int filas = Integer.parseInt(campoFilas.getText()); 
//////        int columnas = Integer.parseInt(campoColumnas.getText());
//////
//////         Mostrar mensaje del puzle generado
//////           JOptionPane.showMessageDialog(this, "Generando un puzle de " + filas + "x" + columnas + " para el jugador " + nombreJugador);    
//////
//////     Cargar imagen (asegúrate de que está en el paquete correcta)
//////    ImageIcon icono = new ImageIcon(getClass().getResource("/practica/rosources/imagenGenerador.jpg"));
//////    Image imagenEscalada = icono.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//////     etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
//////
//////     Refrescar el panel para que se vea la imagen
//////    revalidate();
//////    repaint();
////}
//
    private void generarPuzle() {
        String nombreJugador = campoNombreJugador.getText().trim();
        int filas = Integer.parseInt(campoFilas.getText()); 
        int columnas =Integer.parseInt(campoColumnas.getText());
        JOptionPane.showMessageDialog(this, "Generando un puzle de " + filas + "x" + columnas + " para el jugador " + nombreJugador);    
    
    }

    public static void main(String[] args) {
        JFrame ventanaPrincipal = new JFrame("Formulario Puzle");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(ANCHO_VENTANA, ALTO_VENTANA);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setResizable(false);

        ventanaPrincipal.add(new FormularioPuzle(), BorderLayout.CENTER);
        ventanaPrincipal.setVisible(true);
    }
}
