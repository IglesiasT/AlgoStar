package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void AsimiladorSePuedeConstruirEnCasilleroConGas() {
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(new Gas(), 1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(asimilador.sePuedeConstruirEn(casillero));
    }

    @Test
    public void AsimiladorNoSePuedeConstruirEnCasilleroSinGas() {
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(!asimilador.sePuedeConstruirEn(casillero));
    }


}
