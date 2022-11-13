package edu.fiuba.algo3.modelo;

public class PuertoEstelar extends ConstruccionProtoss{
    public PuertoEstelar(){
        this.mineralNecesarioParaConstruir = 150;
        this.gasNecesarioParaConstruir = 150;
        this.turnosParaConstruirse = 10;
        this.escudo = 600;
        this.vida = 600;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new RangoPilon()) && casillero.contiene(new SinRecurso()));
    }
}
