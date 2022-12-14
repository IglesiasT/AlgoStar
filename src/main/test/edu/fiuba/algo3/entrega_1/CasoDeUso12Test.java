package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso12Test {

    @Test
    public void seDaniaElPilonSeRompeElEscudoYPierdeVida(){
        int escudoEsperado = 0;
        int vidaEsperada = 280;

        Pilon pilon = new Pilon();
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.recibirDanio(320);

        assertEquals(vidaEsperada, pilon.obtenerVida());
        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }


    @Test
    public void seDaniaElPilonYSeRompeElEscudoYPierdeVidaYAlSiguienteTurnoSoloRegeneraEscudo(){
        int escudoEsperado = 10;
        int vidaEsperada = 280;

        Pilon pilon = new Pilon();
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.recibirDanio(320);

        pilon.nuevoTurno(new Protoss());

        assertEquals(vidaEsperada, pilon.obtenerVida());
        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }
}
