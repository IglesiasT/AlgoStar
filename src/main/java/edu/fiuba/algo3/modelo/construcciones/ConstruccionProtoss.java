package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.tablero.Casillero;

public abstract class ConstruccionProtoss extends Construccion{
    protected Escudo escudo;

    public ConstruccionProtoss(){
        super();
        this.escudo = new Escudo(100);
    }

    public int obtenerEscudo(){
        return this.escudo.obtenerVida();
    }

    @Override
    public abstract boolean sePuedeConstruirEn(Casillero casillero);

    @Override
    public void recibirDanio(int danioInflingido) {
        this.escudo.recibirDanio(danioInflingido);

        this.vida -= this.escudo.obtenerDanioNoMitigado();

        if (this.vida <= 0){
            this.ubicacion.destruirConstruccion();
        }
    }
    @Override
    protected void regenerar() {
        this.escudo.regenerar();
    }

    @Override
    public void nuevoTurno(){
        this.turnos++;
        this.regenerar();
    }
}
