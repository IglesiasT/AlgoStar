package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.NoSePuedeMover;
import edu.fiuba.algo3.modelo.ObjetivoInvalido;
import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.HashMap;
import java.util.Map;

public abstract class UnidadProtoss extends ConstruccionProtoss {
    protected Map<String, Integer> danioPorSuperficie = new HashMap<>();
    protected int rangoDeAtaque;

    protected Area superficie;

    public void atacar(ConstruccionZerg construccionEnemiga){
        if (!this.danioPorSuperficie.containsKey(construccionEnemiga.obtenerSuperficie())){
            throw new ObjetivoInvalido();
        }
        int danio = this.danioPorSuperficie.get(construccionEnemiga.obtenerSuperficie());
        construccionEnemiga.recibirDanio(danio);
    }

    public void Moverse(Casillero casillero) {
        if (!casillero.puedeMoverse(this.superficie)) {
            throw new NoSePuedeMover();
        }
        this.ubicacion = casillero;
    }
}
