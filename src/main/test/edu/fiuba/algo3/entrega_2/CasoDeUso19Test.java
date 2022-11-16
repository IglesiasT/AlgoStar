package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ObjetivoInvalido;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zangano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso19Test {
    @Test
    public void zanganoNoPuedeAtacarTierraNiAire(){
        // Arrange
        Zangano zangano = new Zangano();

        // Act and Assert
        assertThrows(ObjetivoInvalido.class, () -> zangano.atacar(new Pilon()));
    }
}
