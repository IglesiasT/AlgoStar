package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;

import java.util.LinkedList;

public abstract class Raza {
    protected ListadoDeRecursos recursos;
    int maximoSuministro;
    int suministro;
    protected LinkedList<Unidad> unidadesEngendradas;

    public Raza(){
        this.maximoSuministro = 200;
        this.suministro = 0;
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(200));
    }

    public Raza(int cantidadDeMineral, int cantidadDeGas){
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(cantidadDeMineral));
        this.recursos.agregar(new Volcan(cantidadDeGas));
        this.maximoSuministro = 200;
        this.suministro = 0;
    }

    public int obtenerOcupacionActual() {
        return this.suministro;
    }

    public abstract int construccionesRealizadas();
}
