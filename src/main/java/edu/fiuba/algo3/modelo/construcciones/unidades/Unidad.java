package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public interface Unidad {
    void atacar(Construccion construccion);
    void moverse(Casillero casilleroDestino);
}
