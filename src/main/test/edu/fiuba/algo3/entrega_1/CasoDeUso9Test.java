package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Acceso;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.FueraDeRangoDePilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso9Test {

    @Test
    public void sePuedeConstruirEnElRangoDeUnPilon(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,3);
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        pilon.construir(casillero1, recursos);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        acceso.construir(casillero2, recursos);

        // Assert
        assertEquals(Acceso.class, casillero2.obtenerConstruccion().getClass());
    }

    @Test
    public void elRangoDelPilonDejaDeEstarActivoAlDestruirse(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Pilon pilon = new Pilon();
        Acceso acceso = new Acceso();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        pilon.construir(casillero1, recursos);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.destruir();

        // Assert
        assertThrows(FueraDeRangoDePilon.class, () -> acceso.construir(casillero2, recursos));
    }

    @Test
    public void sePuedeSeguirConstruyendoLuegoDeDestuirUnPilonSiHayOtroEnRango(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(2,3);
        Pilon pilon1 = new Pilon();
        Pilon pilon2 = new Pilon();
        Acceso acceso = new Acceso();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        pilon1.construir(casillero1, recursos);
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();
        pilon1.nuevoTurno();

        pilon2.construir(casillero2, recursos);
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();
        pilon2.nuevoTurno();

        pilon1.destruir();
        pilon2.nuevoTurno();

        acceso.construir(casillero3, recursos);

        // Assert
        assertEquals(Acceso.class, casillero3.obtenerConstruccion().getClass());
    }
}
