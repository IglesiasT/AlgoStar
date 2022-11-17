package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.SinEspacio;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;

import java.util.ArrayList;

public class Casillero {
    private int fila;
    private int columna;
    private Mapa mapa;
    private Recurso recurso;
    private EspacioDeConstruccion espacio;
    private Construccion construccion;

    public Casillero(int fila, int columna, Mapa mapa){
        this.fila = fila;
        this.columna = columna;
        this.mapa = mapa;
        this.recurso = new SinRecurso();
        this.espacio = new SinEspacio();
        this.construccion = null;
    }
    public Casillero(Recurso recurso, int fila, int columna, Mapa mapa){
        this.fila = fila;
        this.columna = columna;
        this.mapa = mapa;
        this.recurso = recurso;
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

    public Construccion obtenerConstruccion(){ return this.construccion;}

    public boolean contiene (Recurso recurso){
        return (this.recurso.getClass() == recurso.getClass());
    }
    public boolean contiene (EspacioDeConstruccion espacio){
        return (this.espacio.getClass() == espacio.getClass());
    }
    public ArrayList<? extends Casillero> obtenerCasilleros(int radio) {
        return this.mapa.obtenerCasilleros(radio, this.fila, this.columna);
    }
}
