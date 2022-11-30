package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.construcciones.unidades.AmoSupremo;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.Visible;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zerling;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso28Test {
    @Test
    public void unidadEnemigaNoPuedeAtacarZealotCuandoEstaInvisible() {
        Mapa mapa = new Mapa();
        Zealot zealot = new Zealot();
        Zerling zerling = new Zerling();

        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zerling.nuevoTurno();
        zerling.nuevoTurno();

        zealot.moverse(mapa.obtenerCasillero(1, 1));
        zerling.moverse(mapa.obtenerCasillero(1, 2));

        zerling.atacar(zealot);

        assertEquals(60, zealot.obtenerEscudo());
    }

    @Test
    public void unidadEnemigaPuedeAtacarZealotCuandoEstaVisible() {
        Mapa mapa = new Mapa();

        Zealot zealot = new Zealot();
        Zerling zerling = new Zerling();
        AmoSupremo amo = new AmoSupremo();

        zealot.moverse(mapa.obtenerCasillero(1, 1));
        zerling.moverse(mapa.obtenerCasillero(1, 2));
        amo.moverse(mapa.obtenerCasillero(2,2));

        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zerling.nuevoTurno();
        zerling.nuevoTurno();
        amo.nuevoTurno();
        amo.nuevoTurno();
        amo.nuevoTurno();
        amo.nuevoTurno();
        amo.nuevoTurno();

        zerling.atacar(zealot);

       assertEquals(56, zealot.obtenerEscudo());
    }
}
