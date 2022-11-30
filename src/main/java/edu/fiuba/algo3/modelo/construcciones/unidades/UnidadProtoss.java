package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.NoSePuedeMover;
import edu.fiuba.algo3.modelo.ObjetivoFueraDeRango;
import edu.fiuba.algo3.modelo.ObjetivoInvalido;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.HashMap;
import java.util.Map;

public abstract class UnidadProtoss extends ConstruccionProtoss implements Unidad {
    protected Map<String, Integer> danioPorSuperficie;
    protected int rangoDeAtaque;
    protected int suministro;

    public UnidadProtoss(){
        super();
        this.rangoDeAtaque = 1;
        this.danioPorSuperficie = new HashMap<>();
    }

    protected boolean enRangoDeAtaque(Casillero ubicacion){
        return ((ubicacion.obtenerFila() <= this.ubicacion.obtenerFila()+this.rangoDeAtaque &&
                ubicacion.obtenerFila() >= this.ubicacion.obtenerFila()-this.rangoDeAtaque)
                &&
                (ubicacion.obtenerColumna() <= this.ubicacion.obtenerColumna()+this.rangoDeAtaque) &&
                ubicacion.obtenerColumna() >= this.ubicacion.obtenerColumna()-this.rangoDeAtaque);
    }

    public void atacar(ConstruccionZerg construccionEnemiga){
        if (turnos < this.turnosParaConstruirse) {
            throw new EdificioNoEstaOperativo();
        }
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
        if (!casillero.puedeMoverse(this.area)) {
            throw new NoSePuedeMover();
        }
        this.ubicacion = casillero;
        casillero.establecerUnidad(this);
    }

    public int consumirSuministro(int suministroAConsumir){
        return suministroAConsumir + this.suministro;
    }
}
