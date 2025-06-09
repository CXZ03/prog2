/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller1.game;

import javax.swing.JFrame;

/**
 *
 * @author cxz03
 */
public class GameWindows extends JFrame {

    private static final String TITTLE = "CORTACESPED";
    private GameView gameView;

    public GameWindows(GameView gameView) {
        // Atributte initiation
        this.gameView = gameView;

        // Mount components
        initComponents();                               // Add all the components   

        // JFrame settings
        this.setTitle(TITTLE);                          // Set game tittle
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   // Close operation
        this.setResizable(false);                       // Cannot resize
        this.setMaximizedBounds(null);                  // Cannot maximize windows
        this.pack();                                    // Resize to the component preferred size
        this.setLocationRelativeTo(null);               // Center the windows to the center

    }

    private void initComponents() {
        this.add(gameView);
    }
}
