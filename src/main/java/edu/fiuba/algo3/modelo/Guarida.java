package edu.fiuba.algo3.modelo;

public class Guarida extends ConstruccionZerg{
    public Guarida(){
        this.mineralNecesarioParaConstruir = 200;
        this.gasNecesarioParaConstruir = 100;
        this.turnosParaConstruirse = 12;
        this.vida = 1250;
    }

    @Override
    public void nuevoTurno() {

    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }
}
