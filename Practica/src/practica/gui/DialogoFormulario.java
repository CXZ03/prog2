/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import practica.gestor.GestorDialogoFormulario;

/**
 * 
 * 
 * @author cxz03
 */
public class DialogoFormulario extends JDialog {

    private static final String TITULO = "CONFIGURACIÓN DE LA PARTIDA";

    private FormularioPuzle formulario;
    private boolean aceptado = false;

    public DialogoFormulario(JFrame ventanaPadre) {
        // Modal a true para que bloquee las acciones de la ventana principal
        super(ventanaPadre, TITULO, true);
        
        // Usamos border layout para poner el boton de aceptar debajo
        this.setLayout(new BorderLayout());
        
        // Creamos el formulario para ponerlo en el centro
        formulario = new FormularioPuzle();
        this.add(formulario, BorderLayout.CENTER);

        // Crear boton aceptar y lo ponemos debajo
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new GestorDialogoFormulario(this));
        this.add(botonAceptar, BorderLayout.SOUTH);
        
        // Ajustamos la ventana y lo colocamos respecto la ventana del juego
        this.pack();
        this.setLocationRelativeTo(ventanaPadre);
    }
    
    public void aceptar(boolean aceptado) {
        this.aceptado = aceptado;
    }
    
    public boolean seAcepto() {
        return aceptado;
    }
    
    public FormularioPuzle getFormulario() {
        return formulario;
    }
}
