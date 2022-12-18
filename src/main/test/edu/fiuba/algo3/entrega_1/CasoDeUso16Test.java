package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.*;
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
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        asimilador.construir(casillero, recursos);

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> extractor.construir(casillero, recursos));
    }

    @Test
    public void asimiladorNoSePuedeConstruirSobreUnVolcanSiYaHayUnAExtractor(){
        // Arrange
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
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
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setRecurso(new Nodo());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
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
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setRecurso(new Nodo());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new RangoPilon());
        nexo.construir(casillero, recursos);

        // Assert
        assertThrows(RecursoOcupado.class, () -> zangano.ubicar(casillero));
    }
}
