package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Asimilador;
import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
public class CasilleroTest {

    @Test
    public void casilleroConVolcanPermiteConstruirAsimilador() {
        Casillero casillero = new Casillero(new Gas());

        assertDoesNotThrow(NoSePuedeConstruir.class, () -> {casillero.construirEdificio(new Asimilador());});
    }
}
