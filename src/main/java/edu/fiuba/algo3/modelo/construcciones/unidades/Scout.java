package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Scout extends UnidadProtoss{

    public Scout(){
        super();
        this.danioPorSuperficie.put("Tierra", 8);
        this.danioPorSuperficie.put("Aire", 14);
        this.escudo = new Escudo(100);
        this.vida = 150;
        this.turnosParaConstruirse = 9;
        this.rangoDeAtaque = 4;
        this.superficie = new AreaEspacial();
        this.mineralNecesarioParaConstruir = 300;
        this.gasNecesarioParaConstruir = 150;
        this.superficie = new AreaEspacial();
    }
    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}