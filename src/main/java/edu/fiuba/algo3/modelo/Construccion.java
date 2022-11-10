package edu.fiuba.algo3.modelo;

import java.util.*;

public abstract class Construccion {
    protected int mineralNecesarioParaConstruir;
    protected int gasNecesarioParaConstruir;
    protected int turnosParaConstruirse;
    protected int vida;
    protected int turnos;
    protected Casillero ubicacion;

    public Construccion(){
        this.vida = 100;
        this.mineralNecesarioParaConstruir = 0;
        this.gasNecesarioParaConstruir = 0;
        this.ubicacion = null;
    }

    public void construirEnCasillero(Casillero casilleroAConstruir){
        if (! this.sePuedeConstruirEn(casilleroAConstruir)) {
            throw new NoSePuedeConstruir();
        }
        casilleroAConstruir.establecerConstruccion(this);
        this.ubicacion = casilleroAConstruir;
    }

    public void esGeneradorDeGas() {
        throw new NoSePuedeConstruir();
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
}
