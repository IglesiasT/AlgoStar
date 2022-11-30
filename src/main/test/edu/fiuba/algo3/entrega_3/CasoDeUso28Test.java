package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso28Test {
    @Test
    public void unidadEnemigaNoPuedeAtacarZealotCuandoEstaInvisible() {
        Mapa mapa = new Mapa();
        Zealot zealot = new Zealot();
        zealot.moverse(mapa.obtenerCasillero(1, 1));

        Zerling zerling = new Zerling();
        zerling.moverse(mapa.obtenerCasillero(1, 2));

        zerling.atacar(zealot);

        assertEquals(56, zealot.obtenerEscudo());
    }
}
