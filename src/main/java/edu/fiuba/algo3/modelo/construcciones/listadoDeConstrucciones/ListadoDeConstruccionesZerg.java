package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;

import edu.fiuba.algo3.modelo.construcciones.Construccion;

public class ListadoDeConstruccionesZerg extends ListadoDeConstrucciones{

    public void destruir (Construccion construccionADestruir) {
        construccionADestruir.destruir();
    }
}
