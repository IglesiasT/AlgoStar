package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsimiladorTest {
    @Test
    public void asimiladorNoEstaOperativoAntesDeSeisTurnos(){
        //Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        asimilador.construirEnCasillero(casillero);
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();

        //Assert
        assertThrows(Pilon.EdificioNoEstaOperativo.class, asimilador::obtenerGasProducido);
    }

    @Test
    public void generaVeinteDeGas(){
        //Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Tablero());
        int valorEsperado = 20;

        //Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        asimilador.construirEnCasillero(casillero);
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

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(asimilador.sePuedeConstruirEn(casillero));
    }

    @Test
    public void AsimiladorNoSePuedeConstruirEnCasilleroSinGas() {
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(!asimilador.sePuedeConstruirEn(casillero));
    }
}
