package edu.fiuba.algo3.modelo.construcciones.unidades;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Escudo;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;

public class Dragon extends UnidadProtoss{
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
    }
}
