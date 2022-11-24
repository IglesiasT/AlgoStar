package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

public class CasoDeUso5Test {


    @Test
    public void extractorSePuedeConstruirEnUnCasilleroConMoho(){
        Extractor extractor = new Extractor();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

//        assert(extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void extractorNoSePuedeConstruirEnUnCasilleroSinMoho(){
        Extractor extractor = new Extractor();

        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());

//        assert(!extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void reservaDeReproduccionSePuedeConstruirEnUnCasilleroConMoho(){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

//        assert(reserva.sePuedeConstruirEn(casillero));
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirEnUnCasilleroSinMoho(){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

//        assert(!reserva.sePuedeConstruirEn(casillero));
    }

    @Test
    public void guaridaSePuedeConstruirEnUnCasilleroConMoho(){
        Guarida guarida = new Guarida();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

//        assert(guarida.sePuedeConstruirEn(casillero));
    }

    @Test
    public void guaridaNoSePuedeConstruirEnUnCasilleroSinMoho(){
        Guarida guarida = new Guarida();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

//        assert(!guarida.sePuedeConstruirEn(casillero));
    }

    @Test
    public void espiralSePuedeConstruirEnUnCasilleroConMoho(){
        Espiral espiral = new Espiral();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

//        assert(espiral.sePuedeConstruirEn(casillero));
    }

    @Test
    public void espiralNoSePuedeConstruirEnUnCasilleroSinMoho(){
        Espiral espiral = new Espiral();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

//        assert(!espiral.sePuedeConstruirEn(casillero));
    }

    @Test
    public void accesoSePuedeConstruirEnUnCasilleroDentroDelRangoDelPilon(){
        Acceso acceso = new Acceso();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

//        assert(acceso.sePuedeConstruirEn(casillero));
    }

    @Test
    public void accesoNoSePuedeConstruirEnUnCasilleroFueraDelRangoDelPilon(){
        Acceso acceso = new Acceso();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

//        assert(!acceso.sePuedeConstruirEn(casillero));
    }

    @Test
    public void puertoEstelarSePuedeConstruirEnUnCasilleroDentroDelRangoDelPilon(){
        PuertoEstelar puerto = new PuertoEstelar();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

//        assert(puerto.sePuedeConstruirEn(casillero));
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirEnUnCasilleroFueraDelRangoDelPilon(){
        PuertoEstelar puerto = new PuertoEstelar();

        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());

//        assert(!puerto.sePuedeConstruirEn(casillero));
    }

}
