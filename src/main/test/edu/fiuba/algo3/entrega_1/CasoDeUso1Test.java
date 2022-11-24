package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1Test {

    @Test
    public void criaderoSeIniciaConTresLarvas() {
        // Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();

        // Act and Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroUnZanganoYConsumeUnaLarva(){
        // Arrange
        int valorEsperado = 2;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        criadero.construir(casillero, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.engendrarZangano();

        // Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroUnZanganoPasaUnTurnoYVuelveAEstarLlenoElCriadero(){
        // Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());

        criadero.construir(casillero, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.nuevoTurno();

        // Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroDosZanganosPasaUnTurnoYSeRegeneraUnaLarvaDelCriadero(){
        // Arrange
        int valorEsperado = 2;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        criadero.construir(casillero, recursos);

        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.nuevoTurno();

        // Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroDosZanganosPasanDosTurnosYVuelveAEstarLlenoElCriadero(){
        //Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        criadero.construir(casillero, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroTresZanganosPasaUnTurnoYSeRegeneraUnaLarvaDelCriadero(){
        //Arrange
        int valorEsperado = 1;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        criadero.construir(casillero, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroTresZanganosPasaUnTurnoYVuelveAEstarLlenoElCriadero(){
        //Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        criadero.construir(casillero, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }
}
