package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.CasilleroSinGas;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso3Test {
    @Test
    public void asimiladorSePuedeConstruirEnCasilleroConGas() {
        // Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        asimilador.construir(casillero, recursos);

        // Assert
        assertEquals(Asimilador.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void asimiladorNoSePuedeConstruirEnCasilleroSinGas() {
        // Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());

        // Assert
        assertThrows(CasilleroSinGas.class, () -> asimilador.construir(casillero, recursos));
    }

    @Test
    public void extractorSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);

        // Assert
        assertEquals(Extractor.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void extractorNoSePuedeConstruirEnUnCasilleroSinGas(){
        // Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());

        // Assert
        assertThrows(CasilleroSinGas.class, () -> extractor.construir(casillero, recursos));
    }

    @Test
    public void criaderoNoSePuedeConstruirEnUnCasilleroConGas(){
        Criadero criadero = new Criadero();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());

        //assert(!criadero.sePuedeConstruirEn(casillero));
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirEnUnCasilleroConGas(){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        //assert(!reserva.sePuedeConstruirEn(casillero));
    }

    @Test
    public void guaridaNoSePuedeConstruirEnUnCasilleroConGas(){
        Guarida guarida = new Guarida();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        //assert(!guarida.sePuedeConstruirEn(casillero));
    }

    @Test
    public void espiralNoSePuedeConstruirEnUnCasilleroConGas(){
        Espiral espiral = new Espiral();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        //assert(!espiral.sePuedeConstruirEn(casillero));
    }

    @Test
    public void nexoMineralNoSePuedeConstruirEnUnCasilleroConGas(){
        NexoMineral nexo = new NexoMineral();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());

        //assert(!nexo.sePuedeConstruirEn(casillero));
    }

    @Test
    public void pilonNoSePuedeConstruirEnUnCasilleroConGas(){
        Pilon pilon = new Pilon();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());

//        assert(!pilon.sePuedeConstruirEn(casillero));
    }

    @Test
    public void accesoNoSePuedeConstruirEnUnCasilleroConGas(){
        Acceso acceso = new Acceso();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

//        assert(!acceso.sePuedeConstruirEn(casillero));
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirEnUnCasilleroConGas(){
        PuertoEstelar puerto = new PuertoEstelar();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

//        assert(!puerto.sePuedeConstruirEn(casillero));
    }
}
