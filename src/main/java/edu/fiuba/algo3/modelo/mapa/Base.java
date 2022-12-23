package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.Nodo;

import java.util.ArrayList;
import java.util.Random;

public class Base {


    //una base tiene radio 3, 1 volcan y como maximo tiene 7 nodos
    private static final int CANTIDAD_NODOS = 7;
    public static final int RADIO = 3;

    private final Casillero ubicacion;

    public Base(Casillero ubicacion){

        this.ubicacion = ubicacion;
        this.ubicacion.setArea(new AreaTerrestre());
        this.ubicacion.setRecurso(new Volcan());
        ArrayList<? extends Casillero> casilleros = ubicacion.obtenerCasilleros(RADIO);
        casilleros.remove(ubicacion);
        for (Casillero casillero: casilleros){
            casillero.setArea(new AreaTerrestre());
        }
        for (int i=0;i < CANTIDAD_NODOS; i++){
            Casillero casillero = casilleros.get((new Random()).nextInt(casilleros.size()));
            if (casillero.obtenerRecurso() == SinRecurso.class) {
                casillero.setRecurso(new Nodo());
            }
        }
    }
    public Casillero obtenerUbicacion(){
        return ubicacion;
    }

}
