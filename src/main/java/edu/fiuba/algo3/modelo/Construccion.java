package edu.fiuba.algo3.modelo;

public abstract class Construccion {
    protected int turnosParaConstruirse;
    protected int vida;
    public Construccion(){
        this.vida = 100;
    }
    public void esGeneradorDeGas(){
        throw new NoSePuedeConstruir();
    };

    public abstract void recibirDanio( int danioInflingido);
    protected abstract void regenerar();
    public int obtenerVida(){
        return this.vida;
    }
}
