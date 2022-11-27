package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

public abstract class Construccion {
    protected int turnosParaConstruirse;
    protected int vidaMaxima;
    protected int vida;
    protected ListadoDeRecursos recursosNecesarios;

    protected int turnos;
    protected Casillero ubicacion;
    protected String superficie;
    protected Area area;

    public Construccion(){
        this.vidaMaxima = 100;
        this.vida = this.vidaMaxima;
        this.ubicacion = null;
        this.turnos = 0;
        this.superficie = "Tierra";
        this.area = new AreaTerrestre();
        this.recursosNecesarios = new ListadoDeRecursos();
    }

    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        if (! recursos.contieneTodos(this.recursosNecesarios)) {
            throw new NoSePuedeConstruir();
        }

        this.recursosNecesarios.consumir(recursos);
        casilleroAConstruir.establecerConstruccion(this);
        this.ubicacion = casilleroAConstruir;
    }
    public abstract void recibirDanio(int danioInflingido);
    protected abstract void regenerar();
    public int obtenerVida(){
        return this.vida;
    }

    public void nuevoTurno(){
        this.turnos++;
        this.regenerar();
    }


    public void destruir(){
        ubicacion.destruirConstruccion();
    }
    public String obtenerSuperficie(){
        return this.superficie;
    }
    public void establecerUbicacion(Casillero nuevaUbicacion){
        this.ubicacion = nuevaUbicacion;
    }
    public Casillero obtenerUbicacion(){
        return this.ubicacion;
    }
}
