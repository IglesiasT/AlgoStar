package edu.fiuba.algo3.modelo;

public class ConstruccionProtoss extends Construccion{
    private int escudo;

    public ConstruccionProtoss(){
        super();
        this.escudo = 100;
    }
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
}
