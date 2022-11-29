package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Mutalisco extends UnidadZerg{

    EstadoMutalisco estado;

    public Mutalisco(){
        super();
        this.estado = new MutaliscoEstado();
        this.danioAereo = 9;
        this.danioTerrestre = 9;
    }

    public void evolucionarAGuardian(ListadoDeRecursos recursosDisponibles){
        Guardian guardian = new Guardian();
        guardian.construir(this.ubicacion,recursosDisponibles);
        this.estado = guardian;

    }

    public void evolucionarADevorador(ListadoDeRecursos recursosDisponibles){
        Devorador devorador = new Devorador();
        devorador.construir(this.ubicacion,recursosDisponibles);
        this.estado = devorador;

    }

    @Override
    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        this.estado.construir(casilleroAConstruir,recursos);
    }

    @Override
    public void atacar(ConstruccionProtoss construccionEnemiga){
        this.estado.atacar(construccionEnemiga);
    }

    @Override
    public void moverse(Casillero casillero){
        this.estado.moverse(casillero);
    }

    @Override
    public int consumirSuministro(int suministroAConsumir){
        return this.estado.consumirSuministro(suministroAConsumir);
    }

    @Override
    public void recibirDanio(int danioInflingido){
        this.estado.recibirDanio(danioInflingido);
    }

    @Override
    public void destruir(){
        this.estado.destruir();
    }

    @Override
    public String obtenerSuperficie(){
        return this.estado.obtenerSuperficie();
    }

    @Override
    public void establecerUbicacion(Casillero nuevaUbicacion){
        this.estado.establecerUbicacion(nuevaUbicacion);
    }

    @Override
    public Casillero obtenerUbicacion(){
        return this.estado.obtenerUbicacion();
    }

    @Override
    public void nuevoTurno(){this.estado.nuevoTurno();}
}
