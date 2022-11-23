package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Recurso;

import java.util.HashSet;
import java.util.Set;

public abstract class Raza {
    protected Set<Recurso> recursos;

    protected Raza(){
        this.recursos = new HashSet<>();
        this.recursos.add(new Mineral(200));
    }

    protected Raza(int cantidadDeMineral, int cantidadDeGas){
        this.recursos = new HashSet<>();
        this.recursos.add(new Mineral(cantidadDeMineral));
        this.recursos.add(new Gas(cantidadDeGas));
    }
}
