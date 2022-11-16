package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Scout extends UnidadProtoss{

    public Scout(){
        super();
        this.danioPorSuperficie.put("Tierra", 8);
        this.danioPorSuperficie.put("Aire", 14);
        this.escudo = 100;
        this.vida = 150;
        this.turnosParaConstruirse = 9;
        this.rangoDeAtaque = 4;
        this.superficie = "Aire";
        this.mineralNecesarioParaConstruir = 300;
        this.gasNecesarioParaConstruir = 150;
    }
    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
