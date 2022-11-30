package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ObjetivoFueraDeRango;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zerling;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso23Test {

    @Test
    public void unidadNoPuedeAtacarUnEdificioSiNoEstaEnSuRangoDeAtaque(){
        // Arrange
        Mapa mapa = new Mapa();
        Zerling unidad = new Zerling();
        Pilon pilon = new Pilon();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        unidad.moverse(mapa.obtenerCasillero(1,1));
        pilon.construir(mapa.obtenerCasillero(10, 10), recursos);
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        unidad.nuevoTurno();
        unidad.nuevoTurno();

        // Assert
        assertThrows(ObjetivoFueraDeRango.class, () -> unidad.atacar(pilon));
    }

    @Test
    public void unidadPuedeAtacarUnEdificioSiNoEstaEnSuRangoDeAtaque(){
        // Arrange
        int escudoEsperado = 296;
        Mapa mapa = new Mapa();
        Zerling unidad = new Zerling();
        Pilon pilon = new Pilon();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        unidad.moverse(mapa.obtenerCasillero(1,1));
        pilon.construir(mapa.obtenerCasillero(1, 2), recursos);

        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        unidad.nuevoTurno();
        unidad.nuevoTurno();

        unidad.atacar(pilon);

        // Assert
        assertEquals(escudoEsperado, pilon.obtenerEscudo());
    }

    @Test
    public void unidadNoPuedeAtacarUnidadEnemigaSiNoEstaEnSuRangoDeAtaque(){
        Mapa mapa = new Mapa();

        Zealot unidad = new Zealot();
        unidad.moverse(mapa.obtenerCasillero(7,7));
        Zerling unidadEnemiga = new Zerling();
        unidadEnemiga.moverse(mapa.obtenerCasillero(1,1));

        unidad.nuevoTurno();
        unidad.nuevoTurno();
        unidad.nuevoTurno();
        unidad.nuevoTurno();

        unidadEnemiga.nuevoTurno();
        unidadEnemiga.nuevoTurno();

        assertThrows(ObjetivoFueraDeRango.class, () -> unidad.atacar(unidadEnemiga));
    }

    @Test
    public void unidadPuedeAtacarUnidadEnemigaSiEstaEnSuRangoDeAtaque(){
        int vidaDeEnemigoEsperada = 35 - 8;

        Mapa mapa = new Mapa();

        Zealot unidad = new Zealot();
        unidad.moverse(mapa.obtenerCasillero(7,7));
        Zerling unidadEnemiga = new Zerling();
        unidadEnemiga.moverse(mapa.obtenerCasillero(8,7));

        unidad.nuevoTurno();
        unidad.nuevoTurno();
        unidad.nuevoTurno();
        unidad.nuevoTurno();

        unidadEnemiga.nuevoTurno();
        unidadEnemiga.nuevoTurno();

        unidad.atacar(unidadEnemiga);
        assertEquals(vidaDeEnemigoEsperada, unidadEnemiga.obtenerVida());
    }


}
