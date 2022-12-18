package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11Test {

    @Test
    public void seDaniaUnPocoElPilonYPierdeEscudoPeroNoVida(){
        int escudoEsperado = 280;
        int vidaEsperada = 300;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(20);

        assertEquals(vidaEsperada, pilon.obtenerVida());
        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }

    @Test
    public void seDaniaUnPocoElPilonYPierdeEscudoPeroNoVidaYAlSiguienteTurnoRegeneraEscudo(){
        int escudoEsperado = 290;
        int vidaEsperada = 300;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(20);

        pilon.nuevoTurno(new Protoss());

        assertEquals(vidaEsperada, pilon.obtenerVida());
        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }

    @Test
    public void seDaniaUnPocoElPilonYPierdeEscudoYLuegoDeAlgunosTurnosLoRecuperaTodo(){
        int escudoEsperado = 300;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(20);

        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());

        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }
}
