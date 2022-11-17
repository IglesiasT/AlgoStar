package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public abstract class Construccion {
    protected int mineralNecesarioParaConstruir;
    protected int gasNecesarioParaConstruir;
    protected int turnosParaConstruirse;

    protected int vida;

    protected int turnos;
    protected Casillero ubicacion;
    protected String superficie;

    public Construccion(){
        this.vida = 100;
        this.mineralNecesarioParaConstruir = 0;
        this.gasNecesarioParaConstruir = 0;
        this.ubicacion = null;
        this.turnos = 0;
        this.superficie = "Tierra";
    }

    public void construirEnCasillero(Casillero casilleroAConstruir){
        if (!this.sePuedeConstruirEn(casilleroAConstruir)) {
            throw new NoSePuedeConstruir();
        }
        casilleroAConstruir.establecerConstruccion(this);
        this.ubicacion = casilleroAConstruir;
    }

    public abstract boolean sePuedeConstruirEn (Casillero casillero);
    public boolean recursosSuficientes(int cantidadMineral, int cantidadGas){
        return (cantidadMineral >= this.mineralNecesarioParaConstruir && cantidadGas >= this.gasNecesarioParaConstruir);
    }
    public abstract void recibirDanio(int danioInflingido);
    protected abstract void regenerar();
    public int obtenerVida(){
        return this.vida;
    }

    public abstract void nuevoTurno();
    public int consumirMineral(int mineralAConsumir){
        return mineralAConsumir - this.mineralNecesarioParaConstruir;
    }

    public int consumirGas(int gasAConsumir){
        return gasAConsumir - this.gasNecesarioParaConstruir;
    }

    public void destruir(){
        ubicacion.destruirConstruccion();
    }
    public String obtenerSuperficie(){
        return this.superficie;
    }

    public Casillero obtenerUbicacion(){
        return this.ubicacion;
    }
}
