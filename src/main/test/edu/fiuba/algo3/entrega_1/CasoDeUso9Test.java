package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Acceso;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.FueraDeRangoDePilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso9Test {

    @Test
    public void sePuedeConstruirEnElRangoDeUnPilon(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,3);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        pilon.construir(casillero1, recursos);
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        acceso.construir(casillero2, recursos);

        // Assert
        assertEquals(Acceso.class, casillero2.obtenerConstruccion().getClass());
    }

    @Test
    public void elRangoDelPilonDejaDeEstarActivoAlDestruirse(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,3);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        pilon.construir(casillero1, recursos);
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.destruir();

        // Assert
        assertThrows(FueraDeRangoDePilon.class, () -> acceso.construir(casillero2, recursos));
    }

    @Test
    public void sePuedeSeguirConstruyendoLuegoDeDestuirUnPilonSiHayOtroEnRango(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,3);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(2,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Pilon pilon1 = new Pilon();
        Pilon pilon2 = new Pilon();
        Acceso acceso = new Acceso();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        pilon1.construir(casillero1, recursos);
        pilon1.nuevoTurno(new Protoss());
        pilon1.nuevoTurno(new Protoss());
        pilon1.nuevoTurno(new Protoss());
        pilon1.nuevoTurno(new Protoss());
        pilon1.nuevoTurno(new Protoss());
        pilon1.nuevoTurno(new Protoss());

        pilon2.construir(casillero2, recursos);
        pilon2.nuevoTurno(new Protoss());
        pilon2.nuevoTurno(new Protoss());
        pilon2.nuevoTurno(new Protoss());
        pilon2.nuevoTurno(new Protoss());
        pilon2.nuevoTurno(new Protoss());
        pilon2.nuevoTurno(new Protoss());

        pilon1.destruir();
        pilon2.nuevoTurno(new Protoss());

        acceso.construir(casillero3, recursos);

        // Assert
        assertEquals(Acceso.class, casillero3.obtenerConstruccion().getClass());
    }
}
