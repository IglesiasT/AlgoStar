package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Zerling extends UnidadZerg{
    public Zerling(){
        super();
        this.danioPorSuperficie.put("Tierra", 4);
        this.vida = 35;
        this.vidaMaxima = 35;
        this.turnosParaConstruirse = 2;
        this.rangoDeAtaque = 1;
        this.recursosNecesarios.add(new Mineral(25));
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return false;
    }

}
