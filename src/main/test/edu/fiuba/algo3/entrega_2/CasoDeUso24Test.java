package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.mapa.Base;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso24Test {

    @Test
    public void losJugadoresComienzanEnBasesOpuestasDelMapa(){
        Mapa mapa = new Mapa();

        Base baseJugadorUno = mapa.obtenerBase(1);
        Base baseJugadorDos = mapa.obtenerBase(2);

        assertEquals(baseJugadorDos.obtenerUbicacion().obtenerFila(),
                baseJugadorUno.obtenerUbicacion().obtenerColumna());

        assertEquals(baseJugadorDos.obtenerUbicacion().obtenerColumna(),
                baseJugadorUno.obtenerUbicacion().obtenerFila());

    }

}
