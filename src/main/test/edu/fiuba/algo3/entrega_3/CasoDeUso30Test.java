package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.SuministroAgotado;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso30Test {
    //Verificar que alcanzado el limite máximo de 200 de suministros no se puedan construir
    //más unidades.

    @Test
    public void cuandoElSuministroProtossLlegaAlMaximoNoSePuedeSeguirConstruyendo() {
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
        casillero.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(15500, 7650);

        raza.construirAcceso(casillero);
        raza.construirPuertoEstelar(casillero2);

        for (int i = 0; i < 50; i++) {
            raza.construirScout(new Casillero(new AreaTerrestre(), 1 , i , mapa));
        }

        assertThrows(SuministroAgotado.class, () -> raza.construirZealot(casillero3) );
    }

    @Test
    public void cuandoElSuministroZergLlegaAlMaximoNoSePuedeSeguirConstruyendo() {
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1, 1);
        Casillero casillero2 = mapa.obtenerCasillero(1, 2);
        Casillero casillero3 = mapa.obtenerCasillero(1, 3);
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
            criadero.nuevoTurno();
        }

        for (int i = 0; i < 50; i++) {
            raza.engendrarMutalisco(criadero);
        }

        assertThrows(SuministroAgotado.class, () -> raza.engendrarZerling(criadero) );
    }
}
