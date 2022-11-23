package edu.fiuba.algo3.modelo.estados;

public class Terminado extends EstadoDeJuego {

    public void jugar() {throw new JuegoFinalizado();}
}
