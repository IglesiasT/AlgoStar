package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

public class Zerg extends Raza{
    private LinkedList<ConstruccionZerg> construccionesRealizadas;
    public Zerg(){
        super();
        this.construccionesRealizadas = new LinkedList<>();
    }

    public void construir(ConstruccionZerg construccion, Casillero casilleroAConstruir){

        if(!construccion.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
            throw new NoSePuedeConstruir();
        }

        construccion.construirEnCasillero(casilleroAConstruir);

        //Se pudo construir
        construccion.consumirMineral(this.cantidadDeMineral);
        construccion.consumirGas(this.cantidadDeGas);
        this.construccionesRealizadas.add(construccion);
    }
    public void construirCriadero(Casillero casilleroAConstruir){
        Criadero criadero = new Criadero();

        this.construir(criadero, casilleroAConstruir);
    }

    public void construirExtractor(Casillero casilleroAConstruir) {
        Extractor extractor = new Extractor();

        this.construir(extractor, casilleroAConstruir);
    }
}
