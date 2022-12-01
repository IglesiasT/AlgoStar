package edu.fiuba.algo3.modelo.construcciones.unidades;
import edu.fiuba.algo3.modelo.construcciones.Escudo;

public class Visible extends UnidadProtoss implements Visibilidad{

    public Visible(Escudo escudo, int vida ) {
        this.escudo = escudo;
        this.vida = vida;
        this.turnosParaConstruirse = 0;
    }

    public Visibilidad hacerInvisible(){
        return (new Invisible(this.escudo, this.vida));
    }

    public Visibilidad hacerVisible(){
        return this;
    }
}
