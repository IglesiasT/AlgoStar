package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.Extractor;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16Test {

    @Test
    public void extractorNoSePuedeConstruirSobreUnVolcanSiYaHayUnAsimilador(){
        // Arrange
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        asimilador.construir(casillero, recursos);

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> extractor.construir(casillero, recursos));
    }

    @Test
    public void asimiladorNoSePuedeConstruirSobreUnVolcanSiYaHayUnAExtractor(){
        // Arrange
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> asimilador.construir(casillero, recursos));
    }

    @Test
    public void nexoMineralNoSePuedeConstruirSobreUnNodoSiYaHayUnZanganoTrabajando(){
        // Arrange
        Zangano zangano = new Zangano();
        NexoMineral nexo = new NexoMineral();
        Casillero casillero = new Casillero(new Mineral(),new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        zangano.ubicar(casillero);

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> nexo.construir(casillero, recursos));
    }

    @Test
    public void zanganoNoSePuedeAsignarAUnNodoSiTieneUnNexoMineral(){
        // Arrange
        Zangano zangano = new Zangano();
        NexoMineral nexo = new NexoMineral();
        Casillero casillero = new Casillero(new Mineral(),new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        nexo.construir(casillero, recursos);

        // Assert
        assertThrows(RecursoOcupado.class, () -> zangano.ubicar(casillero));
    }
}
