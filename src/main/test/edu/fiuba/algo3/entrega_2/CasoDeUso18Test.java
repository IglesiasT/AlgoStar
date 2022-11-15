package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.unidades.Zerling;
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
        zerling.atacar(nexoMineral);

        // Assert
        assertEquals(valorEsperado, nexoMineral.obtenerEscudo());
    }
}
