/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller1.game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import taller1.definition.MowerDirection;
import taller1.definition.Soil;

/**
 *
 * @author cxz03
 */
public class GameView extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private final Image soilImages[];
    private final Image mowerDirectionImages[];

    private GameTile gameGrid[][];

    public GameView(int rows, int cols) {
        // Image array initiation
        this.soilImages = new Image[Soil.values().length];
        this.mowerDirectionImages = new Image[MowerDirection.values().length];
        initSoilImages();
        initMowerDirectionImages();

        // Game grid initiation
        this.gameGrid = new GameTile[rows][cols];
        initGameGrid();

        // JPanel settings
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new GridLayout(rows, cols));
        this.setFocusable(true);

        // Mount the JPanel
        initComponent();
    }

    public void putImage(Soil soil, int row, int col) {
        gameGrid[row][col].putImage(soilImages[soil.ordinal()]);
    }

    public void putImage(MowerDirection mowerDirection, int row, int col) {
        gameGrid[row][col].putImage(mowerDirectionImages[mowerDirection.ordinal()]);
    }

    private void initSoilImages() {
        try {
            for (Soil s : Soil.values()) {
                this.soilImages[s.ordinal()] = ImageIO.read(new File(s.getImagePath()));
            }
        } catch (IOException ex) {
            System.err.println("Error loading soil images: " + ex.getMessage());
        }
    }

    private void initMowerDirectionImages() {
        try {
            for (MowerDirection md : MowerDirection.values()) {
                this.mowerDirectionImages[md.ordinal()] = ImageIO.read(new File(md.getImagePath()));
            }
        } catch (IOException ex) {
            System.err.println("Error loading mower direction images: " + ex.getMessage());
        }
    }

    private void initGameGrid() {
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[i].length; j++) {
                gameGrid[i][j] = new GameTile();
                gameGrid[i][j].putImage(soilImages[Soil.GRASS.ordinal()]);
            }
        }
    }

    private void initComponent() {
        for (GameTile[] gameGridRows : gameGrid) {
            for (GameTile gameGridTile : gameGridRows) {
                this.add(gameGridTile);
            }
        }
    }
}
