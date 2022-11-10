package edu.fiuba.algo3.modelo;

public abstract class ConstruccionZerg extends Construccion{
    @Override
    public abstract boolean sePuedeConstruirEn(Casillero casillero);

    @Override
    public void recibirDanio(int danioInflingido) {
        this.vida -= danioInflingido;
        if (this.vida <= 0){
            this.ubicacion.destruirConstruccion();
        }
    }

    @Override
    protected void regenerar() {
        if (this.vida < 100){
            this.vida += 5;
        }
    }
}
