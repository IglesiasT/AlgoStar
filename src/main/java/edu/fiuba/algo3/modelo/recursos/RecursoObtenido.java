package edu.fiuba.algo3.modelo.recursos;

import java.util.List;

public class RecursoObtenido {

    protected int cantidad;

    public RecursoObtenido(int cantidad) {
        this.cantidad = cantidad;
    }

    public void consumir(List<RecursoObtenido> recursos){
        for (RecursoObtenido recurso : recursos) {
            if (recurso.getClass() == this.getClass()){
                if(this.cantidad < recurso.cantidad){
                    throw new RecursosInsuficientes();
                }
                this.cantidad -= recurso.cantidad;
            }
        }
    }

    public void agregar(RecursoObtenido recurso){
        this.cantidad += recurso.cantidad;
    }
}
