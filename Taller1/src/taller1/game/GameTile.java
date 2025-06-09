/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller1.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author cxz03
 */
public class GameTile extends JPanel{
    
    private static final int BORDER_WIDTH = 1;
    private Image image;
    
    public GameTile() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, BORDER_WIDTH));
    }
    
    public void putImage(Image image) {
        this.image = image;
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // Reset the panel
        super.paintComponent(g);
        // Paint the image
        g.drawImage(image, 0, 0, this);
    }
}
