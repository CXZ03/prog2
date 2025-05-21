/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

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
 * Representa el tablero del rompecabezas. Esta clase es un componente gráfico
 * que organiza y muestra las piezas del tablero en un diseño de cuadrícula.
 * También se encarga de inicializar y gestionar las piezas, redimensionar
 * imágenes y actualizar el tablero cuando las piezas cambian de posición.
 */
public class Tablero extends JPanel {

    private static final int ANCHO = 720; // Ancho del tablero en píxeles
    private static final int ALTO = 720;  // Alto del tablero en píxeles
    private String directorioImagen = "src/resources/linux-penguin.png"; // Ruta de la imagen base del rompecabezas
    private String directorioImagenPuntoJugador = "src/resources/player-point.png"; // Ruta de la imagen del jugador
    private Pieza[][] piezas; // Matriz que representa las piezas del tablero

    /**
     * Constructor que inicializa el tablero con las dimensiones especificadas.
     *
     * @param nPiezaHorizontal Número de piezas en el eje horizontal (columnas).
     * @param nPiezaVertical Número de piezas en el eje vertical (filas).
     */
    public Tablero(int nPiezaHorizontal, int nPiezaVertical) {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setLayout(new GridLayout(nPiezaVertical, nPiezaHorizontal)); // GridLayout organiza las piezas en filas y columnas
    }

    /**
     * Intercambia dos piezas del tablero. Actualiza gráficamente las imágenes
     * asociadas a las piezas.
     *
     * @param xOrigen Coordenada X de la pieza de origen.
     * @param yOrigen Coordenada Y de la pieza de origen.
     * @param xDestino Coordenada X de la pieza de destino.
     * @param yDestino Coordenada Y de la pieza de destino.
     */
    public void intercambiarPieza(int xOrigen, int yOrigen, int xDestino, int yDestino) {
        Image tmp = piezas[xOrigen][yOrigen].getSubImagen();
        piezas[xOrigen][yOrigen].ponerImagen(piezas[xDestino][yDestino].getSubImagen());
        piezas[xDestino][yDestino].ponerImagen(tmp);
    }

    /**
     * Inicializa los componentes del tablero, eliminando las piezas previas y
     * agregando las nuevas al panel.
     */
    public void iniciarComponentes() {
        // Quitamos todas las piezas previas
        removeAll();

        // Agregamos las piezas al tablero
        for (int j = 0; j < piezas[0].length; j++) {
            for (int i = 0; i < piezas.length; i++) {
                this.add(piezas[i][j]);
            }
        }

        // Informar al layout manager que el panel ha sido modificado
        revalidate();
    }

    /**
     * Inicializa las piezas del tablero a partir de un estado inicial y asigna
     * las imágenes correspondientes.
     *
     * @param estadoTablero Matriz que representa el estado inicial de las
     * piezas.
     * @param xPosJugador Coordenada X del punto del jugador.
     * @param yPosJugador Coordenada Y del punto del jugador.
     * @param nPiezaHorizontal Número de piezas horizontales (columnas).
     * @param nPiezaVertical Número de piezas verticales (filas).
     */
    public void iniciarPiezas(int[][] estadoTablero, int xPosJugador, int yPosJugador, int nPiezaHorizontal, int nPiezaVertical) {
        // Declaramos la matriz de piezas y el imagen del puzle
        piezas = new Pieza[nPiezaHorizontal][nPiezaVertical];
        BufferedImage imagen = null;

        try {
            // Cargar y redimensionar la imagen base
            imagen = ImageIO.read(new File(directorioImagen));
            imagen = resize(imagen, ANCHO, ALTO);

            // Dividir la imagen en subimágenes para cada pieza
            int anchoSubImagen = ANCHO / nPiezaHorizontal;
            int altoSubImagen = ALTO / nPiezaVertical;
            int posImagenHorizontal, posImagenVertical, posPiezaActual;

            for (int i = 0; i < nPiezaHorizontal; i++) {
                for (int j = 0; j < nPiezaVertical; j++) {
                    // Calcular el numero de columna y fila a partir del numero de la pieza
                    posPiezaActual = estadoTablero[i][j];
                    posImagenVertical = posPiezaActual / estadoTablero.length;
                    posImagenHorizontal = posPiezaActual % estadoTablero.length;

                    // asignar la subimagen partida a cada pieza
                    piezas[i][j] = new Pieza();
                    piezas[i][j].ponerImagen(imagen.getSubimage(
                            posImagenHorizontal * anchoSubImagen,
                            posImagenVertical * altoSubImagen,
                            anchoSubImagen,
                            altoSubImagen
                    ));
                }
            }

            // Cargar y redimensionar la imagen del punto del jugador
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
     * @param img La imagen original (BufferedImage) que se va a redimensionar.
     * @param newW El nuevo ancho en píxeles para la imagen redimensionada.
     * @param newH El nuevo alto en píxeles para la imagen redimensionada.
     * @return Una nueva instancia de {@link BufferedImage} con las dimensiones
     * especificadas.
     *
     * @author Ocracoke
     * @see https://stackoverflow.com/questions/9417356/bufferedimage-resize
     */
    private BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }
}
