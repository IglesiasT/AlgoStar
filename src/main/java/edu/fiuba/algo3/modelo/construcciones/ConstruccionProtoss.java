package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.tablero.Casillero;

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

        if (this.vida <= 0){
            this.ubicacion.destruirConstruccion();
        }
    }
    @Override
    protected void regenerar() {
        this.escudo += 10;
    }

    @Override
    public void nuevoTurno(){
        this.turnos++;
        regenerar();
    }
}
