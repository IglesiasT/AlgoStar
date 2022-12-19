package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso26Test {
    //Verificar que para construir unidades se cuente con la capacidad de suministro
    //correspondiente.

    @Test
    public void engendrarUnAmoSupremoConsumeElSuministroEsperado() {
        int valorEsperado = 0;
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(new Casillero(new AreaTerrestre(),1, 1, new Mapa()));

        Zerg raza = new Zerg(50, 0);

        for (int i = 0; i < 4; i++) {
            criadero.nuevoTurno(raza);
        }

        raza.engendrarAmoSupremo(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnZanganoConsumeElSuministroEsperado() {
        int valorEsperado = 1;
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(new Casillero(new AreaTerrestre(),1, 1, new Mapa()));

        Zerg raza = new Zerg(25, 0);

        for (int i = 0; i < 4; i++) {

            criadero.nuevoTurno(raza);
        }

        raza.engendrarZangano(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnZerlingConsumeElSuministroEsperado() {
        int valorEsperado = 1;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setRecurso(new SinRecurso());
        casillero.setArea(new AreaTerrestre());
        casillero.setEspacioDeConstruccion(new Moho());
        Casillero casillero2 = mapa.obtenerCasillero(1, 4);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(casillero2);

        Zerg raza = new Zerg(175, 0);

        raza.construirReservaDeReproduccion(casillero);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();

            criadero.nuevoTurno(raza);

        }

        raza.engendrarZerling(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnHidraliscoConsumeElSuministroEsperado() {
        int valorEsperado = 2;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setRecurso(new SinRecurso());
        casillero.setArea(new AreaTerrestre());
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        casillero.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        Casillero casillero3 = mapa.obtenerCasillero(1, 4);
        casillero3.setRecurso(new SinRecurso());
        casillero3.setArea(new AreaTerrestre());
        criadero.establecerUbicacion(casillero3);

        Zerg raza = new Zerg(425, 125);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();

            criadero.nuevoTurno(raza);

        }

        raza.engendrarHidralisco(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnMutaliscoConsumeElSuministroEsperado() {
        int valorEsperado = 4;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setRecurso(new SinRecurso());
        casillero.setArea(new AreaTerrestre());
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero3.setRecurso(new SinRecurso());
        casillero3.setArea(new AreaTerrestre());
        casillero.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(600, 300);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno(raza);

        }

        raza.engendrarMutalisco(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void engendrarUnZealotConsumeElSuministroEsperado() {
        int valorEsperado = 2;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setRecurso(new SinRecurso());
        casillero.setArea(new AreaTerrestre());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(300, 150);

        raza.construirAcceso(casillero);

        raza.construirZealot(new Casillero(new AreaTerrestre(), 1 , 1 , mapa));

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnDragonConsumeElSuministroEsperado() {
        int valorEsperado = 3;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setRecurso(new SinRecurso());
        casillero.setArea(new AreaTerrestre());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(300, 150);

        raza.construirAcceso(casillero);

        raza.construirDragon(new Casillero(new AreaTerrestre(), 1 , 1 , mapa));

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnScoutConsumeElSuministroEsperado() {
        int valorEsperado = 4;
        Casillero casillero = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new RangoPilon());



        Protoss raza = new Protoss(600, 300);

        raza.construirAcceso(casillero);
        raza.construirPuertoEstelar(casillero2);

        raza.construirScout(casillero3);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void engendrarUnAmoSupremoAumentaElSuministroSegunLoEsperado() {
        int valorEsperado = 205;
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
        criadero.establecerUbicacion(casillero);

        Zerg raza = new Zerg(5700, 5300);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno(raza);
        }

        for (int i = 0; i < 50; i++) {
            criadero.nuevoTurno(raza);
            raza.engendrarMutalisco(criadero);
        }
        criadero.nuevoTurno(raza);

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        raza.engendrarAmoSupremo(criadero);

        raza.engendrarMutalisco(criadero);
        raza.engendrarZangano(criadero);

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void construirUnCriaderoAumentaElSuministroSegunLoEsperado() {
        int valorEsperado = 205;
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
        criadero.establecerUbicacion(casillero);

        Zerg raza = new Zerg(5800, 5300);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno(raza);
        }

        for (int i = 0; i < 50; i++) {
            criadero.nuevoTurno(raza);
            raza.engendrarMutalisco(criadero);
        }

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        raza.construirCriadero(casillero4);

        raza.engendrarMutalisco(criadero);
        raza.engendrarZangano(criadero);

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void construirUnPilonAumentaElSuministroSegunLoEsperado() {
        int valorEsperado = 205;
        Casillero casillero = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero4 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        Casillero casillero5 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(15825, 7700);

        raza.construirAcceso(casillero);
        raza.construirPuertoEstelar(casillero2);

        for (int i = 0; i < 50; i++) {
            Casillero casilleroi = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
            casilleroi.setArea(new AreaTerrestre());
            casilleroi.setRecurso(new SinRecurso());
            raza.construirScout(casilleroi);
        }

        try {raza.construirZealot(casillero);} catch (RuntimeException SuministroAgotado){};

        raza.construirPilon(casillero3);

        raza.construirDragon(casillero4);
        raza.construirZealot(casillero5);

        try {raza.construirZealot(casillero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }


}

