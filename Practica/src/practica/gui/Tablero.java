/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import practica.gui.Pieza;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Esta clase se colocará las piezas del tablero
 *
 * @author cxz03
 */
public class Tablero extends JPanel {

    private static int ANCHO = 720;
    private static int ALTO = 720;
    private String directorioImagen = "src/resources/linux-penguin.png";
    private String directorioImagenPuntoJugador = "src/resources/player-point.png";
    private Pieza piezas[][];

    public Tablero(int nPiezaHorizontal, int nPiezaVertical) {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setLayout(new GridLayout(nPiezaVertical, nPiezaHorizontal));   // GridLayout tiene como primer parámetro fila (vertical) y segunda columna (horizontal)
    }

    // Métodos sobre los movimientos de las piezas
    public void intercambiarPieza(int xOrigen, int yOrigen, int xDestino, int yDestino) {
        Image tmp = piezas[xOrigen][yOrigen].getSubImagen();
        piezas[xOrigen][yOrigen].ponerImagen(piezas[xDestino][yDestino].getSubImagen());
        piezas[xDestino][yDestino].ponerImagen(tmp);
    }

    // Métodos sobre inicialización de componentes
    public void iniciarComponentes() {
        // Quitamos todas la piezas previas;
        removeAll();

        // Agregamos las piezas al panel
        for (int j = 0; j < piezas[0].length; j++) {
            for (int i = 0; i < piezas.length; i++) {
                this.add(piezas[i][j]);
            }
        }

        // Informar al layout manager que el panel ha sido modificado
        revalidate();
    }

    public void iniciarPiezas(int[][] estadoTablero, int xPosJugador, int yPosJugador, int nPiezaHorizontal, int nPiezaVertical) {
        piezas = new Pieza[nPiezaHorizontal][nPiezaVertical];
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(new File(directorioImagen));

            imagen = resize(imagen, ANCHO, ALTO);
            int anchoSubImagen = ANCHO / nPiezaHorizontal;
            int altoSubImagen = ALTO / nPiezaVertical;
            int posImagenHorizontal;
            int posImagenVertical;
            int posPiezaActual;
            for (int i = 0; i < nPiezaHorizontal; i++) {
                for (int j = 0; j < nPiezaVertical; j++) {
                    posPiezaActual = estadoTablero[i][j];
                    posImagenVertical = posPiezaActual / estadoTablero.length;
                    posImagenHorizontal = posPiezaActual % estadoTablero.length;
                    piezas[i][j] = new Pieza();
                    piezas[i][j].ponerImagen(imagen.getSubimage(posImagenHorizontal * anchoSubImagen, posImagenVertical * altoSubImagen, anchoSubImagen, altoSubImagen));
                }
            }
            imagen = ImageIO.read(new File(directorioImagenPuntoJugador));
            imagen = resize(imagen, anchoSubImagen, altoSubImagen);
            piezas[xPosJugador][yPosJugador].ponerImagen(imagen);
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Redimensiona una imagen a un nuevo ancho y alto especificados. Este
     * método utiliza el algoritmo SCALE_SMOOTH para obtener una mejor calidad
     * en la imagen redimensionada.
     *
     * @param img La imagen original (BufferedImage) que se va a redimensionar
     * @param newW El nuevo ancho en píxeles para la imagen redimensionada
     * @param newH El nuevo alto en píxeles para la imagen redimensionada
     * @return BufferedImage Una nueva instancia de BufferedImage con las
     * dimensiones especificadas
     * @author Ocracoke (StackOverflow),
     * https://stackoverflow.com/questions/9417356/bufferedimage-resize
     */
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }
}
