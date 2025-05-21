/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.historial;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author cxz03
 */
public class EscritorFicheroHistorial extends ObjectOutputStream {

    public EscritorFicheroHistorial(OutputStream out) throws FileNotFoundException, IOException {
        super(out);
    }

    public void escribirPartida(RegistroPartida partidaAGuardar) throws IOException {
        writeObject(partidaAGuardar);
    }
}
