/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller1.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import taller1.definition.MowerDirection;

/**
 *
 * @author cxz03
 */
public class GameViewHandler implements KeyListener{
    
    private GameLogic gameLogic;
    
    public GameViewHandler(GameLogic gameLogic, GameView gameView) {
        // Assigne the game logic
        this.gameLogic = gameLogic;
   
        // Add this KeyListener to the GameView class
        gameView.addKeyListener(this);
    }
    
    private void keyPressedHandler(int keyCode) {
        // Translate the keyCode to the movement done
        MowerDirection movement = MowerDirection.getMowerDirection(keyCode);
        if (movement != null) {
            movementKeyPressedHandler(movement);
        } else if (keyCode == KeyEvent.VK_SPACE) {
            // If it's an space
            spacePressedHandler();
        }
        // Check if the game finished
        gameLogic.checkWinCondition();
    }
    
    private void movementKeyPressedHandler(MowerDirection mowerDirection) {
        gameLogic.changeMowerDirection(mowerDirection);
    }
    
    private void spacePressedHandler() {
        gameLogic.moveMower();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressedHandler(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
