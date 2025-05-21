/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import practica.historial.LectorFicheroHistorial;

/**
 *
 * @author cxz03
 */
public class PanelHistorial extends JPanel {
    
    public static String RUTA_HISTORIAL = "src/resources/historial.txt";
    
    private JTextArea areaHistorial;
    private JScrollPane scrollPane;
    
    /**
     * Constructor que inicializa el panel de historial
     */
    public PanelHistorial() {
        // Inicializar componentes y configurar layout
        inicializarComponentes();
    }
    
    /**
     * Inicializa y configura los componentes del panel
     */
    private void inicializarComponentes() {
        // Establecer layout
        setLayout(new BorderLayout());
        
        // Crear área de texto para mostrar el historial
        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false); // Solo lectura
        
        // Crear scroll pane para permitir desplazamiento en historiales largos
        scrollPane = new JScrollPane(areaHistorial);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Añadir el scroll pane al panel
        add(scrollPane, BorderLayout.CENTER);
    }
    
    /**
     * Carga y muestra el historial desde un fichero
     * @param rutaFichero Ruta del fichero de historial
     */
    public void cargarHistorial() {
        try {
            // Crear lector de fichero historial
            LectorFicheroHistorial lector = new LectorFicheroHistorial(RUTA_HISTORIAL);
            
            // Leer todo el contenido
            String contenidoHistorial = lector.leerTodo();
            
            // Mostrar el contenido en el área de texto
            areaHistorial.setText(contenidoHistorial);
                        
            // Cerrar el lector
            lector.close();
            
        } catch (IOException | ClassNotFoundException e) {
            // Mostrar mensaje de error en el área de texto
            areaHistorial.setText("Error al cargar el historial: " + e.getMessage());
        }
    }
    
    /**
     * Limpia el contenido del historial mostrado
     */
    public void limpiarHistorial() {
        areaHistorial.setText("");
    }
}