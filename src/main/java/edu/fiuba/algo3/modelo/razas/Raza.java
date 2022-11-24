package edu.fiuba.algo3.modelo.razas;

public abstract class Raza {
    int cantidadDeMineral;
    int cantidadDeGas;

    int maximoSuministro;

    int suministro;

    protected Raza(){
        this.cantidadDeMineral = 200;
        this.cantidadDeGas = 0;
        this.maximoSuministro = 200;
        this.suministro = 0;
    }
    public abstract int construcciones();

    public int obtenerOcupacionActual(){
        return this.suministro;
    }
}
