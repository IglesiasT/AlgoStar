package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1Test {

    @Test
    public void criaderoSeIniciaConTresLarvas() {
        //Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(new Casillero(1,1, new Tablero()));
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroUnZanganoYConsumeUnaLarva(){
        //Arrange
        int valorEsperado = 2;
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(new Casillero(1,1, new Tablero()));
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.engendrarZangano();

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroUnZanganoPasaUnTurnoYVuelveAEstarLlenoElCriadero(){
        //Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(new Casillero(1,1, new Tablero()));
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroDosZanganosPasaUnTurnoYSeRegeneraUnaLarvaDelCriadero(){
        //Arrange
        int valorEsperado = 2;
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(new Casillero(1,1, new Tablero()));
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroDosZanganosPasanDosTurnosYVuelveAEstarLlenoElCriadero(){
        //Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(new Casillero(1,1, new Tablero()));
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

        //Act
        criadero.construirEnCasillero(new Casillero(1,1, new Tablero()));
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

        //Act
        criadero.construirEnCasillero(new Casillero(1,1, new Tablero()));
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