/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller1;

import taller1.game.GameLogic;
import taller1.game.GameView;
import taller1.game.GameViewHandler;
import taller1.game.GameWindows;

/**
 *
 * @author cxz03
 */
public class Main {
    public static int ROWS = 20;
    public static int COLS = 20;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Init the components of the game
        GameView gameView = new GameView(ROWS, COLS);
        GameLogic gameLogic = new GameLogic(gameView, ROWS, COLS);
        GameViewHandler gameViewHandler = new GameViewHandler(gameLogic, gameView);
        // Init the GUI of the game
        new GameWindows(gameView).setVisible(true);
    }
}
