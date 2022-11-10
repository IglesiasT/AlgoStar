package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProtossTest {

    @Test
    public void noSePuedeConstruirPuertaEstelarSinAcceso(){
        //Arrange
        Protoss razaProtoss = new Protoss();
        Casillero casilleroAConstruir = new Casillero(1,1,new Tablero());

        //Act
        casilleroAConstruir.setEspacioDeConstruccion(new RangoPilon());

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirPuertaEstelar(casilleroAConstruir));
    }
}
