package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.tablero.Casillero;

public class Hidralisco extends UnidadZerg{
    public Hidralisco(){
        this.danioBase = 10;
        this.vida = 80;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 4;
        this.superficie = new AreaTerrestre();
        this.mineralNecesarioParaConstruir = 75;
        this.gasNecesarioParaConstruir = 25;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
