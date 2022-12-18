package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.estados.ConstruccionFinalizada;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.estados.EnConstruccion;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

public abstract class Construccion {
    protected int turnosParaConstruirse;
    protected int vidaMaxima;
    protected int vida;
    protected ListadoDeRecursos recursosNecesarios;
    protected int turnos;
    protected Casillero ubicacion;
    protected Area area;
    protected Estado estado;

    public Construccion(){
        this.vidaMaxima = 100;
        this.vida = this.vidaMaxima;
        this.ubicacion = null;
        this.turnos = 0;
        this.area = new AreaTerrestre();
        this.recursosNecesarios = new ListadoDeRecursos();
        this.estado = new EnConstruccion();
    }

    public void construir(Casillero casilleroAConstruir, ListadoDeRecursos recursos){
        if (recursos.contieneTodos(this.recursosNecesarios)) {
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

        if (turnos == this.turnosParaConstruirse){
            this.estado = new ConstruccionFinalizada();
        }
    }
    public void destruir(){
        ubicacion.destruirConstruccion();
    }
    public void establecerUbicacion(Casillero nuevaUbicacion){
        this.ubicacion = nuevaUbicacion;
    }
    public Casillero obtenerUbicacion(){
        return this.ubicacion;
    }
    public Area obtenerArea() {
        return this.area;
    }

    public abstract Class obtenerRazaMadre();

    public boolean activa(){ return turnos >= turnosParaConstruirse;}
}
