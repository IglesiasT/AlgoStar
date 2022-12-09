package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Base extends Rectangle {


    //una base tiene radio 5, 1 volcan y como maximo tiene 7 nodos
    private static final int CANTIDAD_NODOS = 7;
    private static final int RADIO = 3;

    private Casillero ubicacion;
    private ArrayList<?extends Casillero> casilleros;
    public Base(Casillero ubicacion){
        setWidth(App.TAMANIO_CASILLERO*(RADIO*2 +1) -1 );
        setHeight(App.TAMANIO_CASILLERO*(RADIO*2 +1) -1 );
        setFill(Color.TRANSPARENT);
        relocate((ubicacion.obtenerFila()-RADIO) * App.TAMANIO_CASILLERO,(ubicacion.obtenerColumna()-RADIO) * App.TAMANIO_CASILLERO);
        this.ubicacion = ubicacion;
        this.ubicacion.setArea(new AreaTerrestre());
        this.ubicacion.setRecurso(new Volcan());
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

    public void inicioJugador1(){
        setStroke(Color.MAGENTA);
        setStrokeWidth(2);
    }
    public void inicioJugador2(){
        setStroke(Color.CYAN);
        setStrokeWidth(2);
    }
}
