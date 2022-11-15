package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Pilon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso12Test {

    @Test
    public void seDaniaElPilonSeRompeElEscudoYPierdeVida(){
        int escudoEsperado = 0;
        int vidaEsperada = 280;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(320);

        assertEquals(vidaEsperada, pilon.obtenerVida());
        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }


    @Test
    public void seDaniaElPilonYSeRompeElEscudoYPierdeVidaYAlSiguienteTurnoSoloRegeneraEscudo(){
        int escudoEsperado = 10;
        int vidaEsperada = 280;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(320);

        pilon.nuevoTurno();

        assertEquals(vidaEsperada, pilon.obtenerVida());
        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }
}
