package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {

    @Test
    public void seReduceLaVidaAlSerDaniado(){
        //Arrange
        Extractor extractor = new Extractor();
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
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
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.recibirDanio(20);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        //Assert
        assertEquals(valorEsperado, extractor.obtenerVida());
    }
}
