package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso8Test {
    @Test
    public void asimiladorNoSePuedeConstruirSinLosRecursosSuficientes() {
        // Arrange
        Protoss razaProtoss = new Protoss(0,0);
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act and Assert
        assertThrows(RecursosInsuficientes.class, () -> razaProtoss.construirAsimilador(casillero) );
    }

    @Test
    public void asimiladorSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Protoss razaProtoss = new Protoss();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setRecurso(new Volcan());

        // Act
        razaProtoss.construirAsimilador(casillero);

        // Assert
        assertEquals(Asimilador.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void extractorNoSePuedeConstruirSinLosRecursosSuficientes() {
        // Arrange
        Zerg razaZerg = new Zerg(0,0);
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setRecurso(new Volcan());

        // Act
        casillero.setEspacioDeConstruccion(new Moho());

        // Assert
        assertThrows(RecursosInsuficientes.class, () -> razaZerg.construirExtractor(casillero) );
    }

    @Test
    public void extractorSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Zerg razaZerg = new Zerg();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setRecurso(new Volcan());

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        razaZerg.construirExtractor(casillero);

        // Assert
        assertEquals(Extractor.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void criaderoNoSePuedeConstruirSinLosRecursosSuficientes() {
        // Arrange
        Zerg razaZerg = new Zerg(0,0);
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act and Assert
        assertThrows(RecursosInsuficientes.class, () -> razaZerg.construirCriadero(casillero) );
    }

    @Test
    public void criaderoSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Zerg razaZerg = new Zerg();
        Casillero casillero = new Casillero( new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        razaZerg.construirCriadero(casillero);

        // Assert
        assertEquals(Criadero.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirSinLosRecursosSuficientes() {
        // Arrange
        Zerg razaZerg = new Zerg(0,0);
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero.setEspacioDeConstruccion(new Moho());

        // Assert
        assertThrows(RecursosInsuficientes.class, () -> razaZerg.construirReservaDeReproduccion(casillero) );
    }

    @Test
    public void reservaDeReproduccionSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Zerg razaZerg = new Zerg();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero);

        // Assert
        assertEquals(ReservaDeReproduccion.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void guaridaNoSePuedeConstruirSinLosRecursosSuficientes() {
        // Arrange
        Casillero casillero1 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero2 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Zerg razaZerg = new Zerg(150,0);

        // Act
        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero1);

        // Assert
        assertThrows(RecursosInsuficientes.class, () -> razaZerg.construirGuarida(casillero2) );
    }

    @Test
    public void guaridaSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Casillero casillero1 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero2 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Zerg razaZerg = new Zerg(1000, 1000);

        // Act
        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero1);
        razaZerg.construirGuarida(casillero2);

        // Assert
        assertEquals(Guarida.class, casillero2.obtenerConstruccion().getClass());
    }

    @Test
    public void espiralNoSePuedeConstruirSinLosRecursosSuficientes() {
        // Arrange
        Zerg razaZerg = new Zerg(350,100);
        Casillero casillero1 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero2 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero3 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero1);
        razaZerg.construirGuarida(casillero2);

        // Assert
        assertThrows(RecursosInsuficientes.class, () -> razaZerg.construirEspiral(casillero3) );
    }

    @Test
    public void espiralSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Zerg razaZerg = new Zerg(2000,2000);
        Casillero casillero1 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero2 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero3 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero1);
        razaZerg.construirGuarida(casillero2);
        razaZerg.construirEspiral(casillero3);

        // Assert
        assertEquals(Espiral.class, casillero3.obtenerConstruccion().getClass());
    }

    @Test
    public void nexoMineralNoSePuedeConstruirSinLosRecursosSuficientes() {
        // Arrange
        Protoss razaProtoss = new Protoss(0,0);
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act and Assert
        assertThrows(RecursosInsuficientes.class, () -> razaProtoss.construirNexoMineral(casillero) );
    }

    @Test
    public void nexoMineralSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Protoss razaProtoss = new Protoss();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        razaProtoss.construirNexoMineral(casillero);

        // Assert
        assertEquals(NexoMineral.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void pilonNoSePuedeConstruirSinLosRecursosSuficientes(){
        // Arrange
        Protoss razaProtoss = new Protoss(0,0);
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act and Assert
        assertThrows(RecursosInsuficientes.class, () -> razaProtoss.construirPilon(casillero) );
    }

    @Test
    public void pilonSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Protoss razaProtoss = new Protoss();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        razaProtoss.construirPilon(casillero);

        // Assert
        assertEquals(Pilon.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void accesoNoSePuedeConstruirSinLosRecursosSuficientes(){
        // Arrange
        Protoss razaProtoss = new Protoss(0,0);
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero.setEspacioDeConstruccion(new RangoPilon());

        // Assert
        assertThrows(RecursosInsuficientes.class, () -> razaProtoss.construirAcceso(casillero));
    }

    @Test
    public void accesoSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 150;
        int gasNecesario = 0;
        Protoss razaProtoss = new Protoss(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assertDoesNotThrow(() -> razaProtoss.construirAcceso(casillero) );
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirSinLosRecursosSuficientes(){
        // Arrrange
        Protoss razaProtoss = new Protoss(150,0);
        Casillero casillero1 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero2 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero1.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        razaProtoss.construirAcceso(casillero1);

        // Assert
        assertThrows(RecursosInsuficientes.class, () -> razaProtoss.construirPuertoEstelar(casillero2) );
    }

    @Test
    public void puertoEstelarSePuedeConstruirConLosRecursosSuficientes(){
        // Arrange
        Protoss razaProtoss = new Protoss(4000,4000);
        Casillero casillero1 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        Casillero casillero2 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

        // Act
        casillero1.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        razaProtoss.construirAcceso(casillero1);
        razaProtoss.construirPuertoEstelar(casillero2);

        // Assert
        assertEquals(PuertoEstelar.class, casillero2.obtenerConstruccion().getClass());
    }
}
