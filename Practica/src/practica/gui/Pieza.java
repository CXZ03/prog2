// Autores: David González Lastra y Xiaozhe Cheng

package practica.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Representa una pieza individual del tablero del rompecabezas. Esta clase
 * extiende de JPanel y permite renderizar una subimagen específica en cada
 * pieza.
 *
 * Además, incluye un borde negro para distinguir visualmente las piezas.
 */
public class Pieza extends JPanel {

    private static final int BORDER_WIDTH = 1;
    private Image subImagen;

    /**
     * Constructor que inicializa la pieza con un borde negro.
     */
    public Pieza() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, BORDER_WIDTH));
    }

    /**
     * Asigna una subimagen a esta pieza y repinta el componente para reflejar
     * los cambios.
     *
     * @param subImage La subimagen que se asignará a esta pieza.
     */
    public void ponerImagen(Image subImage) {
        this.subImagen = subImage;
        this.repaint(); // actualizamos la grafica
    }

    /**
     * Obtiene la subimagen actualmente asociada con esta pieza.
     *
     * @return La subimagen asociada a esta pieza.
     */
    public Image getSubImagen() {
        return this.subImagen;
    }

    /**
     * Sobrescribe el método de JPanel para renderizar la subimagen dentro de la
     * pieza. Este método es invocado automáticamente cuando el componente
     * necesita ser repintado.
     *
     * @param g El contexto gráfico utilizado para dibujar la pieza.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el fondo antes de dibujar la nueva imagen
        g.drawImage(subImagen, 0, 0, this); // Dibuja la subimagen en la pieza
    }
}
