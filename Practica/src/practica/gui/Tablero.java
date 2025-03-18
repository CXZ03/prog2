/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import practica.gui.Pieza;
import practica.gestor.GestorTablero;
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
import practica.excepciones.ExcepcionMovimientoIlegal;
import practica.excepciones.ExcepcionPuntoFueraDelTablero;

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
        this.iniciarPiezas(nPiezaHorizontal, nPiezaVertical);
        this.iniciarComponentes();
    }

    public void moverHaciaArriba(int xPuntoJugador, int yPuntoJugador) {
        int yDestino = yPuntoJugador - 1;
        try {
            intercambiarPieza(xPuntoJugador, yPuntoJugador, xPuntoJugador, yDestino);
        } catch (ExcepcionPuntoFueraDelTablero ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        }
        yPuntoJugador = yDestino;
    }

    public void moverHaciaIzquierda(int xPuntoJugador, int yPuntoJugador) {
        int xDestino = xPuntoJugador - 1;
        try {
            intercambiarPieza(xPuntoJugador, yPuntoJugador, xDestino, yPuntoJugador);
        } catch (ExcepcionPuntoFueraDelTablero ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        }
        xPuntoJugador = xDestino;
    }

    public void moverHaciaAbajo(int xPuntoJugador, int yPuntoJugador) {
        int yDestino = yPuntoJugador + 1;
        try {
            intercambiarPieza(xPuntoJugador, yPuntoJugador, xPuntoJugador, yDestino);
        } catch (ExcepcionPuntoFueraDelTablero ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        }
        yPuntoJugador = yDestino;
    }

    public void moverHaciaDerecha(int xPuntoJugador, int yPuntoJugador) {
        int xDestino = xPuntoJugador + 1;
        try {
            intercambiarPieza(xPuntoJugador, yPuntoJugador, xDestino, yPuntoJugador);
        } catch (ExcepcionPuntoFueraDelTablero ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        } catch (ExcepcionMovimientoIlegal ex) {
            System.err.println(ex.getMessage());
            return;     // Eearly return para evitar actualizar la posición del jugador
        }
        xPuntoJugador = xDestino;
    }

    // Métodos sobre los movimientos de las piezas
    private void intercambiarPieza(int xOrigen, int yOrigen, int xDestino, int yDestino) throws ExcepcionPuntoFueraDelTablero, ExcepcionMovimientoIlegal {
        // Miramos que el punto origen esté dentro del tablero
        if ((xOrigen < 0) || (xOrigen >= piezas.length) || (yOrigen < 0) || (yDestino >= piezas[0].length)) {
            throw new ExcepcionPuntoFueraDelTablero("Error: Tablero.java -> intercambiarPieza() -> punto origen fuera del tablero");
        }
        // Miramos que el punto de destino esté dentro del tablero
        if ((xDestino < 0) || (xDestino >= piezas.length) || (yDestino < 0) || (yDestino >= piezas[0].length)) {
            throw new ExcepcionPuntoFueraDelTablero("Error: Tablero.java -> intercambiarPieza() -> punto destino fuera del tablero");
        }
        // Hacemos el intercambio de piezas
        Image tmp = piezas[xOrigen][yOrigen].getSubImagen();
        piezas[xOrigen][yOrigen].ponerImagen(piezas[xDestino][yDestino].getSubImagen());
        piezas[xDestino][yDestino].ponerImagen(tmp);
    }

    // Métodos sobre inicialización de componentes
    private void iniciarComponentes() {
        for (int j = 0; j < piezas[0].length; j++) {
            for (int i = 0; i < piezas.length; i++) {
                this.add(piezas[i][j]);
            }
        }
    }

    private void iniciarPiezas(int nPiezaHorizontal, int nPiezaVertical) {
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
                piezas[i][j].ponerImagen(imagen.getSubimage(posImagenHorizontal, posImagenVertical, anchoSubImagen, altoSubImagen));
            }
        }
        try {
            imagen = ImageIO.read(new File(directorioImagenPuntoJugador));
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagen = resize(imagen, anchoSubImagen, altoSubImagen);
        piezas[0][0].ponerImagen(imagen);
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
     * @author Ocracoke (StackOverflow)
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
