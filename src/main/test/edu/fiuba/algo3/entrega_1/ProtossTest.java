package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProtossTest {
    @Test
    public void noSePuedeConstruirPuertaEstelarSinAcceso(){
        //Arrange
        Protoss razaProtoss = new Protoss();
        Casillero casilleroAConstruir = new Casillero(new AreaTerrestre(),1,1,new Mapa());


        //Act
        casilleroAConstruir.setEspacioDeConstruccion(new RangoPilon());

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirPuertoEstelar(casilleroAConstruir));
    }
}
