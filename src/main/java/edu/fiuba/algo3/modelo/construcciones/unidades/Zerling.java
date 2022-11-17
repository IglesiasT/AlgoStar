package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.*;
public class Zerling extends UnidadZerg{
    public Zerling(){
        this.danioPorSuperficie.put("Tierra", 4);
        this.vida = 35;
        this.turnosParaConstruirse = 2;
        this.rangoDeAtaque = 1;
        this.superficie = new AreaTerrestre();
        this.mineralNecesarioParaConstruir = 25;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }

}
