package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZergTest {

    @Test
    public void sinRecursosNoSePuedeConstruir(){
        //Arrange
        Zerg razaZerg = new Zerg();
        Casillero casilleroAConstruir1 = new Casillero();
        Casillero casilleroAConstruir2 = new Casillero();

        //Act
        razaZerg.construirCriadero(casilleroAConstruir1);
        razaZerg.construirCriadero(casilleroAConstruir2);

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirCriadero(casilleroAConstruir1));
    }

    @Test
    public void noSePuedeCrearEspiralSinGuarida(){
        //Arrange
        Zerg razaZerg = new Zerg();
        Casillero casilleroAConstruir = new Casillero();

        //Act
        casilleroAConstruir.setEspacioDeConstruccion(new Moho());

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirEspiral(casilleroAConstruir));
    }

    @Test
    public void sePuedeCrearEspiralConGuarida(){
        //Arrange
        Zerg razaZerg = new Zerg(1000, 1000);
        Casillero casilleroAConstruir1 = new Casillero();
        Casillero casilleroAConstruir2 = new Casillero();

        //Act
        casilleroAConstruir1.setEspacioDeConstruccion(new Moho());
        razaZerg.construirGuarida(casilleroAConstruir1);
        casilleroAConstruir2.setEspacioDeConstruccion(new Moho());

        //Assert
        assertDoesNotThrow(() -> razaZerg.construirEspiral(casilleroAConstruir2));
    }
}
