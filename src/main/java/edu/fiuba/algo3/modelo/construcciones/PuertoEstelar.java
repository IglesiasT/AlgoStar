package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.tablero.Casillero;

public class PuertoEstelar extends ConstruccionProtoss {
    public PuertoEstelar(){
        this.mineralNecesarioParaConstruir = 150;
        this.gasNecesarioParaConstruir = 150;
        this.turnosParaConstruirse = 10;
        this.escudo = new Escudo(600);
        this.vida = 600;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new RangoPilon()) && casillero.contiene(new SinRecurso()));
    }
}
