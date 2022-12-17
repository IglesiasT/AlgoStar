package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

import java.util.LinkedList;

public class ListadoDeConstruccionesZerg extends ListadoDeConstrucciones{

    public void destruir (Construccion construccionADestruir) {
        for (Construccion construccion : this.construcciones) {
            if (construccion.getClass() == construccionADestruir.getClass()) {
                construccion.destruir();
            }
        }
    }
}
