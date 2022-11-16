package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;

public abstract class UnidadProtoss extends ConstruccionProtoss {
    protected int danioBase;
    protected String superficie;
    protected int rangoDeAtaque;

    public void atacar(ConstruccionZerg construccionEnemiga){
        construccionEnemiga.recibirDanio(this.danioBase);
    }
}
