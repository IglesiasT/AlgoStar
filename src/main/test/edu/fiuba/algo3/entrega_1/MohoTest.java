package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MohoTest {

    @Test
    public void sePuedeConstruirUnEdificioZergSobreElMoho (){
        Moho moho = new Moho();

        assertDoesNotThrow(() -> {moho.construirEdificioZerg(new Extractor(),new Gas());});
    }

    @Test
    public void noSePuedeConstruirUnEdificioProtossSobreElMoho(){
        Moho moho = new Moho();

        assertThrows(NoSePuedeConstruir.class, () -> {moho.construirEdificioProtoss(new Asimilador(),new Gas());});
    }
}
