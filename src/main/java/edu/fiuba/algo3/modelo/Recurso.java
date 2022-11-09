package edu.fiuba.algo3.modelo;

public abstract class Recurso {
    protected int cantidad;

    public abstract void construirEdificio(Construccion construccion);
    public abstract int recolectar(String recolector);
}
