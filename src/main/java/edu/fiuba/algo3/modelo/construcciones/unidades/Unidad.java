package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Raza;

public interface Unidad {
    void moverse(Casillero casilleroDestino);

    void nuevoTurno(Raza raza);
    Class obtenerRazaMadre();
}
