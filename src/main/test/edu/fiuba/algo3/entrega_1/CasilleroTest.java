package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasilleroTest {

    @Test
    public void casilleroTieneMoho(){
        //Arrange
        Casillero casillero = new Casillero(1, 1, new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());

        //Assert
        assertTrue(casillero.contiene(new Moho()));
    }

    @Test
    public void noSePuedeConstruirNexoMineralSiHayZanganoAsignado(){
        //Arrange
        Casillero casillero = new Casillero(new Mineral(), 1, 1, new Tablero());
        Zangano zangano = new Zangano();

        //Act
        zangano.ubicar(casillero);

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> casillero.establecerConstruccion(new NexoMineral()));
    }
}
