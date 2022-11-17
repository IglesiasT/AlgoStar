package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

public class CasoDeUso3Test {
    @Test
    public void asimiladorSePuedeConstruirEnCasilleroConGas() {
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(new Gas(), 1, 1, new Mapa());

        assert(asimilador.sePuedeConstruirEn(casillero));
    }

    @Test
    public void asimiladorNoSePuedeConstruirEnCasilleroSinGas() {
        Asimilador asimilador = new Asimilador();

        Casillero casillero = new Casillero(1, 1, new Mapa());

        assert(!asimilador.sePuedeConstruirEn(casillero));
    }

    @Test
    public void extractorSePuedeConstruirEnUnCasilleroConGas(){
        Extractor extractor = new Extractor();

        Casillero casillero = new Casillero(new Gas(), 1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void extractorNoSePuedeConstruirEnUnCasilleroSinGas(){
        Extractor extractor = new Extractor();

        Casillero casillero = new Casillero(1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(!extractor.sePuedeConstruirEn(casillero));
    }

    @Test
    public void criaderoNoSePuedeConstruirEnUnCasilleroConGas(){
        Criadero criadero = new Criadero();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());

        assert(!criadero.sePuedeConstruirEn(casillero));
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirEnUnCasilleroConGas(){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(!reserva.sePuedeConstruirEn(casillero));
    }

    @Test
    public void guaridaNoSePuedeConstruirEnUnCasilleroConGas(){
        Guarida guarida = new Guarida();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(!guarida.sePuedeConstruirEn(casillero));
    }

    @Test
    public void espiralNoSePuedeConstruirEnUnCasilleroConGas(){
        Espiral espiral = new Espiral();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        assert(!espiral.sePuedeConstruirEn(casillero));
    }

    @Test
    public void nexoMineralNoSePuedeConstruirEnUnCasilleroConGas(){
        NexoMineral nexo = new NexoMineral();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());

        assert(!nexo.sePuedeConstruirEn(casillero));
    }

    @Test
    public void pilonNoSePuedeConstruirEnUnCasilleroConGas(){
        Pilon pilon = new Pilon();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());

        assert(!pilon.sePuedeConstruirEn(casillero));
    }

    @Test
    public void accesoNoSePuedeConstruirEnUnCasilleroConGas(){
        Acceso acceso = new Acceso();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(!acceso.sePuedeConstruirEn(casillero));
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirEnUnCasilleroConGas(){
        PuertoEstelar puerto = new PuertoEstelar();

        Casillero casillero = new Casillero(new Gas(),1, 1, new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assert(!puerto.sePuedeConstruirEn(casillero));
    }
}
