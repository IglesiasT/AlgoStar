package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VolcanTest {

    @Test
    public void seRecolectaLaCantidadDeGasIndicada(){
        //Arrange
        Volcan volcan = new Volcan();
        int valorEsperado = 20;

        //Act and Assert
        assertEquals(valorEsperado, volcan.recolectar(20));
    }

    @Test
    public void luegoDeRecolectarsePorCompletoNoSeRecolectaMasGas(){
        //Arrange
        Volcan volcan = new Volcan();
        int valorEsperado = 0;

        //Act
        volcan.recolectar(5000);

        //Assert
        assertEquals(valorEsperado, volcan.recolectar(20));
    }
}
