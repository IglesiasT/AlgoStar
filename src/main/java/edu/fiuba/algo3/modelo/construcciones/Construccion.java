package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Recurso;

import java.util.HashSet;
import java.util.Set;

public abstract class Construccion {
    protected int turnosParaConstruirse;
    protected int vidaMaxima;
    protected int vida;
    protected Set<Recurso> recursosNecesarios;

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
        this.recursosNecesarios = new HashSet<>();
    }

    public void construir(Casillero casilleroAConstruir, Set<Recurso> recursos){
        if (! recursos.containsAll(this.recursosNecesarios)) {      // esta dando siempre false
            throw new NoSePuedeConstruir();
        }

        for (Recurso recurso : recursos) {
            recurso.consumir(this.recursosNecesarios);
        }

        casilleroAConstruir.establecerConstruccion(this);
        this.ubicacion = casilleroAConstruir;
    }
    public void construir(Casillero casillero){
        // temporal para que los otros tests compilen
    }

    public abstract boolean sePuedeConstruirEn (Casillero casillero);   //luego del refactor esta siendo usado solo en tests
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
