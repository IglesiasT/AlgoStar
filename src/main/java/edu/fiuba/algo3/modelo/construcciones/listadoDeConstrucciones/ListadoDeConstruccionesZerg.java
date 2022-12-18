package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;

import edu.fiuba.algo3.modelo.construcciones.Construccion;

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
