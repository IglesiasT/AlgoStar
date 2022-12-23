package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Acceso;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.FueraDeRangoDePilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso14Test {

    @Test
    public void pilonNoEnergizaCasillerosConMoho(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,7);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,4);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Criadero criadero = new Criadero();
        Pilon pilon = new Pilon();
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();
        Raza raza2 = new Protoss();

        // Act
        recursos.agregar(new Mineral(2000));
        criadero.construir(casillero1, recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        pilon.construir(casillero2, recursos);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);

        // Assert
        assertThrows(FueraDeRangoDePilon.class,() ->casillero3.establecerConstruccion(new Acceso()));
    }

    @Test
    public void mohoCreceAunEstandoEnElRangoDeUnPilon(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,7);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,2);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Criadero criadero = new Criadero();
        Pilon pilon = new Pilon();
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();
        Raza raza2 = new Protoss();

        // Act
        recursos.agregar(new Mineral(2000));
        pilon.construir(casillero1, recursos);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);

        criadero.construir(casillero2, recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        // Assert
        assertDoesNotThrow(() ->casillero3.establecerConstruccion(new ReservaDeReproduccion()));
    }
}
