package edu.fiuba.algo3.modelo.razas;

public abstract class Raza {
    int cantidadDeMineral;
    int cantidadDeGas;

    protected Raza(){
        this.cantidadDeMineral = 200;
        this.cantidadDeGas = 0;
    }
    public abstract int construcciones();
}
