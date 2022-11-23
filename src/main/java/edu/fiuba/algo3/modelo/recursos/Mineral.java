package edu.fiuba.algo3.modelo.recursos;

public class Mineral extends Recurso{
    public Mineral(){
        super();
        this.cantidad = 2000;
    }

    public Mineral(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
