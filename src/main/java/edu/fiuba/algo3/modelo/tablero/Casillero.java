package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.SinEspacio;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.areas.*;

import java.util.ArrayList;

public class Casillero {
    private int fila;
    private int columna;
    private Tablero tablero;
    private Recurso recurso;
    private Area area;

    private EspacioDeConstruccion espacio;
    private Construccion construccion;

    public Casillero(Area area, int fila, int columna, Tablero tablero){
        this.fila = fila;
        this.columna = columna;
        this.tablero = tablero;
        this.recurso = new SinRecurso();
        this.area = area ;
        this.espacio = new SinEspacio();
        this.construccion = null;
    }
    public Casillero(Recurso recurso, Area area, int fila, int columna, Tablero tablero){
        this.fila = fila;
        this.columna = columna;
        this.tablero = tablero;
        this.recurso = recurso;
        this.area = area ;
        this.espacio = new SinEspacio();
        this.construccion = null;
    }

    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
    }
    public void establecerConstruccion(Construccion construccionAEstablecer){

        if (this.construccion != null || (this.recurso.estaOcupado())){
            throw new NoSePuedeConstruir();
        }

        this.construccion = construccionAEstablecer;
        this.recurso.ocupar();
    }

    public void destruirConstruccion(){
        this.construccion = null;
        this.recurso.liberar();
    }

    public Recurso obtenerRecurso() {
        return this.recurso;
    }

    public boolean contiene (Recurso recurso){
        return (this.recurso.getClass() == recurso.getClass());
    }
    public boolean contiene (EspacioDeConstruccion espacio){
        return (this.espacio.getClass() == espacio.getClass());
    }
    public boolean puedeMoverse (Area tipoUnidad) {
        return ((tipoUnidad.getClass() == AreaEspacial.class) || ((tipoUnidad.getClass() == AreaTerrestre.class) && (this.area.getClass() == AreaTerrestre.class)) ) ;
    }

    public ArrayList<? extends Casillero> obtenerCasilleros(int radio) {
        return this.tablero.obtenerCasilleros(radio, this.fila, this.columna);
    }

}
