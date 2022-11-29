package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

public interface EstadoMutalisco {
    void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos);
    void atacar(ConstruccionProtoss construccionEnemiga);
    void moverse(Casillero casillero);
    int consumirSuministro(int suministroAConsumir);
    void recibirDanio(int danioInflingido);

    void destruir();
    String obtenerSuperficie();
    void establecerUbicacion(Casillero nuevaUbicacion);
    Casillero obtenerUbicacion();

    void nuevoTurno();

    Area obtenerArea();
    int obtenerVida();
}
