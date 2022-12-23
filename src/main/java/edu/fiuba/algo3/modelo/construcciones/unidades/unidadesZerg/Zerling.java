package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Zerling extends UnidadZerg {
    public Zerling(){
        super();
        this.danioAereo = 0;
        this.danioTerrestre = 4;
        this.vida = 35;
        this.vidaMaxima = 35;
        this.turnosParaConstruirse = 2;
        this.rangoDeAtaque = 1;
        this.suministro = 1;
        this.recursosNecesarios.agregar(new Mineral(25));
        this.comportamiento = new ComportamientoUnidad(this.ubicacion , this.rangoDeAtaque , this , this.area);
    }
}
