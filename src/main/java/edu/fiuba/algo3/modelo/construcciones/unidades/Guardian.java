package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Guardian extends UnidadZerg{

    public Guardian(){
        this.danioBase = 25;
        this.vida = 100;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 10;
        this.superficie = "Aire";
        this.mineralNecesarioParaConstruir = 50;
        this.gasNecesarioParaConstruir = 100;
    }


    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return true;
    }
}
