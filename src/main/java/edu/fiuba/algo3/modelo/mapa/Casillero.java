package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.SinEspacio;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.areas.*;

import java.util.ArrayList;

public class Casillero {
    private int fila;
    private int columna;
    private Mapa mapa;
    private Recurso recurso;
    private Area area;

    private EspacioDeConstruccion espacio;
    private Construccion construccion;

    public Casillero(Area area, int fila, int columna, Mapa mapa){
        this.fila = fila;
        this.columna = columna;
        this.mapa = mapa;
        this.recurso = new SinRecurso();
        this.area = area ;
        this.espacio = new SinEspacio();
        this.construccion = null;
    }

    public Casillero(Recurso recurso,Area area, int fila, int columna, Mapa mapa){
        this.fila = fila;
        this.columna = columna;
        this.mapa = mapa;
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

        // Aplicar patron Visitor para limpiar estos if
        if (construccionAEstablecer instanceof ProductorDeGas){
            if (this.recurso.getClass() != Gas.class){
                throw new CasilleroSinGas();
            }
            if(construccionAEstablecer instanceof ConstruccionZerg){
                if (this.espacio.getClass() != Moho.class){
                    throw new CasilleroSinMoho();
                }
            }
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
    public boolean puedeMoverse (Area tipoUnidad) {
        return ((tipoUnidad.getClass() == AreaEspacial.class) || ((tipoUnidad.getClass() == AreaTerrestre.class) && (this.area.getClass() == AreaTerrestre.class)) ) ;
    }

    public ArrayList<? extends Casillero> obtenerCasilleros(int radio) {
        return this.mapa.obtenerCasilleros(radio, this.fila, this.columna);
    }

    public int obtenerColumna() {
        return columna;
    }

    public int obtenerFila(){
        return fila;
    }
}
