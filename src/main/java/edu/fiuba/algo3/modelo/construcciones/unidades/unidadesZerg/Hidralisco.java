package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Hidralisco extends UnidadZerg {
    public Hidralisco(){
        super();
        this.vidaMaxima = 80;
        this.vida = this.vidaMaxima;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 4;
        this.suministro = 2;
        this.recursosNecesarios.agregar(new Mineral(75));
        this.recursosNecesarios.agregar(new Gas(25));
        this.danioTerrestre = 10;
        this.danioAereo = 10;
        this.comportamiento = new ComportamientoUnidad(this.ubicacion , this.rangoDeAtaque , this , this.area);
    }
}
