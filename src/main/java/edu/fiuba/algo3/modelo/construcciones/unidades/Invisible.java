package edu.fiuba.algo3.modelo.construcciones.unidades;
import edu.fiuba.algo3.modelo.construcciones.Escudo;

public class Invisible extends UnidadProtoss implements Visibilidad{
    public Invisible(Escudo escudo, int vida ) {
        this.escudo = escudo;
        this.vida = vida;
        this.turnosParaConstruirse = 0;
    }


    public Visibilidad hacerVisible(){
        return (new Visible(this.escudo, this.vida));
    }
    public Visibilidad hacerInvisible(){
        return this;
    }

    @Override
    public void recibirDanio(int danioInflingido){}
}
