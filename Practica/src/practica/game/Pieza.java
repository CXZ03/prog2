/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author cxz03
 */
public class Pieza extends JPanel{
    private static final int BORDER_WIDTH = 1;
    private Image subImagen;
    
    public Pieza() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, BORDER_WIDTH));
    }
    
    public void ponerImagen(Image subImage){
        this.subImagen = subImage;
        this.repaint();
    }
    
    public Image getSubImagen(){
        return this.subImagen;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(subImagen, 0, 0, this);
    }
}
