package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class PuertoEstelar extends ConstruccionProtoss {
    public PuertoEstelar(){
        this.recursosNecesarios.add(new Mineral(150));
        this.recursosNecesarios.add(new Gas(150));
        this.turnosParaConstruirse = 10;
        this.escudo = new Escudo(600);
        this.vida = 600;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new RangoPilon()) && casillero.contiene(new SinRecurso()));
    }
}
