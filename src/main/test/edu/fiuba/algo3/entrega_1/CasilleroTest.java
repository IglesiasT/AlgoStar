package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.mapa.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasilleroTest {

    @Test
    public void casilleroTieneMoho(){
        //Arrange
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());

        //Assert
        assertTrue(casillero.contiene(new Moho()));
    }

    @Test
    public void noSePuedeConstruirNexoMineralSiHayZanganoAsignado(){
        //Arrange

        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setRecurso(new Nodo());
        Zangano zangano = new Zangano();

        //Act
        zangano.ubicar(casillero);

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> casillero.establecerConstruccion(new NexoMineral()));
    }
}
