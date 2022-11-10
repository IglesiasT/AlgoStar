package edu.fiuba.algo3.modelo;

public abstract class ConstruccionProtoss extends Construccion{
    protected int escudo;

    public ConstruccionProtoss(){
        super();
        this.escudo = 100;
    }

    public int obtenerEscudo(){
        return this.escudo;
    }

    @Override
    public abstract boolean sePuedeConstruirEn(Casillero casillero);

    @Override
    public void recibirDanio(int danioInflingido) {
        this.escudo -= danioInflingido;
        if (this.escudo < 0){
            this.vida = this.vida + this.escudo;
            this.escudo = 0;
        }
    }
    @Override
    protected void regenerar() {
        this.escudo += 10;
    }

    @Override
    public void nuevoTurno(){
        regenerar();
    }
}
