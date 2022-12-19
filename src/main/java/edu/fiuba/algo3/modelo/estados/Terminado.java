package edu.fiuba.algo3.modelo.estados;

public class Terminado implements Estado {

    public void jugar() {throw new JuegoFinalizado();}
}
