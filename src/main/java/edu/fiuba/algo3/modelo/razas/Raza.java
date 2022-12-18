package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones.ListadoDeConstruccionesZerg;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.*;

import java.util.LinkedList;
import java.util.List;

public abstract class Raza {
    protected ListadoDeRecursos recursos;
    int maximoSuministro;
    int suministro;

    public Raza(){
        this.maximoSuministro = 200;
        this.suministro = 0;
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(200));
        this.recursos.agregar(new Gas(0));
    }

    public Raza(int cantidadDeMineral, int cantidadDeGas){
        this.recursos = new ListadoDeRecursos();
        this.recursos.agregar(new Mineral(cantidadDeMineral));
        this.recursos.agregar(new Gas(cantidadDeGas));
        this.maximoSuministro = 200;
        this.suministro = 0;
    }

    public int obtenerOcupacionActual() {
        return this.suministro;
    }

    public abstract int construccionesRealizadas();

    public abstract void construir(String construccion, Casillero casillero);
    public abstract void nuevoTurno();
    public abstract void atacar(Unidad atacante, Construccion objetivo);

    public void agregarRecurso(RecursoObtenido recurso){
        this.recursos.agregar(recurso);
    }

    public String obtenerRecursos(){
        return recursos.obtenerRecursos();
    }
    public abstract List<Construccion> obtenerConstrucciones();
    public abstract void destruir(Construccion construccion);
}
