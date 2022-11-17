package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zangano;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.MineralProducido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso7Test {

    @Test
    public void zanganoRecolectaDiezPorTurno(){
        //Arrange
        Zangano zangano = new Zangano();
        Casillero casillero = new Casillero(new Mineral(),new AreaTerrestre(), 1, 1, new Mapa());
        int cantidadEsperada = 10;

        //Act
        zangano.ubicar(casillero);
        zangano.nuevoTurno();

        //Assert
        assertEquals(cantidadEsperada, zangano.producir());
    }

    @Test
    public void nexoMineralRecolectaVeintePorTurno(){
        //Arrange
        NexoMineral nexo = new NexoMineral();
        Casillero casillero = new Casillero(new Mineral(), new AreaTerrestre(),1,1,new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        nexo.construirEnCasillero(casillero);
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();

        MineralProducido mineralProducidoEsperado = new MineralProducido(20);

        nexo.nuevoTurno();

        //Act and Assert
        assertEquals(mineralProducidoEsperado, nexo.obtenerMineralProducido());
    }
}
