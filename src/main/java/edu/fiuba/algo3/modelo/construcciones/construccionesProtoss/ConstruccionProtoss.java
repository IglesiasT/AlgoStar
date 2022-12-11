package edu.fiuba.algo3.modelo.construcciones.construccionesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.Escudo;

public abstract class ConstruccionProtoss extends Construccion {
    protected Escudo escudo;

    public ConstruccionProtoss(){
        super();
        this.escudo = new Escudo(100);
    }
    public int obtenerEscudo(){
        return this.escudo.obtenerVida();
    }
    @Override
    public void recibirDanio(int danioInflingido) {
        this.escudo.recibirDanio(danioInflingido);

        this.vida -= this.escudo.obtenerDanioNoMitigado();

        if (this.vida <= 0){
            this.destruir();
        }
    }
    @Override
    protected void regenerar() {
        this.escudo.regenerar();
    }

}
