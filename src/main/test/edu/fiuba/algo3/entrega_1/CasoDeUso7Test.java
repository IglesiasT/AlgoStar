package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Zangano;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso7Test {

    @Test
    public void zanganoRecolectaVeintePorTurno(){
        //Arrange
        Zangano zangano = new Zangano();
        Casillero casillero = new Casillero(new Mineral(), 1, 1, new Tablero());
        int cantidadEsperada = 10;

        //Act
        zangano.ubicar(casillero);

        //Assert
        assertEquals(cantidadEsperada, zangano.producir());
    }

    @Test
    public void nexoMineralRecolectaVeintePorTurno(){
        //Arrange
        NexoMineral nexo = new NexoMineral();

        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();

        int cantidadEsperada = 20;

        //Act and Assert
        assertEquals(cantidadEsperada, nexo.recolectarMineral());
    }
}
