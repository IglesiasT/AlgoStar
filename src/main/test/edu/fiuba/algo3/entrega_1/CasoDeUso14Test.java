package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

public class CasoDeUso14Test {

    @Test
    public void pilonNoEnergizaCasillerosConMoho(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,7);
        Criadero criadero = new Criadero();
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();

        //Act
        criadero.construirEnCasillero(casillero1);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        pilon.construirEnCasillero(casillero2);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();



        //Assert
        assert !acceso.sePuedeConstruirEn(tablero.obtenerCasillero(1,4));
    }

    @Test
    public void mohoCreceAunEstandoEnElRangoDeUnPilon(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,7);
        Criadero criadero = new Criadero();
        Pilon pilon = new Pilon();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        //Act
        pilon.construirEnCasillero(casillero1);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        criadero.construirEnCasillero(casillero2);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();


        //Assert
        assert reserva.sePuedeConstruirEn(tablero.obtenerCasillero(1,2));
    }
}
