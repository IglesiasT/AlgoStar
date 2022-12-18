package edu.fiuba.algo3.modelo.recursos;

public class Nodo extends Recurso{
    public Nodo(){
        super();
        this.cantidad = 2000;
    }

    public Nodo(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
