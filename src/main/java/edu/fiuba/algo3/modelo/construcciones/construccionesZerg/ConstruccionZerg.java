package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.razas.Zerg;

public abstract class ConstruccionZerg extends Construccion {

    public ConstruccionZerg(){
        super();
    }
    @Override
    public void recibirDanio(int danioInflingido) {
        this.vida -= danioInflingido;

        if (this.vida <= 0){
            this.destruir();
        }
    }

    @Override
    protected void regenerar() {
        if (this.vida < this.vidaMaxima){
            this.vida += 5;
        }
    }

    @Override
    public Class obtenerRazaMadre() {
        return Zerg.class;
    }
}
