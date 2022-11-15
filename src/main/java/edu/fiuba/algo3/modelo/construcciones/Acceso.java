package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Acceso extends ConstruccionProtoss {

    public Acceso(){
        this.mineralNecesarioParaConstruir = 150;
        this.turnosParaConstruirse = 8;
        this.escudo = 500;
        this.vida = 500;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new RangoPilon()) && casillero.contiene(new SinRecurso()));
    }
}