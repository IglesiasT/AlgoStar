package edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss;

import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.construcciones.unidades.ComportamientoUnidad;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.modelo.recursos.Nodo;

public class Dragon extends UnidadProtoss {
    public Dragon(){
        super();
        this.danioAereo = 20;
        this.danioTerrestre = 20;
        this.escudo = new Escudo(80);
        this.turnosParaConstruirse = 6;
        this.rangoDeAtaque = 4;
        this.suministro = 3;
        this.recursosNecesarios.agregar(new Mineral(125));
        this.recursosNecesarios.agregar(new Gas(50));
        this.comportamiento = new ComportamientoUnidad(this.ubicacion, this.rangoDeAtaque , this , this.area);
    }
}
