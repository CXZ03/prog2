/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import practica.gui.Tablero;

/**
 *
 * @author cxz03
 */
public class GestorTablero implements ActionListener, KeyListener{
    Tablero tablero;
    public GestorTablero(Tablero tablero){
        this.tablero = tablero;
    }
    
    private void gestionarTeclaW(){
        tablero.moverHaciaArriba();
    }
    
    private void gestionarTeclaA(){
        tablero.moverHaciaIzquierda();
    }
    
    private void gestionarTeclaS() {
        tablero.moverHaciaAbajo();
    }
    
    private void gestionarTeclaD() {
        tablero.moverHaciaDerecha();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
            case 'W':
                System.out.println("---> DEBUG: key pressed 'w'");
                this.gestionarTeclaW();
                break;
            case 'a':
            case 'A':
                System.out.println("---> DEBUG: key pressed 'a'");
                this.gestionarTeclaA();
                break;
            case 's':
            case 'S':
                System.out.println("---> DEBUG: key pressed 's'");
                this.gestionarTeclaS();
                break;
            case 'd':
            case 'D':
                System.out.println("---> DEBUG: key pressed 'd'");
                this.gestionarTeclaD();
                break;
            default:
                System.out.println("---> DEBUG: key pressed <SIN ASIGNAR>");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
