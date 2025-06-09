/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package taller1.definition;

import java.awt.event.KeyEvent;

/**
 *
 * @author cxz03
 */
public enum MowerDirection {
    EAST("src/resources/imagenes_juego_cortacesped/cortador_e.jpg", 0, 1),
    NORTH("src/resources/imagenes_juego_cortacesped/cortador_n.jpg", -1, 0),
    WEST("src/resources/imagenes_juego_cortacesped/cortador_o.jpg", 0, -1),
    SOUTH("src/resources/imagenes_juego_cortacesped/cortador_s.jpg", 1, 0);

    private final String imagePath;
    private final int rowOffset;
    private final int colOffset;
    
    MowerDirection(String imagePath, int rowOffset, int colOffset) {
        this.imagePath = imagePath;
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
    }

    public String getImagePath() {
        return imagePath;
    }

    public static MowerDirection getMowerDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                return NORTH;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                return SOUTH;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                return WEST;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                return EAST;
            default:
                return null;
        }
    }
    
    public int getRowOffset() {
        return rowOffset;
    }
    
    public int getColOffset() {
        return colOffset;
    }
    
}
