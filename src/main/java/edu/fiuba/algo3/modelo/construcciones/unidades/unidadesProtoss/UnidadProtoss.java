package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss;

import edu.fiuba.algo3.modelo.NoSePuedeMover;
import edu.fiuba.algo3.modelo.ObjetivoFueraDeRango;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

public abstract class UnidadProtoss extends ConstruccionProtoss implements Unidad {
    protected int rangoDeAtaque;
    protected int suministro;
    protected int danioAereo;
    protected int danioTerrestre;

    public UnidadProtoss(){
        super();
        this.rangoDeAtaque = 1;
        this.danioAereo = 0;
        this.danioTerrestre = 0;
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

        if (!enRangoDeAtaque(construccionEnemiga.obtenerUbicacion())){
            throw new ObjetivoFueraDeRango();
        }

        // Se aplica patron Visitor de manera que el area sepa cuanto danio recibir
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
    @Override
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        try {
            moverse(casilleroAConstruir);
            this.recursosNecesarios.consumir(recursos);
        }catch(Exception e){
            throw e;
        }


    }
    public int consumirSuministro(int suministroAConsumir){
        return suministroAConsumir + this.suministro;
    }
}
