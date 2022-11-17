package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Mutalisco extends UnidadZerg{


    public Mutalisco(){
        this.danioPorSuperficie.put("Tierra", 9);
        this.danioPorSuperficie.put("Aire", 9);
        this.vida = 120;
        this.vidaMaxima = 120;
        this.turnosParaConstruirse = 7;
        this.rangoDeAtaque = 3;
        this.superficie = new AreaEspacial();
        this.mineralNecesarioParaConstruir = 100;
        this.gasNecesarioParaConstruir = 100;
        this.superficie = new AreaEspacial();
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        //ni idea como es lo del aire
        return true;
    }

    public Guardian evolucionar(){
        return new Guardian();
    }
}
