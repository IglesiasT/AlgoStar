package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.NexoMineral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NexoMineralTest {

    @Test
    public void recolectaVeintePorTurno(){
        //Arrange
        NexoMineral nexo = new NexoMineral();
        int cantidadEsperada = 20;
        //Act
        assertEquals(cantidadEsperada, nexo.recolectarMineral());
    }
}
