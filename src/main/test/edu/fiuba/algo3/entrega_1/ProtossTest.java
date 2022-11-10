package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.Protoss;
import edu.fiuba.algo3.modelo.RangoPilon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProtossTest {

    @Test
    public void noSePuedeConstruirPuertaEstelarSinAcceso(){
        //Arrange
        Protoss razaProtoss = new Protoss();
        Casillero casilleroAConstruir = new Casillero();

        //Act
        casilleroAConstruir.setEspacioDeConstruccion(new RangoPilon());

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirPuertaEstelar(casilleroAConstruir));
    }
}
