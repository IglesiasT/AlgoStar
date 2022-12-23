package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Mutalisco extends UnidadZerg implements EstadoMutalisco {
    public Mutalisco(){
        super();
        this.danioAereo = 9;
        this.danioTerrestre = 9;
        this.vidaMaxima = 120;
        this.vida = this.vidaMaxima;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.recursosNecesarios.agregar(new Gas(100));
        this.turnosParaConstruirse = 7;
        this.rangoDeAtaque = 3;
        this.suministro = 4;
        this.area = new AreaEspacial();
        this.comportamiento = new ComportamientoUnidad(this.ubicacion , this.rangoDeAtaque , this , this.area);

    }

}
