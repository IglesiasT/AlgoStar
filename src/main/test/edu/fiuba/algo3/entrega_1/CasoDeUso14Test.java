package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

public class CasoDeUso14Test {

    @Test
    public void pilonNoEnergizaCasillerosConMoho(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,7);
        Criadero criadero = new Criadero();
        Pilon pilon = new Pilon();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        criadero.construir(casillero1, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        pilon.construir(casillero2, recursos);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        // Assert
        assert !(mapa.obtenerCasillero(1,4).contiene(new RangoPilon()));
    }

    @Test
    public void mohoCreceAunEstandoEnElRangoDeUnPilon(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,7);
        Criadero criadero = new Criadero();
        Pilon pilon = new Pilon();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        criadero.construir(casillero1, recursos);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        criadero.construir(casillero2, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();


        // Assert
        assert mapa.obtenerCasillero(1,2).contiene(new Moho());
    }
}
