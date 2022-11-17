package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.NoSePuedeMover;
import edu.fiuba.algo3.modelo.ObjetivoFueraDeRango;
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

    protected boolean enRangoDeAtaque(Casillero ubicacion){
        return ((ubicacion.obtenerFila() <= this.ubicacion.obtenerFila()+this.rangoDeAtaque &&
                ubicacion.obtenerFila() >= this.ubicacion.obtenerFila()-this.rangoDeAtaque)
                &&
                (ubicacion.obtenerColumna() <= this.ubicacion.obtenerColumna()+this.rangoDeAtaque) &&
                ubicacion.obtenerColumna() >= this.ubicacion.obtenerColumna()-this.rangoDeAtaque);
    }

    public void atacar(ConstruccionZerg construccionEnemiga){
        if (!this.danioPorSuperficie.containsKey(construccionEnemiga.obtenerSuperficie())){
            throw new ObjetivoInvalido();
        }

        if (!enRangoDeAtaque(construccionEnemiga.obtenerUbicacion())){
            throw new ObjetivoFueraDeRango();
        }

        int danio = this.danioPorSuperficie.get(construccionEnemiga.obtenerSuperficie());
        construccionEnemiga.recibirDanio(danio);
    }

    public void moverse(Casillero casillero) {
        if (!casillero.puedeMoverse(this.superficie)) {
            throw new NoSePuedeMover();
        }
        this.ubicacion = casillero;
    }
}
