package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MineralTest {
    @Test
    public void seRecolectaLaCantidadDeMineralIndicada(){
        //Arrange
        Nodo mineral = new Nodo();
        Mineral valorEsperado = new Mineral(500);

        //Act and Assert
        assertEquals(valorEsperado, mineral.recolectar(new NexoMineral(),500));
    }

    @Test
    public void luegoDeRecolectarsePorCompletoNoSeRecolectaMasMineral(){
        //Arrange
        Nodo mineral = new Nodo();
        Mineral valorEsperado = new Mineral(0);

        //Act
        mineral.recolectar(new NexoMineral(),2000);

        //Assert
        assertEquals(valorEsperado, mineral.recolectar(new NexoMineral(),70));
    }
}
