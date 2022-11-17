package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Espiral extends ConstruccionZerg {
    public Espiral(){
        this.mineralNecesarioParaConstruir = 150;
        this.gasNecesarioParaConstruir = 100;
        this.turnosParaConstruirse = 10;
        this.vida = 1300;
        this.vidaMaxima = 1300;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Moho()) && casillero.contiene(new SinRecurso()));
    }
}
