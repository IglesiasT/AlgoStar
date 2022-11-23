package edu.fiuba.algo3.modelo.recursos;

public class Gas extends Recurso{

    public Gas(){
        super();
        this.cantidad = 5000;
    }
    public Gas(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
