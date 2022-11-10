package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Asimilador;
import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Pilon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PilonTest {
    @Test
    public void caso9(){
        //Arrange
        Casillero casilleroConstruido = new Casillero();
        Pilon pilon = new Pilon();
        Asimilador asimilador = new Asimilador();

        //casilleroConstruido.construirEdificioProtoss(pilon);
        //casilleroConstruido.construirEdificioProtoss(asimilador);

    }

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
    public void seDaniaElPilonSeRompeElEscudoYPierdeVida(){
        int escudoEsperado = 0;
        int vidaEsperada = 280;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(320);

        assertEquals(vidaEsperada, pilon.obtenerVida());
        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }

    @Test
    public void seDaniaUnPocoElPilonYPierdeEscudoPeroNoVidaYAlSiguienteTurnoRegeneraEscudo(){
        int escudoEsperado = 290;
        int vidaEsperada = 300;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(20);

        pilon.nuevoTurno();

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

    @Test
    public void seDaniaUnPocoElPilonYPierdeEscudoYLuegoDeAlgunosTurnosLoRecuperaTodo(){
        int escudoEsperado = 300;

        Pilon pilon = new Pilon();
        pilon.recibirDanio(20);

        pilon.nuevoTurno();
        pilon.nuevoTurno();

        assertEquals(escudoEsperado, pilon.obtenerEscudo());

    }

}
