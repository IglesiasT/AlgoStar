package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.Nodo;

public class Guardian extends UnidadZerg implements EstadoMutalisco {

    public Guardian(){
        this.danioTerrestre = 25;
        this.vida = 100;
        this.turnosParaConstruirse = 4;
        this.rangoDeAtaque = 10;
        this.recursosNecesarios.agregar(new Mineral(50));
        this.recursosNecesarios.agregar(new Gas(100));
        this.area = new AreaEspacial();
    }

}
