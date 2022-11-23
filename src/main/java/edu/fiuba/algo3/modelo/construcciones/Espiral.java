package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Espiral extends ConstruccionZerg {
    public Espiral(){
        this.recursosNecesarios.agregar(new Mineral(150));
        this.recursosNecesarios.agregar(new Gas(100));
        this.turnosParaConstruirse = 10;
        this.vidaMaxima = 1300;
        this.vida = this.vidaMaxima;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }
}
