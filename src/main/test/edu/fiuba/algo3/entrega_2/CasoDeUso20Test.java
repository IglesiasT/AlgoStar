package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.NoSePuedeMover;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.unidades.*;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20Test {

    @Test
    public void ZerlingNoPuedeMoverseAUnAreaEspacial(){
        Zerling unidad = new Zerling();
        Casillero casillero = new Casillero(new AreaEspacial(), 1 , 1 , new Tablero()) ;

        assertThrows(NoSePuedeMover.class, () -> unidad.Moverse(casillero) );
    }

    @Test
    public void HidraliscoNoPuedeMoverseAUnAreaEspacial(){
        Hidralisco unidad = new Hidralisco();
        Casillero casillero = new Casillero(new AreaEspacial(), 1 , 1 , new Tablero()) ;

        assertThrows(NoSePuedeMover.class, () -> unidad.Moverse(casillero) );
    }

    @Test
    public void ZealotNoPuedeMoverseAUnAreaEspacial(){

    }


    @Test
    public void DragonNoPuedeMoverseAUnAreaEspacial(){

    }


    @Test
    public void MutaliscoPuedeMoverseAUnAreaEspacial(){

    }


    @Test
    public void GuardianPuedeMoverseAUnAreaEspacial(){

    }

    @Test
    public void ScoutPuedeMoverseAUnAreaEspacial(){

    }

}
