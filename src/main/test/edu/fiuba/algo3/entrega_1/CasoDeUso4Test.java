package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Extractor;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.GasProducido;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso4Test {
    @Test
    public void sinZanganosAsignadosNoGeneraGas(){
        //Arrange
        Extractor extractor = new Extractor();
        GasProducido valorEsperado = new GasProducido(0);
        Casillero casillero = new Casillero(new Gas(),1,1,new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        //Act
        extractor.construirEnCasillero(casillero);
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
        GasProducido gasProducidoEsperado = new GasProducido(10);
        Casillero casillero = new Casillero(new Gas(),1,1,new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        //Act
        extractor.construirEnCasillero(casillero);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano(new Zangano());
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        //Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void dosZanganosAsignadosGeneranVeinteDeGas(){
        //Arrange
        Extractor extractor = new Extractor();
        GasProducido gasProducidoEsperado = new GasProducido(20);
        Casillero casillero = new Casillero(new Gas(),1,1,new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        //Act
        extractor.construirEnCasillero(casillero);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano(new Zangano());
        extractor.asignarZangano(new Zangano());
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        //Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void tresZanganosAsignadosGeneranTreintaDeGas(){
        //Arrange
        Extractor extractor = new Extractor();
        GasProducido gasProducidoEsperado = new GasProducido(30);
        Casillero casillero = new Casillero(new Gas(),1,1,new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        //Act
        extractor.construirEnCasillero(casillero);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano(new Zangano());
        extractor.asignarZangano(new Zangano());
        extractor.asignarZangano(new Zangano());
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        //Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void noSePuedeAsignarMasDeTresZanganos(){
        //Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new Gas(),1,1,new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        //Act
        extractor.construirEnCasillero(casillero);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        extractor.asignarZangano(new Zangano());
        extractor.asignarZangano(new Zangano());
        extractor.asignarZangano(new Zangano());

        //Assert
        assertThrows(MaximoDeZanganosAsignados.class,()-> extractor.asignarZangano(new Zangano()));
    }
}
