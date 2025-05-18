/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import practica.gui.DialogoFormulario;
import practica.gui.FormularioPuzle;

/**
 * Clase donde se encarga de manejar los eventos de la Clase DialogoFormualrio
 * 
 * @author cxz03
 */
public class GestorDialogoFormulario implements ActionListener {
    
    private DialogoFormulario dialogoFormulario;

    public GestorDialogoFormulario(DialogoFormulario dialogoFormulario) {
        this.dialogoFormulario = dialogoFormulario;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        FormularioPuzle formulario = dialogoFormulario.getFormulario();
        
        // Si el formato del formulario esta correcto cerramos el dialogo y cambiamos el flag de aceptado a true
        if (formulario.verificarNumeros() && formulario.verificarNombre()) {
                dialogoFormulario.aceptar(true);
                dialogoFormulario.dispose();
            }
    }
}
