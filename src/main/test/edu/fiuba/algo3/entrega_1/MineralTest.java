package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MineralTest {
    @Test
    public void seRecolectaLaCantidadDeMineralIndicada(){
        //Arrange
        Mineral mineral = new Mineral();
        int valorEsperado = 500;

        //Act and Assert
        assertEquals(valorEsperado, mineral.recolectar(500));
    }

    @Test
    public void luegoDeRecolectarsePorCompletoNoSeRecolectaMasMineral(){
        //Arrange
        Mineral mineral = new Mineral();
        int valorEsperado = 0;

        //Act
        mineral.recolectar(2000);

        //Assert
        assertEquals(valorEsperado, mineral.recolectar(70));
    }
}
