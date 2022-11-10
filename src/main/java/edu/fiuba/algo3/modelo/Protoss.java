package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public class Protoss extends Raza{
    private LinkedList<ConstruccionProtoss> construccionesRealizadas;
    public Protoss(){
        super();
        this.construccionesRealizadas = new LinkedList<>();
    }

    public void construir(ConstruccionProtoss construccion, Casillero casilleroAConstruir){

        if(!construccion.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
            throw new NoSePuedeConstruir();
        }

        construccion.construirEnCasillero(casilleroAConstruir);

        //Se pudo construir
        construccion.consumirMineral(this.cantidadDeMineral);
        construccion.consumirGas(this.cantidadDeGas);
        this.construccionesRealizadas.add(construccion);
    }
    public void construirPilon(Casillero casilleroAConstruir){
        Pilon pilon = new Pilon();

        this.construir(pilon, casilleroAConstruir);
    }

    public void construirNexoMineral(Casillero casilleroAConstruir) {
        NexoMineral nexo = new NexoMineral();

        this.construir(nexo, casilleroAConstruir);
    }

    public void construirAsimilador(Casillero casilleroAConstruir) {
        Asimilador asimilador = new Asimilador();

        this.construir(asimilador, casilleroAConstruir);
    }

    public void construirAcceso(Casillero casilleroAConstruir){
        Acceso acceso = new Acceso();

        this.construir(acceso, casilleroAConstruir);
    }

    public void construirPuertaEstelar(Casillero casilleroAConstruir){
        if(! this.construccionesRealizadas.contains(new Acceso())){
            throw new NoSePuedeConstruir();
        }
        PuertaEstelar puertaEstelar = new PuertaEstelar();

        this.construir(puertaEstelar, casilleroAConstruir);
    }
}
