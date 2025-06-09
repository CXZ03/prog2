/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package taller1.definition;

import java.awt.Image;

/**
 *
 * @author cxz03
 */
public enum Soil {
    GRASS("src/resources/imagenes_juego_cortacesped/cesped.jpg"),
    DIRT("src/resources/imagenes_juego_cortacesped/tierra.jpg");
    
    private final String imagePath;
    
    Soil(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getImagePath() {
        return imagePath;
    }
}
