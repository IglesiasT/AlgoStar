package edu.fiuba.algo3.modelo;

public class Moho {

    public Criadero construirEdificioZerg(){
        return (new Criadero());
    }

    public void construirEdificioProtoss() throws NoSePuedeConstruir{
        throw new NoSePuedeConstruir();
    }
}
