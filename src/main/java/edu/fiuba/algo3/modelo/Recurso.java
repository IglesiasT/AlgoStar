package edu.fiuba.algo3.modelo;

public abstract class Recurso {
    protected int cantidad;
    public abstract int recolectar(String recolector);
    public int obtenerCantidad(){
        return this.cantidad;
    }
}
