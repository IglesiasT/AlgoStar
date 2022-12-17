package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ObjetivoFueraDeRango;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
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
        recursos.agregar(new Mineral(2000));
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setRecurso(new SinRecurso());
        casillero1.setArea(new AreaTerrestre());
        Casillero casillero2 = mapa.obtenerCasillero(9,9);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        unidad.moverse(casillero1);
        pilon.construir(casillero2, recursos);
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());

        unidad.nuevoTurno(new Zerg());
        unidad.nuevoTurno(new Zerg());

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
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setRecurso(new SinRecurso());
        casillero1.setArea(new AreaTerrestre());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        recursos.agregar(new Mineral(2000));
        unidad.moverse(casillero1);
        pilon.construir(casillero2,recursos);

        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());

        unidad.nuevoTurno(new Zerg());
        unidad.nuevoTurno(new Zerg());

        unidad.atacar(pilon);

        // Assert
        assertEquals(escudoEsperado, pilon.obtenerEscudo());
    }

    @Test
    public void unidadNoPuedeAtacarUnidadEnemigaSiNoEstaEnSuRangoDeAtaque(){
        Mapa mapa = new Mapa();

        Zealot unidad = new Zealot();
        Casillero casillero1 = mapa.obtenerCasillero(7,7);
        casillero1.setRecurso(new SinRecurso());
        casillero1.setArea(new AreaTerrestre());
        unidad.moverse(casillero1);
        Zerling unidadEnemiga = new Zerling();
        Casillero casillero2 = mapa.obtenerCasillero(1,1);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        unidadEnemiga.moverse(casillero2);

        unidad.nuevoTurno(new Protoss());
        unidad.nuevoTurno(new Protoss());
        unidad.nuevoTurno(new Protoss());
        unidad.nuevoTurno(new Protoss());

        unidadEnemiga.nuevoTurno(new Zerg());
        unidadEnemiga.nuevoTurno(new Zerg());

        assertThrows(ObjetivoFueraDeRango.class, () -> unidad.atacar(unidadEnemiga));
    }

    @Test
    public void unidadPuedeAtacarUnidadEnemigaSiEstaEnSuRangoDeAtaque(){
        int vidaDeEnemigoEsperada = 35 - 8;

        Mapa mapa = new Mapa();

        Zealot unidad = new Zealot();
        Casillero casillero1 = mapa.obtenerCasillero(7,7);
        casillero1.setRecurso(new SinRecurso());
        casillero1.setArea(new AreaTerrestre());
        unidad.moverse(casillero1);
        Zerling unidadEnemiga = new Zerling();
        Casillero casillero2 = mapa.obtenerCasillero(8,7);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        unidadEnemiga.moverse(casillero2);

        unidad.nuevoTurno(new Protoss());
        unidad.nuevoTurno(new Protoss());
        unidad.nuevoTurno(new Protoss());
        unidad.nuevoTurno(new Protoss());

        unidadEnemiga.nuevoTurno(new Zerg());
        unidadEnemiga.nuevoTurno(new Zerg());

        unidad.atacar(unidadEnemiga);
        assertEquals(vidaDeEnemigoEsperada, unidadEnemiga.obtenerVida());
    }


}
