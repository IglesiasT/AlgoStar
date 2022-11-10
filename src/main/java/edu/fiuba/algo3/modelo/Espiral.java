package edu.fiuba.algo3.modelo;

public class Espiral extends ConstruccionZerg{
    public Espiral(){
        this.mineralNecesarioParaConstruir = 150;
        this.gasNecesarioParaConstruir = 100;
        this.turnosParaConstruirse = 10;
        this.vida = 1300;
    }

    @Override
    public void nuevoTurno() {

    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }
}
