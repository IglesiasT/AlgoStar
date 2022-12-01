package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso28Test {
    @Test
    public void unidadEnemigaNoPuedeAtacarZealotCuandoEstaInvisible() {
        // Arrange
        Mapa mapa = new Mapa();
        Zealot zealot = new Zealot();
        Zerling zerling = new Zerling();

        // Act
        zealot.moverse(mapa.obtenerCasillero(1, 1));
        zerling.nuevoTurno();
        zerling.nuevoTurno();
        zerling.nuevoTurno();
        zerling.moverse(mapa.obtenerCasillero(1, 2));
        zerling.atacar(zealot);

        // Assert
        assertEquals(56, zealot.obtenerEscudo());
    }
}
