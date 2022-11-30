package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;

import java.util.LinkedList;

public abstract class Raza {
    protected ListadoDeRecursos recursos;
    protected LinkedList<? extends Construccion> construccionesRealizadas;

    int maximoSuministro;

    int suministro;

    protected Raza(){
        this.maximoSuministro = 200;
        this.suministro = 0;
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(200));
        this.construccionesRealizadas = new LinkedList<>();
    }

    protected Raza(int cantidadDeMineral, int cantidadDeGas){
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(cantidadDeMineral));
        this.recursos.agregar(new Gas(cantidadDeGas));
        this.construccionesRealizadas = new LinkedList<>();
        this.maximoSuministro = 200;
        this.suministro = 0;
    }

    public int obtenerOcupacionActual() {
        return this.suministro;
    }

    public abstract int construcciones();
}
