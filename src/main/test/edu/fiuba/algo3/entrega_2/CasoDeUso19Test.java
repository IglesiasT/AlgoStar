package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ObjetivoInvalido;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso19Test {
    @Test
    public void zanganoNoPuedeAtacarTierraNiAire(){
        // Arrange
        Zangano zangano = new Zangano();

        // Act
        zangano.nuevoTurno();

        // Assert
        assertThrows(ObjetivoInvalido.class, () -> zangano.atacar(new Pilon()));
    }

    @Test
    public void zerlingNoPuedeAtacarAire(){
        // Arrange
        Zerling zerling = new Zerling();

        // Act
        zerling.nuevoTurno();
        zerling.nuevoTurno();

        // Assert
        assertThrows(ObjetivoInvalido.class, () -> zerling.atacar(new Scout()));
    }

    @Test
    public void guardianNoPuedeAtacarAire(){
        // Arrange
        Guardian guardian = new Guardian();

        // Act
        guardian.nuevoTurno();
        guardian.nuevoTurno();
        guardian.nuevoTurno();
        guardian.nuevoTurno();

        // Assert
        assertThrows(ObjetivoInvalido.class, () -> guardian.atacar(new Scout()));
    }

    @Test
    public void zealotNoPuedeAtacarAire(){
        // Arrange
        Zealot zealot = new Zealot();

        //Act
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();

        //Assert
        assertThrows(ObjetivoInvalido.class, () -> zealot.atacar(new Mutalisco()));
    }
}
