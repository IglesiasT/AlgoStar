package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.razas.Zerg;


public class ListadoDeConstruccionesZerg extends ListadoDeConstrucciones{

    public void destruir (Construccion construccionADestruir) {
        construccionADestruir.destruir();
    }
/*
    public void eliminarConstruccionesDestruidas(Zerg raza){
        for (ConstruccionZerg construccion: construcciones){
            if (construccion.obtenerVida()<=0){
                if (construccion.getClass() == Criadero.class)
                    raza.destruir((Criadero) construccion);
                else if (construccion.getClass() == AmoSupremo.class)
                    raza.destruir((AmoSupremo) construccion);
                else raza.destruir(construccion);
            }
        }
    }
 */
}
