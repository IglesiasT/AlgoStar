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

        Base baseJugadorUno = mapa.obtenerBaseUno();
        Base baseJugadorDos = mapa.obtenerBaseDos();

        assert(baseJugadorDos.obtenerUbicacion().obtenerFila() -
                baseJugadorUno.obtenerUbicacion().obtenerFila() >= 10);

        assert(baseJugadorDos.obtenerUbicacion().obtenerColumna() -
                baseJugadorUno.obtenerUbicacion().obtenerColumna() >= 10);

    }

}
