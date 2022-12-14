package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionPreviaNoConstruida;
import edu.fiuba.algo3.modelo.construcciones.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZergTest {

    @Test
    public void sinRecursosNoSePuedeConstruir(){
        //Arrange
        Zerg razaZerg = new Zerg();

        Casillero casilleroAConstruir1 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        //Act
        razaZerg.construirCriadero(casilleroAConstruir1);

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirCriadero(casilleroAConstruir1));
    }

    @Test
    public void noSePuedeCrearEspiralSinGuarida(){
        //Arrange
        Zerg razaZerg = new Zerg();
        Casillero casilleroAConstruir = new Casillero(new AreaTerrestre(),1, 1, new Mapa());


        //Act
        casilleroAConstruir.setEspacioDeConstruccion(new Moho());

        //Assert
        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.construirEspiral(casilleroAConstruir));
    }
}
