// Autores: David González Lastra y Xiaozhe Cheng

package practica.gui;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import practica.historial.LectorFicheroHistorial;

/**
 * Representa el panel de historial del rompecabezas. Este panel muestra el
 * historial de partidas almacenado en un archivo.
 *
 * Utiliza un área de texto con desplazamiento para mostrar el contenido del
 * historial y permite limpiar el contenido mostrado.
 */
public class PanelHistorial extends JPanel {

    public static final String RUTA_HISTORIAL = "src/resources/historial.txt"; // Ruta por defecto del historial

    private JTextArea areaHistorial; // Área de texto para mostrar el historial
    private JScrollPane scrollPane;  // Contenedor con barra de desplazamiento para el área de texto

    /**
     * Constructor que inicializa el panel de historial.
     */
    public PanelHistorial() {
        // Inicializar componentes y configurar layout
        inicializarComponentes();
    }

    /**
     * Inicializa y configura los componentes del panel.
     */
    private void inicializarComponentes() {
        // Usar BorderLayout para que el centro reescale automáticamente
        setLayout(new BorderLayout());

        // Crear área de texto para mostrar el historial
        areaHistorial = new JTextArea();
        areaHistorial.setEditable(false); // Solo lectura

        // Crear scroll pane para permitir desplazamiento en historiales largos
        scrollPane = new JScrollPane(areaHistorial);

        // Añadir el scroll pane al panel
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Carga y muestra el historial desde un fichero de historial.
     */
    public void cargarHistorial() {
        try {
            // Crear lector de fichero historial
            LectorFicheroHistorial lector = new LectorFicheroHistorial(RUTA_HISTORIAL);

            // Leer todo el contenido del historial
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
     * Limpia el contenido del historial mostrado en el panel.
     */
    public void limpiarHistorial() {
        areaHistorial.setText("");
    }
}
