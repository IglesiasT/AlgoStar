package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.NoSePuedeMover;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.unidades.*;
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