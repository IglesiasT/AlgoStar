package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.visitante.NoSePuedeMover;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import edu.fiuba.algo3.modelo.mapa.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20Test {

    @Test
    public void ZerlingNoPuedeMoverseAUnAreaEspacial() {
        Zerling unidad = new Zerling();
        Casillero casillero = new Casillero(new AreaEspacial(), 1, 1, new Mapa());

        assertThrows(NoSePuedeMover.class, () -> unidad.moverse(casillero));
    }

    @Test
    public void HidraliscoNoPuedeMoverseAUnAreaEspacial() {
        Hidralisco unidad = new Hidralisco();
        Casillero casillero = new Casillero(new AreaEspacial(), 1, 1, new Mapa());

        assertThrows(NoSePuedeMover.class, () -> unidad.moverse(casillero));
    }

    @Test
    public void ZealotNoPuedeMoverseAUnAreaEspacial() {
        Zealot unidad = new Zealot();
        Casillero casillero = new Casillero(new AreaEspacial(), 1, 1, new Mapa());

        assertThrows(NoSePuedeMover.class, () -> unidad.moverse(casillero));
    }


    @Test
    public void DragonNoPuedeMoverseAUnAreaEspacial() {
        Dragon unidad = new Dragon();
        Casillero casillero = new Casillero(new AreaEspacial(), 1, 1, new Mapa());

        assertThrows(NoSePuedeMover.class, () -> unidad.moverse(casillero));
    }


    @Test
    public void MutaliscoPuedeMoverseAUnAreaEspacial() {
        Mutalisco unidad = new Mutalisco();
        Casillero casillero = new Casillero(new AreaEspacial(), 1, 1, new Mapa());

        assertDoesNotThrow(() ->unidad.moverse(casillero));
    }


    @Test
    public void GuardianPuedeMoverseAUnAreaEspacial() {
        Guardian unidad = new Guardian();
        Casillero casillero = new Casillero(new AreaEspacial(), 1, 1, new Mapa());

        assertDoesNotThrow(() ->unidad.moverse(casillero));
    }

    @Test
    public void ScoutPuedeMoverseAUnAreaEspacial() {
        Scout unidad = new Scout();
        Casillero casillero = new Casillero(new AreaEspacial(), 1, 1, new Mapa());

        assertDoesNotThrow(() ->unidad.moverse(casillero));
    }

}