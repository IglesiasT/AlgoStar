package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VolcanTest {

    @Test
    public void seRecolectaLaCantidadDeGasIndicada(){
        //Arrange
        Volcan volcan = new Volcan();
        Gas valorEsperado = new Gas(20);

        //Act and Assert
        assertEquals(valorEsperado, volcan.recolectar(new Asimilador(),20));
    }

    @Test
    public void luegoDeRecolectarsePorCompletoNoSeRecolectaMasGas(){
        //Arrange
        Volcan volcan = new Volcan();
        Gas valorEsperado = new Gas(0);

        //Act
        volcan.recolectar(new Asimilador(),5000);

        //Assert
        assertEquals(valorEsperado, volcan.recolectar(new Asimilador(),20));
    }
}
