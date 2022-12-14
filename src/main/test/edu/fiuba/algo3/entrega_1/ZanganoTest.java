package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZanganoTest {

    @Test
    public void recolectaDiezPorTurno(){
        //Arrange
        Zangano zangano = new Zangano();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setRecurso(new Volcan());
        int cantidadEsperada = 10;

        //Act
        zangano.ubicar(casillero);
        zangano.nuevoTurno();

        //Assert
        assertEquals(cantidadEsperada, zangano.producir());
    }
}
