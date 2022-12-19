package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.CasilleroSinGas;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {
    @Test
    public void asimiladorSePuedeConstruirEnCasilleroConGas() {
        // Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        casillero.setRecurso(new Volcan());

        // Act
        recursos.agregar(new Mineral(2000));
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
        recursos.agregar(new Mineral(2000));

        // Assert
        assertThrows(CasilleroSinGas.class, () -> asimilador.construir(casillero, recursos));
    }

    @Test
    public void extractorSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        casillero.setRecurso(new Volcan());

        // Act
        recursos.agregar(new Mineral(2000));
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
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());

        // Assert
        assertThrows(CasilleroSinGas.class, () -> extractor.construir(casillero, recursos));
    }

    @Test
    public void criaderoNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        casillero.setRecurso(new Volcan());

        // Act
        recursos.agregar(new Mineral(2000));

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> criadero.construir(casillero, recursos));
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        casillero.setRecurso(new Volcan());

        // Act
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> reserva.construir(casillero, recursos));
    }

    @Test
    public void guaridaNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        Guarida guarida = new Guarida();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> guarida.construir(casillero, recursos));
    }

    @Test
    public void espiralNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        Espiral espiral = new Espiral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> espiral.construir(casillero, recursos));
    }

    @Test
    public void nexoMineralNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        NexoMineral nexo = new NexoMineral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        casillero.setRecurso(new Volcan());

        // Act
        recursos.agregar(new Mineral(2000));

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> nexo.construir(casillero, recursos));
    }

    @Test
    public void pilonNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        Pilon pilon = new Pilon();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        casillero.setRecurso(new Volcan());

        // Act
        recursos.agregar(new Mineral(2000));

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> pilon.construir(casillero, recursos));
    }

    @Test
    public void accesoNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        Acceso acceso = new Acceso();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        casillero.setRecurso(new Volcan());

        // Act
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new RangoPilon());

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> acceso.construir(casillero, recursos));
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirEnUnCasilleroConGas(){
        // Arrange
        PuertoEstelar puerto = new PuertoEstelar();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new RangoPilon());

        // Assert
        assertThrows(NoSePuedeConstruir.class, () -> puerto.construir(casillero, recursos));
    }
}
