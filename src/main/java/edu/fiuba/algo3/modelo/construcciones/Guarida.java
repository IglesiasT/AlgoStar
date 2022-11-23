package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Guarida extends ConstruccionZerg {
    public Guarida(){
        this.recursosNecesarios.add(new Mineral(200));
        this.recursosNecesarios.add(new Gas(100));
        this.turnosParaConstruirse = 12;
        this.vida = 1250;
        this.vidaMaxima = 1250;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }
}
