package edu.fiuba.algo3.modelo;

public class Construccion {

    protected int turnosParaConstruirse;
    public void esGeneradorDeGas(){
        throw new NoSePuedeConstruir();
    };
}
