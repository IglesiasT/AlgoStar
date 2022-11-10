package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CriaderoTest {
    @Test
    public void criaderoSeIniciaConTresLarvas() {

        int valorEsperado = 3;
        Criadero criadero = new Criadero();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroUnZanganoYConsumeUnaLarva(){

        int valorEsperado = 2;
        Criadero criadero = new Criadero();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();

        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroZanganosPasaUnTurnoYSeRegeneraUnaLarvaDelCriadero(){

        int valorEsperado = 2;
        Criadero criadero = new Criadero();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.engendrarZangano();
        criadero.engendrarZangano();
        criadero.nuevoTurno();

        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void pasanTresTurnosYCriaderoNoEstaOperativo(){
        Criadero criadero = new Criadero();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        assertThrows(EdificioNoEstaOperativo.class, criadero::engendrarZangano);
    }

    @Test
    public void seReduceLaVidaAlSerDaniado(){
        //Arrange
        Criadero criadero = new Criadero();
        int valorEsperado = 50;

        //Act
        criadero.recibirDanio(50);

        //Assert
        assertEquals(valorEsperado, criadero.obtenerVida());
    }

    @Test
    public void alSerDaniadoRegeneraVidaHastaCien(){
        //Arrange
        Criadero criadero = new Criadero();
        int valorEsperado = 100;

        //Act
        criadero.recibirDanio(5);
        criadero.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, criadero.obtenerVida());
    }

    @Test
    public void noSePuedeConstruirCriaderoEnCasilleroConGas(){
        Criadero criadero = new Criadero();

        Casillero casillero = new Casillero(new Gas());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(!criadero.sePuedeConstruirEn(casillero));
    }

}
