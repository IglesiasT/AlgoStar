package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
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
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.recibirDanio(5);
        extractor.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, extractor.obtenerVida());
    }

    @Test
    public void sePuedeConstruirEnUnCasilleroConGasYMoho(){
        Extractor extractor = new Extractor();

        Casillero casillero = new Casillero(new Gas());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void sePuedeConstruirConLosRecursosSuficientes(){
        //Arrange
        Extractor extractor = new Extractor();
        int cantidadMineral = 100;
        int cantidadGas = 40;

        //Act and Assert
        assert extractor.recursosSuficientes(cantidadMineral, cantidadGas);
    }

    @Test
    public void noSePuedeConstruirSinLosRecursosSuficientes(){
        //Arrange
        Extractor extractor = new Extractor();
        int cantidadMineral = 14;
        int cantidadGas = 0;

        //Act and Assert
        assert (! extractor.recursosSuficientes(cantidadMineral, cantidadGas));
    }
}
