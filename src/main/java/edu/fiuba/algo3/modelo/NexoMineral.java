package edu.fiuba.algo3.modelo;

public class NexoMineral extends Construccion {
    private int produccionPorTurno;

    public NexoMineral(){
        this.produccionPorTurno = 20;
    }

    public int recolectarMineral(){
        return produccionPorTurno;
    }
}
