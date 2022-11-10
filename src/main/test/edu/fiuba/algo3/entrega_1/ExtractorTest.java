package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.Extractor;
import edu.fiuba.algo3.modelo.MaximoDeZanganosAsignados;
import edu.fiuba.algo3.modelo.Pilon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtractorTest {

    @Test
    public void extractorNoEstaOperativoAntesDeSeisTurnos(){
        //Arrange
        Extractor extractor = new Extractor();

        //Act
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        //Assert
        assertThrows(EdificioNoEstaOperativo.class, extractor::obtenerGasProducido);
    }

    @Test
    public void sinZanganosAsignadosNoGeneraGas(){
        //Arrange
        Extractor extractor = new Extractor();
        int valorEsperado = 0;

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
        int valorEsperado = 10;

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
        assertEquals(valorEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void dosZanganosAsignadosGeneranVeinteDeGas(){
        //Arrange
        Extractor extractor = new Extractor();
        int valorEsperado = 20;

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
        assertEquals(valorEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void tresZanganosAsignadosGeneranTreintaDeGas(){
        //Arrange
        Extractor extractor = new Extractor();
        int valorEsperado = 30;

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
        assertEquals(valorEsperado, extractor.obtenerGasProducido());
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

    @Test
    public void seReduceLaVidaAlSerDaniado(){
        //Arrange
        Extractor extractor = new Extractor();
        int valorEsperado = 50;

        //Act
        extractor.recibirDanio(50);

        //Assert
        assertEquals(valorEsperado, extractor.obtenerVida());
    }

    @Test
    public void alSerDaniadoRegeneraVidaHastaCien(){
        //Arrange
        Extractor extractor = new Extractor();
        int valorEsperado = 100;

        //Act
        extractor.recibirDanio(5);
        extractor.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, extractor.obtenerVida());
    }
}
