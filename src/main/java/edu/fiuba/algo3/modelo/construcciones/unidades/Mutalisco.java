package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Mutalisco extends UnidadZerg{


    public Mutalisco(){
        super();
        this.danioPorSuperficie.put("Tierra", 9);
        this.danioPorSuperficie.put("Aire", 9);
        this.vidaMaxima = 120;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 7;
        this.rangoDeAtaque = 3;
        this.mineralNecesarioParaConstruir = 100;
        this.gasNecesarioParaConstruir = 100;
        this.superficie = "Aire";
        this.area = new AreaEspacial();
        this.suministro = 4;
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
