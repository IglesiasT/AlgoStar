package edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.unidades.UnidadProtoss;

public class Invisible extends UnidadProtoss implements Visibilidad {
    public Invisible(Escudo escudo, int vida ) {
        this.escudo = escudo;
        this.vida = vida;
    }


    public Visibilidad hacerVisible(){
        return (new Visible(this.escudo, this.vida));
    }
    public Visibilidad hacerInvisible(){
        return this;
    }

    @Override
    public void recibirDanio(int danioInflingido){

    }
}
