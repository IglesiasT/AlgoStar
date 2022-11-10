package edu.fiuba.algo3.modelo;

import java.util.*;

public abstract class Construccion {
    protected int turnosParaConstruirse;
    protected int vida;
    protected int turnos;

    public Construccion(){
        this.vida = 100;
    }
    public void esGeneradorDeGas() {
        throw new NoSePuedeConstruir();
    }

    public abstract boolean sePuedeConstruirEn (Casillero casillero);

    public abstract void recibirDanio( int danioInflingido);
    protected abstract void regenerar();
    public int obtenerVida(){
        return this.vida;
    }
}
