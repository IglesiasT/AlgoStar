package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Gas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GasTest {

    @Test
    public void seRecolectaLaCantidadDeGasIndicada(){
        //Arrange
        Gas gas = new Gas();
        int valorEsperado = 20;

        //Act and Assert
        assertEquals(valorEsperado, gas.recolectar(20));
    }

    @Test
    public void luegoDeRecolectarsePorCompletoNoSeRecolectaMasGas(){
        //Arrange
        Gas gas = new Gas();
        int valorEsperado = 0;

        //Act
        gas.recolectar(5000);

        //Assert
        assertEquals(valorEsperado, gas.recolectar(20));
    }
}
