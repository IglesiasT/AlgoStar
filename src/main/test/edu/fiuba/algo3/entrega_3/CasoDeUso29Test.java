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

public class CasoDeUso29Test {
    //Verificar que alcanzado el limite máximo de 200 de suministros no se siga sumando su
    //capacidad.

    @Test
    public void cuandoElSuministroProtossLlegaAlMaximoNoSePuedeSeguirConstruyendo() {
        int valorEsperado = 200;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(15500, 7650);

        raza.construirAcceso(casillero);
        raza.construirPuertoEstelar(casillero2);

        for (int i = 0; i < 50; i++) {
            raza.construirScout(new Casillero(new AreaTerrestre(), 1 , i , mapa));
        }

        try {raza.construirZealot(casillero3);} catch (RuntimeException SuministroAgotado){};
        try {raza.construirZealot(casillero3);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }

    @Test
    public void cuandoElSuministroZergLlegaAlMaximoNoSePuedeSeguirConstruyendo() {
        int valorEsperado = 200;
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(mapa.obtenerCasillero(1, 4));

        Zerg raza = new Zerg(5525, 5200);

        raza.construirReservaDeReproduccion(casillero);
        raza.construirGuarida(casillero2);
        raza.construirEspiral(casillero3);

        for (int i = 0; i < 12; i++) {
            raza.nuevoTurno();
            criadero.nuevoTurno(new Zerg());
        }

        for (int i = 0; i < 50; i++) {
            raza.engendrarMutalisco(criadero);
        }

        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};
        try {raza.engendrarZerling(criadero);} catch (RuntimeException SuministroAgotado){};

        assertEquals(valorEsperado , raza.obtenerOcupacionActual());
    }
}


