package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso28Test {
    @Test
    public void unidadEnemigaNoPuedeAtacarZealotCuandoEstaInvisible() {
        // Arrange
        Casillero casillero = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Raza raza = new Zerg();

        Zealot zealot = new Zealot();
        Zerling zerling = new Zerling();

        // Act
        zealot.moverse(casillero);
        for (int i = 0; i <5; i++) {
            zealot.nuevoTurno(new Protoss());
        }

        zealot.invisibilizar();
        zerling.nuevoTurno(raza);
        zerling.nuevoTurno(raza);
        zerling.nuevoTurno(raza);

        zerling.moverse(casillero2);
        zerling.atacar(zealot);

        // Assert
        assertEquals(60, zealot.obtenerEscudo());
    }
}