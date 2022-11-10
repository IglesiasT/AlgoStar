package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Asimilador;
import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.Pilon;
import org.junit.jupiter.api.Test;

public class PilonTest {
    @Test
    public void caso9(){
        //Arrange
        Casillero casilleroConstruido = new Casillero();
        Pilon pilon = new Pilon();
        Asimilador asimilador = new Asimilador();

        casilleroConstruido.construirEdificioProtoss(pilon);
        casilleroConstruido.construirEdificioProtoss(asimilador);

    }
}
