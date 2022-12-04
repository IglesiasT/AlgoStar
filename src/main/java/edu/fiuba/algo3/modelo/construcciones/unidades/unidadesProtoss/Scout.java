package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.UnidadProtoss;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Scout extends UnidadProtoss {

    public Scout(){
        super();
        this.danioAereo = 14;
        this.danioTerrestre = 8;
        this.escudo = new Escudo(100);
        this.vida = 150;
        this.turnosParaConstruirse = 9;
        this.rangoDeAtaque = 4;
        this.recursosNecesarios.agregar(new Mineral(300));
        this.recursosNecesarios.agregar(new Gas(150));
        this.area = new AreaEspacial();
        this.suministro = 4;
    }
}
