package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;

public class AmoSupremo extends UnidadZerg{

    public AmoSupremo(){
        this.vida = 200;
        this.turnosParaConstruirse = 5;
        this.rangoDeAtaque = 0;
        this.mineralNecesarioParaConstruir = 50;
        this.gasNecesarioParaConstruir = 0;
        this.area = new AreaEspacial();
    }


    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return true;
    }
}
