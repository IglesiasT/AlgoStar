package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MohoTest {

    @Test
    public void sePuedeConstruirUnEdificioZergSobreElMoho (){
        Moho moho = new Moho();

        assertSame(Criadero.class, moho.construirEdificioZerg().getClass());
    }

    @Test
    public void noSePuedeConstruirUnEdificioProtossSobreElMoho(){
        Moho moho = new Moho();

        assertThrows(NoSePuedeConstruir.class, moho::construirEdificioProtoss);
    }
}
