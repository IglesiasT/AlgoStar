package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;

public abstract class UnidadZerg extends ConstruccionZerg {
    protected int danioBase;
    protected String superficie;
    protected int rangoDeAtaque;

    public void atacar(ConstruccionProtoss construccionEnemiga){
        construccionEnemiga.recibirDanio(this.danioBase);
    }
}
