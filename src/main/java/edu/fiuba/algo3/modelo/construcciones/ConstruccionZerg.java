package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.mapa.Casillero;

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

    public void nuevoTurno(){
        this.turnos++;
        this.regenerar();
    }
}
