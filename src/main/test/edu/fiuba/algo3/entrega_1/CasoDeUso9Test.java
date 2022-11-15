package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Acceso;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

public class CasoDeUso9Test {

    @Test
    public void sePuedeEnElRangoDeUnPilon(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();

        //Act
        pilon.construirEnCasillero(casillero1);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();


        //Assert
        assert acceso.sePuedeConstruirEn(tablero.obtenerCasillero(1,3));
    }

    @Test
    public void elRangoDelPilonDejaDeEstarActivoAlDestruirse(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();

        //Act
        pilon.construirEnCasillero(casillero1);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        pilon.destruir();


        //Assert
        assert !acceso.sePuedeConstruirEn(tablero.obtenerCasillero(1,3));
    }

    @Test
    public void sePuedeSeguirConstruyendoLuegoDeDestuirUnPilonSiHayOtroEnRango(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        Pilon pilon1 = new Pilon();
        Pilon pilon2 = new Pilon();
        Acceso acceso = new Acceso();

        //Act
        pilon1.construirEnCasillero(casillero1);
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();

        pilon2.construirEnCasillero(casillero2);
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();

        pilon1.destruir();
        pilon2.nuevoTurno();

        //Assert
        assert acceso.sePuedeConstruirEn(tablero.obtenerCasillero(1,3));
    }
}