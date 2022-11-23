package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Acceso;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

public class CasoDeUso9Test {

    @Test
    public void sePuedeEnElRangoDeUnPilon(){
        //Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();

        //Act
        pilon.construir(casillero1);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();


        //Assert
        assert acceso.sePuedeConstruirEn(mapa.obtenerCasillero(1,3));
    }

    @Test
    public void elRangoDelPilonDejaDeEstarActivoAlDestruirse(){
        //Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();

        //Act
        pilon.construir(casillero1);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        pilon.destruir();


        //Assert
        assert !acceso.sePuedeConstruirEn(mapa.obtenerCasillero(1,3));
    }

    @Test
    public void sePuedeSeguirConstruyendoLuegoDeDestuirUnPilonSiHayOtroEnRango(){
        //Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Pilon pilon1 = new Pilon();
        Pilon pilon2 = new Pilon();
        Acceso acceso = new Acceso();

        //Act
        pilon1.construir(casillero1);
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();

        pilon2.construir(casillero2);
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();

        pilon1.destruir();
        pilon2.nuevoTurno();

        //Assert
        assert acceso.sePuedeConstruirEn(mapa.obtenerCasillero(1,3));
    }
}
