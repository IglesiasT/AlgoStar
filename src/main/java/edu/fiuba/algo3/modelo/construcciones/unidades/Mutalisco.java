package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Mutalisco extends UnidadZerg{


    public Mutalisco(){
        this.danioBase = 9;
        this.vida = 120;
        this.turnosParaConstruirse = 7;
        this.rangoDeAtaque = 3;
        this.superficie = "Aire";
        this.mineralNecesarioParaConstruir = 100;
        this.gasNecesarioParaConstruir = 100;
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
