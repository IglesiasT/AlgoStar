package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Extractor;
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
        int valorEsperado = 700;

        //Act
        extractor.recibirDanio(50);

        //Assert
        assertEquals(valorEsperado, extractor.obtenerVida());
    }

    @Test
    public void alSerDaniadoRegeneraVidaHastaCienPasadosLosTurnosNecesarios(){
        //Arrange
        Extractor extractor = new Extractor();

        int valorEsperado = 750;

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
