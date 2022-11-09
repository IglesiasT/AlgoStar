package edu.fiuba.algo3.modelo;

public class Zerg extends Raza{
    public Zerg(){
        super();
        this.listadoConstrucciones.put("Criadero", 50);
    }

    public void construir(String construccion, Casillero casilleroAConstruir){
        if(this.cantidadDeMineral == 0){
            throw new NoSePuedeConstruir();
        }

        int mineralDisponible = (int) listadoConstrucciones.get(construccion);

        this.cantidadDeMineral -= mineralDisponible;
    }
}
