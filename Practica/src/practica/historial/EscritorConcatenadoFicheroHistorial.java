/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.historial;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author cxz03
 */
public class EscritorConcatenadoFicheroHistorial extends EscritorFicheroHistorial{

    public EscritorConcatenadoFicheroHistorial(OutputStream out) throws FileNotFoundException, IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
