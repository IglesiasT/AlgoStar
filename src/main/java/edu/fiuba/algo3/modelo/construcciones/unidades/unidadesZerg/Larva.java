package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

public class Larva {

    public UnidadZerg evolucionar (UnidadZerg unidad , Casillero ubicacion , ListadoDeRecursos recursos){
        unidad.construir(ubicacion, recursos);
        return unidad;
    }
}
