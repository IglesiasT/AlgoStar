package edu.fiuba.algo3.modelo.estadosDeJuego;

public class Terminado implements EstadoDeJuego {

    public void jugar() {throw new JuegoFinalizado();}
}
