package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public abstract class Raza {
    protected ListadoDeRecursos recursos;
    protected LinkedList<? extends Construccion> construccionesRealizadas;

    protected Raza(){
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(200));
        this.construccionesRealizadas = new LinkedList<>();
    }

    protected Raza(int cantidadDeMineral, int cantidadDeGas){
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(cantidadDeMineral));
        this.recursos.agregar(new Gas(cantidadDeGas));
        this.construccionesRealizadas = new LinkedList<>();
    }
}
