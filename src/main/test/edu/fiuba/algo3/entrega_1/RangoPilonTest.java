package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.RangoPilon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RangoPilonTest {
    @Test
    public void sePuedeConstruirUnEdificioProtossSobreElRangoDelPilon (){
        //MODIFICAR
        RangoPilon rangoPilon = new RangoPilon();

        assertSame(Criadero.class, rangoPilon.construirEdificioProtoss().getClass());
    }

    @Test
    public void noSePuedeConstruirUnEdificioZergSobreElRangoDelPilon(){
        //MODIFICAR
        RangoPilon rangoPilon = new RangoPilon();

        assertThrows(NoSePuedeConstruir.class, rangoPilon::construirEdificioZerg);
    }
}