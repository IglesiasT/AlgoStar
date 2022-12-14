package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ObjetivoInvalido;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.UnidadProtoss;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso19Test {
    @Test
    public void zanganoNoPuedeAtacarTierraNiAire(){
        // Arrange
        int valorEsperador = 600;
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        ConstruccionProtoss construccionEnemiga = new Pilon();
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral());
        construccionEnemiga.construir(casillero2,recursos);

        Zangano zangano = new Zangano();

        // Act
        zangano.nuevoTurno();
        zangano.ubicar(casillero1);
        zangano.atacar(construccionEnemiga);

        // Assert
        assertEquals(valorEsperador,construccionEnemiga.obtenerVida()+construccionEnemiga.obtenerEscudo());
    }

    @Test
    public void zerlingNoPuedeAtacarAire(){
        // Arrange
        int valorEsperador = 250;
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaEspacial());
        casillero2.setRecurso(new SinRecurso());
        UnidadProtoss unidadEnemiga = new Scout();
        unidadEnemiga.moverse(casillero2);

        Zerling zerling = new Zerling();
        zerling.moverse(casillero1);

        // Act
        zerling.nuevoTurno();
        zerling.nuevoTurno();
        zerling.atacar(unidadEnemiga);

        // Assert
        assertEquals(valorEsperador,unidadEnemiga.obtenerVida()+unidadEnemiga.obtenerEscudo());
    }

    @Test
    public void guardianNoPuedeAtacarAire(){
        // Arrange
        int valorEsperador = 250;
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaEspacial());
        casillero2.setRecurso(new SinRecurso());
        UnidadProtoss unidadEnemiga = new Scout();
        unidadEnemiga.moverse(casillero2);

        Guardian guardian = new Guardian();
        guardian.moverse(casillero1);

        // Act
        guardian.nuevoTurno();
        guardian.nuevoTurno();
        guardian.nuevoTurno();
        guardian.nuevoTurno();
        guardian.atacar(unidadEnemiga);

        // Assert
        assertEquals(valorEsperador,unidadEnemiga.obtenerVida()+unidadEnemiga.obtenerEscudo());
    }

    @Test
    public void zealotNoPuedeAtacarAire(){

        // Arrange
        int valorEsperador = 120;
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaEspacial());
        casillero2.setRecurso(new SinRecurso());
        UnidadZerg unidadEnemiga = new Mutalisco();
        unidadEnemiga.moverse(casillero2);

        Zealot zealot = new Zealot();
        zealot.moverse(casillero1);

        // Act
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.nuevoTurno();
        zealot.atacar(unidadEnemiga);

        // Assert
        assertEquals(valorEsperador,unidadEnemiga.obtenerVida());
    }
}
