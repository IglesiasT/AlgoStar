package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso4Test {
    @Test
    public void sinZanganosAsignadosNoGeneraGas(){
        // Arrange
        Extractor extractor = new Extractor();
        Gas valorEsperado = new Gas(0);
        Casillero casillero = new Casillero(new AreaTerrestre(), 1,1,new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();


        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        // Assert
        assertEquals(valorEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void unZanganoAsignadoGeneraDiezDeGas(){
        // Arrange
        Extractor extractor = new Extractor();
        Gas gasProducidoEsperado = new Gas(10);
        Casillero casillero = new Casillero(new AreaTerrestre(), 1,1,new Mapa());
        casillero.setRecurso(new Volcan());
        Zangano zangano = new Zangano();
        ListadoDeRecursos recursos = new ListadoDeRecursos();


        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        zangano.nuevoTurno();

        extractor.asignarZangano(zangano);
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        // Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void dosZanganosAsignadosGeneranVeinteDeGas(){
        // Arrange
        Extractor extractor = new Extractor();
        Gas gasProducidoEsperado = new Gas(20);
        Casillero casillero = new Casillero(new AreaTerrestre(), 1,1,new Mapa());
        casillero.setRecurso(new Volcan());
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        ListadoDeRecursos recursos = new ListadoDeRecursos();


        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        zangano1.nuevoTurno();
        zangano2.nuevoTurno();

        extractor.asignarZangano(zangano1);
        extractor.asignarZangano(zangano2);
        extractor.nuevoTurno();     // El gas correspondiente debe generarse por turno

        // Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void tresZanganosAsignadosGeneranTreintaDeGas(){
        // Arrange
        Extractor extractor = new Extractor();
        Gas gasProducidoEsperado = new Gas(30);
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        casillero.setRecurso(new Volcan());
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();
        ListadoDeRecursos recursos = new ListadoDeRecursos();


        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        zangano1.nuevoTurno();
        zangano2.nuevoTurno();
        zangano3.nuevoTurno();

        extractor.asignarZangano(zangano1);
        extractor.asignarZangano(zangano2);
        extractor.asignarZangano(zangano3);
        extractor.nuevoTurno(); //El gas correspondiente debe generarse por turno

        // Assert
        assertEquals(gasProducidoEsperado, extractor.obtenerGasProducido());
    }

    @Test
    public void noSePuedeAsignarMasDeTresZanganos(){
        //Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        casillero.setRecurso(new Volcan());
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        zangano1.nuevoTurno();
        zangano2.nuevoTurno();
        zangano3.nuevoTurno();

        extractor.asignarZangano(zangano1);
        extractor.asignarZangano(zangano2);
        extractor.asignarZangano(zangano3);

        //Assert
        assertThrows(MaximoDeZanganosAsignados.class, ()-> extractor.asignarZangano(new Zangano()));
    }
}
