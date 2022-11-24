package edu.fiuba.algo3.modelo.recursos;

import java.util.HashSet;
import java.util.Set;

public class ListadoDeRecursos {
    private Set<Recurso> recursos;

    public ListadoDeRecursos(){
        this.recursos = new HashSet<>();
    }

    public boolean contieneRecurso(Recurso recursoBuscado){
        for(Recurso recurso : this.recursos)
            if(recurso.getClass() == recursoBuscado.getClass()){
                return true;
            }
        return false;
    }

    public boolean contieneTodos(ListadoDeRecursos recursosBuscados){
        for (Recurso recursoBuscado : recursosBuscados.recursos) {
            if(! this.contieneRecurso(recursoBuscado)){
                return false;
            }
        }
        return true;
    }

    public void consumir(ListadoDeRecursos recursosAConsumir){
        for (Recurso recurso : recursosAConsumir.recursos) {
            recurso.consumir(this.recursos);
        }
    }

    public void agregar(Recurso recurso){
        this.recursos.add(recurso);
    }
}
