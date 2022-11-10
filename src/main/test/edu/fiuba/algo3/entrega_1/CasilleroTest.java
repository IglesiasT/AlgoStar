package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasilleroTest {

    @Test
    public void casilleroTieneMoho(){
        Casillero casillero = new Casillero();
        casillero.setEspacioDeConstruccion(new Moho());

        assertTrue(casillero.contiene(new Moho()));

    }
}
