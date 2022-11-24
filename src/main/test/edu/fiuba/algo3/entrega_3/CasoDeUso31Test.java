package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
import edu.fiuba.algo3.modelo.construcciones.unidades.AmoSupremo;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso31Test{
    //Verificar que al destruir pilones, amos supremos o criaderos  disminuye la capacidad de
    //suministros del jugador.

    @Test
    public void destruirUnPilonDisminuyeElSuministroSegunLoEsperado() {
        int valorEsperado = 200;
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

        raza.destruir(new Pilon());

        try {raza.construirZealot(casillero3);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void destruirUnAmoSupremoDisminuyeElSuministroSegunLoEsperado() {
        int valorEsperado = 200;
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

        raza.destruir(new AmoSupremo());

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void destruirUnCriaderoDisminuyeElSuministroSegunLoEsperado() {
        int valorEsperado = 200;
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

        raza.destruir(new Criadero());

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
}
