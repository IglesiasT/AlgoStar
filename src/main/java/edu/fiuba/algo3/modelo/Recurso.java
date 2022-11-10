package edu.fiuba.algo3.modelo;

public abstract class Recurso {
    protected int cantidad;
    public int obtenerCantidad(){
        return this.cantidad;
    }
    public int recolectar(int recoleccionPorTurno) {
        if(this.cantidad >= recoleccionPorTurno){
            this.cantidad -= recoleccionPorTurno;
            return recoleccionPorTurno;
        }
        return 0;
    }
}
