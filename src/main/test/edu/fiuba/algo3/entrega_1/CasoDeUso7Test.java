package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.NodoMineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso7Test {

    @Test
    public void zanganoRecolectaDiezPorTurno(){
        //Arrange
        Zangano zangano = new Zangano();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setRecurso(new Mineral());
        int cantidadEsperada = 10;

        //Act
        zangano.ubicar(casillero);
        zangano.nuevoTurno();

        //Assert
        assertEquals(cantidadEsperada, zangano.producir());
    }

    @Test
    public void nexoMineralRecolectaVeintePorTurno(){
        // Arrange
        NexoMineral nexo = new NexoMineral();
        Casillero casillero = new Casillero( new AreaTerrestre(),1,1,new Mapa());
        casillero.setRecurso(new Mineral());
        NodoMineral mineralProducidoEsperado = new NodoMineral(20);
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        recursos.agregar(new Mineral());
        nexo.construir(casillero, recursos);
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();

        nexo.nuevoTurno();

        // Assert
        assertEquals(mineralProducidoEsperado, nexo.obtenerMineralProducido());
    }
}
