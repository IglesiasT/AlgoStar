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
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso30Test {
    //Verificar que alcanzado el limite máximo de 200 de suministros no se puedan construir
    //más unidades.

    @Test
    public void cuandoElSuministroProtossLlegaAlMaximoNoSePuedeSeguirConstruyendo() {
        Casillero casillero1 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero1.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());

        Protoss raza = new Protoss(15500, 7650);

        raza.construirAcceso(casillero1);
        raza.construirPuertoEstelar(casillero2);

        for (int i = 0; i < 50; i++) {
            Casillero casilleroi = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
            casilleroi.setArea(new AreaTerrestre());
            casilleroi.setRecurso(new SinRecurso());
            raza.construirScout(casilleroi);
        }

        assertThrows(SuministroAgotado.class, () -> raza.construirZealot(casillero3) );
    }

    @Test
    public void cuandoElSuministroZergLlegaAlMaximoNoSePuedeSeguirConstruyendo() {
        Casillero casillero1 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        casillero1.setEspacioDeConstruccion(new Moho());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new Moho());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new Moho());
        Casillero casillero4 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());
        Criadero criadero = new Criadero();
        criadero.establecerUbicacion(casillero4);

        Zerg raza = new Zerg(5525, 5200);

        raza.construirReservaDeReproduccion(casillero1);
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

        assertThrows(SuministroAgotado.class, () -> raza.engendrarZerling(criadero) );
    }
}