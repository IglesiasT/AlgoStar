package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Guardian extends UnidadZerg{

    public Guardian(){
        this.danioPorSuperficie.put("Tierra", 25);
        this.vida = 100;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 10;
        this.recursosNecesarios.add(new Mineral(50));
        this.recursosNecesarios.add(new Gas(100));
        this.area = new AreaEspacial();
    }


    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return true;
    }
}
