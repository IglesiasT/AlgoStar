package edu.fiuba.algo3.modelo;

public class ReservaDeReproduccion extends ConstruccionZerg{

    public ReservaDeReproduccion(){
        this.mineralNecesarioParaConstruir = 150;
        this.turnosParaConstruirse = 12;
        this.vida = 1000;
    }

    @Override
    public void nuevoTurno() {

    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }
}
