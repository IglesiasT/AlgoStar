package edu.fiuba.algo3.modelo;

public abstract class Recurso {
    protected boolean ocupado;
    protected int cantidad;

    public Recurso(){
        this.ocupado = false;
        this.cantidad = 0;
    }
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

    public void ocupar(){
        if (this.ocupado){
            throw new RecursoOcupado();
        }
        this.ocupado = true;
    }
    public void liberar(){
        this.ocupado = false;
    }
    public boolean estaOcupado(){ return this.ocupado;}
}
