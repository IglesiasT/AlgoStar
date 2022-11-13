package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.Extractor;
import edu.fiuba.algo3.modelo.Pilon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {

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
    public void alSerDaniadoRegeneraVidaHastaCienPasadosLosTurnosNecesarios(){
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
        extractor.recibirDanio(20);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        //Assert
        assertEquals(valorEsperado, extractor.obtenerVida());
    }
}
