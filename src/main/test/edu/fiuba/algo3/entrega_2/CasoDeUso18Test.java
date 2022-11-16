package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.Hidralisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso18Test {
    // Unidades Zerg
    @Test
    public void zerlingInflinge4DeDanioEnTierra(){
        // Arrange
        Zerling zerling = new Zerling();
        NexoMineral nexoMineral = new NexoMineral();
        int valorEsperado = 246;    //250 escudo - 4 ataque

        // Act
        zerling.nuevoTurno();
        zerling.nuevoTurno();
        zerling.atacar(nexoMineral);

        // Assert
        assertEquals(valorEsperado, nexoMineral.obtenerEscudo());
    }

    @Test
    public void hidraliscoInflinge10DeDanioEnTierra(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco();
        Pilon pilon = new Pilon();
        int valorEsperado = 290;    //290 escudo - 10 ataque

        // Act
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.atacar(pilon);

        // Assert
        assertEquals(valorEsperado, pilon.obtenerEscudo());
    }

    @Test
    public void hidraliscoInflinge10DeDanioEnAire(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco();
        Scout scout = new Scout();
        int valorEsperado = 90;    //100 escudo - 10 ataque

        // Act
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.atacar(scout);

        // Assert
        assertEquals(valorEsperado, scout.obtenerEscudo());
    }
}
