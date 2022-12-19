package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
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
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

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
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        zangano.nuevoTurno(new Zerg());

        zangano.moverse(casillero);
        extractor.nuevoTurno(new Zerg()); //El gas correspondiente debe generarse por turno

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
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        zangano1.nuevoTurno(new Zerg());
        zangano2.nuevoTurno(new Zerg());

        zangano1.moverse(casillero);
        zangano2.moverse(casillero);
        extractor.nuevoTurno(new Zerg());     // El gas correspondiente debe generarse por turno

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
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        zangano1.nuevoTurno(new Zerg());
        zangano2.nuevoTurno(new Zerg());
        zangano3.nuevoTurno(new Zerg());

        zangano1.moverse(casillero);
        zangano2.moverse(casillero);
        zangano3.moverse(casillero);
        extractor.nuevoTurno(new Zerg()); //El gas correspondiente debe generarse por turno

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
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        zangano1.nuevoTurno(new Zerg());
        zangano2.nuevoTurno(new Zerg());
        zangano3.nuevoTurno(new Zerg());

        zangano1.moverse(casillero);
        zangano2.moverse(casillero);
        zangano3.moverse(casillero);

        //Assert
        assertThrows(MaximoDeZanganosAsignados.class, ()-> extractor.asignarZangano(new Zangano()));
    }
}
