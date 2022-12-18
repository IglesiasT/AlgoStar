package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso31Test{
    //Verificar que al destruir pilones, amos supremos o criaderos  disminuye la capacidad de
    //suministros del jugador.

    @Test
    public void destruirUnPilonDisminuyeElSuministroSegunLoEsperado() {
        int valorEsperado = 200;
        Casillero casillero1 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        casillero1.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(15825, 7700);

        raza.construirAcceso(casillero1);
        raza.construirPuertoEstelar(casillero2);

        for (int i = 0; i < 50; i++) {
            raza.construirScout(new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa()));
        }

        try {raza.construirZealot(casillero3);} catch (RuntimeException SuministroAgotado){};

        raza.construirPilon(new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa()));

        raza.destruir(new Pilon());

        try {raza.construirZealot(casillero3);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void destruirUnAmoSupremoDisminuyeElSuministroSegunLoEsperado() {
        int valorEsperado = 200;
        Mapa mapa = new Mapa();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        casillero.setEspacioDeConstruccion(new Moho());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new Moho());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(5700, 5300);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno(new Zerg());
        }

        for (int i = 0; i < 50; i++) {
            criadero.nuevoTurno(new Zerg());
            raza.engendrarMutalisco(criadero);
        }

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        AmoSupremo amoSupremo = raza.engendrarAmoSupremo(criadero);

        raza.destruir(amoSupremo);

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void destruirUnCriaderoDisminuyeElSuministroSegunLoEsperado() {
        int valorEsperado = 200;
        Mapa mapa = new Mapa();
        Casillero casillero = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        casillero.setEspacioDeConstruccion(new Moho());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new Moho());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new Moho());
        Casillero casillero4 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());
        casillero4.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(5700, 5300);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno(new Zerg());
        }

        for (int i = 0; i < 50; i++) {
            criadero.nuevoTurno(new Zerg());
            raza.engendrarMutalisco(criadero);
        }

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        raza.construirCriadero(casillero4);

        raza.destruir((Criadero) casillero4.obtenerConstruccion());

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
}