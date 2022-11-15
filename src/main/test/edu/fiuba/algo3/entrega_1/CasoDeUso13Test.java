package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.construcciones.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

public class CasoDeUso13Test {

    @Test
    public void seDestrulleCriaderoPeroElMohoQueda(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Criadero criadero = new Criadero();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        //Act
        criadero.construirEnCasillero(casillero1);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.destruir();
        criadero.nuevoTurno();

        //Assert
        assert reserva.sePuedeConstruirEn(tablero.obtenerCasillero(1,3));
    }
}
