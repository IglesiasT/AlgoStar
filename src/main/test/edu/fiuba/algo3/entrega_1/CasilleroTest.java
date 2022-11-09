package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
public class CasilleroTest {

    @Test
    public void casilleroConVolcanPermiteConstruirAsimilador() {
        Casillero casillero = new Casillero(new Gas());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assertDoesNotThrow( () -> {casillero.construirEdificioProtoss(new Asimilador());});
    }
}
