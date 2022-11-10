package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasilleroTest {

    @Test
    public void casilleroConGasPermiteConstruirAsimilador() {
        Casillero casillero = new Casillero(new Gas());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assertDoesNotThrow( () -> {casillero.construirEdificioProtoss(new Asimilador());});
    }

    @Test
    public void casilleroConGasNoPermiteConstruirCriadero(){
        Casillero casillero = new Casillero(new Gas());
        casillero.setEspacioDeConstruccion(new Moho());

        assertThrows(NoSePuedeConstruir.class,() -> {casillero.construirEdificioZerg(new Criadero());});
    }

    @Test
    public void casilleroTieneMoho(){
        Casillero casillero = new Casillero();
        casillero.setEspacioDeConstruccion(new Moho());

        assertTrue(casillero.contiene(new Moho()));

    }
}
