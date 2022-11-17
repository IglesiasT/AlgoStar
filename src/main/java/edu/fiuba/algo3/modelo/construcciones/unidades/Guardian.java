package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class Guardian extends UnidadZerg{

    public Guardian(){
        this.danioPorSuperficie.put("Tierra", 25);
        this.vida = 100;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 10;
        this.mineralNecesarioParaConstruir = 50;
        this.gasNecesarioParaConstruir = 100;
        this.area = new AreaEspacial();
    }


    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return true;
    }
}
