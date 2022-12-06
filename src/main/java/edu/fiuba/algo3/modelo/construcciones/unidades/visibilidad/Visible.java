package edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.UnidadProtoss;

public class Visible extends UnidadProtoss implements Visibilidad{

    public Visible(Escudo escudo, int vida ) {
        this.escudo = escudo;
        this.vida = vida;
    }

    public Visibilidad hacerInvisible(){
        return (new Invisible(this.escudo, this.vida));
    }

    public Visibilidad hacerVisible(){
        return this;
    }

}
