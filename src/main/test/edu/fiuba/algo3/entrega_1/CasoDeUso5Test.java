package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

public class CasoDeUso5Test {


    @Test
    public void extractorSePuedeConstruirEnUnCasilleroConMoho(){
        Extractor extractor = new Extractor();

        Casillero casillero = new Casillero(new Gas(), 1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void extractorNoSePuedeConstruirEnUnCasilleroSinMoho(){
        Extractor extractor = new Extractor();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Tablero());

        assert(!extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void reservaDeReproduccionSePuedeConstruirEnUnCasilleroConMoho(){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(reserva.sePuedeConstruirEn(casillero));
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirEnUnCasilleroSinMoho(){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assert(!reserva.sePuedeConstruirEn(casillero));
    }

    @Test
    public void guaridaSePuedeConstruirEnUnCasilleroConMoho(){
        Guarida guarida = new Guarida();

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(guarida.sePuedeConstruirEn(casillero));
    }

    @Test
    public void guaridaNoSePuedeConstruirEnUnCasilleroSinMoho(){
        Guarida guarida = new Guarida();

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assert(!guarida.sePuedeConstruirEn(casillero));
    }

    @Test
    public void espiralSePuedeConstruirEnUnCasilleroConMoho(){
        Espiral espiral = new Espiral();

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(espiral.sePuedeConstruirEn(casillero));
    }

    @Test
    public void espiralNoSePuedeConstruirEnUnCasilleroSinMoho(){
        Espiral espiral = new Espiral();

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assert(!espiral.sePuedeConstruirEn(casillero));
    }

    @Test
    public void accesoSePuedeConstruirEnUnCasilleroDentroDelRangoDelPilon(){
        Acceso acceso = new Acceso();

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(acceso.sePuedeConstruirEn(casillero));
    }

    @Test
    public void accesoNoSePuedeConstruirEnUnCasilleroFueraDelRangoDelPilon(){
        Acceso acceso = new Acceso();

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assert(!acceso.sePuedeConstruirEn(casillero));
    }

    @Test
    public void puertoEstelarSePuedeConstruirEnUnCasilleroDentroDelRangoDelPilon(){
        PuertoEstelar puerto = new PuertoEstelar();

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(puerto.sePuedeConstruirEn(casillero));
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirEnUnCasilleroFueraDelRangoDelPilon(){
        PuertoEstelar puerto = new PuertoEstelar();

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assert(!puerto.sePuedeConstruirEn(casillero));
    }

}
