package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Hidralisco extends UnidadZerg{
    public Hidralisco(){
        super();
        this.danioPorSuperficie.put("Tierra", 10);
        this.danioPorSuperficie.put("Aire", 10);
        this.vidaMaxima = 80;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 4;
        this.recursosNecesarios.agregar(new Mineral(75));
        this.recursosNecesarios.agregar(new Gas(25));
    }
}
