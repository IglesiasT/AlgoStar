package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.ObjetivoInvalido;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;

import java.util.HashMap;
import java.util.Map;

public abstract class UnidadProtoss extends ConstruccionProtoss {
    protected String superficie;
    protected Map<String, Integer> danioPorSuperficie = new HashMap<>();
    protected int rangoDeAtaque;

    public void atacar(ConstruccionZerg construccionEnemiga){
        if (!this.danioPorSuperficie.containsKey(construccionEnemiga.obtenerSuperficie())){
            throw new ObjetivoInvalido();
        }
        int danio = this.danioPorSuperficie.get(construccionEnemiga.obtenerSuperficie());
        construccionEnemiga.recibirDanio(danio);
    }
}
