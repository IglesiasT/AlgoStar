package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.*;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;
import edu.fiuba.algo3.modelo.tablero.Casillero;

public abstract class UnidadZerg extends ConstruccionZerg {
    protected int danioBase;
    protected Area superficie;
    protected int rangoDeAtaque;

    public void atacar(ConstruccionProtoss construccionEnemiga){
        construccionEnemiga.recibirDanio(this.danioBase);
    }

    public boolean puedeMoverse(Casillero casillero) {
        return casillero.puedeMoverse(this.superficie);
    }
}
