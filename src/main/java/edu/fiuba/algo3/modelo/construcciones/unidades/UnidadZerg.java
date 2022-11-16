package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;

import java.util.HashMap;
import java.util.Map;

public abstract class UnidadZerg extends ConstruccionZerg {
    protected String superficie;
    protected Map<String, Integer> danioPorSuperficie = new HashMap<>();
    protected int rangoDeAtaque;

    public void atacar(ConstruccionProtoss construccionEnemiga){
        int danio = this.danioPorSuperficie.get(construccionEnemiga.obtenerSuperficie());
        construccionEnemiga.recibirDanio(danio);
    }
}
