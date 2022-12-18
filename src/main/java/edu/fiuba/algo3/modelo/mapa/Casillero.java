package edu.fiuba.algo3.modelo.mapa;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.ProductorDeGas;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.SinEspacio;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.areas.*;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Casillero {
    private int fila;
    private int columna;
    private Mapa mapa;
    private Recurso recurso;
    private Area area;

    private EspacioDeConstruccion espacio;
    private Construccion construccion;
    private List<Unidad> unidades;

    public Casillero(Area area, int fila, int columna, Mapa mapa){

        this.fila = fila;
        this.columna = columna;
        this.mapa = mapa;
        this.recurso = new SinRecurso();
        this.area = area ;
        this.espacio = new SinEspacio();
        this.construccion = null;
        this.unidades = new LinkedList<>();
    }

    /*
    no se si hace falta este
    public Casillero(Recurso recurso,Area area, int fila, int columna, Mapa mapa){
        this.fila = fila;
        this.columna = columna;
        this.mapa = mapa;
        this.recurso = recurso;
        this.area = area ;
        this.espacio = new SinEspacio();
        this.construccion = null;
    }

     */

    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
    }
    public void establecerConstruccion(Construccion construccionAEstablecer){

        if (this.construccion != null || (this.recurso.estaOcupado())){
            throw new NoSePuedeConstruir();
        }

        if ((construccionAEstablecer.obtenerArea().getClass() == AreaTerrestre.class)&&(this.area.getClass() != AreaTerrestre.class)){
            throw new NoSePuedeConstruir();
        }

        // Aplicar patron Visitor para limpiar estos if
        if(construccionAEstablecer instanceof ConstruccionZerg){
            if (this.espacio.getClass() != Moho.class && !(construccionAEstablecer instanceof Criadero)){
                throw new CasilleroSinMoho();
            }
        }
        if (construccionAEstablecer instanceof ProductorDeGas){
            if (this.recurso.getClass() != Volcan.class){
                throw new CasilleroSinGas();
            }

        } else if (this.recurso.getClass() == Volcan.class) {
            throw new NoSePuedeConstruir();
        }

        if (construccionAEstablecer instanceof NexoMineral){
            if (this.recurso.getClass() != Nodo.class){
                throw new CasilleroSinMineral();
            }

        } else if (this.recurso.getClass() == Nodo.class) {
            throw new NoSePuedeConstruir();
        }

        this.construccion = construccionAEstablecer;
        this.recurso.ocupar();
    }
    public void destruirConstruccion(){
        this.construccion = null;
        this.recurso.liberar();
    }
    public void ubicarUnidad(Unidad unidad){
        unidades.add(unidad);
    }
    public void retirarUnidad(Unidad unidad){
        unidades.remove(unidad);
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
    public boolean puedeMoverse (Area tipoUnidad) {     // Rompe tell don't ask, ver presentacion polimorfismo hay ej parecido
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
    public void setRecurso(Recurso recurso){
        this.recurso = recurso;
    }
    public void setArea(Area area){
        this.area = area;
    }

    public Area obtenerArea(){
        return this.area;
    }
    public List<Unidad> obtenerUnidades(){return unidades;}
}
