package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.construcciones.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

public class CasoDeUso13Test {

    @Test
    public void seDestrulleCriaderoPeroElMohoQueda(){
        //Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Criadero criadero = new Criadero();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        //Act
        criadero.construir(casillero1);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.destruir();
        criadero.nuevoTurno();

        //Assert
        //assert reserva.sePuedeConstruirEn(mapa.obtenerCasillero(1,3));
    }
}
