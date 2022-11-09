package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Asimilador;
import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AsimiladorTest {
    @Test
    public void asimiladorNoEstaOperativoAntesDeSeisTurnos(){
        //Arrange
        Asimilador asimilador = new Asimilador();

        //Act
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();

        //Assert
        assertThrows(EdificioNoEstaOperativo.class, asimilador::obtenerGasProducido);
    }

    @Test
    public void generaVeinteDeGas(){
        //Arrange
        Asimilador asimilador = new Asimilador();
        int valorEsperado = 20;

        //Act
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();

        asimilador.nuevoTurno();    //Una vez construido, empieza a generar gas

        //Assert
        assertEquals(valorEsperado, asimilador.obtenerGasProducido());
    }
}
