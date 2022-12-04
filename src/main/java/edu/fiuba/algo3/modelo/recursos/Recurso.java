package edu.fiuba.algo3.modelo.recursos;

import java.util.Set;

public abstract class Recurso {
    protected boolean ocupado;
    protected int cantidad;

    public Recurso(){
        this.ocupado = false;
        this.cantidad = 0;
    }
    public int recolectar(int recoleccionPorTurno) {
        this.cantidad -= recoleccionPorTurno;
        if(this.cantidad <= 0) {
            int recursoRecolectado = recoleccionPorTurno + this.cantidad;
            this.cantidad = 0;
            return recursoRecolectado;
        }
        return recoleccionPorTurno;
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
    public void consumir(Set<Recurso> recursos){
        for (Recurso recurso : recursos) {
            if (recurso.equals(this)){
                if(this.cantidad < recurso.cantidad){
                    throw new RecursosInsuficientes();
                }
                this.cantidad -= recurso.cantidad;
            }
        }
    }
}
