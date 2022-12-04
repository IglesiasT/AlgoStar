package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso26Test {
    //Verificar que para construir unidades se cuente con la capacidad de suministro
    //correspondiente.

    @Test
    public void engendrarUnAmoSupremoConsumeElSuministroEsperado() {
        int valorEsperado = 0;
        Mapa mapa = new Mapa();
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(50, 0);

        for (int i = 0; i < 4; i++) {
            criadero.nuevoTurno();
        }

        raza.engendrarAmoSupremo(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnZanganoConsumeElSuministroEsperado() {
        int valorEsperado = 1;
        Mapa mapa = new Mapa();
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(25, 0);

        for (int i = 0; i < 4; i++) {
            criadero.nuevoTurno();
        }

        raza.engendrarZangano(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnZerlingConsumeElSuministroEsperado() {
        int valorEsperado = 1;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(175, 0);

        raza.construirReservaDeReproduccion(casillero);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno();
        }

        raza.engendrarZerling(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnHidraliscoConsumeElSuministroEsperado() {
        int valorEsperado = 2;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        casillero.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(425, 125);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno();
        }

        raza.engendrarHidralisco(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnMutaliscoConsumeElSuministroEsperado() {
        int valorEsperado = 4;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
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
            criadero.nuevoTurno();
        }

        raza.engendrarMutalisco(criadero);

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void engendrarUnZealotConsumeElSuministroEsperado() {
        int valorEsperado = 2;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
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
        casillero.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(300, 150);

        raza.construirAcceso(casillero);

        raza.construirDragon(new Casillero(new AreaTerrestre(), 1 , 1 , mapa));

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
    @Test
    public void engendrarUnScoutConsumeElSuministroEsperado() {
        int valorEsperado = 4;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(600, 300);

        raza.construirAcceso(casillero);
        raza.construirPuertoEstelar(casillero2);

        raza.construirScout(new Casillero(new AreaTerrestre(), 1 , 1 , mapa));

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void engendrarUnAmoSupremoAumentaElSuministroSegunLoEsperado() {
        int valorEsperado = 205;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(5700, 5300);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno();
        }

        for (int i = 0; i < 50; i++) {
            raza.engendrarMutalisco(criadero);
        }

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
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(5700, 5300);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno();
        }

        for (int i = 0; i < 50; i++) {
            raza.engendrarMutalisco(criadero);
        }

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        raza.construirCriadero(mapa.obtenerCasillero(1, 5));

        raza.engendrarMutalisco(criadero);
        raza.engendrarZangano(criadero);

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void construirUnPilonAumentaElSuministroSegunLoEsperado() {
        int valorEsperado = 205;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(15825, 7700);

        raza.construirAcceso(casillero);
        raza.construirPuertoEstelar(casillero2);

        for (int i = 0; i < 50; i++) {
            raza.construirScout(new Casillero(new AreaTerrestre(), 1 , i , mapa));
        }

        try {raza.construirZealot(casillero3);} catch (RuntimeException SuministroAgotado){};

        raza.construirPilon(mapa.obtenerCasillero(1, 4));

        raza.construirDragon(mapa.obtenerCasillero(1, 5));
        raza.construirZealot(mapa.obtenerCasillero(1, 6));

        try {raza.construirZealot(casillero3);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }


}

