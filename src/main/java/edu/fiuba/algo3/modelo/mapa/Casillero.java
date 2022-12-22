package edu.fiuba.algo3.modelo.mapa;


import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.NoSePuedeConstruir;
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
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Casillero {
    private final int fila;
    private final int columna;
    private final Mapa mapa;
    private Recurso recurso;
    private Area area;

    private EspacioDeConstruccion espacio;
    private Construccion construccion;
    private final List<Unidad> unidades;

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

    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
    }
    public void establecerConstruccion(Construccion construccionAEstablecer){

        if (this.construccion != null){
            throw new NoSePuedeConstruir();
        }

        if (construccionAEstablecer.obtenerArea().getClass() != this.area.getClass()){
            throw new NoSePuedeConstruir();
        }

        VisitanteConstruccion visitante = new VisitanteConstruccion();
        construccionAEstablecer.visitar(visitante , this.espacio , this.recurso);

        this.recurso.ocupar();
        this.construccion = construccionAEstablecer;
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
    public boolean contiene (EspacioDeConstruccion espacio){
        return (this.espacio.getClass() == espacio.getClass());
    }
    public Casillero mover(Casillero nuevaPosicion , Area tipoUnidad) {
        if ( (tipoUnidad.getClass() != AreaEspacial.class) && ( this.area.getClass() == AreaEspacial.class ) ) {
            return null;
        }

        return nuevaPosicion;
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
