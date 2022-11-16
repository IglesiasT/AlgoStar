package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Extractor;
import edu.fiuba.algo3.modelo.recursos.GasProducido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso4Test {
    @Test
    public void sinZanganosAsignadosNoGeneraGas(){
        //Arrange
        Extractor extractor = new Extractor();
        GasProducido valorEsperado = new GasProducido(0);

        //Act
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void unZanganoAsignadoGeneraDiezDeGas(){
        //Arrange
        Extractor extractor = new Extractor();
        GasProducido gasProducidoEsperado = new GasProducido(10);

        //Act
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano();
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        //Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void dosZanganosAsignadosGeneranVeinteDeGas(){
        //Arrange
        Extractor extractor = new Extractor();
        GasProducido gasProducidoEsperado = new GasProducido(20);

        //Act
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano();
        extractor.asignarZangano();
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        //Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void tresZanganosAsignadosGeneranTreintaDeGas(){
        //Arrange
        Extractor extractor = new Extractor();
        GasProducido gasProducidoEsperado = new GasProducido(30);

        //Act
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano();
        extractor.asignarZangano();
        extractor.asignarZangano();
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        //Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void noSePuedeAsignarMasDeTresZanganos(){
        //Arrange
        Extractor extractor = new Extractor();

        //Act
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano();
        extractor.asignarZangano();
        extractor.asignarZangano();

        //Assert
        assertThrows(MaximoDeZanganosAsignados.class, extractor::asignarZangano);
    }
}
