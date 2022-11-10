package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.NexoMineral;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NexoMineralTest {
    @Test
    public void noEstaOperativoAntesDeCuatroTurnos(){
        //Arrange
        NexoMineral nexo = new NexoMineral();

        //Act
        nexo.nuevoTurno();

        //Assert
        assertThrows(EdificioNoEstaOperativo.class, nexo::recolectarMineral);
    }

    @Test
    public void recolectaVeintePorTurno(){
        //Arrange
        NexoMineral nexo = new NexoMineral();
        int cantidadEsperada = 20;

        //Act and Assert
        assertEquals(cantidadEsperada, nexo.recolectarMineral());
    }
}
