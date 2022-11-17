package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.recursos.GasProducido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsimiladorTest {
    @Test
    public void asimiladorNoEstaOperativoAntesDeSeisTurnos(){
        //Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Mapa());

        //Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        asimilador.construirEnCasillero(casillero);
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();

        //Assert
        assertThrows(EdificioNoEstaOperativo.class, asimilador::obtenerGasProducido);
    }

    @Test
    public void generaVeinteDeGas(){
        //Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Mapa());
        GasProducido gasProducidoEsperado = new GasProducido(20);

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
        assertEquals(gasProducidoEsperado, asimilador.obtenerGasProducido());
    }

    @Test
    public void AsimiladorSePuedeConstruirEnCasilleroConGas() {
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(asimilador.sePuedeConstruirEn(casillero));
    }

    @Test
    public void AsimiladorNoSePuedeConstruirEnCasilleroSinGas() {
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(!asimilador.sePuedeConstruirEn(casillero));
    }
}
