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
 * Clase que gestiona los eventos del DialogoFormulario. Se encarga de validar
 * los datos ingresados en el formulario y cerrar el cuadro de diálogo si los
 * datos son correctos.
 *
 * Implementa ActionListener para manejar eventos de acción.
 */
public class GestorDialogoFormulario implements ActionListener {

    private DialogoFormulario dialogoFormulario;

    /**
     * Constructor que inicializa el gestor con el diálogo asociado.
     *
     * @param dialogoFormulario El diálogo que será gestionado.
     */
    public GestorDialogoFormulario(DialogoFormulario dialogoFormulario) {
        this.dialogoFormulario = dialogoFormulario;
    }

    /**
     * Maneja el evento de acción generado por el botón de aceptar en el
     * diálogo.
     *
     * @param e El evento de acción que se ha disparado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        FormularioPuzle formulario = dialogoFormulario.getFormulario();

        // Verificar que los datos del formulario son válidos
        if (formulario.verificarNumeros() && formulario.verificarNombre()) {
            // Si los datos son correctos, marcar el formulario como aceptado y cerrar el diálogo
            dialogoFormulario.aceptar(true);
            dialogoFormulario.dispose();
        }
    }
}
