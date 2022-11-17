package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.NoSePuedeMover;
import edu.fiuba.algo3.modelo.ObjetivoInvalido;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.HashMap;
import java.util.Map;

public abstract class UnidadProtoss extends ConstruccionProtoss {
    protected Map<String, Integer> danioPorSuperficie;
    protected int rangoDeAtaque;

    public UnidadProtoss(){
        super();
        this.rangoDeAtaque = 1;
        this.danioPorSuperficie = new HashMap<>();
    }

    public void atacar(ConstruccionZerg construccionEnemiga){
        if (!this.danioPorSuperficie.containsKey(construccionEnemiga.obtenerSuperficie())){
            throw new ObjetivoInvalido();
        }
        int danio = this.danioPorSuperficie.get(construccionEnemiga.obtenerSuperficie());
        construccionEnemiga.recibirDanio(danio);
    }

    public void moverse(Casillero casillero) {
        if (!casillero.puedeMoverse(this.area)) {
            throw new NoSePuedeMover();
        }
        this.ubicacion = casillero;
    }
}
