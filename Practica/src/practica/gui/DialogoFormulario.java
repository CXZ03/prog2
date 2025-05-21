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
 * Representa un cuadro de diálogo modal que contiene un formulario para
 * configurar la partida. Este cuadro bloquea las interacciones con la ventana
 * principal hasta que el usuario complete o cierre el diálogo.
 *
 * Utiliza un FormularioPuzle para recopilar los parámetros de la partida y un
 * botón para aceptar los datos ingresados.
 */
public class DialogoFormulario extends JDialog {

    private static final String TITULO = "CONFIGURACIÓN DE LA PARTIDA";
    private FormularioPuzle formulario; // Formulario para ingresar los parámetros de la partida
    private boolean aceptado = false; // Flag para si el usuario aceptó el formulario

    /**
     * Constructor que inicializa el cuadro de diálogo con un formulario y un
     * botón de aceptar.
     *
     * @param ventanaPadre La ventana principal desde la cual se lanza este
     * cuadro de diálogo.
     */
    public DialogoFormulario(JFrame ventanaPadre) {
        // Modal a true para que bloquee las acciones de la ventana principal
        super(ventanaPadre, TITULO, true);

        // Usamos BorderLayout para organizar los elementos
        this.setLayout(new BorderLayout());

        // Crear el formulario y colocarlo en el centro del diálogo
        formulario = new FormularioPuzle();
        this.add(formulario, BorderLayout.CENTER);

        // Crear el botón "Aceptar" y añadir un gestor de eventos
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new GestorDialogoFormulario(this));
        this.add(botonAceptar, BorderLayout.SOUTH);

        // Ajustar el tamaño del diálogo y colocarlo centrado respecto a la ventana padre
        this.pack();
        this.setLocationRelativeTo(ventanaPadre);
    }

    /**
     * Establece si el usuario aceptó el formulario.
     *
     * @param aceptado true si el formulario fue aceptado, de lo contrario
     * false.
     */
    public void aceptar(boolean aceptado) {
        this.aceptado = aceptado;
    }

    /**
     * Verifica si el formulario fue aceptado por el usuario.
     *
     * @return true si el formulario fue aceptado, de lo contrario false.
     */
    public boolean seAcepto() {
        return aceptado;
    }

    /**
     * Obtiene el formulario que contiene los parámetros de configuración de la
     * partida.
     *
     * @return Una instancia de FormularioPuzle.
     */
    public FormularioPuzle getFormulario() {
        return formulario;
    }
}
