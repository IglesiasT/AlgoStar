package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ObjetivoFueraDeRango;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
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
        Raza raza = new Zerg();
        Raza raza2 = new Protoss();

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
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);


        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);

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
        Raza raza = new Zerg();
        Raza raza2 = new Protoss();

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

        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);
        pilon.nuevoTurno(raza2);


        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);


        unidad.atacar(pilon);

        // Assert
        assertEquals(escudoEsperado, pilon.obtenerEscudo());
    }

    @Test
    public void unidadNoPuedeAtacarUnidadEnemigaSiNoEstaEnSuRangoDeAtaque(){
        Mapa mapa = new Mapa();
        Raza raza = new Protoss();
        Raza raza2 = new Zerg();
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


        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);

        unidadEnemiga.nuevoTurno(raza2);
        unidadEnemiga.nuevoTurno(raza2);


        assertThrows(ObjetivoFueraDeRango.class, () -> unidad.atacar(unidadEnemiga));
    }

    @Test
    public void unidadPuedeAtacarUnidadEnemigaSiEstaEnSuRangoDeAtaque(){
        int vidaDeEnemigoEsperada = 35 - 8;

        Mapa mapa = new Mapa();
        Raza raza = new Protoss();
        Zealot unidad = new Zealot();
        Casillero casillero1 = mapa.obtenerCasillero(7,7);
        casillero1.setRecurso(new SinRecurso());
        casillero1.setArea(new AreaTerrestre());
        unidad.moverse(casillero1);
        Zerling unidadEnemiga = new Zerling();
        Raza raza2 = new Zerg();
        Casillero casillero2 = mapa.obtenerCasillero(8,7);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        unidadEnemiga.moverse(casillero2);

        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);
        unidad.nuevoTurno(raza);

        unidadEnemiga.nuevoTurno(raza2);
        unidadEnemiga.nuevoTurno(raza2);

        unidad.atacar(unidadEnemiga);
        assertEquals(vidaDeEnemigoEsperada, unidadEnemiga.obtenerVida());
    }


}
