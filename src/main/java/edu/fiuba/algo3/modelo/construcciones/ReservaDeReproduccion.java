package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class ReservaDeReproduccion extends ConstruccionZerg {

    public ReservaDeReproduccion(){
        this.mineralNecesarioParaConstruir = 150;
        this.turnosParaConstruirse = 12;
        this.vida = 1000;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }
}
