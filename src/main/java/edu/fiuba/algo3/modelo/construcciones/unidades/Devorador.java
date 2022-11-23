package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Devorador extends UnidadZerg{


    public Devorador(){
        super();
        this.danioPorSuperficie.put("Aire", 15);
        this.vidaMaxima = 200;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 5;
        this.mineralNecesarioParaConstruir = 150;
        this.gasNecesarioParaConstruir = 50;
        this.superficie = "Aire";
        this.area = new AreaEspacial();
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        //ni idea como es lo del aire
        return true;
    }
}
