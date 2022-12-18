package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;

public class ListadoDeConstruccionesProtoss extends ListadoDeConstrucciones{
    @Override
    public int destruir (Construccion construccionADestruir, int maximoSuministro) {

        construccionADestruir.destruir();
        construcciones.remove(construccionADestruir);

        if (construccionADestruir.getClass() == Pilon.class){
            maximoSuministro -= 5 ;
        }

        return maximoSuministro;
    }

}
