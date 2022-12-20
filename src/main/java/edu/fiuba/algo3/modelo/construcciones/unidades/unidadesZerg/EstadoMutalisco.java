package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

public interface EstadoMutalisco {
    void construir(Casillero casillero,ListadoDeRecursos recursos);
    void atacar(ConstruccionProtoss construccionEnemiga);
    int consumirSuministro(int suministroAConsumir);
    void recibirDanio(int danioInflingido);
    void nuevoTurno(Raza raza);
    Area obtenerArea();
    int obtenerVida();
    boolean activa();
    void enRangoDeAtaque(Casillero casillero);
    void moverse(Casillero casillero);
}
