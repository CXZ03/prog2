/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.game;

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
    private Pieza piezas[][];

    public Tablero(int nPiezaHorizontal, int nPiezaVertical) {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setLayout(new GridLayout(nPiezaVertical, nPiezaHorizontal));   // GridLayout tiene como primer parámetro fila (vertical) y segunda columna (horizontal)
        this.inicializarPiezas(nPiezaHorizontal, nPiezaVertical);
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        for (int j = 0; j < piezas[0].length; j++) {
            for (int i = 0; i < piezas.length; i++) {
                this.add(piezas[i][j]);
            }
        }
    }

    private void inicializarPiezas(int nPiezaHorizontal, int nPiezaVertical) {
        piezas = new Pieza[nPiezaHorizontal][nPiezaVertical];
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(new File(directorioImagen));
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagen = resize(imagen, ANCHO, ALTO);
        int anchoSubImagen = ANCHO / nPiezaHorizontal;
        int altoSubImagen = ALTO / nPiezaVertical;
        for (int i = 0, posImagenHorizontal = 0; i < nPiezaHorizontal; i++, posImagenHorizontal += anchoSubImagen) {
            for (int j = 0, posImagenVertical = 0; j < nPiezaVertical; j++, posImagenVertical += altoSubImagen) {
                piezas[i][j] = new Pieza();
                piezas[i][j].setImage(imagen.getSubimage(posImagenHorizontal, posImagenVertical, anchoSubImagen, altoSubImagen));
            }
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}
