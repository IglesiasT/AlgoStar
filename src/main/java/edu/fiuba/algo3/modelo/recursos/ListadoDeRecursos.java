package edu.fiuba.algo3.modelo.recursos;

import java.util.LinkedList;
import java.util.List;

public class ListadoDeRecursos {
    private List<RecursoObtenido> recursos;

    public ListadoDeRecursos(){
        this.recursos = new LinkedList<>();
    }

    public boolean contieneRecurso(RecursoObtenido recursoBuscado){
        for(RecursoObtenido recurso : this.recursos)
            if(recurso.getClass() == recursoBuscado.getClass()){
                return true;
            }
        return false;
    }

    public boolean contieneTodos(ListadoDeRecursos recursosBuscados){
        for (RecursoObtenido recursoBuscado : recursosBuscados.recursos) {
            if(! this.contieneRecurso(recursoBuscado)){
                return true;
            }
        }
        return false;
    }

    public void consumir(ListadoDeRecursos recursosAConsumir){
        for (RecursoObtenido recurso : recursosAConsumir.recursos) {
            recurso.consumir(this.recursos);
        }
    }

    public void agregar(RecursoObtenido recursoAgregar){
        boolean yaAgregado = false;
        for (RecursoObtenido recurso: recursos){
            if (recurso.getClass() == recursoAgregar.getClass()){
                recurso.agregar(recursoAgregar);
                yaAgregado = true;
            }
        }
        if (!yaAgregado)
            this.recursos.add(recursoAgregar);
    }

    public String obtenerRecursos(){
        return "Δ"+Integer.toString(recursos.get(1).cantidad)+" ❖"+Integer.toString(recursos.get(0).cantidad);
    }
}
