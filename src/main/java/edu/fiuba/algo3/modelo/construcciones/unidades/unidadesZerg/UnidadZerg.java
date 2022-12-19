package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.visitante.Atacante;
import edu.fiuba.algo3.modelo.visitante.NoSePuedeMover;
import edu.fiuba.algo3.modelo.visitante.ObjetivoFueraDeRango;

public abstract class UnidadZerg extends ConstruccionZerg implements Unidad {
    protected int rangoDeAtaque;
    protected int suministro;
    protected int danioAereo;
    protected int danioTerrestre;

    public UnidadZerg() {
        super();
        this.rangoDeAtaque = 1;
        this.danioAereo = 0;
        this.danioTerrestre = 0;
    }

    @Override
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        moverse(casilleroAConstruir);
        this.recursosNecesarios.consumir(recursos);
    }
    protected boolean enRangoDeAtaque(Casillero ubicacion){
        return ((ubicacion.obtenerFila() <= this.ubicacion.obtenerFila()+this.rangoDeAtaque &&
                ubicacion.obtenerFila() >= this.ubicacion.obtenerFila()-this.rangoDeAtaque)
                &&
                (ubicacion.obtenerColumna() <= this.ubicacion.obtenerColumna()+this.rangoDeAtaque) &&
                ubicacion.obtenerColumna() >= this.ubicacion.obtenerColumna()-this.rangoDeAtaque);

    }

    public void atacar(ConstruccionProtoss construccionEnemiga){
        estado.jugar();
        if (!enRangoDeAtaque(construccionEnemiga.obtenerUbicacion())){
            throw new ObjetivoFueraDeRango();
        }

        Atacante ataque = new Atacante(this.danioAereo, this.danioTerrestre);
        Area areaConstruccion = construccionEnemiga.obtenerArea();
        areaConstruccion.aceptar(ataque, construccionEnemiga);
    }

    public void moverse(Casillero casillero) {
        if (!casillero.puedeMoverse(this.area)) {
            throw new NoSePuedeMover();
        }
        if(this.ubicacion != null)
            this.ubicacion.retirarUnidad(this);
        casillero.ubicarUnidad(this);
        this.ubicacion = casillero;
    }

    public int consumirSuministro(int suministroAConsumir){
        return suministroAConsumir + this.suministro;
    }
}
