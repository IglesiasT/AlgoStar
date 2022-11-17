package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.Extractor;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16Test {

    @Test
    public void extractorNoSePuedeConstruirSobreUnVolcanSiYaHayUnAsimilador(){
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Tablero());
        asimilador.construirEnCasillero(casillero);

        assert(!extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void asimiladorNoSePuedeConstruirSobreUnVolcanSiYaHayUnAExtractor(){
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construirEnCasillero(casillero);

        assertThrows(NoSePuedeConstruir.class, () -> asimilador.construirEnCasillero(casillero));
    }

    @Test
    public void nexoMineralNoSePuedeConstruirSobreUnNodoSiYaHayUnZanganoTrabajando(){
        Zangano zangano = new Zangano();
        NexoMineral nexo = new NexoMineral();

        Casillero casillero = new Casillero(new Mineral(),new AreaTerrestre(), 1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        zangano.ubicar(casillero);

        assertThrows(NoSePuedeConstruir.class, () -> nexo.construirEnCasillero(casillero));
    }

    @Test
    public void zanganoNoSePuedeAsignarAUnNodoSiTieneUnNexoMineral(){
        Zangano zangano = new Zangano();
        NexoMineral nexo = new NexoMineral();

        Casillero casillero = new Casillero(new Mineral(),new AreaTerrestre(), 1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        nexo.construirEnCasillero(casillero);

        assertThrows(RecursoOcupado.class, () -> zangano.ubicar(casillero));
    }
}
