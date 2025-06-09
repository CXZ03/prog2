/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller1.game;

import java.util.Random;
import taller1.definition.MowerDirection;
import taller1.definition.Soil;

/**
 *
 * @author cxz03
 */
public class GameLogic {

    private GameView gameView;

    private Soil gameState[][];
    private MowerDirection mowerDirection;
    private int mowerRow;
    private int mowerCol;
    private int remainGrass;

    public GameLogic(GameView gameView, int rows, int cols) {
        // Init atributte
        this.gameView = gameView;
        // Set the starting game state
        this.remainGrass = rows * cols;
        this.gameState = new Soil[rows][cols];
        Random random = new Random();
        this.mowerRow = random.nextInt(rows);
        this.mowerCol = random.nextInt(cols);
        this.mowerDirection = MowerDirection.values()[random.nextInt(MowerDirection.values().length)];   // Get a random direction
        initGameState();
    }

    public void initGameState() {
        // Set all the soil to grass
        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState[i].length; j++) {
                gameState[i][j] = Soil.GRASS;
            }
        }
        // Set the mower position to dirt
        gameState[mowerRow][mowerCol] = Soil.DIRT;
        // Put the mower in the grid
        gameView.putImage(mowerDirection, mowerRow, mowerCol);
        remainGrass--;
    }

    public void changeMowerDirection(MowerDirection newMowerDirection) {
        // Change the mower direction and updates the view
        mowerDirection = newMowerDirection;
        gameView.putImage(mowerDirection, mowerRow, mowerCol);
    }

    public void moveMower() {
        int newMowerRow = mowerRow + mowerDirection.getRowOffset();
        int newMowerCol = mowerCol + mowerDirection.getColOffset();
        // Check if the new position is out of the grid
        if (newMowerRow < 0
                || newMowerRow >= gameState.length
                || newMowerCol < 0
                || newMowerCol >= gameState[newMowerRow].length) {
            // Not expected movement, returns
            return;
        }
        // Legal movement
        if (gameState[newMowerRow][newMowerCol] == Soil.GRASS) {
            gameState[newMowerRow][newMowerCol] = Soil.DIRT;
            remainGrass--;
        }
        gameView.putImage(Soil.DIRT, mowerRow, mowerCol);
        mowerRow = newMowerRow;
        mowerCol = newMowerCol;
        gameView.putImage(mowerDirection, mowerRow, mowerCol);
    }

    public void checkWinCondition() {
        if (remainGrass == 0) {
            // The game finished, launcht a JDialog to informate the player
            String msgs[] = {
                "ENHORABUENA",
                "¡¡¡has completado el juego!!!",
                "HAS ACABADO DE CORTAR TODO EL CESPED"
            };
            GameNotification notification = new GameNotification(msgs);
            GameNotificationHandler handler = new GameNotificationHandler(notification);
            notification.pack();
            notification.setLocationRelativeTo(gameView);
            notification.setVisible(true);
        }
    }
}
