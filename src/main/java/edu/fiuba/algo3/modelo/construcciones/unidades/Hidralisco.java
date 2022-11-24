package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Hidralisco extends UnidadZerg{
    public Hidralisco(){
        super();
        this.danioPorSuperficie.put("Tierra", 10);
        this.danioPorSuperficie.put("Aire", 10);
        this.vidaMaxima = 80;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 4;
        this.mineralNecesarioParaConstruir = 75;
        this.gasNecesarioParaConstruir = 25;
        this.suministro = 2;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }
}
