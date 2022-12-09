package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;

import java.util.ArrayList;
import java.util.Random;

public class Base {


    //una base tiene radio 5, 1 volcan y como maximo tiene 7 nodos
    private static final int CANTIDAD_NODOS = 7;

    public static final int RADIO = 3;


    private Casillero ubicacion;
    private ArrayList<?extends Casillero> casilleros;

    public Base(Casillero ubicacion){

        this.ubicacion = ubicacion;
        this.ubicacion.setArea(new AreaTerrestre());
        this.ubicacion.setRecurso(new Gas());
        casilleros = ubicacion.obtenerCasilleros(RADIO);
        casilleros.remove(ubicacion);
        for (int i=0;i < CANTIDAD_NODOS; i++){
            Casillero casillero = casilleros.get((new Random()).nextInt(casilleros.size()));
            casillero.setArea(new AreaTerrestre());
            casillero.setRecurso(new Mineral());
        }
    }

    public Casillero obtenerUbicacion(){
        return ubicacion;
    }

}
