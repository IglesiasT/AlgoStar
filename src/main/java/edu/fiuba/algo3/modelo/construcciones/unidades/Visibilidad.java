package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public interface Visibilidad {
    void recibirDanio(int danioInflingido);
    int obtenerEscudo();
    Visibilidad hacerVisible();
    Visibilidad hacerInvisible();
    int obtenerVida();
}
